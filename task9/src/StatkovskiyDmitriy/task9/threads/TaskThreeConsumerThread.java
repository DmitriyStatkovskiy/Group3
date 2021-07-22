package StatkovskiyDmitriy.task9.threads;

import StatkovskiyDmitriy.task9.Store;

public class TaskThreeConsumerThread implements Runnable {
    Store store;

    public TaskThreeConsumerThread(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
