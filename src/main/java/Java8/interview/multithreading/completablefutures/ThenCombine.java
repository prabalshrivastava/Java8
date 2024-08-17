package Java8.interview.multithreading.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenCombine {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
      try {
        printCurrentThread();
        Thread.sleep(1000);
        printCurrentThread();
        return 10;
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, executorService);

    CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
      try {
        printCurrentThread();
        Thread.sleep(1000);
        printCurrentThread();
        return 20;
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, executorService);
    printCurrentThread();
    CompletableFuture<Integer> future = future1.thenCombine(future2, (x, y) -> x + y);
    printCurrentThread();
    System.out.println("[" + System.currentTimeMillis() + "]" + " Inside Thread " + Thread.currentThread() + " RESULT -> "  + future.get());
    printCurrentThread();
    executorService.shutdown();
  }

  private static void printCurrentThread() {
    System.out.println(
        "[" + System.currentTimeMillis() + "]" + " Inside Thread " + Thread.currentThread());
  }
}