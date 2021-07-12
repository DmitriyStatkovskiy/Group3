package StatkovskiyDmitriy.task9.threads;

import java.time.LocalTime;

public class DaemonThread implements Runnable {
    private int seconds = 1;

    private boolean isActive = true;

    public int getSeconds() {
        return seconds;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void disable() {
        isActive = false;
    }

    DaemonThread() {
    }

    public DaemonThread(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public synchronized void run() {
        try {
            while (isActive) {
                System.out.println(LocalTime.now());
                wait(seconds * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
