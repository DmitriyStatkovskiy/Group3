package eu.senla.bookstore;

import java.time.LocalDate;
/**
 * Entities:
 * stock
 * requests
 * orders
 *
 * Methods:
 * add
 * changeStatus
 * print
 *
 *
 *
 */

public class Main {
    public static void main(String[] args) {
//        StockService bookStore = new StockService();
//        OrderService orderList = new OrderService();
//
//        bookStore.addBook("c", "ewe", "22", 55.2, LocalDate.of(2020,12,3), true);
//        bookStore.addBook("b", "ewe", "12", 32, LocalDate.now(), false);
//        bookStore.addBook("a", "ew322e", "54", 123, LocalDate.now(), true);
//        bookStore.addBook("d","aa2sdd","223d",23.41,LocalDate.of(1990,7,19), true);
//
//        for (Book s : bookStore.stock
//        ) {
//            System.out.println(s);
//        }
//
//        bookStore.sortByName();
//
//
//        for (Book s : bookStore.stock
//        ) {
//            System.out.println(s);
//        }
//
//        bookStore.changeBookStatus("c");
//
//        bookStore.changeBookStatusToFalse("b");
//        for (Book s : bookStore.stock) {
//            System.out.println(s);
//        }
//        System.out.println();
//        orderList.addOrder("Blabla","1","a",LocalDate.now());
//        orderList.addOrder("Blabla","2","b",LocalDate.now());
//        orderList.addOrder("Ololo","3","a",LocalDate.now());
//
//        for (Order order:orderList.orderArrayList
//             ) {
//            System.out.println(order);
//        }
//
//        orderList.changeOrderStatus("1","completed");
//        orderList.changeOrderStatus("2","canceled");
//        orderList.changeOrderStatus("22","canceled");
//
//        for (Order order:orderList.orderArrayList
//        ) {
//            System.out.println(order);
//        }

        BookStore bookStore = new BookStore();
        bookStore.stock.addBook("c", "ewe", "22", 55.2, LocalDate.of(2020,12,3), true);
        bookStore.stock.addBook("qwe", "ewwree", "22+23", 545.2, LocalDate.of(2021,3,3), true);
        bookStore.stock.addBook("123", "ew321e", "2223", 25.2, LocalDate.of(2010,2,23), true);
        bookStore.stock.printStock();
        bookStore.addNewOrder("Mr.Bla", "1", "42 or 69?",LocalDate.now());
        bookStore.requests.printRequests();
        bookStore.orders.printOrders();
        bookStore.addBookToStock("42 or 69?", "mars 4kk B.C.",
                "The Answer to the Ultimate Question of Life, the Universe, and Everything",420,LocalDate.now());
        bookStore.requests.printRequests();
        bookStore.stock.printStock();

//        bookStore.requests.addRequest("1","a");
//        bookStore.orders.addOrder("Blabla","1","a",LocalDate.now());
//        bookStore.requests.add(new Request("2","sad"));
//        bookStore.stock.printStock();
//
//        bookStore.requests.printRequests();
//        System.out.println();
//        bookStore.addBookToStock("sad", "ewe", "22", 55.2, LocalDate.of(2020,12,3));
//
//        bookStore.requests.printRequests();

    }
}