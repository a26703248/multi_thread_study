package lesson01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemoMain {

    public static void main(String[] args) throws Exception {
        // not result
        CompletableFuture<Void> notResult = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(notResult.get());
        // has result
        CompletableFuture<String> hasResult = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task2 over";
        });
        System.out.println(hasResult.get());
    }

}
