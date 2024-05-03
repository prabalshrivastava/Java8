package interview.paytm;

import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Triplets {
//  Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//  Notice that the solution set must not contain duplicate triplets.
//  Input: nums = [-1,0,1,2,-1,-4]
//  Output: [[-1,-1,2],[-1,0,1]]
//  Explanation:
//  nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//  nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//  nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//  The distinct triplets are [-1,0,1] and [-1,-1,2].
//  Notice that the order of the output and the order of the triplets does not matter.

  public static void main(String[] args) {
//    bruteForceApproach();
    //nums[i] + nums[j] + nums[k] == 0.
    //nums[i] + nums[j] = -nums[k].

    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] arr = new int[]{-1, 0, 1, 2, -1, -4};

    //-1, 0, 1, 2, -1, -4
//    -1 -> 0,4
    for (int i = 0; i < arr.length; i++) {
//      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
      List<Integer> list = new ArrayList<>();
      if (map.containsKey(arr[i])) {
        list = map.get(arr[i]);
      }
      list.add(i);
      map.put(arr[i], list);
    }
    System.out.println(map);
    Set<List<Integer>> set = new HashSet<>();
    //n -> length of array
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int sum = arr[i] + arr[j];
        int negativeSum = -sum;
        if (map.containsKey(negativeSum) && !map.get(negativeSum).contains(i) && !map.get(
            negativeSum).contains(j)) {
          List<Integer> list = new ArrayList<>();
          list.add(arr[i]);
          list.add(arr[j]);
          list.add(negativeSum);
          Collections.sort(list); //O(m log m) -> O(3 log3) -> O(1)
          set.add(list);
        }
      }
    }
    System.out.println(set);
  }

  private static void bruteForceApproach() {
    Set<List<Integer>> set = new HashSet<>();
//    int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
//    int[] arr = new int[]{0, 1, 1};
    int[] arr = new int[]{0, 0, 0};
    for (int i = 0; i < arr.length; i++) {
      int sum = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        sum = sum + arr[j];
        for (int k = j + 1; k < arr.length; k++) {
          sum = sum + arr[k];
          if (sum == 0) {
            set.add(List.of(arr[i], arr[j], arr[k]));
          }
        }
      }
    }
    System.out.println(set);
  }
}
