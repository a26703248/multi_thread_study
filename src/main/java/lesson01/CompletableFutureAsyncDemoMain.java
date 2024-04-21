package lesson01;

import java.util.concurrent.*;

public class CompletableFutureAsyncDemoMain {

    private static final ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {
        // default
//        defaultCTF();
        // specify thread pool
//        specifyThreadPool();
        // specify thread pool + thenRunAsync
        specifyThreadPoolAndAsync();
        pool.shutdown();
    }

    private static void specifyThreadPoolAndAsync() throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<Void> cft3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            return "over";
        }, pool).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " task1");
        }).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " task2");
        }).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " task3");
        });
        System.out.println(cft3.get(1, TimeUnit.SECONDS));
    }

    private static void specifyThreadPool() throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<Void> cft2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " start");
            return "over";
        }, pool).thenRun(() -> {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " task1");
        }).thenRun(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " task2");
        }).thenRun(() -> {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " task3");
        });
        System.out.println(cft2.get(1, TimeUnit.SECONDS));
    }

    private static void defaultCTF() throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<Void> cft = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " start");
            return "over";
        }).thenRun(() -> {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " task1");
        }).thenRun(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " task2");
        }).thenRun(() -> {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " task3");
        });
        System.out.println(cft.get(1, TimeUnit.SECONDS));
    }

}
