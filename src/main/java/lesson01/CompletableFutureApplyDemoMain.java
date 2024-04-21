package lesson01;

import java.util.concurrent.*;

public class CompletableFutureApplyDemoMain {
    private static final ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {
        // thenApply and handle
        CompletableFuture.supplyAsync(() -> {
                    System.out.println(Thread.currentThread().getName() + " task 1");
                    return 1;
                }, pool).thenApply(task1 -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " task 2");
                    return task1 += 1;
                }).thenApply(task2 -> {
                    System.out.println(Thread.currentThread().getName() + " task 3");
                    int i = 10 / 0;
                    return task2 += 1;
                })
                .handle((task3, e) -> {
                    System.out.println(Thread.currentThread().getName() + " task 4");
                    return task3+=1;
                })
                .whenComplete((v, e) -> {
                    if (e == null) {
                        System.out.println(Thread.currentThread().getName() + " result: " + v);
                    }
                }).exceptionally(e -> {
                    System.out.println("error: " + e.getCause() + "\n" + e.getMessage());
                    return null;
                });
        System.out.println("main running");
        pool.shutdown();
    }
}
