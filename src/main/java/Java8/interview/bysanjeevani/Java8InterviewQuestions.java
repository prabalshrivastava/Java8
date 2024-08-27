package Java8.interview.bysanjeevani;/* Online Java Compiler and Editor */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8InterviewQuestions {

  public static void main(String[] args) {
    System.out.println("Hello, World!");
    ArrayList<Integer> al = new ArrayList<>();
    al.add(12);
    al.add(23);
    al.add(45);
    al.add(10);
    al.add(8);
    al.add(12);
    al.add(23);
    al.add(7);
    al.add(32);
    al.add(25);
    al.add(40);
    System.out.println("array : " + al);

    //print only even number
    System.out.println(
        "Even Numbers " + al.parallelStream().filter(integer -> integer % 2 == 0).toList());
    System.out.println(
        "Multiplied Numbers " + al.parallelStream().map(integer -> integer * 2).toList());
    System.out.println("Sorted " + al.parallelStream().sorted().toList());
    System.out.println("Unique " + al.parallelStream().distinct().toList());
    System.out.println("Odd & Even " + al.parallelStream()
        .collect(Collectors.groupingBy(integer -> integer % 2 == 0 ? "Even" : "Odd")));

    //Remove duplicate elements from a list using Java 8 streams?
    List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
    System.out.println("Remove Duplicates " + listOfStrings.parallelStream().distinct().toList());

    //Find frequency of each character in a string using Java 8 streams?
    String inputString = "Java Concept Of The Day";
    System.out.println("Frequency " + Arrays.stream(inputString.split("")).parallel()
        .collect(Collectors.groupingBy(
            Function.identity(), Collectors.counting())));
  }




}
