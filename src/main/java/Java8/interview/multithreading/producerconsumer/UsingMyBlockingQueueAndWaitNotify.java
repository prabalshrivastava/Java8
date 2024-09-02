package Java8.interview.multithreading.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UsingMyBlockingQueueAndWaitNotify {

  public static void main(String[] args) {
    MyBlockingQueue1<Integer> myBlockingQueue = new MyBlockingQueue1<>(10);
    final Runnable producer = () -> {
      int i = 0;
      while (true) {
        try {
          System.out.println("Putting : " + myBlockingQueue.queue);
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
          System.out.println("taking : " + myBlockingQueue.queue);
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

class MyBlockingQueue1<T> {

  Lock lock = new ReentrantLock(true);
  Queue<T> queue = new LinkedList<>();
  Object notEmpty = new Object();
  Object notFull = new Object();
  int maxSize = 16;

  public MyBlockingQueue1(int maxSize) {
    this.maxSize = maxSize;
  }

  public synchronized void put(T element) throws InterruptedException {
    while (queue.size() == maxSize) {
      //if Queue is at its max capacity then current thread has to wait
      // since there is no further space to add elements into the queue
      synchronized (notFull) {
        notFull.wait();
      }
    }
    queue.add(element);
    synchronized (notEmpty) {
      notEmpty.notifyAll();
    }

  }

  public synchronized T take() throws InterruptedException {
    while (queue.isEmpty()) {
      //If Queue is empty then current thread has to wait
      //since there are no further elements in the queue
      synchronized (notEmpty) {
        notEmpty.wait();
      }
    }
    T removedElement = queue.remove();
    synchronized (notFull) {
      notFull.notifyAll();
    }
    return removedElement;

  }

//  @Override
//  public String toString() {
//    return "Queue: " + queue.toString();
//  }
}
