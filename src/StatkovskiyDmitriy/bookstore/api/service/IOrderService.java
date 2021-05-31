package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.dao.OrderDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;

import java.util.List;

public interface IOrderService {
    Order createNew();

    Order addBook(Order order, Book book);

    Order completeOrder(Order order);

    double calculateOrderPrice(OrderDao order);

    Order changeOrderStatus(Order order, OrderStatus status);

    Order cancelOrder(Order order);

    Order getOrder(String id);

    Order delete(String id);
}
