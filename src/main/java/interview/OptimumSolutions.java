package interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OptimumSolutions {

  public static void main(String[] args) {
    String str = "abccbdabbcdddaaa";
    String[] split = str.split("");
    System.out.println(Arrays.toString(split));

//    Arrays.stream(split).collect(Collectors.groupingBy(s -> s,() -> s))
//    str.toCharArray().reduce((chars, chars2) -> cha)
//    Arrays.stream(str.toCharArray()).

    List<Integer> list = List.of(1, 3, 4, 5, 6);
    System.out.println(
        list.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList()));
    System.out.println(
        list.stream().filter(integer -> integer % 2 != 0).collect(Collectors.toList()));

    List<String> list1 = List.of("apple", "banana", "mango", "kiwi", "watermelon");
    System.out.println(
        list1.stream().sorted((s, t1) -> t1.length() - s.length()).collect(Collectors.toList()));

    System.out.println(
        list1.stream().sorted((s, t1) -> t1.length() - s.length())
            .collect(Collectors.toMap(o -> o, s -> s.length())));

//    2nd highest age
//    select * from employee orderby desc
//    offset=1 and limit=1;

//    select * from employee where age > (select avg(age) from employee);

  }
}
//
////  @Configuration
//  class DBConfig{
//
////    @Bean
////    database(){
////
////    }
//  }
//
//
//  @RestController("/db")
//  DbController{
////    @Autowired
////    @Inject
//    DBService DBService;
//
//
//    @PostMapping("/save")
//    save(@ResponseBody Dto dto){
////    dbservice.save();
//    }
//
//  }
//
////  @Service
//  class DBService{
////    @Autowired
////    @Inject
//    DBRepo DBRepo;
//
//    save(Dto str){
////      transformation
//      dbrepo.save(strDomain);
//    }
//  }
//
////  @Repository
//  class DBRepo{
//
//  }
//}
