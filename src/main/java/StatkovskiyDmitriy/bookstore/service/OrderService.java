package StatkovskiyDmitriy.bookstore.service;

import DmitriyStatkovskiy.ioc.annotation.Autowired;
import DmitriyStatkovskiy.ioc.annotation.Component;
import StatkovskiyDmitriy.bookstore.api.dao.IOrderDao;
import StatkovskiyDmitriy.bookstore.api.service.IBookService;
import StatkovskiyDmitriy.bookstore.api.service.IOrderService;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class OrderService implements IOrderService, Serializable {
    static Logger logger = LoggerFactory.getLogger(BookService.class);
    private static OrderService instance;
    @Autowired
    private IOrderDao orderDao;
    @Autowired
    private IBookService bookService;
    @Autowired
    private IRequestService requestService;

    private OrderService() {

    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public OrderService(IOrderDao orderDao, IBookService bookService, IRequestService requestService) {
        this.orderDao = orderDao;
        this.bookService = bookService;
        this.requestService = requestService;
    }

    @Override
    public Order createNew() {
        return orderDao.createOrder();
    }

    @Override
    public Order addBook(Order order, Book book) {
        order.getAll().add(book);
        return order;
    }

    @Override
    public Order completeOrder(Order order) {
        if (!order.getStatus().equals(OrderStatus.NEW)) {
            return order;
        }
        List<Book> outOfStockBook = bookService.getOutOfStockBooks(order);
        if (outOfStockBook.size() == 0) {
            order.setClosed(LocalDate.now());
            order.setStatus(OrderStatus.COMPLETED);
        } else {
            Book book = outOfStockBook.stream()
                    .findFirst()
                    .get();
            requestService.createRequest(book);
        }
        return order;
    }

    @Override
    public Order cancelOrder(Order order) throws javax.persistence.EntityNotFoundException {
        try {
            if (order.getStatus().equals(OrderStatus.NEW)) {
                order.setStatus(OrderStatus.CANCELED);
            }
        } catch (javax.persistence.EntityNotFoundException exception) {
            logger.info("can't cancel order " + order);
            throw new EntityNotFoundException("can't cancel order " + order);
        }
        return order;
    }

    public Order changeOrderStatus(Order order, OrderStatus status) {
        order.setStatus(status);
        return order;
    }

    public double calculateOrderPrice(Order order) {
        List<Book> books = order.getAll();
        return books.stream()
                .map(book -> book.getPrice())
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public List<Order> sortOrdersByFulfillmentDate() {
        List<Order> orders = orderDao.getAll();
        return orders.stream()
                .filter(order -> order.getClosed() != null)
                .sorted(Comparator.comparing(o -> o.getClosed()))
                .collect(Collectors.toList());
    }

    public List<Order> sortOrdersByStatus() {
        List<Order> orders = orderDao.getAll();
        return orders.stream()
                .sorted(Comparator.comparing(o -> o.getStatus()))
                .collect(Collectors.toList());
    }

    public List<Order> sortOrdersByPrice() {
        List<Order> orders = orderDao.getAll();
        orders.forEach(order -> order.setPrice(calculateOrderPrice(order)));
        return orders.stream()
                .sorted(Comparator.comparing(o -> o.getPrice()))
                .collect(Collectors.toList());
    }

    public List<Order> sortCompletedOrdersByPriceFromRange(LocalDate from, LocalDate to) {
        List<Order> orders = orderDao.getAll();
        orders.stream()
                .filter(order -> order.getClosed() != null)
                .filter(order -> order.getClosed().isBefore(to))
                .filter(order -> order.getClosed().isAfter(from))
                .filter(order -> order.getStatus().equals(OrderStatus.COMPLETED))
                .forEach(order -> order.setPrice(calculateOrderPrice(order)));

        return orders.stream()
                .sorted(Comparator.comparing(o -> o.getPrice()))
                .collect(Collectors.toList());
    }

    public List<Order> sortCompletedOrdersByCompletedDateFromRange(LocalDate from, LocalDate to) {
        List<Order> orders = orderDao.getAll();
        return orders.stream()
                .filter(order -> order.getClosed() != null)
                .filter(order -> order.getClosed().isBefore(to))
                .filter(order -> order.getClosed().isAfter(from))
                .filter(order -> order.getStatus().equals(OrderStatus.COMPLETED))
                .sorted(Comparator.comparing(o -> o.getClosed()))
                .collect(Collectors.toList());
    }

    public double calculateEarnedMoneyFromRange(LocalDate from, LocalDate to) {
        List<Order> orders = orderDao.getAll();
        orders.stream()
                .filter(order -> order.getClosed() != null)
                .filter(order -> order.getClosed().isBefore(to))
                .filter(order -> order.getClosed().isAfter(from))
                .filter(order -> order.getStatus().equals(OrderStatus.COMPLETED))
                .forEach(order -> order.setPrice(calculateOrderPrice(order)));

        return orders.stream()
                .map(order -> order.getPrice())
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public int numberOfCompletedOrdersFromRange(LocalDate from, LocalDate to) {
        List<Order> orders = orderDao.getAll();
        List<Order> completedOrders = orders.stream()
                .filter(order -> order.getClosed() != null)
                .filter(order -> order.getClosed().isAfter(from))
                .filter(date -> date.getClosed().isBefore(to))
                .filter(order -> order.getStatus().equals(OrderStatus.COMPLETED))
                .collect(Collectors.toList());
        int number = completedOrders.size();
        return number;
    }

    public Order showOrderInformation(String customerName) throws EntityNotFoundException {
        List<Order> units = orderDao.getAll();
        Order details = units.stream()
                .filter(order -> order.getCustomerName().equals(customerName))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("order not found, customer name: " + customerName));
        return details;
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    public Order getOrderById(String id) throws EntityNotFoundException {
        Order order = orderDao.getAll().stream()
                .filter(order1 -> order1.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("order not found, id: " + id));

        return order;
    }

    public void deleteAll() {
        orderDao.deleteAll();
    }

    public void setOrders(List<Order> orders) {
        orderDao.setOrders(orders);
    }
}
