package Java8.interview.multithreading.futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureWithExecutorServiceAndCallable {

  //https://connect2grp.medium.com/understating-java-future-and-callable-features-aec70d2aef6
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    example1();
    example2WithLambda();

    //Question -> How do I submit example1(); and example2WithLambda(); in threads.
  }

  private static void example1() throws InterruptedException, ExecutionException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<String> future = executorService.submit(new Callable<String>() {
      @Override
      public String call() {
        return "Hello World";
      }
    });
    System.out.printf("future.isDone() : %s\n", future.isDone());
    System.out.printf("future.isCancelled() : %s\n", future.isCancelled());
    String string = future.get();
    System.out.println(string);
    executorService.shutdown();
  }

  private static void example2WithLambda() throws InterruptedException, ExecutionException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<String> future = executorService.submit(() -> "Hello World");
    System.out.printf("future.isDone() : %s\n", future.isDone());
    System.out.printf("future.isCancelled() : %s\n", future.isCancelled());
    String string = future.get();
    System.out.println(string);
    executorService.shutdown();
  }
}
