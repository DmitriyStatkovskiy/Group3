package StatkovskiyDmitriy.bookstore.service;

import StatkovskiyDmitriy.bookstore.api.dao.IOrderDao;
import StatkovskiyDmitriy.bookstore.api.service.IOrderService;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.api.service.IStockService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService implements IOrderService {

    private IOrderDao orderDao;
    private IStockService stockService;
    private IRequestService requestService;


    public OrderService(IOrderDao orderDao, IStockService stockService, IRequestService requestService) {
        this.orderDao = orderDao;
        this.stockService = stockService;
        this.requestService = requestService;
    }

    @Override
    public Order createNew() {
        return orderDao.createOrder();
    }

    @Override
    public Order addBook(Order order, Book book) {
        order.getBooks().add(book);
        return order;
    }

    @Override
    public Order completeOrder(Order order) {
        if (!order.getStatus().equals(OrderStatus.NEW)) {
            return order;
        }
        List<Book> outOfStockBooks = stockService.getOutOfStockBooks(order);
        if (outOfStockBooks.size() == 0) {
            order.setOrderClosedDate(LocalDate.now());
            order.setStatus(OrderStatus.COMPLETED);
        } else {
            for (Book book : outOfStockBooks) {
                requestService.createRequest(book);
            }
        }
        return order;
    }

    @Override
    public Order cancelOrder(Order order) {
        if (order.getStatus().equals(OrderStatus.NEW)) {
            order = orderDao.cancelOrder(order);
        }
        return order;
    }

    public Order changeOrderStatus(Order order, OrderStatus status) {
        order.setStatus(status);
        return order;
    }

    public double calculateOrderPrice(Order order) {
        double result = 0;
        List<Book> books = order.getBooks();
        return books.stream()
                .map(book -> book.getPrice())
                .mapToDouble(Double::doubleValue)
                .sum();

    }

    public List<Order> sortOrdersByFulfillmentDate(IOrderDao orderDao) {
        List<Order> orders = orderDao.getAll();
        return orders.stream()
                .sorted(Comparator.comparing(o -> o.getOrderClosedDate()))
                .collect(Collectors.toList());

    }

    public List<Order> sortOrdersByStatus(IOrderDao orderDao) {
        List<Order> orders = orderDao.getAll();
        return orders.stream()
                .sorted(Comparator.comparing(o -> o.getStatus()))
                .collect(Collectors.toList());
    }

    public List<Order> sortOrdersByPrice(IOrderDao orderDao) {
        List<Order> orders = orderDao.getAll();
        for (Order order : orders) {
            order.setOrderPrice(calculateOrderPrice(order));
        }
        return orders.stream()
                .sorted(Comparator.comparing(o -> o.getOrderPrice()))
                .collect(Collectors.toList());

    }

    @Override
    public Order getOrder(String id) {
        return null;
    }

    @Override
    public Order delete(String id) {
        return null;
    }
}
