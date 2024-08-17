package Java8.interview.multithreading.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AllOf {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
      try {
        System.out.println(System.currentTimeMillis() + " Executing -> Task 1 from " + Thread.currentThread());
        Thread.sleep(1000);
        return System.currentTimeMillis() + " -> Task 1 from " + Thread.currentThread();
      } catch (InterruptedException e) {
        return "Interrupted" + Thread.currentThread();
      }
    }, executorService);

    CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
      try {
        System.out.println(System.currentTimeMillis() + " Executing -> Task 2 from " + Thread.currentThread());
        Thread.sleep(1000);
        return System.currentTimeMillis() + " -> Task 2 from " + Thread.currentThread();
      } catch (InterruptedException e) {
        return "Interrupted" + Thread.currentThread();
      }
    }, executorService);

    CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
      try {
        System.out.println(System.currentTimeMillis() + " Executing -> Task 3 from " + Thread.currentThread());
        Thread.sleep(1000);
        return System.currentTimeMillis() + " -> Task 3 from " + Thread.currentThread();
      } catch (InterruptedException e) {
        return "Interrupted" + Thread.currentThread();
      }
    }, executorService);

    CompletableFuture<Void> allTasks = CompletableFuture.allOf(future1, future2,
        future3);
    System.out.println(allTasks.get());
    System.out.println(future1.get());
    System.out.println(future2.get());
    System.out.println(future3.get());

    executorService.shutdown();
  }
}
