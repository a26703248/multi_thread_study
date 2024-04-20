package lesson01;

import java.util.concurrent.*;

public class FutureTaskDemoMain {

    private final static ExecutorService pool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        futureTaskGetResult();
        long endTime = System.currentTimeMillis();
        System.out.println("-------costTime: " + (endTime - startTime) + " millis");
        pool.shutdown();
    }

    // 1132 millis
    private static void notAsyncThread(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void futureTaskNotGetResult() {
        FutureTask<String> ft1 = new FutureTask<String>(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName() + " task over";
        });
        pool.submit(ft1);
        FutureTask<String> ft2 = new FutureTask<String>(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName() + " task over";
        });
        pool.submit(ft2);
        FutureTask<String> ft3 = new FutureTask<String>(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName() + " task over";
        });
        pool.submit(ft3);
    }

    private static void futureTaskGetResult() throws Exception {
        FutureTask<String> ft1 = new FutureTask<String>(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName() + " task over";
        });
        pool.submit(ft1);
        FutureTask<String> ft2 = new FutureTask<String>(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName() + " task over";
        });
        pool.submit(ft2);
        FutureTask<String> ft3 = new FutureTask<String>(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName() + " task over";
        });
        pool.submit(ft3);
        System.out.println(ft1.get());
        System.out.println(ft2.get());
        System.out.println(ft3.get());
    }

}
