package Java8.interview;// TypesOfInnerClasses.java

// Member Inner Class
public class TypesOfInnerClasses {
    private int outerField = 10; // Accessible by the InnerClass

    // Member Inner Class has access to the private field of TypesOfInnerClasses
    class InnerClass {
        void display() {
            System.out.println("InnerClass: outerField = " + outerField);
        }
    }

    // Static Nested Class
    // No access to instance variables of TypesOfInnerClasses without an instance
    static class StaticNestedClass {
        // Cannot access outerField directly
        void display() {
            System.out.println("StaticNestedClass: Cannot access outerField directly");
            // Reason: StaticNestedClass is a static class, and static members cannot access instance variables directly.
        }
    }

    // Local Inner Class
    void outerMethod() {
        int localVariable = 20; // Accessible by LocalInnerClass

        // Local Inner Class has access to the local variables of outerMethod
        class LocalInnerClass {
            void display() {
                System.out.println("LocalInnerClass: localVariable = " + localVariable);
                System.out.println("LocalInnerClass: outerField is accessible indirectly: " + outerField);
                // Reason: LocalInnerClass can access the local variables of outerMethod, including localVariable,
                // and it can indirectly access outerField since outerField is a member of the outer class.
            }
        }

        LocalInnerClass localInner = new LocalInnerClass();
        localInner.display();
    }

    // Anonymous Inner Class
    interface MyInterface {
        void myMethod();
    }

    // Anonymous Inner Class does not have direct access to TypesOfInnerClasses's instance variables
    MyInterface anonymousObject = new MyInterface() {
        // Cannot access outerField directly
        public void myMethod() {
            System.out.println("AnonymousInnerClass: Cannot access outerField directly");
            // Reason: Anonymous inner class is created without an instance, and it cannot directly access instance variables.
        }
    };

    public static void main(String[] args) {
        TypesOfInnerClasses outer = new TypesOfInnerClasses();

        // Member Inner Class
        InnerClass inner = outer.new InnerClass();
        inner.display();

        // Static Nested Class
        StaticNestedClass staticNested = new StaticNestedClass();
        staticNested.display();

        // Local Inner Class
        outer.outerMethod();

        // Anonymous Inner Class
        outer.anonymousObject.myMethod();
    }
}
