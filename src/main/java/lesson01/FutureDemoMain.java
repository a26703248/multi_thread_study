package lesson01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureDemoMain {

    public static void main(String[] args) throws Exception {
        Runnable myRunnable = () -> {
            System.out.println("runnable: " + Thread.currentThread().getName());
        };
        Callable<String> myCallable = () -> "callable: " + Thread.currentThread().getName();
        // 合併 callable 使用，因為 Thread 物件只能傳入 Runnable 介面子類別
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread t1 = new Thread(myRunnable, "t1");
        Thread t2 = new Thread(futureTask, "t2");
        t1.start();
        t2.start();
        System.out.println(futureTask.get());
    }

}
