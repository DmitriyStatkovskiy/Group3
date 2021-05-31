package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;

public interface IOrderService {
    Order createNew();

    Order addBook(Order order, Book book);

    Order completeOrder(Order order);

    Order changeOrderStatus(Order order, OrderStatus status);

    Order cancelOrder(Order order);

    Order getOrder(String id);

    Order delete(String id);
}
