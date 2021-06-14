package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IOrderDao;
import StatkovskiyDmitriy.bookstore.model.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderDao implements IOrderDao {
    private static OrderDao instance;
    List<Order> orders = new ArrayList<>();

    private OrderDao() {

    }

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }
        return instance;
    }

    public Order createOrder() {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderCreatedDate(LocalDate.now());
        orders.add(order);
        return order;
    }

    public List<Order> getAll() {
        return orders;
    }


}
