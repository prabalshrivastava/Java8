package interviewquestions;

public class Strings {

  public static void main(String[] args) {
    String s1 = "hello";
    String s2 = "hello!";
    String s3 = s2 + "world";
    String s4 = "hello!world";
    System.out.println(s3 == s4);//false
    System.out.println(s3.intern() == s4);//true -> here we are also adding the
    System.out.println(s3.equals(s4));//true
    String s5 = new String("Hello");
    System.out.println("Hello" == s5);
    System.out.println(s5 == s5.intern());
  }
}