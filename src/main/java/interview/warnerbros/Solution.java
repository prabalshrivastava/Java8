package interview.warnerbros;/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 
 * meeting rooms
 * Meeting: (2, 5), (9, 7), (8,12)
 * find number meeting rooms needed
 * output: 2
 * int meetingRooms(int[][] meetings)

 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    int[][] arr = {{9, 11},{2, 5}, {8,12}};
    int[][] arr1 = {{1,3},{2, 5},{3,7}};
    meetingRooms(arr);
  }

  static int meetingRooms(int[][] meetings) {
    
    Arrays.sort(meetings, (m1,m2) -> m1[1] - m2[1]);
    System.out.println(Arrays.deepToString(meetings));

    int roomsNeeded = 0;
    int maxRoomsNeeded = 0;
    for(int i=1;i<meetings.length;i++){
      int[] current = meetings[i];
      int[] previous = meetings[i-1];

      while(i<meetings.length && previous[1] > current[0]) {
        //meetings can be in same room
        current = meetings[i];
        previous = meetings[i-1];
        i++;
        roomsNeeded++;
      }
      
      // else{
      //   //seperate Meeting room needed.
      // }
    }
    return 0;
  }
}


// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!