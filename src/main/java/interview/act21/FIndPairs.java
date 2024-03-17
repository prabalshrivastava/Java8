package interview.act21;

import java.util.HashSet;
import java.util.Set;

public class FIndPairs {

  public static void main(String[] args) {
//    int[] arr = {5, 2, 3, 6, 7};
    int[] arr = {4, 5, 2, 3, 6, 7};
    int k = 8;
    //5+3=8
    //5=8-3
    pairUsingSetUnique(arr, k);
  }

  private static void pairUsingSetUnique(int[] arr, int k) {
    Set<Integer> set = new HashSet<>();
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (set.contains(k - arr[i])) {
        System.out.println("Pair : " + arr[i] + " - " + (k - arr[i]));
        return;
      }
      set.add(arr[i]);
    }
  }
}
