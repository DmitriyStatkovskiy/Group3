package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IOrderDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class OrderDao implements IOrderDao {
    List<Order> orders = new ArrayList<>();

    public Order createOrder() {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        orders.add(order);
        return order;
    }

    @Override
    public Order addBookToOrder(Book book) {
        return null;
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
//
//    public void addOrder(String customerName, String orderNumber, String bookName, LocalDate orderCreationDate) {
//        Order order = new Order(customerName, orderNumber, bookName, "new", orderCreationDate);
//        orders.add(order);
//
//    }

//    public String getOrderId(String orderId) {
//        for (Order order : orders) {
//            if (orderId.equals(order.getOrderNumber())) {
//                return order.getOrderNumber();
//            }
//        }
//        return "order not found";
//    }

//    public String getBookName(LocalDate date) {
//        for (Order order : orders) {
//            if (date.equals(order.getOrderFulfillmentDate())) {
//                return order.getBookName();
//            }
//        }
//        return "book not found";
//    }

    public List<Order> findOrderByRange(LocalDate from, LocalDate to) {
        return orders.stream()
                .filter(order -> order.getOrderFulfillmentDate().isBefore(to))
                .filter(order -> order.getOrderFulfillmentDate().isAfter(from))
                .collect(Collectors.toList());
    }

//    public String getBookName(String orderId) {
//        for (Order order : orders) {
//            if (orderId.equals(order.getOrderNumber())) {
//                return order.getBookName();
//            }
//        }
//        return "book not found";
//    }

//    public LocalDate getOrderFulfillmentDate(LocalDate date) {
//        for (Order order : orders) {
//            if (date.equals(order.getOrderFulfillmentDate())) {
//                return order.getOrderFulfillmentDate();
//            }
//        }
//        return null;
//    }

//    public ArrayList<LocalDate> getCompletedOrderDates() {
//        ArrayList<LocalDate> fulfillmentDates = new ArrayList<>();
//        for (Order order : orders) {
//            if (order.getOrderFulfillmentDate() != null && !order.getOrderFulfillmentDate().equals(LocalDate.of(1970, 1, 1))) {
//                fulfillmentDates.add(order.getOrderFulfillmentDate());
//            }
//        }
//        return fulfillmentDates;
//
//    }

    public void changeOrderStatus(String orderNumber, String status) {
        for (Order order : orders) {
            if (orderNumber.equals(order.getOrderNumber()) && status.equals("completed")) {
                order.setOrderStatus(status);
                order.setOrderFulfillmentDate(LocalDate.now());
            }
            if (orderNumber.equals(order.getOrderNumber()) && status.equals("canceled")) {
                order.setOrderStatus(status);
                order.setOrderFulfillmentDate(LocalDate.of(1970, 1, 1));
            }
        }
    }

//    public void printOrders() {
//        for (Order order : orders) {
//            System.out.println(order);
//        }
//        System.out.println();
//    }

//    public void sortByName() {
//        orders.sort(comparing(Order::getBookName));
//    }
//
//    public void sortByOrderNumber() {
//        orders.sort(comparing(Order::getOrderNumber));
//    }
//
//    public void sortByOrderCreationDate() {
//        orders.sort(comparing(Order::getOrderCreationDate));
//    }
//
//    public void sortByOrderFulfillmentDate() {
//        orders.sort(comparing(Order::getOrderFulfillmentDate));
//    }
//
//    public void sortByOrderStatus() {
//        orders.sort(comparing(Order::getOrderStatus));
//    }
}
