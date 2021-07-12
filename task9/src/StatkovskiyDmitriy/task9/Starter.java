package StatkovskiyDmitriy.task9;

import StatkovskiyDmitriy.task9.threads.*;

import static java.lang.Thread.sleep;

public class Starter {
    public void taskOne() {
        try {
            Thread threadOne = new Thread(new FirstThread());
            Thread threadTwo = new Thread(new SecondThread());
            System.out.println(threadOne.getState() + " new");
            threadOne.start();
            threadTwo.start();
            sleep(500);
            System.out.println(threadOne.getState() + " timed_waiting");
            System.out.println(threadTwo.getState() + " waiting");

            Object a = SecondThread.getA();
            synchronized (a) {
                a.notify();
            }

            System.out.println(threadTwo.getState() + " blocked");
            sleep(2000);
            System.out.println(threadOne.getState() + " terminated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void taskTwo() {
        Thread name = new Thread(new NameThread());
        Thread surname = new Thread(new SurnameThread());
        try {
            taskFour();
            surname.start();
            name.start();
            name.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void taskFour() {
        Thread daemon = new Thread(new DaemonThread(3));
        daemon.setDaemon(true);
        daemon.start();
    }

    public void taskThree() {
        Store store = new Store();
        ProducerThread producer = new ProducerThread(store);
        ConsumerThread consumer = new ConsumerThread(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}