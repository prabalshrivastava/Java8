package interview.techm;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Sol {

  public static void main(String[] args) {
    String[] inputArray = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
//    expected output
//    "epam", "pame", "aepm"
//    "abcd" "dcba"
//    "java" "ajav"
//    Map<String,List<>>
//    for (int i = 0; i < inputArray.length; i++) {
//    }

    Map<String, Long> collect = Arrays.stream(inputArray)
        .collect(Collectors.groupingBy(s -> {
          char[] charArray = s.toCharArray();
          Arrays.sort(charArray);
          return new String(charArray);
        }, Collectors.counting()));
    System.out.println(collect);
//        .forEach(System.out::println);
//        .collect(Collectors.groupingBy())

//    longest common prefix string amongst an array of strings.
//    Example 1:
//    Input: strs = ["flower","flow","flight"]
//    Output: "fl"
//    Example 2:
//    Input: strs = ["dog","racecar","car"]
//    Output: ""
//    Explanation: There is no common prefix among the input strings.

    String[] strs = {"flower", "flow", "flight"};
    String prefix = "";
    Character currentChar = '\n';
    int minLength = Integer.MAX_VALUE;
    for (int i = 0; i < strs.length; i++) {
      minLength = Math.min(minLength, strs.length);
    }

    for (int j = 0; j < minLength; j++) {
      currentChar = strs[0].charAt(j);
      boolean isPrefix = true;
      for (int i = 1; i < strs.length; i++) {
        if (strs[i].charAt(j) != currentChar) {
          //need to break out
        }
      }
    }
//    tabA
//    cola
//    1
//    1
//    2
//
//    tabB
//    colb
//    1
//    2
//    3

  }
}
