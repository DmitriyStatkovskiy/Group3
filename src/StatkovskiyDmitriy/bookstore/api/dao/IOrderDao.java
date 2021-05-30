package StatkovskiyDmitriy.bookstore.api.dao;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;

public interface IOrderDao {
    Order createOrder();

    Order addBookToOrder(Book book);

    Order getOrder(String id);

    Order deleteOrder(String id);

    Order cancelOrder(Order order);
}
