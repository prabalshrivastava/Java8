package Java8.interview.multithreading.completablefutures;

import java.util.concurrent.*;
import javax.annotation.processing.Completion;

public class ChainingFutures {


//  Future vs CompletableFuture
//  Future and CompletableFuture are both abstractions for representing a result that will be available in the future, but there are some important differences between them.
//
//  Blocking vs non-blocking: One of the key differences between Future and CompletableFuture is that Future is a blocking API, whereas CompletableFuture is non-blocking. With a Future object, you must call the get() method to retrieve the result, but this method blocks until the result is available. In contrast, with a CompletableFuture object, you can use various non-blocking methods to retrieve the result, such as thenApply(), thenAccept(), or join().
//  Composition: CompletableFuture provides a more powerful composition API than Future. With Future, it is difficult to chain multiple asynchronous operations together or to combine the results of multiple operations. CompletableFuture, on the other hand, provides methods such as thenCompose(), thenCombine(), and allOf() that make it easy to compose multiple asynchronous operations and to handle their results in a non-blocking way.
//  Exception Handling: CompletableFuture provides better exception handling than Future. With Future, you can only check if the computation completed successfully or not. If an exception occurs during the computation, you have to catch it explicitly. In contrast, with CompletableFuture, you can handle exceptions in a more declarative way using methods like exceptionally() and handle().
//  Completion: With a Future object, there is no way to explicitly complete the future. Once you submit a task to an executor service and get a Future object in return, you can only wait for the task to complete. With CompletableFuture, you have more control over the completion of the future. You can complete it explicitly by calling complete(), completeExceptionally(), or cancel() methods.
//  In summary, CompletableFuture provides a more flexible and powerful API for working with asynchronous computations than Future. It offers non-blocking methods, composition methods, better exception handling, and explicit completion methods, which makes it easier to write robust and scalable concurrent code.
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CompletableFuture<String> future1 = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
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