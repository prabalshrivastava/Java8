Semaphores are a synchronization mechanism used in concurrent programming to control access to a shared resource by multiple threads. A semaphore maintains a set of permits that can be acquired or released by threads. The number of available permits determines how many threads can access the resource concurrently.

There are two types of semaphores:

1. **Binary Semaphore (Mutex):**
   - Also known as a mutex (mutual exclusion), a binary semaphore has only two states: available (unlocked) or unavailable (locked).
   - It is typically used to protect a critical section of code, ensuring that only one thread can execute the protected code at a time.

2. **Counting Semaphore:**
   - A counting semaphore has an associated integer value that represents the number of available permits.
   - Threads can acquire and release permits, and the semaphore tracks the total number of permits available.
   - It is used to control access to a resource with multiple instances, allowing a specified number of threads to access the resource concurrently.

**Common Semaphore Operations:**
- `acquire()`: Requests a permit from the semaphore. If a permit is available, it is acquired; otherwise, the thread is blocked until a permit becomes available.
- `release()`: Releases a permit back to the semaphore, increasing the number of available permits.
- `tryAcquire()`: Attempts to acquire a permit without blocking. Returns `true` if successful; otherwise, returns `false`.
- `availablePermits()`: Returns the current number of available permits.

**Example Usage:**
```java
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final int MAX_AVAILABLE_PERMITS = 5;
    private static final Semaphore semaphore = new Semaphore(MAX_AVAILABLE_PERMITS);

    public static void main(String[] args) {
        // Threads trying to access a shared resource
        Thread thread1 = new Thread(SemaphoreExample::accessResource);
        Thread thread2 = new Thread(SemaphoreExample::accessResource);

        // Start the threads
        thread1.start();
        thread2.start();
    }

    private static void accessResource() {
        try {
            // Acquire a permit
            semaphore.acquire();
            System.out.println("Thread " + Thread.currentThread().getId() + " acquired a permit.");

            // Simulate some work with the shared resource
            Thread.sleep(2000);

            // Release the permit
            semaphore.release();
            System.out.println("Thread " + Thread.currentThread().getId() + " released a permit.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

In this example, two threads try to access a shared resource controlled by a semaphore. The semaphore ensures that no more than `MAX_AVAILABLE_PERMITS` threads can access the resource concurrently. Threads acquire and release permits using the `acquire()` and `release()` methods, respectively.