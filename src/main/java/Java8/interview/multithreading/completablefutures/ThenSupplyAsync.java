package Java8.interview.multithreading.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class ThenSupplyAsync {

  public static void main(String[] args) {
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

    CompletableFuture<Integer> transformedFuture = future.thenApplyAsync(s -> {
      System.out.println("Thread: " + Thread.currentThread().getName());
      return s.length();
    });

    transformedFuture.thenAccept(length -> {
      System.out.println("Thread: " + Thread.currentThread().getName());
      System.out.println("Length of Hello: " + length);
    });
  }

}
