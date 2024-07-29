package interview.sfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Sfs {

  public static void main(String[] args) {
    //create a concurrent modification exception using list
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(1);
    list.add(1);
    list.add(1);
    list.add(1);
    list.add(1);
    list.add(1);

    int i = 0;
    Iterator<Integer> listIterator = list.iterator();
//    while (listIterator.hasNext()) {
//      System.out.println(listIterator.next());
//      list.remove(i);
//    }

    //create a concurrent modification exception using map
    Map<String, String> map = new HashMap<>();
    map.put("1", "One");
    map.put("2", "Two");
    map.put("3", "Three");
    Iterator<Entry<String, String>> entryIterator = map.entrySet().iterator();
    try {
      while (entryIterator.hasNext()) {
        map.remove(entryIterator.next().getKey());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //write a query for making the
  //select count(order_id),product_name from orders group by product_name having product_category='ELECTRONICS'
}
