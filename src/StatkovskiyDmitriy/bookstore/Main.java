package StatkovskiyDmitriy.bookstore;

import StatkovskiyDmitriy.bookstore.api.dao.IOrderDao;
import StatkovskiyDmitriy.bookstore.api.dao.IRequestDao;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.api.service.IStockService;
import StatkovskiyDmitriy.bookstore.dao.OrderDao;
import StatkovskiyDmitriy.bookstore.dao.RequestDao;
import StatkovskiyDmitriy.bookstore.dao.StockUnitDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;
import StatkovskiyDmitriy.bookstore.model.enums.StockUnitStatus;
import StatkovskiyDmitriy.bookstore.service.OrderService;
import StatkovskiyDmitriy.bookstore.service.RequestService;
import StatkovskiyDmitriy.bookstore.service.StockService;

import java.time.LocalDate;

/**
 *
 */

public class Main {
    public static void main(String[] args) {

        IOrderDao orderDao = new OrderDao();
        IRequestDao requestDao = new RequestDao();
        IRequestService requestService = new RequestService(requestDao);

        StockUnitDao stockUnitDao = new StockUnitDao();

        IStockService stockService = new StockService(stockUnitDao, requestService);

        OrderService orderService = new OrderService(orderDao, stockService, requestService);

        Order order = orderService.createNew();
        Order order2 = orderService.createNew();
        Order order3 = orderService.createNew();

        Book bookA = new Book("AAA", "1", 10, "aaa");
        Book bookB = new Book("BBB", "2", 20, "bbb");
        Book bookC = new Book("CCC", "3", 30, "ccc");
        Book bookD = new Book("DDD", "4", 40, "ddd");
        Book bookE = new Book("EEE", "5", 50, "eee");

        stockUnitDao.addBook(bookA);
        stockUnitDao.addBook(bookB);
        stockUnitDao.addBook(bookD);
        stockUnitDao.addBook(bookE);
        stockUnitDao.addBook(bookC);
        stockService.changeBookStatus(stockUnitDao.getStockUnitByBookId(bookB.getId()),StockUnitStatus.OUT_OF_STOCK);
        //test sort methods
//        stockService.sortBooksByName(stockUnitDao);
//        stockService.sortUnitsByStatus(stockUnitDao);
//        stockUnitDao.printStock();//
//        stockUnitDao.printStock(stockService.sortBooksByName(stockUnitDao));
//        stockUnitDao.printStock(stockService.sortUnitsByStatus(stockUnitDao));

        orderService.addBook(order, bookA);
        orderService.addBook(order, bookB);
        orderService.addBook(order2, bookE);
        orderService.addBook(order3, bookA);

        requestService.createRequest(bookB);
        requestService.createRequest(bookA);
        requestService.createRequest(bookB);
        requestService.createRequest(bookB);
        requestService.createRequest(bookB);
        requestService.createRequest(bookB);
        requestService.createRequest(bookC);
        requestService.createRequest(bookA);
        requestService.createRequest(bookA);

        orderService.cancelOrder(order);
        System.out.println(order);
        orderService.completeOrder(order);

        System.out.println(order);
        System.out.println("Created requests:");
        requestDao.getAll().forEach(System.out::println);
        stockService.addBook(bookB);
        requestDao.getAll().forEach(System.out::println);
        orderService.completeOrder(order);
        System.out.println(order);
        //  test sort stock by name
        System.out.println();
        stockUnitDao.printStock();
        System.out.println();
        stockUnitDao.printStock(stockService.sortBooksByName(stockUnitDao));

        requestService.sortRequestsByBookName(requestDao).forEach(System.out::println);
//        sort by order price
        System.out.println(orderService.calculateOrderPrice(order));
        System.out.println("Orders without sort:");
        orderDao.getAll().forEach(System.out::println);
        System.out.println("sorted orders:");
        orderService.sortOrdersByPrice(orderDao).forEach(System.out::println);

//        show book description
        System.out.println(stockService.showBookDescription(stockUnitDao, "DDD"));

//        test changeOrderStatus
        orderService.addBook(order2, bookD);
        System.out.println(order2);
        orderService.changeOrderStatus(order2, OrderStatus.CANCELED);
        orderService.completeOrder(order3);
        System.out.println(order2);
        System.out.println(order3);
//      sort requests by quantity
        requestService.sortRequestsByQuantity(requestDao).forEach(System.out::println);
        System.out.println(orderService.numberOfCompletedOrdersFromRange(orderDao, LocalDate.of(2021, 6, 1), LocalDate.of(2021, 6, 12)));


    }
}