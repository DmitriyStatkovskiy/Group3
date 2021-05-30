package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;

public interface IOrderService {
    Order createNew();

    Order addBook(Order order, Book book);

    Order completeOrder(Order order);

    Order cancelOrder(Order order);

    Order getOrder(String id);

    Order delete(String id);
}
