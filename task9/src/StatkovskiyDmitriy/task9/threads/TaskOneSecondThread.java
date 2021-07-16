package StatkovskiyDmitriy.task9.threads;

public class TaskOneSecondThread implements Runnable {
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
                exception.printStackTrace();
            }
        }
    }
}