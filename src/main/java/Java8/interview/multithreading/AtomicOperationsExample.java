package Java8.interview.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicOperationsExample {

    // Atomic Variable
    private AtomicInteger atomicCounter = new AtomicInteger(0);

    // Synchronized method
    public synchronized void synchronizedMethod() {
        // Atomic operation inside a synchronized method
        // This ensures that only one thread can execute this block at a time
        int currentValue = atomicCounter.getAndIncrement();
        System.out.println("Thread ID: " + Thread.currentThread().getId() +
                           " - Synchronized Method: Incremented Atomic Counter to " + currentValue);
    }

    // ReentrantLock
    private final Lock lock = new ReentrantLock();

    // Method using ReentrantLock
    public void lockMethod() {
        lock.lock(); // Acquiring the lock
        try {
            // Atomic operation inside a critical section using ReentrantLock
            int currentValue = atomicCounter.getAndIncrement();
            System.out.println("Thread ID: " + Thread.currentThread().getId() +
                               " - ReentrantLock Method: Incremented Atomic Counter to " + currentValue);
        } finally {
            lock.unlock(); // Releasing the lock in a finally block
        }
    }

    // Non-synchronized method
    public void nonSynchronizedMethod() {
        // Atomic operation outside a synchronized or locked block
        int currentValue = atomicCounter.getAndIncrement();
        System.out.println("Thread ID: " + Thread.currentThread().getId() +
                           " - Non-Synchronized Method: Incremented Atomic Counter to " + currentValue);
    }

    public static void main(String[] args) {
        AtomicOperationsExample example = new AtomicOperationsExample();

        // Creating threads to demonstrate atomic operations
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                example.synchronizedMethod();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                example.lockMethod();
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                example.nonSynchronizedMethod();
            }
        });

        // Starting the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Waiting for threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Displaying the final value of the atomic counter
        System.out.println("Final Atomic Counter Value: " + example.atomicCounter.get());
    }
}
