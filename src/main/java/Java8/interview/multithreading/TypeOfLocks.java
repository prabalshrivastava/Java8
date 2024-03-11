package Java8.interview.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class TypeOfLocks {

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
    private final Lock reentrantLock = new ReentrantLock();

    // Method using ReentrantLock
    public void reentrantLockMethod() {
        reentrantLock.lock(); // Acquiring the lock
        try {
            // Atomic operation inside a critical section using ReentrantLock
            int currentValue = atomicCounter.getAndIncrement();
            System.out.println("Thread ID: " + Thread.currentThread().getId() +
                               " - ReentrantLock Method: Incremented Atomic Counter to " + currentValue);
        } finally {
            reentrantLock.unlock(); // Releasing the lock in a finally block
        }
    }

    // ReadWriteLock
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // Method using ReadWriteLock for reading
    public void readWriteLockReadMethod() {
        readWriteLock.readLock().lock(); // Acquiring the read lock
        try {
            // Read operation inside a critical section using ReadWriteLock
            int currentValue = atomicCounter.get();
            System.out.println("Thread ID: " + Thread.currentThread().getId() +
                               " - ReadWriteLock Read Method: Read Atomic Counter value: " + currentValue);
        } finally {
            readWriteLock.readLock().unlock(); // Releasing the read lock in a finally block
        }
    }

    // Method using ReadWriteLock for writing
    public void readWriteLockWriteMethod() {
        readWriteLock.writeLock().lock(); // Acquiring the write lock
        try {
            // Write operation inside a critical section using ReadWriteLock
            int currentValue = atomicCounter.getAndIncrement();
            System.out.println("Thread ID: " + Thread.currentThread().getId() +
                               " - ReadWriteLock Write Method: Incremented Atomic Counter to " + currentValue);
        } finally {
            readWriteLock.writeLock().unlock(); // Releasing the write lock in a finally block
        }
    }

    // StampedLock
    private final StampedLock stampedLock = new StampedLock();

    // Method using StampedLock for optimistic reading
    public void stampedLockOptimisticReadMethod() {
        long stamp = stampedLock.tryOptimisticRead(); // Attempting optimistic reading
        // No lock acquisition is needed for optimistic reading

        try {
            // Read operation inside a critical section using optimistic reading
            int currentValue = atomicCounter.get();
            System.out.println("Thread ID: " + Thread.currentThread().getId() +
                               " - StampedLock Optimistic Read Method: Read Atomic Counter value: " + currentValue);

            // Validating the stamp
            if (!stampedLock.validate(stamp)) {
                // Retry using a different lock strategy if the optimistic reading is invalidated
//                stampedLock.readLock().lock();
                try {
                    // Re-read or perform another read operation using the read lock
                } finally {
//                    stampedLock.readLock().unlock(); // Releasing the read lock in a finally block
                }
            }
        } finally {
            // Releasing the optimistic read lock (if acquired)
            stampedLock.unlock(stamp);
        }
    }

    public static void main(String[] args) {
        TypeOfLocks example = new TypeOfLocks();

        // Creating threads to demonstrate atomic operations with different locks
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                example.synchronizedMethod();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                example.reentrantLockMethod();
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                example.readWriteLockReadMethod();
            }
        });

        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                example.readWriteLockWriteMethod();
            }
        });

        Thread thread5 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                example.stampedLockOptimisticReadMethod();
            }
        });

        // Starting the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        // Waiting for threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Displaying the final value of the atomic counter
        System.out.println("Final Atomic Counter Value: " + example.atomicCounter.get());
    }
}
