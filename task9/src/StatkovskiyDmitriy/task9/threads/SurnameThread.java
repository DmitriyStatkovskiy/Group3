package StatkovskiyDmitriy.task9.threads;

public class SurnameThread implements Runnable {
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
                System.out.println("Statkovskiy");
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
