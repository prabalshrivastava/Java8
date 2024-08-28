package interview.epam;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Epam {

  public static void main(String[] args) {
    String peek = "peek";
    String keep = "keep";
    String race = "race";
    String care = "care";
    String dood = "dood";
    String dodo = "dodo";

    System.out.println(isAnagram(peek, keep));//true
    System.out.println(isAnagram(peek, "kepp"));//false
    System.out.println(isAnagram(dood, dodo));//true
    System.out.println(isAnagram(race, care));//true
    System.out.println(isAnagram("prabal", "lanbarp"));//false
    System.out.println(isAnagram("prabal", "labarl"));//false
    System.out.println(isAnagram("prabal", "labarp"));//true

    Map<String, Person> map = new HashMap<>();
    map.put("g", new Person(5, 51, "EE"));
    map.put("e", new Person(4, 25, "DD"));
    map.put("a", new Person(3, 44, "CC"));

    Map<String, Person> personMap = new LinkedHashMap<>();
    map.entrySet().stream().sorted(Comparator.comparingInt(entry -> entry.getValue().age)).forEach(
        stringPersonEntry -> personMap.put(stringPersonEntry.getKey(),
            stringPersonEntry.getValue()));
    System.out.println(personMap);



  }

  private static boolean isAnagram(String peek, String keep) {
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();
    if (peek.length() != keep.length()) {
      return false;
    }

    for (int i = 0; i < peek.toCharArray().length; i++) {
      map1.put(peek.charAt(i), map1.getOrDefault(peek.charAt(i), 0) + 1);
      map2.put(keep.charAt(i), map2.getOrDefault(keep.charAt(i), 0) + 1);
    }
    Set<Entry<Character, Integer>> entries = map1.entrySet();

    for (Entry<Character, Integer> entry : entries) {
      Integer map2Freq = map2.getOrDefault(entry.getKey(), 0);
      if (entry.getValue() == null || !map2Freq.equals(entry.getValue())) {
        //is not anagram
        return false;
      }
    }
    return true;
  }
}


class Person {

  public int id;
  public int age;
  public String name;

  public Person(int id, int age, String name) {
    this.id = id;
    this.age = age;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person{" + "id=" + id + ", age=" + age + ", name='" + name + '\'' + '}';
  }
}
