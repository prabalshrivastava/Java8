package interview.jpmc;

import java.util.List;

public class Solution {
//  getCurrency Currency
//  getAccountName Account_Name
//  getLongAccountName Long_Account_Name
//  getTradeID Trade_ID
//  getSWIFTCode SWIFT_Code

  public static void main(String[] args) {
//    System.out.println(Integer.valueOf('a'));//97
//    System.out.println(Integer.valueOf('z'));//122
//    System.out.println(Integer.valueOf('A'));//65
//    System.out.println(Integer.valueOf('Z'));//90

//    getAccountName
//    01234567890123
    List<String> strings = List.of(
        "getCurrency",
        "getAccountName",
        "getLongAccountName",
        "getTradeID",
        "getSWIFTCode"
    );
    for (int j = 0; j < strings.size(); j++) {
      String stringToBeProcessed = strings.get(j);
      StringBuilder output = new StringBuilder();
      boolean isCapitalEncountered = false;
      for (int i = 3; i < stringToBeProcessed.length(); i++) {
        char currentChar = stringToBeProcessed.charAt(i);
        if (65 <= currentChar && currentChar <= 97) {
          isCapitalEncountered = true;
          output.append(stringToBeProcessed.charAt(i));
          i++;
          currentChar = stringToBeProcessed.charAt(i);
        }
        while (97 <= currentChar && currentChar <= 122) {
          output.append(currentChar);
          i++;
          if (i >= stringToBeProcessed.length()) {
            break;
          }
          currentChar = stringToBeProcessed.charAt(i);
        }
        if (i < stringToBeProcessed.length()) {
          output.append("_");
          if (65 <= currentChar && currentChar <= 97) {
            output.append(stringToBeProcessed.charAt(i));
          }
        } else {
          break;
        }
        if (65 <= currentChar && currentChar <= 97) {
          continue;
        }
      }
      System.out.println(output);
    }
  }
}


//vehicle
//4wheeler 2wheeler 6wheeler
//4wheeler -> Car SUV
//2wheeler -> Bike
//6wheeler -> Truck
// Attribute -> Tires CC NoOfPassengers