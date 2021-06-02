package StatkovskiyDmitriy.bookstore.api.dao;

import StatkovskiyDmitriy.bookstore.model.Order;

import java.util.List;

public interface IOrderDao {
    Order createOrder();

    Order getOrder(String id);

    List<Order> getAll();

    Order deleteOrder(String id);

}
