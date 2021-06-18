package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public interface IOrderService {
    Order createNew();

    Order addBook(Order order, Book book);

    Order completeOrder(Order order);

    double calculateOrderPrice(Order order);

    List<Order> sortOrdersByPrice();

    Order changeOrderStatus(Order order, OrderStatus status);

    List<Order> sortOrdersByStatus();

    List<Order> sortOrdersByFulfillmentDate();

    Order cancelOrder(Order order);

    List<Order> sortCompletedOrdersByPriceFromRange(LocalDate from, LocalDate to);

    List<Order> sortCompletedOrdersByCompletedDateFromRange(LocalDate from, LocalDate to);

    int numberOfCompletedOrdersFromRange(LocalDate from, LocalDate to);

    double calculateEarnedMoneyFromRange(LocalDate from, LocalDate to);

    Order showOrderInformation(String customerName);

    List<Order> getAll();

    Order getOrderById(String id);
}
