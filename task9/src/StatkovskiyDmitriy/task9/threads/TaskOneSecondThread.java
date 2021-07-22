package StatkovskiyDmitriy.task9.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskOneSecondThread implements Runnable {
    static Logger logger = LoggerFactory.getLogger(TaskOneSecondThread.class);
    private static final Object objectFromSecondThread = new Object();

    public static Object getObjectFromSecondThread() {
        return objectFromSecondThread;
    }

    @Override
    public void run() {
        synchronized (objectFromSecondThread) {
            try {
                objectFromSecondThread.wait();
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage() + " " + exception.getCause());
                logger.warn("InterruptedException TaskOneSecondThread.run");
            }
        }
    }
}