package Java8.interview.multithreading.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenAccept {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(1000);
        return "Hello World!";
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, executorService);
    future1.thenAccept(x -> System.out.println(Thread.currentThread().getName() + " -> " + x));
    System.out.println(Thread.currentThread().getName());
  }
}