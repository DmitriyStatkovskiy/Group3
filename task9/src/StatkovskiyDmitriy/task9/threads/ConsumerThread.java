package StatkovskiyDmitriy.task9.threads;

import StatkovskiyDmitriy.task9.Store;

public class ConsumerThread implements Runnable {
    Store store;

    public ConsumerThread(Store store) {
        this.store = store;
    }

    boolean isActive = true;

    public void setActive(boolean active) {
        isActive = active;
    }

    public void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
