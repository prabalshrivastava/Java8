The Java Threads API provides a variety of methods and concepts in the `Thread` class and related classes. Here's an overview of some of the key methods in the `Thread` class:

1. **Creating Threads:**
    - `Thread(Runnable target)`: Constructs a new thread with a specified `Runnable` target.
    - `Thread(Runnable target, String name)`: Constructs a new thread with a specified `Runnable` target and a name.
    - `Thread(String name)`: Constructs a new thread with a specified name.

2. **Starting and Running Threads:**
    - `start()`: Causes this thread to begin execution.
    - `run()`: Entry point for the thread. You override this method with the code to be executed by the thread.

3. **Thread Lifecycle:**
    - `sleep(long millis)`: Causes the currently executing thread to sleep for the specified milliseconds.
    - `join()`: Waits for this thread to die.
    - `isAlive()`: Tests if this thread is alive.

4. **Thread Priority:**
    - `setPriority(int priority)`: Sets the priority of this thread.
    - `getPriority()`: Returns the priority of this thread.

5. **Thread Interruption:**
    - `interrupt()`: Interrupts this thread.
    - `isInterrupted()`: Tests whether the current thread has been interrupted.
    - `interrupted()`: Tests whether the current thread has been interrupted and clears the interrupt status.

6. **Synchronization:**
    - `synchronized`: Keyword used to define critical sections and methods to control access to shared resources.
    - `wait()`: Causes the current thread to wait until another thread invokes the `notify()` method or `notifyAll()` method.
    - `notify()`: Wakes up a single thread that is waiting on this object's monitor.
    - `notifyAll()`: Wakes up all threads that are waiting on this object's monitor.

7. **Thread Group:**
    - `ThreadGroup`: A class representing a group of threads.
    - `Thread(ThreadGroup group, Runnable target)`: Constructs a new thread with a specified thread group and target.

8. **Daemon Threads:**
    - `setDaemon(boolean on)`: Marks this thread as either a daemon thread or a user thread.

9. **Thread States:**
    - `getState()`: Returns the state of this thread.

10. **Thread Local Variables:**
    - `ThreadLocal`: Provides thread-local variables.

11. **Concurrency Utilities:**
    - `java.util.concurrent`: Package providing high-level concurrency utilities, such as `ExecutorService`, `Future`, etc.

These are just some of the key methods and concepts provided by the Java Threads API. It's important to explore the Java documentation for `Thread` and related classes for a more comprehensive understanding of multithreading in Java.