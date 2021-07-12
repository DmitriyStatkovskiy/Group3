package StatkovskiyDmitriy.task9.threads;

public class TaskOneSecondThread implements Runnable {
    private static Object a = new Object();
    public static Object getA() {
        return a;
    }

    @Override
    public void run() {
        try {
            synchronized (a) {
                a.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

