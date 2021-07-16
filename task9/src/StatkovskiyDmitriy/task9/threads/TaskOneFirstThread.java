package StatkovskiyDmitriy.task9.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

public class TaskOneFirstThread implements Runnable {
    static Logger logger = LoggerFactory.getLogger(TaskOneFirstThread.class);

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getState() + " runnable");
        try {
            sleep(1000);
        } catch (InterruptedException exception) {
            System.out.println(exception.getMessage() + " " + exception.getCause());
            logger.warn("InterruptedException TaskOneSecondThread.run");
        }
    }
}
