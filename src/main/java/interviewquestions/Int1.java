package interviewquestions;

import java.util.ArrayList;

public class Int1 {

  public static void main(String[] args) {
    //1
    byte by = 127;
    by++;
    System.out.println(by);



    //2
    //short sh = 201000;


    //3
    // Getting an integer value
    Integer i = Integer.valueOf(12);
    // Printing the same integer value
    System.out.print(i + " ");
    // Calling method 2
    modify(i);
    // Now printing the value stored in above integer
    System.out.print(i);


    //4
    ArrayList obj = new ArrayList();
    obj.add("A");
    obj.add(0, "B");
    System.out.println(obj.size());


    
  }

  // Method 2

  // To modify integer value

  private static void modify(Integer i) {
    i = i + 1;
  }
}