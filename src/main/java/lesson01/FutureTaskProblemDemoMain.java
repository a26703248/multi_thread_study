package lesson01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskProblemDemoMain {

    public static void main(String[] args) throws Exception {
        FutureTask<String> ft1 = new FutureTask<>(() -> {
            System.out.println("task running");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task over";
        });
        Thread t1 = new Thread(ft1);
        t1.start();
//        System.out.println(ft1.get()); // 當 get 先被呼叫時就必須等待返回結果，導致後續動作被阻塞

        System.out.println(Thread.currentThread().getName() + " other task running");

//        System.out.println(ft1.get());
//        System.out.println(ft1.get(3, TimeUnit.SECONDS));
    }

}
