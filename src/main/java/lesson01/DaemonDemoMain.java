package lesson01;

public class DaemonDemoMain {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                // 等待
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        });
        thread.setDaemon(true);
        thread.start();
    }
}
