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
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;
import StatkovskiyDmitriy.bookstore.model.enums.StockUnitStatus;
import StatkovskiyDmitriy.bookstore.service.OrderService;
import StatkovskiyDmitriy.bookstore.service.RequestService;
import StatkovskiyDmitriy.bookstore.service.StockService;

/**
 *
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
        Order order2 = orderService.createNew();
        Order order3 = orderService.createNew();

        Book bookA = new Book("AAA", "1", 10, "aaa");
        Book bookB = new Book("BBB", "2", 20, "bbb");
        Book bookC = new Book("CCC", "3", 30, "ccc");
        Book bookD = new Book("DDD", "4", 40, "ddd");
        Book bookE = new Book("EEE", "5", 50, "eee");

        stockDao.addBook(bookA);
        stockDao.addBook(bookB);
        stockDao.addBook(bookD);
        stockDao.addBook(bookE);
        stockDao.addBook(bookC);
        stockDao.changeBookStatus(bookB.getId(), StockUnitStatus.OUT_OF_STOCK);
        //test sort methods
//        stockService.sortBooksByName(stockDao);
//        stockService.sortUnitsByStatus(stockDao);
//        stockDao.printStock();//
//        stockDao.printStock(stockService.sortBooksByName(stockDao));
//        stockDao.printStock(stockService.sortUnitsByStatus(stockDao));

        orderService.addBook(order, bookA);
        orderService.addBook(order, bookB);
        orderService.addBook(order2,bookE);
        orderService.addBook(order3,bookA);

        requestService.createRequest(bookB);
        requestService.createRequest(bookA);
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
//        //test sort stock by name
//        System.out.println();
//        stockDao.printStock();
//        System.out.println();
//        stockDao.printStock(stockService.sortBooksByName(stockDao));

//        System.out.println(requestService.sortRequestsByBookName(requestService));
        //sort by order price
//        System.out.println(orderService.calculateOrderPrice(order));
//        System.out.println("Orders without sort:");
//        orderDao.getAll().forEach(System.out::println);
//        System.out.println("sorted orders:");
//        orderService.sortOrdersByPrice(orderService).forEach(System.out::println);

////        show book description
//         System.out.println(stockService.showBookDescription(stockDao, "DDD"));
//
////        test changeOrderStatus
//        orderService.addBook(order2, bookD);
//        System.out.println(order2);
//        orderService.changeOrderStatus(order2, OrderStatus.CANCELED);
//        System.out.println(order2);
    }
}