package lesson01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureAcceptDemoMain {
    private static final ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        // thenRun
        System.out.println("thenRun: " + CompletableFuture.supplyAsync(()-> "task over")
                .thenRun(() ->System.out.println("run")).join());
        // thenAccept
        CompletableFuture<Void> cft = CompletableFuture.supplyAsync(() -> {
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
        }).thenAccept(System.out::println);
        System.out.println("thenAccept: " + cft.join());
        System.out.println("main running");
        pool.shutdown();
    }
}
