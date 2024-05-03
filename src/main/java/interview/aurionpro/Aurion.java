package interview.aurionpro;

public class Aurion {

  public static void main(String[] args) {
    String[] s = {"flying", "fly", "flown"};
    String[] s1 = {"running ", "runner", "run"};

    System.out.println(findPrefix(s));
    System.out.println(findPrefix(s1));
  }

  private static String findPrefix(String[] s) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < s.length; i++) {
      min = Math.min(s[i].length(), min);
    }
//    System.out.println(min);
    char currentChar = '\n';
    StringBuilder stringBuilder = new StringBuilder();
    for (int j = 0; j < min; j++) {
      currentChar = s[0].charAt(j);
      boolean isCurrentCharacterEqual = true;
      for (int i = 0; i < s.length; i++) {
        if (s[i].charAt(j) != currentChar) {
          isCurrentCharacterEqual = false;
        }
      }
      if (isCurrentCharacterEqual) {
        stringBuilder.append(currentChar);
      }else
        return stringBuilder.toString();
    }
    return stringBuilder.toString();
  }
}
