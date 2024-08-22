package Java8.interview.streams.CodingInterviewQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class CollectingAndThenExample2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Collect names with more than 3 letters and then get the count
        int count = names.stream()
            .filter(name -> name.length() > 3)
            .collect(Collectors.collectingAndThen(
                Collectors.toList(),
                List::size
            ));

        System.out.println("Count of names with more than 3 letters: " + count);
    }
}
