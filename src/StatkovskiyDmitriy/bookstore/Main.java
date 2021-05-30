package StatkovskiyDmitriy.bookstore;

import StatkovskiyDmitriy.bookstore.api.dao.IOrderDao;
import StatkovskiyDmitriy.bookstore.api.dao.IRequestDao;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.api.service.IStockService;
import StatkovskiyDmitriy.bookstore.dao.OrderDao;
import StatkovskiyDmitriy.bookstore.dao.RequestDao;
import StatkovskiyDmitriy.bookstore.dao.StockDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.StockUnitStatus;
import StatkovskiyDmitriy.bookstore.service.OrderService;
import StatkovskiyDmitriy.bookstore.service.RequestService;
import StatkovskiyDmitriy.bookstore.service.StockService;

/**
 *
 */
//подумать закрывать ли запрос при отмене заказа
public class Main {
    public static void main(String[] args) {

//        BookStoreService bookStore = new BookStoreService();
//        bookStore.stockDao.addBook("420 or 328", "ewe", "22", 55.2, LocalDate.of(2020, 12, 3), true);
//        bookStore.stockDao.addBook("qwe", "ewwree", "22+23", 545.2, LocalDate.of(2021, 3, 3), true);
//        bookStore.stockDao.addBook("qwe", "ewwr33ee", "2wer", 45.32, LocalDate.of(2018, 7, 29), true);
//        bookStore.stockDao.addBook("123", "ew321e", "2223", 25.2, LocalDate.of(2010, 2, 23), true);
//        System.out.println("Список книг после добавления на склад");
//        bookStore.stockDao.printStock();
//        bookStore.addNewOrder("Mr.Bla", "1", "42 or 69?", LocalDate.now());
//
//        System.out.println("Список запросов и заказов после добавления заказа с отсутствующей на складе книгой:");
//        bookStore.requestDao.printRequests();
//        bookStore.orderDao.printOrders();
//
//        bookStore.addBookToStock("42 or 69?", "wefw",
//                "142dd", 420, LocalDate.now());
//
//        bookStore.addNewOrder("Ms.Bla", "2", "420 or 328?", LocalDate.of(2021, 5, 5));
//        bookStore.addNewOrder("Ms.Bla", "3", "qwe", LocalDate.of(2021, 5, 6));
//        bookStore.addNewOrder("Ms.Bla", "4", "ewe", LocalDate.of(2021, 5, 7));
//
//        bookStore.requestDao.addRequest("23", "REQUESTED_BOOK");
//
//        bookStore.completeOrder("1");
//        bookStore.completeOrder("3");
//        bookStore.completeOrder("4");
//
//        bookStore.cancelOrder("2");
//        bookStore.completeOrder("23");
//
//        bookStore.orderDao.printOrders();
//        bookStore.requestDao.printRequests();
//        bookStore.stockDao.printStock();
//
//        bookStore.calculateProfit(LocalDate.of(2021, 2, 2), LocalDate.of(2021, 6, 23));
       // bookStore.range(LocalDate.of(2021, 2, 2), LocalDate.of(2021, 6, 23));
        //        bookStore.stock.sortByName();
        //        bookStore.stock.printStock();O
        IOrderDao orderDao = new OrderDao();
        IRequestDao requestDao = new RequestDao();
        IRequestService requestService = new RequestService(requestDao);

        StockDao stockDao = new StockDao();
        IStockService stockService = new StockService(stockDao, requestService);



        OrderService orderService = new OrderService(orderDao, stockService, requestService);

        Order order = orderService.createNew();

        Book bookA = new Book("AAA","1",10,"e");
        Book bookB = new Book("BBB","2",20,"ee");
        Book bookC = new Book("CCC","3",30,"eee");
        Book bookD = new Book("DDD","4",40,"eeee");
        Book bookE = new Book("EEE","5",50,"eeeee");


        stockDao.addBook(bookA);
        stockDao.addBook(bookB);
        stockDao.changeBookStatus(bookB.getId(), StockUnitStatus.OUT_OF_STOCK);


        orderService.addBook(order,bookA);
        orderService.addBook(order,bookB);
//        orderService.cancelOrder(order);
        System.out.println(order);
        orderService.completeOrder(order);

        System.out.println(order);
        System.out.println("Created requests:");
        requestDao.getAll().forEach(System.out::println);
        stockService.addBook(bookB);
        requestDao.getAll().forEach(System.out::println);
        orderService.completeOrder(order);
        System.out.println(order);

    }
}