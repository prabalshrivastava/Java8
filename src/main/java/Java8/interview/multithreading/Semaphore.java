package Java8.interview.multithreading;

public class Semaphore {
    // Maximum number of permits (available resources)
    private static final int MAX_AVAILABLE_PERMITS = 3;

    // Semaphore with the specified number of permits
    private static final java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(MAX_AVAILABLE_PERMITS);

    public static void main(String[] args) {
        // Creating threads to demonstrate semaphore operations
        Thread thread1 = new Thread(() -> performOperation("Thread 1"));
        Thread thread2 = new Thread(() -> performOperation("Thread 2"));

        // Start the threads
        thread1.start();
        thread2.start();
    }

    private static void performOperation(String threadName) {
        try {
            // Acquiring a permit from the semaphore
            System.out.println(threadName + " is trying to acquire a permit.");
            semaphore.acquire();
            System.out.println(threadName + " acquired a permit. Available permits: " + semaphore.availablePermits());

            // Simulating some work with the shared resource
            System.out.println(threadName + " is performing some work with the shared resource.");

            // Releasing the acquired permit back to the semaphore
            semaphore.release();
            System.out.println(threadName + " released a permit. Available permits: " + semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//Initialization:
//private static final int MAX_AVAILABLE_PERMITS = 3;: Defines the maximum number of permits (available resources).
//private static final Semaphore semaphore = new Semaphore(MAX_AVAILABLE_PERMITS);: Initializes a Semaphore with the specified number of permits.
//Acquiring Permits:
//    semaphore.acquire();: Threads attempt to acquire a permit from the semaphore.
//    System.out.println(threadName + " acquired a permit. Available permits: " + semaphore.availablePermits());: Displays a message when a thread successfully acquires a permit.
//Simulating Work:
//    System.out.println(threadName + " is performing some work with the shared resource.");: Simulates some work being done with the shared resource.
//Releasing Permits:
//    semaphore.release();: Threads release the acquired permit back to the semaphore.
//    System.out.println(threadName + " released a permit. Available permits: " + semaphore.availablePermits());: Displays a message when a thread releases a permit.
//The code showcases how multiple threads interact with the semaphore to control access to a shared resource, ensuring that the maximum number of threads accessing the resource concurrently does not exceed the specified limit.