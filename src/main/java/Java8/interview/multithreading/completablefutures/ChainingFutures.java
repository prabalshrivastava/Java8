package Java8.interview.multithreading.completablefutures;

import java.util.concurrent.*;

public class ChainingFutures {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(1000);
        return "Hello";
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, executorService);

    CompletableFuture<String> future2 = future1.thenApplyAsync(s -> s + "world!", executorService);
    CompletableFuture<String> future3 = future2.thenApplyAsync(s -> s + "!", executorService);
    System.out.println(future3.get());
  }
}