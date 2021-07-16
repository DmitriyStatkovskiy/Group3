package StatkovskiyDmitriy.task9.threads;

public class TaskTwoNameThread implements Runnable {
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
            exception.printStackTrace();
        }
    }
}
