package interview.act21;

public class ReverseStringUsingRecursion {
  public static void main(String[] args) {
    String str = "Prabal";
    reverse(str);
  }

  private static String reverse(String str) {
    if (str.length() == 1)
      return str;
    return reverse(str.substring(1)) + str.charAt(0);
  }
}
