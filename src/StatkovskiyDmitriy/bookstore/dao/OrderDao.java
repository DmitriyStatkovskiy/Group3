package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IOrderDao;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderDao implements IOrderDao {
    List<Order> orders = new ArrayList<>();

    public Order createOrder() {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderCreationDate(LocalDate.now());
        orders.add(order);
        return order;
    }

    @Override
    public Order getOrder(String id) {
        return null;
    }

    @Override
    public Order deleteOrder(String id) {
        return null;
    }

    @Override
    public Order cancelOrder(Order order) {
        order.setStatus(OrderStatus.CANCELED);
        return order;
    }

    @Override
    public Order changeOrderStatus(Order order, OrderStatus status) {
        order.setStatus(status);
        return order;
    }

    public List<Order> findOrderByRange(LocalDate from, LocalDate to) {
        return orders.stream()
                .filter(order -> order.getOrderFulfillmentDate().isBefore(to))
                .filter(order -> order.getOrderFulfillmentDate().isAfter(from))
                .collect(Collectors.toList());
    }


}
