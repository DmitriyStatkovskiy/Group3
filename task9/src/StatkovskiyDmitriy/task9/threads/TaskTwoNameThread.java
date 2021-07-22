package StatkovskiyDmitriy.task9.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskTwoNameThread implements Runnable {
    static Logger logger = LoggerFactory.getLogger(TaskTwoNameThread.class);
    boolean isActive = true;

    public void setActive(boolean active) {
        isActive = active;
    }

    public void disable() {
        isActive = false;
    }

    @Override
    public synchronized void run() {
        try {
            while (isActive) {
                System.out.println("Dmitriy");
                Thread.sleep(100);
            }
        } catch (InterruptedException exception) {
            System.out.println(exception.getMessage() + " " + exception.getCause());
            logger.warn("InterruptedException TaskTwoNameThread.run");
        }
    }
}
