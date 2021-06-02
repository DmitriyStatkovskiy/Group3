package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IOrderDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderDao implements IOrderDao {
    List<Order> orders = new ArrayList<>();

    public Order createOrder() {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderCreatedDate(LocalDate.now());
        orders.add(order);
        return order;
    }

    @Override
    public Order getOrder(String id) {
        return null;
    }

    @Override
    public Order deleteOrder(String id) {
        return null;
    }

    public List<Order> getAll() {
        return orders;
    }

    public List<Book> getBooksFromOrder(Order order) {
        List<Book> books = order.getBooks();
        return books;
    }
}
