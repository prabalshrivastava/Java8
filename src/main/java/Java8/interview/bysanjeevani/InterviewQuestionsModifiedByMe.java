package Java8.interview.bysanjeevani;/* Online Java Compiler and Editor */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewQuestionsModifiedByMe {

  public static void main(String[] args) {
    // Given int array find the 2nd minimum number.
    // Return the number which should come at 2nd position when we sort the array .
    // Array may contain duplicates also .
    // Hint : Use max PriorityQueue to remove some candidates (optimised approach, but first try the brute force approach for it) .
    // ex1 : arr = [9,3,5,8,4,7,8]
    // output : 4
    // ex2: arr = [3,9,8,8,5,3,3] -> [3, 3, 3, 5, 8, 8, 9]
    // output : 3
    // ex3: arr = [4,3]
    // output : 4
    // ex4: arr = [5]
    // output : "invalid input"

    int[] arr = {9, 3, 5, 8, 4, 7, 8};
    int[] arr1 = {3, 9, 8, 8, 5, 3, 3};
    int[] arr2 = {4, 3};
    int[] arr3 = {5};
    findSecondElement(arr);
    findSecondElement(arr1);
    findSecondElement(arr2);
    findSecondElement(arr3);
  }

  private static void findSecondElement(int[] arr) {
    if (arr == null || arr.length <= 1) {
      System.out.println("Invalid Input");
      return;
    }
    Queue<Integer> queue = new PriorityQueue<>();
//    Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < arr.length; i++) {
      queue.add(arr[i]);
    }
    System.out.println(queue);
    queue.remove();
    System.out.println(queue.remove());
  }


}
