package StatkovskiyDmitriy.bookstore.api.dao;

import StatkovskiyDmitriy.bookstore.model.Order;

import java.util.List;

public interface IOrderDao {
    Order createOrder();

    List<Order> getAll();

}
