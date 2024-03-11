package Java8.interview;

public class SingleAbstractMethodWithStaticAndDefault {

  public static void main(String[] args) {
    // Using a lambda expression to implement the SAM interface
    MySAMInterface samInstance = () -> System.out.println("Lambda expression implementation");

    // Calling SAM method
    samInstance.myAbstractMethod(); // Output: Lambda expression implementation

    // Calling default method
    samInstance.myDefaultMethod();  // Output: Default method in MySAMInterface

    // Calling static method
    MySAMInterface.myStaticMethod(); // Output: Static method in MySAMInterface
  }
}

@FunctionalInterface
interface MySAMInterface {
  // Abstract method (SAM)
  void myAbstractMethod();

  // Default method
  default void myDefaultMethod() {
    System.out.println("Default method in MySAMInterface");
  }

  // Static method
  static void myStaticMethod() {
    System.out.println("Static method in MySAMInterface");
  }
}









//A SAM (Single Abstract Method) interface in Java is an interface that declares only one abstract (non-default, non-static) method. SAM interfaces are often used in the context of functional programming and are associated with lambda expressions and functional interfaces in Java.
//    In Java, prior to version 8, SAM interfaces were typically used with anonymous inner classes. With the introduction of lambda expressions and functional interfaces in Java 8, working with SAM interfaces became more concise.
//When it comes to default and static methods in interfaces, they can coexist with SAM interfaces. Here's an example:
//    ```java
//@FunctionalInterface
//interface MySAMInterface {
//  // Abstract method (SAM)
//  void myAbstractMethod();
//  // Default method
//  default void myDefaultMethod() {
//    System.out.println("Default method in MySAMInterface");
//  }
//  // Static method
//  static void myStaticMethod() {
//    System.out.println("Static method in MySAMInterface");
//  }
//}
//public class Main {
//  public static void main(String[] args) {
//    // Using a lambda expression to implement the SAM interface
//    MySAMInterface samInstance = () -> System.out.println("Lambda expression implementation");
//    // Calling SAM method
//    samInstance.myAbstractMethod(); // Output: Lambda expression implementation
//    // Calling default method
//    samInstance.myDefaultMethod();  // Output: Default method in MySAMInterface
//    // Calling static method
//    MySAMInterface.myStaticMethod(); // Output: Static method in MySAMInterface
//  }
//}
//```
//In this example, `MySAMInterface` is a SAM interface with a single abstract method (`myAbstractMethod`). It also includes a default method (`myDefaultMethod`) and a static method (`myStaticMethod`). The interface is annotated with `@FunctionalInterface` to indicate that it's intended to be used as a functional interface.
//Lambda expressions can be used to provide concise implementations for SAM interfaces, and you can still utilize default and static methods in such interfaces. The default and static methods provide additional utility and functionality that can be shared among all classes that implement the interface.