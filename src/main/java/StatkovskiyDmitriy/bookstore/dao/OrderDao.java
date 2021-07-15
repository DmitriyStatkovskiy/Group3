package StatkovskiyDmitriy.bookstore.dao;

import DmitriyStatkovskiy.ioc.injection.annotation.Autowired;
import DmitriyStatkovskiy.ioc.injection.annotation.Component;
import StatkovskiyDmitriy.bookstore.api.dao.IOrderDao;
import StatkovskiyDmitriy.bookstore.model.Order;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
public class OrderDao implements IOrderDao, Serializable {
    private static OrderDao instance;
    @Autowired
    private List<Order> orders = new ArrayList<>();

    private OrderDao() {

    }

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }
        return instance;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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

    public void deleteAll() {
        orders = new ArrayList<>();
    }
}
