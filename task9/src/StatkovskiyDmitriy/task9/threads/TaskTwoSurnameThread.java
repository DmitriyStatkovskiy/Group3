package StatkovskiyDmitriy.task9.threads;

public class TaskTwoSurnameThread implements Runnable {
    boolean isActive = true;

    public void setActive(boolean active) {
        isActive = active;
    }

    public void disable() {
        isActive = false;
    }

    @Override
    public synchronized void run() {
        while (isActive) {
            System.out.println("Statkovskiy");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
