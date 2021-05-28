package eu.senla.bookstore.dao;

import eu.senla.bookstore.model.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class OrderDao {
    ArrayList<Order> orders = new ArrayList<>();

    public void addOrder(String customerName, String orderNumber, String bookName, LocalDate orderCreationDate) {
        Order order = new Order(customerName, orderNumber, bookName, "new", orderCreationDate);
        orders.add(order);

    }
    public void findOut(List<LocalDate> from){
        List<String> qwe = orders.stream()
                .filter(d->d.getOrderFulfillmentDate().equals(from))
                .map(Order::getOrderNumber)
                .collect(Collectors.toList());
        System.out.println(qwe);

    }

    public String getOrderId(String orderId){
        for (Order order :
                orders) {
            if(orderId.equals(order.getOrderNumber())){
                return order.getOrderNumber();
            }
        }
        return "order not found";
    }
    public String getBookName(String orderId){
        for (Order order :
                orders) {
            if(orderId.equals(order.getOrderNumber())){
                return order.getBookName();
            }
        }
        return "book not found";
    }
    public LocalDate getOrdrFlfllDate(LocalDate date){
        for (Order order :
                orders) {
            if(date.equals(order.getOrderFulfillmentDate())){
                return order.getOrderFulfillmentDate();
            }
        }
        return null;
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
    public void sortByName() {
        orders.sort(comparing(Order::getBookName));
    }
    public void sortByOrderNumber() {
        orders.sort(comparing(Order::getOrderNumber));
    }
    public void sortByOrderCreationDate() {
        orders.sort(comparing(Order::getOrderCreationDate));
    }
    public void sortByOrderFulfillmentDate() {
        orders.sort(comparing(Order::getOrderFulfillmentDate));
    }
    public void sortByOrderStatus() {
        orders.sort(comparing(Order::getOrderStatus));
    }
}
