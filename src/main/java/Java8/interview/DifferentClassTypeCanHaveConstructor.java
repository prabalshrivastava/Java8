package Java8.interview;

import com.sun.jdi.InterfaceType;

public class DifferentClassTypeCanHaveConstructor {

}

//Let's go through each of these:

//    1. **Interfaces:**
//    - Interfaces in Java cannot have constructors. They only define method signatures, constants, and, starting from Java 8, default and static methods.

//   ```java
interface MyInterface {
  // No constructors allowed
}
//   ```

//       2. **Abstract Classes:**
//    - Abstract classes can have constructors. These constructors are typically used to initialize the state of the abstract class.

//    ```java
abstract class MyAbstractClass {

  public MyAbstractClass() {
    // constructor code
  }
}
//   ```

//       3. **Enums:**
//    - Enums in Java can have constructors, but they are implicitly private and can only be called within the enum itself.

//    ```java
enum MyEnum {
  VALUE1("First"), VALUE2("Second");

  private String description;

  MyEnum(String description) {
    this.description = description;
  }
}
//   ```

//       4. **Static Classes:**
//    - Java does not have a concept of "static classes" in the same way some other languages do. However, you can have static nested classes, and these can have constructors.

//    ```java
class OuterClass1 {

  static class StaticNestedClass {

    public StaticNestedClass() {
      // constructor code
    }
  }
}
//   ```

//       5. **Inner Classes:**
//    - Inner classes (non-static nested classes) can have constructors.

//    ```java
class OuterClass2 {

  class InnerClass2 {

    public InnerClass2() {
      // constructor code
    }
  }
}
//   ```

//       6. **Static Inner Classes:**
//    - Static inner classes can also have constructors.

//   ```java
class OuterClass {

  static class StaticInnerClass {

    public StaticInnerClass() {
      // constructor code
    }
  }
}
//   ```

//       7. **Record Classes:**
//    - Record classes in Java automatically generate constructors for their components (fields). You don't need to explicitly define constructors for records.

//    ```java
//record MyRecord(String name, int age) {
//  // Automatically generated constructor
//}
//   ```

//       8. **Local Classes:**
//    - Local classes (classes defined within a block of code) can have constructors.

//    ```java
class OuterClass3 {

  void outerMethod() {
    class LocalClass {

      public LocalClass() {
        // constructor code
      }
    }
  }
}
//   ```

//       9. **Anonymous Classes:**
//    - Anonymous classes can have instance initializers, but they don't have constructors in the traditional sense. Instead, they use instance initializers for initialization.

//    ```java
//InterfaceType anonymousObject = new InterfaceType() {
//  {
//    // instance initializer code
//  }
//
//  // other members
//};
//   ```

//       10. **Annotations:**
//    - Annotations themselves do not have constructors. However, when you define your custom annotation, you can use elements with default values to achieve a similar effect.

//    ```java
@interface MyAnnotation {

  String value() default "default value";
}
//    ```