package Java8.interview.multithreading.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1. supplyAsync(Supplier<U> supplier)
        // Runs a task asynchronously that returns a result.
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");

        // 2. runAsync(Runnable runnable)
        // Runs a task asynchronously that doesn't return any result.
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println("Running async task"));

        // 3. thenApply(Function<T, U> fn)
        // Transforms the result of this CompletableFuture after it completes.
        CompletableFuture<String> future3 = future1.thenApply(result -> result + " World");

        // 4. thenAccept(Consumer<T> action)
        // Consumes the result of this CompletableFuture after it completes.
        CompletableFuture<Void> future4 = future3.thenAccept(result -> System.out.println("Result: " + result));

        // 5. thenRun(Runnable action)
        // Runs a task after this CompletableFuture completes, ignoring the result.
        CompletableFuture<Void> future5 = future4.thenRun(() -> System.out.println("All tasks completed"));

        // 6. thenCompose(Function<T, CompletableFuture<U>> fn)
        // Flattens two CompletableFutures into a single one by chaining.
        CompletableFuture<String> future6 = future1.thenCompose(result -> CompletableFuture.supplyAsync(() -> result + " Universe"));

        // 7. thenCombine(CompletionStage<U> other, BiFunction<T, U, V> fn)
        // Combines the results of two CompletableFutures and returns a new one.
        CompletableFuture<String> future7 = future1.thenCombine(future6, (result1, result2) -> result1 + " and " + result2);

        // 8. handle(BiFunction<T, Throwable, U> fn)
        // Handles both result and exception of this CompletableFuture.
        CompletableFuture<String> future8 = future1.handle((result, ex) -> result != null ? result + " Handled" : "Error occurred");

        // 9. exceptionally(Function<Throwable, T> fn)
        // Recovers from exceptions that occur during computation.
        CompletableFuture<Object> future9 = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Error");
        }).exceptionally(ex -> "Recovered from error");

        // 10. allOf(CompletableFuture<?>... cfs)
        // Returns a CompletableFuture that completes when all of the given CompletableFutures complete.
        CompletableFuture<Void> future10 = CompletableFuture.allOf(future1, future3, future6);

        // 11. anyOf(CompletableFuture<?>... cfs)
        // Returns a CompletableFuture that completes when any of the given CompletableFutures complete.
        CompletableFuture<Object> future11 = CompletableFuture.anyOf(future1, future3, future6);

        // 12. complete(T value)
        // Manually completes this CompletableFuture with the given value.
        CompletableFuture<String> future12 = new CompletableFuture<>();
        future12.complete("Completed manually");
        System.out.println(future12.get()); // Output: Completed manually

        // 13. completeExceptionally(Throwable ex)
        // Completes this CompletableFuture with an exception.
        CompletableFuture<String> future13 = new CompletableFuture<>();
        future13.completeExceptionally(new RuntimeException("Manual exception"));
        future13.exceptionally(ex -> "Handled exception").thenAccept(System.out::println);

        // 14. whenComplete(BiConsumer<? super T, ? super Throwable> action)
        // Executes a callback after this CompletableFuture completes, handling both result and exception.
        CompletableFuture<String> future14 = future1.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Completed with: " + result);
            } else {
                System.out.println("Completed with exception: " + ex.getMessage());
            }
        });

        // 15. toCompletableFuture()
        // Returns this CompletableFuture instance itself.
        CompletableFuture<String> future15 = future1.toCompletableFuture();

        // 16. applyToEither(CompletionStage<? extends T> other, Function<? super T, U> fn)
        // Applies a function to the result of whichever CompletableFuture completes first.
        CompletableFuture<String> future16 = future1.applyToEither(future6, result -> result + " Fastest");

        // 17. acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action)
        // Consumes the result of whichever CompletableFuture completes first.
        CompletableFuture<Void> future17 = future1.acceptEither(future6, result -> System.out.println("Fastest result: " + result));

        // 18. runAfterEither(CompletionStage<?> other, Runnable action)
        // Runs a task after either of the two CompletableFutures complete.
        CompletableFuture<Void> future18 = future1.runAfterEither(future6, () -> System.out.println("One of the tasks completed"));

        // 19. runAfterBoth(CompletionStage<?> other, Runnable action)
        // Runs a task after both CompletableFutures complete.
        CompletableFuture<Void> future19 = future1.runAfterBoth(future6, () -> System.out.println("Both tasks completed"));

        // 20. thenAcceptBoth(CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action)
        // Consumes the results of both CompletableFutures when they complete.
        CompletableFuture<Void> future20 = future1.thenAcceptBoth(future6, (result1, result2) -> System.out.println(result1 + " and " + result2));

        // 21. completeAsync(Supplier<? extends T> supplier)
        // Completes this CompletableFuture asynchronously using the provided supplier.
        CompletableFuture<String> future21 = new CompletableFuture<>();
        future21.completeAsync(() -> "Completed asynchronously");

        // 22. orTimeout(long timeout, TimeUnit unit)
        // Completes this CompletableFuture exceptionally if not completed within the specified timeout.
        CompletableFuture<String> future22 = future1.orTimeout(1, TimeUnit.SECONDS);

        // 23. completeOnTimeout(T value, long timeout, TimeUnit unit)
        // Completes this CompletableFuture with the provided value if not completed within the specified timeout.
        CompletableFuture<String> future23 = future1.completeOnTimeout("Timeout value", 1, TimeUnit.SECONDS);

        // 24. delayedExecutor(long delay, TimeUnit unit)
        // Returns an executor that delays execution of tasks for a specified time.
        CompletableFuture<String> future24 = CompletableFuture.supplyAsync(() -> "Delayed Hello", CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS));

        // 25. minimalCompletionStage()
        // Returns a minimal CompletionStage that completes when this stage completes.
        CompletableFuture<String> future25 = future1.minimalCompletionStage().toCompletableFuture();

        // 26. newIncompleteFuture()
        // Returns a new incomplete CompletableFuture of the same type as this one.
        CompletableFuture<String> future26 = future1.newIncompleteFuture();
        future26.complete("New Incomplete Future");

        // Wait for futures to complete (just for demonstration purposes)
        CompletableFuture.allOf(future1, future2, future3, future4, future5, future6, future7, future8, future9, future10,
                future11, future12, future13, future14, future15, future16, future17, future18, future19, future20,
                future21, future22, future23, future24, future25, future26).join();

        System.out.println("All CompletableFutures executed.");
    }
}
