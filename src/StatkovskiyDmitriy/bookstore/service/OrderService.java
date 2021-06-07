package StatkovskiyDmitriy.bookstore.service;

import StatkovskiyDmitriy.bookstore.api.dao.IOrderDao;
import StatkovskiyDmitriy.bookstore.api.service.IOrderService;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.api.service.IStockUnitService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService implements IOrderService {

    private IOrderDao orderDao;
    private IStockUnitService stockService;
    private IRequestService requestService;


    public OrderService(IOrderDao orderDao, IStockUnitService stockService, IRequestService requestService) {
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
            outOfStockBooks
                    .forEach(book -> requestService.createRequest(book));
//            for (Book book : outOfStockBooks) {
//                requestService.createRequest(book);
//            }
        }
        return order;
    }

    @Override
    public Order cancelOrder(Order order) {
        if (order.getStatus().equals(OrderStatus.NEW)) {
            order.setStatus(OrderStatus.CANCELED);
            ;
        }
        return order;
    }

    public Order changeOrderStatus(Order order, OrderStatus status) {
        order.setStatus(status);
        return order;
    }

    public double calculateOrderPrice(Order order) {

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
        orders.forEach(order -> order.setOrderPrice(calculateOrderPrice(order)));
        return orders.stream()
                .sorted(Comparator.comparing(o -> o.getOrderPrice()))
                .collect(Collectors.toList());
    }

    public List<Order> sortCompletedOrdersByPriceFromRange(IOrderDao orderDao, LocalDate from, LocalDate to) {
        List<Order> orders = orderDao.getAll();
        orders.stream()
                .filter(order -> order.getOrderClosedDate() != null)
                .filter(order -> order.getOrderClosedDate().isBefore(to))
                .filter(order -> order.getOrderClosedDate().isAfter(from))
                .filter(order -> order.getStatus().equals(OrderStatus.COMPLETED))
                .forEach(order -> order.setOrderPrice(calculateOrderPrice(order)));

        return orders.stream()
                .sorted(Comparator.comparing(o -> o.getOrderPrice()))
                .collect(Collectors.toList());
    }

    public List<Order> sortCompletedOrdersByCompletedDateFromRange(IOrderDao orderDao, LocalDate from, LocalDate to) {
        List<Order> orders = orderDao.getAll();
        return orders.stream()
                .filter(order -> order.getOrderClosedDate() != null)
                .filter(order -> order.getOrderClosedDate().isBefore(to))
                .filter(order -> order.getOrderClosedDate().isAfter(from))
                .filter(order -> order.getStatus().equals(OrderStatus.COMPLETED))
                .sorted(Comparator.comparing(o -> o.getOrderClosedDate()))
                .collect(Collectors.toList());
    }

    public double calculateEarnedMoneyFromRange(IOrderDao orderDao, LocalDate from, LocalDate to) {
        List<Order> orders = orderDao.getAll();
        orders.stream()
                .filter(order -> order.getOrderClosedDate() != null)
                .filter(order -> order.getOrderClosedDate().isBefore(to))
                .filter(order -> order.getOrderClosedDate().isAfter(from))
                .filter(order -> order.getStatus().equals(OrderStatus.COMPLETED))
                .forEach(order -> order.setOrderPrice(calculateOrderPrice(order)));

        return orders.stream()
                .map(order -> order.getOrderPrice())
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public int numberOfCompletedOrdersFromRange(IOrderDao orderDao, LocalDate from, LocalDate to) {
        List<Order> orders = orderDao.getAll();
        List<Order> completedOrders = orders.stream()
                .filter(order -> order.getOrderClosedDate() != null)
                .filter(order -> order.getOrderClosedDate().isAfter(from))
                .filter(date -> date.getOrderClosedDate().isBefore(to))
                .filter(order -> order.getStatus().equals(OrderStatus.COMPLETED))
                .collect(Collectors.toList());
        int number = completedOrders.size();
        return number;
    }

    public Order showOrderInformation(IOrderDao orderDao, String customerName) {
        List<Order> units = orderDao.getAll();
        Order details = units.stream()
                .filter(order -> order.getCustomerName().equals(customerName))
                .findFirst()
                .get();
        return details;
    }
}
