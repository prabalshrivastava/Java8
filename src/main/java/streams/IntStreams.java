package streams;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreams {
  public static void main(String[] args) {
    int[] numbers = {4, 1, 13, 90, 16, 2, 0};

    System.out.println(IntStream.of(numbers).count());
    System.out.println(IntStream.of(numbers).sum());
    System.out.println(IntStream.of(numbers).min().getAsInt());
    System.out.println(IntStream.of(numbers).max().getAsInt());
    System.out.println(IntStream.of(numbers).average().getAsDouble());
    System.out.println(IntStream.of(numbers).anyMatch(value -> value % 2 == 0));
    System.out.println(IntStream.of(numbers).allMatch(value -> value % 2 == 0));
    System.out.println(IntStream.of(numbers).noneMatch(value -> value % 2 == 0));
    IntStream.of(numbers)
        .filter(value -> value % 2 == 0)
        .forEach(value -> System.out.print(value + ","));
    System.out.println("");
    IntStream.of(numbers).asDoubleStream().forEach(value -> System.out.print(value + ","));
    System.out.println("");
    IntStream.of(numbers).asLongStream().forEach(value -> System.out.print(value + ","));
    System.out.println("");
    // boxed relates to boxing from int to Integer
    System.out.println(IntStream.of(numbers).boxed().collect(Collectors.toList()));
    System.out.println(
        IntStream.of(numbers)
            .mapToObj(value -> new SimpleEntry<>("current value", value))
            .collect(Collectors.toList()));

    IntStream.of(numbers)
        .map(
            operand -> {
              System.out.print(",input : " + operand);
              int i = operand % 2;
              System.out.print(",output : " + i);
              return i;
            })
        .sum();

    System.out.println("\nUsing distinct");
    IntStream.of(10, 10, 10, 11, 0, 11, 0, 12, 13, 13, 12).distinct().forEach(System.out::println);

    System.out.println("Using asDoubleStream");
    IntStream.of(numbers).asDoubleStream().forEach(System.out::println);
    System.out.println("Using asLongStream");
    IntStream.of(numbers).asLongStream().forEach(System.out::println);
    System.out.println("Using dropWhile");
    IntStream.of(numbers).dropWhile(value -> value % 2 == 0).forEach(System.out::println);

    // start from flatmap
    System.out.println(
        Stream.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8))
            .flatMap(Collection::stream)
            .collect(Collectors.toList()));

    System.out.println("IntStream.of(numbers).findAny().getAsInt()");
    System.out.println(IntStream.of(numbers).findAny().getAsInt());

    System.out.println("IntStream.of(numbers).findFirst().getAsInt()");
    System.out.println(IntStream.of(numbers).findFirst().getAsInt());

    System.out.println("IntStream.of(numbers).forEachOrdered(System.out::println);");
    IntStream.of(numbers).forEachOrdered(System.out::println);

    System.out.println("IntStream.of(numbers).limit(3).forEach(System.out::println);");
    IntStream.of(numbers).limit(3).forEach(System.out::println);

    System.out.println("IntStream.of(numbers).sequential().forEach(System.out::println);");
    IntStream.of(numbers).sequential().forEach(System.out::println);

    System.out.println("IntStream.of(numbers).isParallel()");
    System.out.println(IntStream.of(numbers).isParallel());

    System.out.println("IntStream.of(numbers).parallel().isParallel()");
    System.out.println(IntStream.of(numbers).parallel().isParallel());

    System.out.println("IntStream.of(numbers).mapToDouble(value -> value % 2).forEach(System.out::println)");
    IntStream.of(numbers).mapToDouble(value -> value % 2).forEach(System.out::println);

    System.out.println("IntStream.of(numbers).mapToDouble(value -> value).forEach(System.out::println)");
    IntStream.of(numbers).mapToDouble(value -> value).forEach(System.out::println);

    System.out.println("IntStream.of(numbers).mapToLong(value -> value* 100000000L).forEach(System.out::println);");
    IntStream.of(numbers).mapToLong(value -> value* 100000000L).forEach(System.out::println);

    IntStream.of(numbers).noneMatch()
  }
}
