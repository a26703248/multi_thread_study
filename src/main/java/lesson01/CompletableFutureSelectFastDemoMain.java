package lesson01;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureSelectFastDemoMain {

    public static void main(String[] args) {
        CompletableFuture<String> playerARunning = CompletableFuture.supplyAsync(() -> {
            System.out.println("player A running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "player A";
        });
        CompletableFuture<String> playerBRunning = CompletableFuture.supplyAsync(() -> {
            System.out.println("player B running");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "player B";
        });

        CompletableFuture<String> result = playerARunning.applyToEither(playerBRunning, f -> f + " winner");
        System.out.println(result.join());
    }

}
