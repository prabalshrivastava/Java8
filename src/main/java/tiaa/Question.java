package tiaa;

import java.util.Stack;

public class Question {

  //  Decode the string
//  input 2[a2[b]c]
//  input abbcabbc
  //2[a2[b]c]
  //012345678
  public static void main(String[] args) {
    //1,8
    //4,6

    String input = "2[a2[b]c]";
    Stack<KV> stack = new Stack<>();
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '[') {
        KV kv = new KV(i,'[');
        stack.push(kv);
      } else if (input.charAt(i)==']') {
        if (!stack.isEmpty() && stack.peek().equals('[')) {
          stack.pop();
        }
      }
    }
  }
  static class KV{
    int index;
    char value;

    public KV(int index, char value) {
      this.index = index;
      this.value = value;
    }
  }
}
