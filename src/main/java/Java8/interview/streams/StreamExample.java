package Java8.interview.streams;

import interview.Privacera.Employee;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.Function;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23, 22, 34, 12, 10, 11, 13, 9);

        //print even number
 /*
        List<Integer> res = list.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println(res);
 */
        //sort numbers
/*
        List<Integer> sorted= list.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);

 */
        //find primenumber
        // list.stream().filter( i->i%(i));

        //Java 8 String streams and finding the first non repeated character with functional programming
        String str = "mynameismyname";
        Stream<Character> stre = str.chars().mapToObj(c -> Character.valueOf((char) c));
        LinkedHashMap<Character, Long> res = stre.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        // List<Character> finall = res.entrySet().stream().filter(entry -> entry.getValue() == 1).map(i -> i.getKey()).collect(Collectors.toList());
        Optional<Map.Entry<Character, Long>> first = str.chars().mapToObj(c -> Character.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).findFirst();
        System.out.println(first);
//How do you remove duplicate elements from a list using Java 8 streams?

/*
        List<Integer> list1 = Arrays.asList(34,11,23,11,4,3,5,3,2,13,9);
        //approach 1
        List<Integer> result1 = list1.stream().distinct().collect(Collectors.toList());
        System.out.println(result1);
        List<Map.Entry<Integer, Long>> result2 = list1.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() == 1).collect(Collectors.toList());
*/

        //How do you find frequency of each character in a string using Java 8 streams?

       /* String string = "sanjeevanisahu";
        LinkedHashMap <Character,Long >result = string.chars().mapToObj(c->Character.valueOf((char)c))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap :: new ,Collectors.counting()));
        System.out.println(result);*/

        //How do you find frequency of each element in an array or a list?
        /*List<Integer> list1 = Arrays.asList(3,4,11,12,23,6,3,11,9,9,8);
             Map<Integer,Long> map= list1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);*/
       // list.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap()::new,Collectors.counting()));

        //How do you sort the given list  in reverse order?
      /*  List<Integer> list2 = Arrays.asList(3,4,11,12,23,6,3,11,9,9,8);
        List<Integer> reverse = list2.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverse);*/

        //How do you sort the given list of decimals in reverse order?
       /* List<Double> dob = Arrays.asList(3.4,5.6,11.7,12.3,78.3,2.3);
        List<Double> result =dob.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(result);*/

        // Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
       /* List<String> strn = Arrays.asList("abc","bcd","efg","pqr","xyz","ppr");
        String result = strn.stream().collect(Collectors.joining(",","[","]"));
        System.out.println(result);*/

        // From the given list of integers, print the numbers which are multiples of 5?

      /*  List<Integer> ls = Arrays.asList(23,40,11,10,89,20,25);
        List<Integer> ress = ls.stream().filter(i->i%5==0).collect(Collectors.toList());
        System.out.println(ress);*/

        // Given a list of integers, find maximum and minimum of those numbers?
    /*    List<Integer> ls = Arrays.asList(23,40,11,10,89,20,25);
        Integer ressMax = ls.stream().max(Comparator.comparing(String :: valueOf)).get();
        System.out.println(ressMax);
        Integer ressMIn = ls.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(ressMIn);*/

        //How do you merge two unsorted arrays into single sorted array using Java 8 streams?

     /*   int a[] = new int[]{2,56,12,45,23,9,10};
        int b[] = new int[]{2,56,12,45,23,9,10};

        a.stream().*/

        /*List<Employee> empList = new ArrayList();
        empList.add(new Employee(1,"abc",2000,"IT"));
        empList.add(new Employee(2,"axyz",9000,"cloud"));
        empList.add(new Employee(3,"pqr",7000,"finance"));
        empList.add(new Employee(4,"abcde",1000,"networking"));
        empList.add(new Employee(5,"aaaa",2300,"IT"));


        System.out.println(empList);

        Optional<Employee> result = empList.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).skip(2).findFirst();

        System.out.println(result);*/

        /*List<Employee> empList = new ArrayList();
        empList.add(new Employee(1,"abc",2000,"IT"));
        empList.add(new Employee(2,"axyz",9000,"cloud"));
        empList.add(new Employee(3,"pqr",7000,"finance"));
        empList.add(new Employee(4,"abcde",1000,"networking"));
        empList.add(new Employee(5,"aaaa",2300,"IT"));

       List<Employee> resu = empList.stream().sorted(Comparator.comparing(Employee :: getSalary).reversed()).collect(Collectors.toList());
        System.out.println(resu);*/
        List<Employee> empList = new ArrayList();
        empList.add(new Employee(1,"abc",2000,"IT","Female"));
        empList.add(new Employee(2,"axyz",9000,"cloud","Male"));
        empList.add(new Employee(3,"pqr",7000,"finance","Female"));
        empList.add(new Employee(4,"abcde",1000,"networking","Female"));
        empList.add(new Employee(5,"aaaa",2300,"IT","Male"));

        Map<String,Long> map =empList.stream().collect(Collectors.groupingBy(Employee :: getGender , Collectors.counting()));
      //  System.out.println(map);


//        Map<String,Optional<Employee>> maxSalary  = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.maxBy((t1,t2)->(int)(t1.getSalary()-t2.getSalary()))));
//        System.out.println(maxSalary);

    }
}
