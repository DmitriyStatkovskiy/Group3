package eu.senla.bookstore;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrderService {
    ArrayList<Order> orders = new ArrayList<>();

    public void addOrder(String customerName, String orderNumber, String bookName, LocalDate orderCreationDate) {
        Order order = new Order(customerName, orderNumber, bookName, "new", orderCreationDate);
        orders.add(order);

    }

    public void changeOrderStatus(String orderNumber, String status) {
        for (Order order : orders
        ) {
            if (orderNumber.equals(order.getOrderNumber())&&status.equals("completed")) {
                order.setOrderStatus(status);
                order.setOrderFulfillmentDate(LocalDate.now());
            }
            if (orderNumber.equals(order.getOrderNumber())&&status.equals("canceled")) {
                order.setOrderStatus(status);
                order.setOrderFulfillmentDate(LocalDate.of(1970,1,1)); //used in orderToString
            }
        }
    }
    public void printOrders(){
        for (Order order: orders
        ) {
            System.out.println(order);
        }
        System.out.println();
    }
}
