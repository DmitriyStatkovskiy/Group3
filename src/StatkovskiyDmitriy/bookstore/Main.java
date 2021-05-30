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
 * it's a total mess I know
 * task 3 completed; task 4 I'll complete in a few days
 * I hope it's better than nothing
 */

public class Main {
    public static void main(String[] args) {

        IOrderDao orderDao = new OrderDao();
        IRequestDao requestDao = new RequestDao();
        IRequestService requestService = new RequestService(requestDao);

        StockDao stockDao = new StockDao();
        IStockService stockService = new StockService(stockDao, requestService);

        OrderService orderService = new OrderService(orderDao, stockService, requestService);

        Order order = orderService.createNew();

        Book bookA = new Book("AAA", "1", 10, "e");
        Book bookB = new Book("BBB", "2", 20, "ee");
        Book bookC = new Book("CCC", "3", 30, "eee");
        Book bookD = new Book("DDD", "4", 40, "eeee");
        Book bookE = new Book("EEE", "5", 50, "eeeee");


        stockDao.addBook(bookA);
        stockDao.addBook(bookB);
        // stockDao.changeBookStatus(bookB.getId(), StockUnitStatus.OUT_OF_STOCK);


        orderService.addBook(order, bookA);
        orderService.addBook(order, bookB);
        //orderService.cancelOrder(order);
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