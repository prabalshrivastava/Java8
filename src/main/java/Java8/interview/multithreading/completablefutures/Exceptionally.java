package Java8.interview.multithreading.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exceptionally {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    CompletableFuture<Object> future1 = CompletableFuture.supplyAsync(() -> {
          throw new RuntimeException("Something went wrong");
        },
        executorService);

    CompletableFuture<Object> future2 = future1.exceptionally(throwable -> {
      System.out.println(throwable.getMessage());
      return "Default Value";
    });

    System.out.println(future2.get());
    executorService.shutdown();


  }

  private static void printCurrentThread() {
    System.out.println(
        "[" + System.currentTimeMillis() + "]" + " Inside Thread " + Thread.currentThread());
  }
}