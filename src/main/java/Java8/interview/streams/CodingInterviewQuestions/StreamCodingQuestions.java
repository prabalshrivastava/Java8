package Java8.interview.streams.CodingInterviewQuestions;

import static java.util.List.of;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCodingQuestions {

  public static void main(String[] args) {

    /**
     * Separate odd and even numbers in a list of integers.
     *
     * Given a list of integers, write a Java 8 program to separate
     * the odd and even numbers into two separate lists.
     */

    separationOfEvenOddNumberInMap();
    separationOfEvenOddNumberInList();

    /**
     * Remove duplicate elements from a list using Java 8 streams
     *
     * Write a Java 8 program to remove duplicate elements from a list
     * using the stream API and lambda expressions.
     */

    removeDuplicateFromList();

    /**
     * Find the frequency of each character in a string using Java 8 streams
     *
     * Write a Java 8 program to find the frequency of each character in
     * a given string using the stream API and collectors.
     */
    characterFrequency();

    /**
     * Find the frequency of each element in an array or a list
     *
     * Write a Java 8 program to find the frequency of
     * each element in an array or a list using streams and collectors.
     */

    wordFrequency();

    /**
     * Sort a given list of decimals in reverse order
     *
     * Write a Java 8 program to sort a given list of decimal numbers in reverse order.
     */

    reverseSortedList();

    /**
     * Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
     *
     * Given a list of strings, write a Java 8 program to join the strings
     * with '[' as a prefix, ']' as a suffix, and ',' as a delimiter.
     */

    joinListOfStrings();

    /**
     * Print the numbers from a given list of integers that are multiples of 5
     *
     * Write a Java 8 program to print the numbers from a given list of integers that are multiples of 5.
     */

    multipleOf5();

    /**
     * Find the maximum and minimum of a list of integers
     * Given a list of integers, write a Java 8 program to find the maximum and minimum numbers in the list.
     */

    minMaxFromList();

    /**
     * Merge two unsorted arrays into a single sorted array using Java 8 streams
     * Write a Java 8 program to merge two unsorted arrays into a single-sorted array using the stream API.
     */
    mergeUnsortedArrayIntoSorted();

    /**
     * Merge two unsorted arrays into a single sorted array without duplicates
     * Write a Java 8 program to merge two unsorted arrays into a single-sorted array without duplicates.
     */
    mergeUnsortedArrayIntoSortedWithoutDuplicate();

    /**
     * Get the three maximum and three minimum numbers from a given list of integers
     *
     * Write a Java 8 program to get the three maximum and three minimum numbers from a given list of integers.
     */

    min3max3();

    /**
     * Check if two strings are anagrams or not using Java 8 streams
     * Write a Java 8 program to check if two strings are anagrams or not using the stream API and lambda expressions.
     */

    isAnagram();
    isAnagram2();

    /**
     * Find the sum of all digits of a number in Java 8
     *
     * Write a Java 8 program to find the sum of all digits of a given number.
     *
     */
    sumOf();
    /**
     * Find the second-largest number in an integer array
     *
     * Write a Java 8 program to find the second-largest number in an integer array.
     */
    secondLargestNumberFromList();

    /**
     * Sort a list of strings according to the increasing order of their length
     *
     * Write a Java 8 program to sort a given list of strings according to the increasing order of their length.
     */
    sortByLengthOfList();
    /**
     * Find the sum and average of all elements in an integer array
     *
     * Write a Java 8 program to find the sum and average of all elements in an integer array.
     */

    calculateAndSumAndAverage();
    /**
     * Find the common elements between two arrays
     *
     * Write a Java 8 program to find the common elements between two arrays using streams.
     */
    commonElements();
    /**
     * Reverse each word of a string using Java 8 streams
     *
     * Write a Java 8 program to reverse each word of a given string using the stream API and lambda expressions
     */
    reverseEachWord();

    /**
     * Find the sum of the first 10 natural numbers
     *
     * Write a Java 8 program to find the sum of the first 10 natural numbers using streams.
     */

    int sumOf10NaturalNumber = IntStream.rangeClosed(1, 10)
        .sum();
    System.out.println(sumOf10NaturalNumber);

    /**
     * Reverse an integer array
     *
     * Write a Java 8 program to reverse an integer array.
     */
    reversedArray();

    /**
     * Find the most repeated element in an array
     *
     * Write a Java 8 program to find the most repeated element in an array.
     */

    mostRepeatedElement();

    /**
     * Check if a string is a palindrome using Java 8 streams
     *
     * Write a Java 8 program to check if a given string is a palindrome using the stream API and lambda expressions.
     */

    checkIsTheStringPalindrome();

    /**
     * Find strings in a list that start with a number
     *
     * Given a list of strings, write a Java 8 program to find the strings that start with a number.
     */

    stringsStartsWithNumber();

    /**
     * Extract duplicate elements from an array
     *
     * Write a Java 8 program to extract duplicate elements from an array.
     */

    extractDuplicateElements();

    /**
     * Print duplicate characters in a string
     * Write a Java 8 program to print the duplicate characters in a string.
     */

    duplicateCharactersInString();

    /**
     * Find the first repeated character in a string
     * Write a Java 8 program to find the first repeated character in a string.
     */
    firstRepeatedCharacter();

    /**
     * Find the first non-repeated character in a string
     *
     * Write a Java 8 program to find the first non-repeated character in a string.
     */
    firstNonRepeatingCharacter();

    /**
     * Generate the Fibonacci series
     *
     * Write a Java 8 program to generate the Fibonacci series.
     */
    generateFibonacciSeries();

    /**
     * Print the first 10 odd numbers
     *
     * Write a Java 8 program to print the first 10 odd numbers.
     */
    firstTenOddNumbers();

    /**
     * Get the last element of an array
     *
     * Write a Java 8 program to get the last element of an array.
     */

    lastElementInTheArray();

    /**
     * Calculate the age of a person in years
     *
     * Write a Java 8 program to calculate the age of a person in years given their birthday.
     */
    calculatePersonAgeInYear();
  }

  private static void calculatePersonAgeInYear() {
    LocalDate birthDate = LocalDate.of(1998, 8, 17);
    System.out.println("calculatePersonAgeInYear : " + Period.between(birthDate, LocalDate.now()));
    System.out.println(
        "calculatePersonAgeInYear : " + Period.between(birthDate, LocalDate.now()).getYears());
  }

  private static void lastElementInTheArray() {
    int[] intArray = {0, 1, 2, 3, 4, 5};
    System.out.println("lastElementInTheArray : " +
        Arrays.stream(intArray)
            .boxed().reduce((first, second) -> second)
            .orElse(-1));
  }

  private static void firstTenOddNumbers() {
    System.out.println("firstTenOddNumbers : " +
        Arrays.toString(IntStream.rangeClosed(0, 20).filter(i -> i % 2 != 0).toArray())
    );

    System.out.println("firstTenOddNumbers : " +
        Stream.iterate(1, integer -> integer + 2).limit(10).toList());
  }

  private static void generateFibonacciSeries() {
    //0 1 1 2 3 5 8 13
    System.out.println("generateFibonacciSeries : " +
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
            .limit(10)
            .map(arr -> arr[0]).toList()
    );

  }

  private static void firstNonRepeatingCharacter() {
    String tempStr = "rohitrohi";
    System.out.println("firstNonRepeatingCharacter : " +
        Arrays.stream(tempStr.split(""))
            .filter(s -> tempStr.indexOf(s) == tempStr.lastIndexOf(s))
            .findFirst().orElse(null));
  }

  private static void checkIsTheStringPalindrome() {
    String str = "momd";
    System.out.println("checkIsTheStringPalindrome : " +
        IntStream.range(0, str.length())
            .noneMatch(i -> str.charAt(i) != str.charAt(str.length() - 1 - i))
    );

  }

  private static void firstRepeatedCharacter() {
    String word = "rohttoh";
    System.out.println("firstRepeatedCharacter : " +
        Arrays.stream(word.split("")).filter(s -> word.indexOf(s) != word.lastIndexOf(s))
            .findFirst().orElse(null));
  }

  private static void duplicateCharactersInString() {
    String word = "rohttoh";
    System.out.println("original String " + word);
    System.out.println("duplicateCharactersInString : " +
        Arrays.stream(
                word.split(""))
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
            .entrySet().stream().filter(entry -> entry.getValue() > 1)
            .toList());

    System.out.println("duplicateCharactersInString : " +
        Arrays.stream(
            word.split("")
        ).filter(s -> word.indexOf(s) != word.lastIndexOf(s)).distinct().toList()
    );

  }

  private static void extractDuplicateElements() {
    List<Integer> duplicateElements = of(1, 2, 2, 2, 3, 3, 4, 5, 1, 1, 56, 7, 8, 9, 10);
    System.out.println("maxed Elements " + duplicateElements);
    System.out.println("extractDuplicateElements : " +
        duplicateElements.stream().collect(
            Collectors.groupingBy(integer -> integer, Collectors.counting())
        ).entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() > 1).toList()
    );

    System.out.println("extractDuplicateElements : " +
        duplicateElements.stream().filter(
            integer -> duplicateElements.indexOf(integer) != duplicateElements.lastIndexOf(integer)
        ).distinct().toList()
    );
  }

  private static void stringsStartsWithNumber() {
    String[] words = {"rohit", "foo", "nemo", "target1", "12Target", "2robot"};
    System.out.println("original Strings " + Arrays.toString(words));
    System.out.println("stringsStartsWithNumber : " +
        Arrays.stream(words).filter(s -> {
          char c = s.charAt(0);
          return c >= '0' && c <= '9';
        }).toList());

    System.out.println("stringsStartsWithNumber : " +
        Arrays.stream(words).filter(s -> Character.isDigit(s.charAt(0))).toList());

  }

  private static void mostRepeatedElement() {
    int[] elements = {2, 3, 1, 4, 4, 1, 4, 333, 3, 333, 2, 2, 2, 5, 222};
    System.out.println("original Array" + Arrays.toString(elements));

    System.out.println("mostRepeatedElement : " +
        Arrays.stream(elements).boxed().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
            ).entrySet()
            .stream()
            .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
            .map(Entry::getKey)
            .findFirst().orElse(null));
  }

  private static void reversedArray() {
    int[] numberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println("original array" + Arrays.toString(numberArray));
    System.out.println("reversedArray : " +
        Arrays.toString(IntStream.rangeClosed(1, numberArray.length)
            .map(i -> numberArray[numberArray.length - i])
            .toArray())
    );
  }

  private static void reverseEachWord() {
    String stmt = "java is OOP language";
    System.out.println("reverseEachWord : " +
        Arrays.stream(stmt.split(" ")).map(s -> new StringBuilder(s).reverse())
            .collect(Collectors.joining(" ")));
  }

  private static void commonElements() {
    List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> twoToTen = of(2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println("commonElements : " +
        oneToTen.stream().filter(twoToTen::contains)
            .toList());
  }

  private static void calculateAndSumAndAverage() {
    List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println("calculateAndSumAndAverage : " +
        oneToTen.stream().collect(Collectors.summarizingInt(Integer::intValue)));
  }

  private static void sortByLengthOfList() {
    List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita",
        "gita");
    System.out.println("sortByLengthOfList : " +
        names.stream().sorted(Comparator.comparingInt(String::length))
            .toList());
  }

  private static void secondLargestNumberFromList() {
    List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println("secondLargestNumberFromList : " +
        oneToTen.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null));
  }

  private static void sumOf() {
    List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println("sumOf : " +
        oneToTen.stream().reduce((integer, integer2) -> integer + integer2).orElse(null));
    System.out.println("sumOf : " +
        oneToTen.stream().reduce(Integer::sum).orElse(null));

    System.out.println("sumOf : " +
        oneToTen.stream().mapToInt(Integer::intValue).sum());
  }

  private static boolean isAnagram2() {

    String string1 = "listen";
    String string2 = "silent";
    if (
        Arrays.equals(Arrays.stream(string1.split("")).sorted().toArray(),
            Arrays.stream(string2.split("")).sorted().toArray())
    ) {
      System.out.println("Is Anagram");
    } else {
      System.out.println("Is Not Anagram");
    }

    if (
        Arrays.stream(string1.split("")).sorted().collect(Collectors.joining("")).equals(
            Arrays.stream(string2.split("")).sorted().collect(Collectors.joining(""))
        )
    ) {
      System.out.println("Is Anagram");
    } else {
      System.out.println("Is Not Anagram");
    }

    return false;
  }

  private static void isAnagram() {
    char[] splitIt = "listen".toCharArray();
    char[] splitIt2 = "silent".toCharArray();
    Arrays.sort(splitIt);
    Arrays.sort(splitIt2);
    if (Arrays.equals(splitIt, splitIt2)) {
      System.out.println("Is Anagram");
    } else {
      System.out.println("Is not anagram");
    }

  }

  private static void min3max3() {
    List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
    System.out.println("3 Min Elements : " +
        randomNumbers.stream().sorted().limit(3).toList());
    System.out.println("3 Max Elements : " +
        randomNumbers.stream().sorted(Comparator.reverseOrder())
            .limit(3).toList());
  }

  private static void find3rdMinAnd3rdMax() {
    List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
    System.out.println("3rd Min : " +
        randomNumbers.stream().sorted().skip(2).findFirst().orElse(null));
    System.out.println("3rd Max : " +
        randomNumbers.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse(null));
  }

  private static void mergeUnsortedArrayIntoSortedWithoutDuplicate() {
    int[] randomNumbers = {12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
    int[] randomNumber2 = {4, 32, 2, 5, 6, 78, 98, 53, 90};
    System.out.println("mergeUnsortedArrayIntoSortedWithoutDuplicate : " +
        Arrays.toString(
            IntStream.concat(Arrays.stream(randomNumber2), Arrays.stream(randomNumbers)).sorted()
                .distinct()
                .toArray()));
  }

  private static void mergeUnsortedArrayIntoSorted() {
    int[] randomNumbers = {12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
    int[] randomNumber2 = {4, 3, 2, 5, 6, 78, 98, 53, 90};

    System.out.println("mergeUnsortedArrayIntoSorted : " +
        Arrays.toString(
            IntStream.concat(Arrays.stream(randomNumbers), Arrays.stream(randomNumber2)).sorted()
                .toArray()));

  }

  private static void minMaxFromList() {
    List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
    System.out.println(randomNumbers.stream().max(Integer::compare).orElse(Integer.MAX_VALUE));
    System.out.println(randomNumbers.stream().min(Integer::compare).orElse(Integer.MIN_VALUE));

    IntSummaryStatistics summaryStatistics = randomNumbers.stream()
        .collect(Collectors.summarizingInt(Integer::intValue));
    System.out.println(
        summaryStatistics);

    System.out.println(summaryStatistics.getMax());
    System.out.println(summaryStatistics.getMin());
    System.out.println(summaryStatistics.getCount());
    System.out.println(summaryStatistics.getSum());
    System.out.println(summaryStatistics.getAverage());
  }

  private static void multipleOf5() {
    List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
    System.out.println("multipleOf5 : " +
        randomNumbers.stream().filter(integer -> integer % 5 == 0).toList());
  }

  private static void joinListOfStrings() {
    List<String> languageList = of("java", "c++", "c", "C sharp", "python", "kotlin", "scala");
    System.out.println("joinListOfStrings : " +
        languageList.stream().collect(Collectors.joining(",", "[", "]")));
  }

  private static void reverseSortedList() {
    List<Integer> randomNumbers = of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
    System.out.println("reverseSortedList : " +
        randomNumbers.stream().sorted(Comparator.reverseOrder()).toList()
    );

    System.out.println("reverseSortedList : " +
        randomNumbers.stream().sorted((x, y) -> y.compareTo(x)).toList()
    );
  }

  private static void wordFrequency() {
    List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita",
        "gita");

    System.out.println("wordFrequency : " +
        names.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()))
    );
  }

  private static void characterFrequency() {
    String name = "rohitroh";
    System.out.println("characterFrequency : " +
        Arrays.stream(name.split(""))
            .collect(Collectors.groupingBy(s -> s, Collectors.counting())));

    System.out.println("characterFrequency : " +
        name.chars().boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    );

    System.out.println("characterFrequency : " +
        name.chars().mapToObj(i -> (char) i)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    );


  }

  private static void removeDuplicateFromList() {
    List<Integer> oneToTen = of(1, 1, 3, 4, 5, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println(
        "removeDuplicateFromList : " + oneToTen.stream().distinct().toList());

    System.out.println(
        "removeDuplicateFromList : " + oneToTen.stream().collect(Collectors.toSet()));

    System.out.println("removeDuplicateFromList - UniqueList : " + oneToTen.stream()
        .filter(integer -> oneToTen.indexOf(integer) == oneToTen.lastIndexOf(integer))
        .collect(Collectors.toList()));
  }

  private static void separationOfEvenOddNumberInList() {
    List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println(
        oneToTen.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0)).values().stream()
            .toList());

    Collection<List<Integer>> collect = oneToTen.stream()
        .collect(
            Collectors.collectingAndThen(
                Collectors.partitioningBy(
                    integer -> integer % 2 == 0
                ), Map::values
            )
        );
    System.out.println(collect);
  }

  private static void separationOfEvenOddNumberInMap() {
    List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//    System.out.println(
//        oneToTen.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList()));
//    System.out.println(
//        oneToTen.stream().filter(integer -> integer % 2 != 0).collect(Collectors.toList()));

    Map<Boolean, List<Integer>> listMap = oneToTen.stream()
        .collect(Collectors.partitioningBy(integer -> integer % 2 == 0));
    System.out.println(listMap);
  }
}