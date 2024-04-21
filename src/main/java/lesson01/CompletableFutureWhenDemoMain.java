package lesson01;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.beans.JavaBean;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureWhenDemoMain {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task2 over";
        }).whenComplete((v, e) -> {
            if(e == null){
                System.out.println("compute complete, update status: " + v);
            }
        }).exceptionally(e -> {
            System.out.println("error: " + e.getCause() + e.getMessage());
            return null;
        });
        System.out.println("main run");
    }

}
