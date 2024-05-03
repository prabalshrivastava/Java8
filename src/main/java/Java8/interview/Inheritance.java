package Java8.interview;

public class Inheritance {

  public static void main(String[] args) {
    Parent1 parent1 = new Child1();
    parent1.getParent();
  }
}
class Parent1{
  public static void getParent(){
    System.out.println("parent 1");
  }
}

class Child1 extends Parent1{
  public static void getParent(){
    System.out.println("child 1");
  }
  void getChild(){

  }
}
