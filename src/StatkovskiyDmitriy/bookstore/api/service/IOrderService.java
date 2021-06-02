package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.api.dao.IOrderDao;
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

    List<Order> sortOrdersByPrice(IOrderDao orderDao);

    Order changeOrderStatus(Order order, OrderStatus status);

    List<Order> sortOrdersByStatus(IOrderDao orderDao);

    List<Order> sortOrdersByFulfillmentDate(IOrderDao orderDao);

    Order cancelOrder(Order order);

    List<Order> sortCompletedOrdersByPriceFromRange(IOrderDao orderDao, LocalDate from, LocalDate to);

    List<Order> sortCompletedOrdersByCompletedDateFromRange(IOrderDao orderDao, LocalDate from, LocalDate to);

    int numberOfCompletedOrdersFromRange(IOrderDao orderDao, LocalDate from, LocalDate to);

    double calculateEarnedMoneyFromRange(IOrderDao orderDao, LocalDate from, LocalDate to);

    Order getOrder(String id);

    Order delete(String id);
}
