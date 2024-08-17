package Java8.interview.multithreading.futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureWithExecutorServiceAndCallable1 {
//https://connect2grp.medium.com/understating-java-future-and-callable-features-aec70d2aef6
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    example2WithLambda();
  }
  private static void example2WithLambda() throws InterruptedException, ExecutionException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<Integer> future = executorService.submit(() -> {
      Integer sum = 0;
      for (int i = 0; i < 1000000; i++) {
        System.out.println("adding ->" + sum);
        sum = sum + i;
      }
      return sum;
    });
    System.out.printf("future.isDone() : %s\n" , future.isDone());
    System.out.printf("future.isCancelled() : %s\n" , future.isCancelled());
    Integer ans = future.get();
    System.out.println(ans);
    executorService.shutdown();
  }
}
