package Java8.interview;// TypesOfFieldModifiersInJava.java

// Outer class demonstrating various field modifiers
public class TypesOfFieldModifiersInJava {

    // Public field - accessible from any class
    public int publicField;

    // Protected field - accessible within its own package and by subclasses
    protected int protectedField;

    // Default (package-private) field - accessible only within its own package
    int defaultField;

    // Private field - accessible only within its own class
    private int privateField;

    // Static field - belongs to the class, not to instances of the class
    static int staticField;

    // Final field - cannot be modified (constant)
    final int constantField = 42;

    // Transient field - should not be serialized
    transient int transientField;

    // Volatile field - may be changed by multiple threads
    volatile int volatileField;

    // Abstract field - applicable only to interfaces; must be implemented by implementing classes
    interface MyInterface {
        // Abstract field in an interface (implicitly public, static, and final)
        int abstractField = 10;
    }

    // Synchronized method - ensures that only one thread can access this method at a time
    synchronized void synchronizedMethod() {
        // Synchronized method implementation
    }

    // Method to demonstrate transient field
    void demonstrateTransientField() {
        // Setting a value to the transient field
        transientField = 100;

        // Displaying the transient field
        System.out.println("Demonstrating Transient Field:");
        System.out.println("Before Serialization: transientField = " + transientField);

        // Simulating serialization and deserialization
        serializeAndDeserialize();

        // Displaying the transient field after deserialization
        System.out.println("After Deserialization: transientField = " + transientField);
    }

    // Method to demonstrate volatile field
    void demonstrateVolatileField() {
        // Starting a new thread to modify the volatile field
        new Thread(() -> {
            System.out.println("Demonstrating Volatile Field:");
            System.out.println("Thread 1: Modifying volatileField");
            // Modifying the volatile field
            volatileField = 200;
        }).start();

        // Starting another thread to read the volatile field
        new Thread(() -> {
            try {
                // Sleeping for a while to ensure the first thread executes first
                Thread.sleep(1000);

                // Displaying the volatile field
                System.out.println("Thread 2: Reading volatileField = " + volatileField);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // Method to simulate serialization and deserialization
    private void serializeAndDeserialize() {
        // Simulating serialization by creating a byte array
        byte[] serializedData = serialize();

        // Simulating deserialization by reading from the byte array
        deserialize(serializedData);
    }

    // Method to serialize the object
    private byte[] serialize() {
        // In a real scenario, this method would convert the object to a byte array
        // Here, we're just returning a placeholder byte array
        return new byte[0];
    }

    // Method to deserialize the object
    private void deserialize(byte[] data) {
        // In a real scenario, this method would reconstruct the object from the byte array
        // Here, we're just using a placeholder operation
    }

    // Inner class
    class InnerClass {
        // Inner class can access all fields of the outer class
        void accessOuterFields() {
            System.out.println("InnerClass: Accessing outer fields");

            // Accessing fields of the outer class
            System.out.println("publicField: " + publicField);
            System.out.println("protectedField: " + protectedField);
            System.out.println("defaultField: " + defaultField);
            // System.out.println("privateField: " + privateField); // privateField is not accessible directly
            System.out.println("staticField: " + staticField);
            // System.out.println("constantField: " + constantField); // constantField is final and cannot be modified
            System.out.println("transientField: " + transientField);
            System.out.println("volatileField: " + volatileField);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating an instance of the outer class
        TypesOfFieldModifiersInJava example = new TypesOfFieldModifiersInJava();

        // Accessing and modifying fields through the instance of the outer class
        example.publicField = 1;
        example.protectedField = 2;
        example.defaultField = 3;
        // example.privateField = 4; // privateField is not accessible directly
        example.staticField = 5;
        // example.constantField = 6; // constantField is final and cannot be modified
        example.transientField = 7;
        example.volatileField = 8;

        // Creating an instance of the inner class
        InnerClass innerInstance = example.new InnerClass();
        innerInstance.accessOuterFields();

        // Demonstrating transient and volatile fields
        example.demonstrateTransientField();
        example.demonstrateVolatileField();
    }
}
