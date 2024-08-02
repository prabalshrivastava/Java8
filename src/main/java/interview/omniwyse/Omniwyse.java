package interview.omniwyse;

public class Omniwyse {

  public static void main(String[] args) {
    String string = "Once 10 king, always a king";
//    String string1 = "Once A King, Always A King";

//    97-65 = 32
//    A -> 65
//    a -> 97
    System.out.println(Integer.valueOf('A'));
    System.out.println(Integer.valueOf('a'));
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < string.length(); i++) {
      if (i - 1 >= 0 && string.charAt(i - 1) == ' ') {
        if ('a' <= string.charAt(i) && string.charAt(i) <= 'z') {
          stringBuilder.append((char) (string.charAt(i) - 32));
        } else {
          stringBuilder.append(string.charAt(i));
        }
      } else {
        stringBuilder.append(string.charAt(i));
      }
    }
    System.out.println(" -> " + stringBuilder);

//    String[] split = string.split(" ");
//    for (int i = 0; i < split.length; i++) {
//      StringBuilder stringBuilder = new StringBuilder();
//      for (int j = 0; j < split[i].length(); j++) {
//        if (j == 0) {
//          stringBuilder.append(split[i].charAt(j));
//        } else {
//          stringBuilder.append(split[i].charAt(j));
//        }
//      }
//    }
  }
}
