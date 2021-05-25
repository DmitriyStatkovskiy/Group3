package eu.senla.bookstore;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrderService {
    ArrayList<Order> orderArrayList = new ArrayList<>();

    public void addOrder(String customerName, String orderNumber, String bookName, LocalDate orderCreationDate) {
        Order order = new Order(customerName, orderNumber, bookName, "new", orderCreationDate);
        orderArrayList.add(order);
    }

    public void changeOrderStatus(String orderNumber, String status) {
        for (Order order : orderArrayList
        ) {
            if (orderNumber.equals(order.getOrderNumber())&&status.equals("completed")) {
                order.setOrderStatus(status);
                order.setOrderFulfillmentDate(LocalDate.now());
            }
            else {
                order.setOrderStatus(status);
            }
        }
    }
}
