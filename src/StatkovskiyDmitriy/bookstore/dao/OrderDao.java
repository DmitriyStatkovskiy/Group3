package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IOrderDao;
import StatkovskiyDmitriy.bookstore.model.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderDao implements IOrderDao {
    List<Order> orders = new ArrayList<>();

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
