package Java8.interview.multithreading.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UsingArrayBlockingQueue {

  public static void main(String[] args) {
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    final Runnable producer = () -> {
      int i = 0;
      while (true) {
        try {
          System.out.println("Putting : " + queue);
          queue.put(i++);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    };

    new Thread(producer).start();
    new Thread(producer).start();


    final Runnable consumer = () -> {
      while (true){
        Integer take = null;
        try {
          System.out.println("taking : " + queue);
          take = queue.take();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
//        System.out.println(take);
      }
    };
    new Thread(consumer).start();
    new Thread(consumer).start();
  }
}
