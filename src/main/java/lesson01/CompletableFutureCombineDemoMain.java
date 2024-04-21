package lesson01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureCombineDemoMain {

    private static final ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        }, pool);
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        }, pool);
        CompletableFuture<Integer> task3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 30;
        });
        CompletableFuture<Integer> result = task1.thenCombine(task2, Integer::sum)
                .thenCombine(task3, Integer::sum);
        System.out.println(result.join());
        pool.shutdown();

    }
}
