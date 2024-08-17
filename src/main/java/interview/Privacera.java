package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Privacera {

  //  +++++
//
//Arpit 8000 50
//Pushpak 4000 35
//Arpit 6000 30
//Arpit 5000 40
//Arpit 5000 30
//
//O/P
//
//Arpit 5000 30
//Arpit 5000 40
//Arpit 6000 30
//Arpit 8000 50
//Pushpak 4000 35
  static Queue<Integer> queue = new LinkedList<>();

  public static void main(String[] args) {
//    List<Employee> employeeList = new ArrayList<>();
//    employeeList.sort((employee, t1) -> {
//      if (employee.name.compareTo(t1.name) == 0) {
//        if (employee.salary.compareTo(t1.salary) == 0) {
//          return employee.age.compareTo(t1.age);
//        } else {
//          return employee.salary.compareTo(t1.salary);
//        }
//      } else {
//        return employee.name.compareTo(t1.name);
//      }
//    });

    //Teacher and a student -> A teacher can take up 5 assignments at a time but it can review only 1 assignment.
    //List of student submitting the assignment.Students are coming in parallel

//    while (true){
//      if (queue.size() <= 5){
//
//      }
//    }

    //thers is 1 thread ie consuming -> Polling the data out of the Queue
    //thers is n thread ie producing -> Putting the data in the Queue
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);

    list.parallelStream().forEach(Privacera::add);
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    executorService.submit(() -> {
      Thread.sleep(1000);
      return queue.remove();
    });
  }

  //class A{ map<K,integer> }
  public synchronized static void add(Integer integer) {
    if (queue.size() <= 5) {
      queue.add(integer);
    } else {
      try {
        Thread.sleep(20000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  class Employee {

    String name;
    Integer salary;
    Integer age;
  }
}


class A<K> {

  Map<K, Integer> map = new HashMap<K, Integer>();

  public void add(K k) {
    map.put(k, map.getOrDefault(k, 0) + 1);
  }

  public Map<K, Integer> sort() {
    return map.entrySet().stream()
        .sorted((kIntegerEntry, t1) -> kIntegerEntry.getValue().compareTo(t1.getValue()))
        .collect(
            Collectors.toMap(
                kIntegerEntry -> kIntegerEntry.getKey(),
                kIntegerEntry -> kIntegerEntry.getValue()
            )
        );
  }
}

//A <- B C
//J @Autowiring A