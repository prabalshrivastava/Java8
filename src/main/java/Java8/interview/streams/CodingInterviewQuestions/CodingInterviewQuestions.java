package Java8.interview.streams.CodingInterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CodingInterviewQuestions {

  public static void main(String[] args) {
    //Count Occurrence of each character in String using Java 8
    String input = "gainjavaknowledge";
    String[] split = input.split("");
    System.out.println(
        Arrays.stream(split)
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
    );

    //Find duplicate elements from string using Java8?
    System.out.println(Arrays.stream(split)
        .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() > 1)
        .map(Entry::getKey)
        .collect(Collectors.toSet()));

    //Find second highest element from an array in java 8
    int[] numbers = {5, 13, 41, 88, 99, 77};
    Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().stream()
        .findAny().ifPresent(
            System.out::println);
  }
}
