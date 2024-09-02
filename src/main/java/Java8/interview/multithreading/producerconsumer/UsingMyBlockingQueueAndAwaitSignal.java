package Java8.interview.multithreading.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UsingMyBlockingQueueAndAwaitSignal {

  public static void main(String[] args) {
    MyBlockingQueue1<Integer> myBlockingQueue = new MyBlockingQueue1<>(10);
    final Runnable producer = () -> {
      int i = 0;
      while (true) {
        try {
          System.out.println("Putting : " + myBlockingQueue);
          myBlockingQueue.put(i++);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    };
    new Thread(producer).start();
    new Thread(producer).start();

    final Runnable consumer = () -> {
      int i = 0;
      while (true) {
        try {
          System.out.println("taking : " + myBlockingQueue);
          myBlockingQueue.take();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    };
    new Thread(consumer).start();
    new Thread(consumer).start();
  }
}

//when queue is full then producer has to wait
//when queue is empty then consumer has to wait

//So when queue was full and consumer consumed the element then consumer can signal
//Consumer Signals that Queue is definitely notFull so that producer can start producing again.

//So when queue was empty and producer produced an element then producer can signal
//Producer Signals that Queue is definitely notEmpty so that consumer can start consuming again

class MyBlockingQueue<T> {

  Lock lock = new ReentrantLock(true);
  Queue<T> queue = new LinkedList<>();
  Condition notEmpty = lock.newCondition();
  Condition notFull = lock.newCondition();
  int maxSize = 16;

  public MyBlockingQueue(int maxSize) {
    this.maxSize = maxSize;
  }

  public void put(T element) throws InterruptedException {
    lock.lock();
    try {
      while (queue.size() == maxSize) {
        //if Queue is at its max capacity then current thread has to wait
        // since there is no further space to add elements into the queue
        notFull.await();
      }
      queue.add(element);
      notEmpty.signalAll();
    } finally {
      lock.unlock();
    }
  }

  public T take() throws InterruptedException {
    lock.lock();
    try {
      while (queue.isEmpty()) {
        //If Queue is empty then current thread has to wait
        //since there are no further elements in the queue
        notEmpty.await();
      }
      T removedElement = queue.remove();
      notFull.signalAll();
      return removedElement;
    } finally {
      lock.unlock();
    }
  }

  @Override
  public String toString() {
    lock.lock();
    try {
      return "Queue: " + queue.toString();
    } finally {
      lock.unlock();
    }
  }
}
