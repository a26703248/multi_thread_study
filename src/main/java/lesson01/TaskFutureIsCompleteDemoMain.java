package lesson01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TaskFutureIsCompleteDemoMain {

    public static void main(String[] args) throws Exception {
        FutureTask<String> ft1 = new FutureTask<>(() -> {
            System.out.println("task running");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "async task over";
        });
        Thread t1 = new Thread(ft1);
        t1.start();

        System.out.println(Thread.currentThread().getName() + " other task running");

        while (true) {
            if (ft1.isDone()){
                System.out.println(ft1.get());
                break;
            } else {
                System.out.println("other task running");
            }
        }

    }

}
