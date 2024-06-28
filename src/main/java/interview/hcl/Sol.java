package interview.hcl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sol {

  public static void main(String[] args) {
    String[] strArr = {"Prabal", "Prabal", "Prabal", "Shrivastava"};
    removeDuplicatesUsingSet(strArr);
    calculateTheNoOfBounces();
  }

  private static void calculateTheNoOfBounces() {
    // 100m wall & its falling to ground & it bounces back 80% of original height.
    // What is the no of bounces it takes to reach the ground.

    // 100m * .8
    // 80m * .8
    // 64m * .8 = 51.2m
    // 51.2m * .8 = 40.96

    //0.92
    //0.000000002
    double height = 100.0;
    int count = 0;
    while (height >= 0.1) {
      height = height * .8;
      System.out.print(height + " - ");
      count++;
    }
    System.out.println(count);
  }

  private static void removeDuplicatesUsingSet(String[] strArr) {
    Set<String> set = new HashSet<>(List.of(strArr));
    System.out.println(set);
  }
}
