package Java8.interview;

interface Interface1 {
    default void myMethod() {
        System.out.println("Default method in Interface1");
    }
}

interface Interface2 {
    default void myMethod() {
        System.out.println("Default method in Interface2");
    }
}


// This will result in a compilation error
//class MyClassGivingError implements Interface1, Interface2 {
//    // Error: class inherits unrelated defaults for myMethod() from types Interface1 and Interface2
//}

public class DefaultMethodAmbiguityDiamondProblem implements Interface1, Interface2 {
    @Override
    public void myMethod() {
        Interface1.super.myMethod(); // Calling the default method from Interface1
        // or provide a completely new implementation
        // System.out.println("MyClass implementation");
    }
}




//In Java, if you have two interfaces that declare a default method with the same signature, it can lead to a compilation error if a class implements both interfaces. This situation is known as a "diamond problem" or "multiple inheritance problem."
//Here's an example to illustrate the issue:
//    ```java
//interface Interface1 {
//    default void myMethod() {
//        System.out.println("Default method in Interface1");
//    }
//}
//interface Interface2 {
//    default void myMethod() {
//        System.out.println("Default method in Interface2");
//    }
//}
//// This will result in a compilation error
//class MyClass implements Interface1, Interface2 {
//    // Error: class inherits unrelated defaults for myMethod() from types Interface1 and Interface2
//}
//```
//In this example, both `Interface1` and `Interface2` have a default method `myMethod()` with the same signature. When you try to implement both interfaces in the `MyClass` class, a compilation error occurs because the compiler cannot determine which default method to use.
//To resolve this issue, you need to provide an implementation for the conflicting method in the implementing class. You can choose to call one of the default methods using the interface name, or provide a completely new implementation:
//    ```java
//class MyClass implements Interface1, Interface2 {
//    @Override
//    public void myMethod() {
//        Interface1.super.myMethod(); // Calling the default method from Interface1
//        // or provide a completely new implementation
//        // System.out.println("MyClass implementation");
//    }
//}
//```
//By explicitly calling `Interface1.super.myMethod()`, you specify which default method you want to use in your class. Alternatively, you can provide a new implementation that suits the requirements of your class.