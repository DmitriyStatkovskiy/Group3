package StatkovskiyDmitriy.bookstore.api.dao;

import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public interface IOrderDao {
    Order createOrder();

    Order getOrder(String id);

    List<Order> getAll();

    Order deleteOrder(String id);

    Order cancelOrder(Order order);

    Order changeOrderStatus(Order order, OrderStatus status);
}
