package StatkovskiyDmitriy.task9;

import StatkovskiyDmitriy.task9.threads.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

public class Starter {
    static Logger logger = LoggerFactory.getLogger(Starter.class);

    public void taskOne() {
        try {
            Thread threadOne = new Thread(new TaskOneFirstThread());
            Thread threadTwo = new Thread(new TaskOneSecondThread());
            System.out.println(threadOne.getState() + " new");
            threadOne.start();
            threadTwo.start();
            sleep(500);
            System.out.println(threadOne.getState() + " timed_waiting");
            System.out.println(threadTwo.getState() + " waiting");

            Object object = TaskOneSecondThread.getObjectFromSecondThread();
            synchronized (object) {
                object.notify();
            }

            System.out.println(threadTwo.getState() + " blocked");
            sleep(2000);
            System.out.println(threadOne.getState() + " terminated");

        } catch (InterruptedException exception) {
            System.out.println(exception.getMessage() + " " + exception.getCause());
            logger.warn("InterruptedException Starter.taskOne");
        }
    }

    public void taskTwo() {
        Thread name = new Thread(new TaskTwoNameThread());
        Thread surname = new Thread(new TaskTwoSurnameThread());
        try {
            taskFour();
            surname.start();
            name.start();
            name.join();
        } catch (InterruptedException exception) {
            System.out.println(exception.getMessage() + " " + exception.getCause());
            logger.warn("InterruptedException Starter.taskTwo");
        }
    }

    public void taskFour() {
        Thread daemon = new Thread(new TaskFourDaemonThread(3));
        daemon.setDaemon(true);
        daemon.start();
    }

    public void taskThree() {
        Store store = new Store();
        TaskThreeProducerThread producer = new TaskThreeProducerThread(store);
        TaskThreeConsumerThread consumer = new TaskThreeConsumerThread(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}