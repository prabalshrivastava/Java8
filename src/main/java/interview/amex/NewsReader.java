package interview.amex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class NewsReader {
  // Design a system where we can read news articles online Complete the methods. public class NewsReader {
  // readNews method keeps track how many times the newsId has been read public void readNews(int newsId) { }
  // topFiveNews returns the top 5 news that have been read the most. public int[] topFiveNews() { int[] result = null; return result; } }

  // readNews method keeps track how many times the newsId has been read
  // topFiveNews returns the top 5 news that have been read the most.

  public void readNews(int newsId) {
  }

  public int[] topFiveNews() {
    int[] result = null;
    return result;
  }

  public static void main(String[] args) {
    int[] arr = {5, 3, 6, 7, 8};
    int input = 12;
    Set<Integer> set = new HashSet<>();
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (set.contains(Math.abs(input - arr[i]))) {
        count++;
      }
      set.add(arr[i]);// 5 3 6
    }
  }
  //4 5 6 7 0 1 2



//  Student
//  StudentId name
//  1
//  1
//  1
//  2
//  2
//  3
//  3


//  Course
//  studentId courseId
//  1
//  1
//  2
//  2
//  3
//  4


//  select * from student s


//  Sales: product_id, no_of_items_sale and sale_year
//  Product : product_id, brand_name, price, category

//  select count(p.product_id),p.brand_name from product p
//  group by p.brand_name;
//  order by count(p.product_id) desc

}
