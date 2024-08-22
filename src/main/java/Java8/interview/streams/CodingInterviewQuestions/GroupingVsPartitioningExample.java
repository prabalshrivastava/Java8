package Java8.interview.streams.CodingInterviewQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingVsPartitioningExample {

  /**
   * The difference between `Collectors.groupingBy()` and `Collectors.partitioningBy()` in Java lies
   * in how they classify and collect elements from a stream. Both are used for grouping, but they
   * differ in the type of result they produce and how they operate. ### 1.
   * **`Collectors.partitioningBy()`**: - **Partitioning into Two Groups**: It partitions the stream
   * of elements into two groups based on a given predicate (true/false). - **Result Type**: It
   * returns a `Map<Boolean, List<T>>`, where the keys are `true` and `false`. - **Use Case**: When
   * you need to divide elements into two groups (e.g., pass/fail, even/odd). - **Fixed Size**:
   * Since it only partitions into two groups, the result map will always have exactly two keys:
   * `true` and `false`. ### Example: ```java List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5,
   * 6); Map<Boolean, List<Integer>> partitioned = numbers.stream()
   * .collect(Collectors.partitioningBy(num -> num % 2 == 0)); ``` - `partitioned.get(true)` would
   * give `[2, 4, 6]` (even numbers). - `partitioned.get(false)` would give `[1, 3, 5]` (odd
   * numbers). ### 2. **`Collectors.groupingBy()`**: - **Grouping into Multiple Groups**: It groups
   * the elements based on a classification function, which can create multiple groups. - **Result
   * Type**: It returns a `Map<K, List<T>>`, where `K` is the type of the key produced by the
   * classification function, and `T` is the type of elements in the list. - **Use Case**: When you
   * need to classify elements into multiple groups (e.g., grouping by length of a string,
   * categorizing by age range). - **Variable Size**: The result map can have any number of keys
   * depending on the classification function. ### Example: ```java List<String> names =
   * Arrays.asList("Alice", "Bob", "Charlie", "David"); Map<Integer, List<String>> groupedByLength =
   * names.stream() .collect(Collectors.groupingBy(String::length)); ``` - `groupedByLength.get(3)`
   * would give `[Bob]` (names of length 3). - `groupedByLength.get(5)` would give `[Alice, David]`
   * (names of length 5). ### Key Differences: 1. **Predicate vs. Function**: - `partitioningBy()`
   * uses a predicate (boolean condition). - `groupingBy()` uses a classification function that can
   * produce any type of key. 2. **Result Type**: - `partitioningBy()` returns a `Map<Boolean,
   * List<T>>` with exactly two groups (true and false). - `groupingBy()` returns a `Map<K,
   * List<T>>` with potentially multiple groups. 3. **Use Case**: - Use `partitioningBy()` when you
   * only need two groups. - Use `groupingBy()` when you need multiple groups. ### Example to
   * Illustrate Both: ```java import java.util.*; import java.util.stream.Collectors; public class
   * GroupingVsPartitioningExample { public static void main(String[] args) { List<String> names =
   * Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva"); // partitioningBy: Partition names
   * into two groups - starts with 'A' and does not start with 'A' Map<Boolean, List<String>>
   * partitioned = names.stream() .collect(Collectors.partitioningBy(name -> name.startsWith("A")));
   * System.out.println("Partitioned: " + partitioned); // groupingBy: Group names by their length
   * Map<Integer, List<String>> groupedByLength = names.stream()
   * .collect(Collectors.groupingBy(String::length)); System.out.println("Grouped by length: " +
   * groupedByLength); } } ``` ### Output: ``` Partitioned: {false=[Bob, Charlie, David, Eva],
   * true=[Alice]} Grouped by length: {3=[Bob], 4=[Eva], 5=[Alice, David], 7=[Charlie]} ``` -
   * **Partitioning Example**: The map contains two groups based on whether the name starts with
   * 'A'. - **Grouping Example**: The map contains multiple groups, each representing a different
   * length of names. Would you like to explore further examples or use cases?
   */
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");

    // partitioningBy: Partition names into two groups - starts with 'A' and does not start with 'A'
    Map<Boolean, List<String>> partitioned = names.stream()
        .collect(Collectors.partitioningBy(name -> name.startsWith("A")));
    System.out.println("Partitioned: " + partitioned);

    // groupingBy: Group names by their length
    Map<Integer, List<String>> groupedByLength = names.stream()
        .collect(Collectors.groupingBy(String::length));
    System.out.println("Grouped by length: " + groupedByLength);
  }
}
