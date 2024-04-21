package lesson01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureGetResultDemoMain {

    public static void main(String[] args) throws Exception {
        // get join complete getNow()
        CompletableFuture<String> rcft = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "over";
        });
        System.out.println(rcft.get());
        System.out.println(rcft.get(2, TimeUnit.SECONDS));
        System.out.println(rcft.join());
        System.out.println(rcft.getNow("empty"));
        System.out.println(rcft.complete("complete"));
    }
}
