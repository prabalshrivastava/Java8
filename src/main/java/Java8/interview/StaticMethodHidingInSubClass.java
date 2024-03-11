package Java8.interview;

class Parent {
    static void staticMethod() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    static void staticMethod() {
        System.out.println("Static method in Child");
    }
}

public class StaticMethodHidingInSubClass {
    public static void main(String[] args) {
        // Calling static method through the class itself
        Parent.staticMethod(); // Output: Static method in Parent
        Child.staticMethod();  // Output: Static method in Child

        // Accessing through instances (not recommended)
        Parent parentInstance = new Parent();
        Parent childInstance = new Child();

        parentInstance.staticMethod(); // Output: Static method in Parent
        childInstance.staticMethod();  // Output: Static method in Parent
    }
}




//Static methods in Java are not inherited in the traditional sense. Unlike instance methods, static methods are associated with the class or interface itself rather than with instances of the class or implementing classes in the case of interfaces.
//
//When a subclass is created, it does not inherit static methods from its superclass. However, static methods can be accessed through the class itself. If a subclass defines a static method with the same signature as a static method in its superclass, it is said to hide the superclass's static method, but it's not really inheritance in the usual sense.
//
//Here's a quick example:
//
//    ```java
//class Parent {
//    static void staticMethod() {
//        System.out.println("Static method in Parent");
//    }
//}
//
//class Child extends Parent {
//    static void staticMethod() {
//        System.out.println("Static method in Child");
//    }
//}
//
//public class Main {Static methods in Java are not inherited in the traditional sense. Unlike instance methods, static methods are associated with the class or interface itself rather than with instances of the class or implementing classes in the case of interfaces.
//
//When a subclass is created, it does not inherit static methods from its superclass. However, static methods can be accessed through the class itself. If a subclass defines a static method with the same signature as a static method in its superclass, it is said to hide the superclass's static method, but it's not really inheritance in the usual sense.
//
//Here's a quick example:
//
//```java
//class Parent {
//    static void staticMethod() {
//        System.out.println("Static method in Parent");
//    }
//}
//
//class Child extends Parent {
//    static void staticMethod() {
//        System.out.println("Static method in Child");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        // Calling static method through the class itself
//        Parent.staticMethod(); // Output: Static method in Parent
//        Child.staticMethod();  // Output: Static method in Child
//
//        // Accessing through instances (not recommended)
//        Parent parentInstance = new Parent();
//        Parent childInstance = new Child();
//
//        parentInstance.staticMethod(); // Output: Static method in Parent
//        childInstance.staticMethod();  // Output: Static method in Parent
//    }
//}
//```
//
//As shown in the example, calling `staticMethod()` through an instance is discouraged because it can lead to confusion. The actual method called depends on the declared type of the reference, not the actual type of the object.
//
//In summary, static methods are not inherited in the traditional sense, but they can be accessed through the class itself. If a subclass defines a static method with the same signature, it hides the static method of its superclass.
//    public static void main(String[] args) {
//        // Calling static method through the class itself
//        Parent.staticMethod(); // Output: Static method in Parent
//        Child.staticMethod();  // Output: Static method in Child
//
//        // Accessing through instances (not recommended)
//        Parent parentInstance = new Parent();
//        Parent childInstance = new Child();
//
//        parentInstance.staticMethod(); // Output: Static method in Parent
//        childInstance.staticMethod();  // Output: Static method in Parent
//    }
//}
//```
//
//As shown in the example, calling `staticMethod()` through an instance is discouraged because it can lead to confusion. The actual method called depends on the declared type of the reference, not the actual type of the object.
//
//In summary, static methods are not inherited in the traditional sense, but they can be accessed through the class itself. If a subclass defines a static method with the same signature, it hides the static method of its superclass.
