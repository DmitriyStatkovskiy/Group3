package StatkovskiyDmitriy.task9;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Integer> product = new ArrayList<>();

    public synchronized void get() {
        while (product.size() < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        product.remove(product.size() - 1);

        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product.size());
        for (Integer integer : product) {
            System.out.print(integer + " ");
        }
        if (product.size() != 0) {
            System.out.println();
        }
        notify();
    }

    public synchronized void put() {
        while (product.size() >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product.add((int) (Math.random() * 1000 + 1000));
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product.size());
        for (Integer integer : product) {
            System.out.print(integer + " ");
        }
        if (product.size() != 0) {
            System.out.println();
        }

        notify();
    }
}
