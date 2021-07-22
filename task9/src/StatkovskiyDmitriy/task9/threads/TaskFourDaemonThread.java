package StatkovskiyDmitriy.task9.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;

public class TaskFourDaemonThread implements Runnable {
    static Logger logger = LoggerFactory.getLogger(TaskFourDaemonThread.class);
    private int seconds = 1;

    private boolean isActive = true;

    public void setActive(boolean active) {
        isActive = active;
    }

    public void disable() {
        isActive = false;
    }

    TaskFourDaemonThread() {
    }

    public TaskFourDaemonThread(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public synchronized void run() {
        while (isActive) {
            System.out.println(LocalTime.now());
            try {
                wait(seconds * 1000);
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage() + " " + exception.getCause());
                logger.warn("InterruptedException TaskFourDaemonThread.run");
            }
        }
    }
}
