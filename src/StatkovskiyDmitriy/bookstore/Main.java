package StatkovskiyDmitriy.bookstore;

import StatkovskiyDmitriy.bookstore.service.BookStoreService;

import java.time.LocalDate;

/**
 *
 */
//подумать закрывать ли запрос при отмене заказа
public class Main {
    public static void main(String[] args) {

        BookStoreService bookStore = new BookStoreService();
        bookStore.stock.addBook("420 or 328", "ewe", "22", 55.2, LocalDate.of(2020, 12, 3), true);
        bookStore.stock.addBook("qwe", "ewwree", "22+23", 545.2, LocalDate.of(2021, 3, 3), true);
        bookStore.stock.addBook("qwe", "ewwr33ee", "2wer", 45.32, LocalDate.of(2018, 7, 29), true);
        bookStore.stock.addBook("123", "ew321e", "2223", 25.2, LocalDate.of(2010, 2, 23), true);
        System.out.println("Список книг после добавления на склад");
        bookStore.stock.printStock();
        bookStore.addNewOrder("Mr.Bla", "1", "42 or 69?", LocalDate.now());

        System.out.println("Список запросов и заказов после добавления заказа с отсутствующей на складе книгой:");
        bookStore.requests.printRequests();
        bookStore.orders.printOrders();

        bookStore.addBookToStock("42 or 69?", "mars 4kk B.C.",
                "The Answer to the Ultimate Question of Life, the Universe, and Everything", 420, LocalDate.now());
        bookStore.addNewOrder("Ms.Bla", "2", "420 or 328?", LocalDate.of(2021, 5, 5));

        bookStore.requests.addRequest("23", "REQUESTED_BOOK");

        bookStore.completeOrder("1");
        bookStore.cancelOrder("2");
        bookStore.completeOrder("23");

        bookStore.orders.printOrders();
        bookStore.requests.printRequests();
        bookStore.stock.printStock();

        bookStore.findOutProfit(LocalDate.of(2021, 2, 2), LocalDate.of(2021, 6, 23));
       // bookStore.range(LocalDate.of(2021, 2, 2), LocalDate.of(2021, 6, 23));
        //        bookStore.stock.sortByName();
        //        bookStore.stock.printStock();

    }
}