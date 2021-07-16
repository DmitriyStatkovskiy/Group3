package StatkovskiyDmitriy.task9.threads;

import static java.lang.Thread.sleep;

public class TaskOneFirstThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getState() + " runnable");
        try {
            sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
