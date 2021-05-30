package StatkovskiyDmitriy.bookstore.model;

import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private String customerName;
    private String orderNumber;
    private String bookName;
    private String orderStatus;
    private OrderStatus status = OrderStatus.NEW;
    private LocalDate orderCreationDate;
    private LocalDate orderFulfillmentDate;

    private List<Book> books = new ArrayList<>();

    public Order(String customerName, String orderNumber, String bookName, String orderStatus, LocalDate orderCreationDate) {
        this.customerName = customerName;
        this.orderNumber = orderNumber;
        this.bookName = bookName;
        this.orderStatus = orderStatus;
        this.orderCreationDate = orderCreationDate;
    }

    public Order() {
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    private String fulfillmentDate() {

        if (orderFulfillmentDate == null) {
            return "In progress";
        }
        if (orderFulfillmentDate.equals(LocalDate.of(1970, 1, 1))) {
            return "Canceled";
        }
        return orderFulfillmentDate.toString();
    }

    private String printBooks() {
        String message = "";
        for (Book book : books) {
            message += " " + book.getName() + " " + book.getPrice() + " ";
        }
        return message;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderStatus='" + status + '\'' +
                ", orderCreationDate=" + orderCreationDate +
                ", Books" + printBooks() +
                ", orderFulfillmentDate=" + fulfillmentDate() +
                '}';
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(LocalDate orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public LocalDate getOrderFulfillmentDate() {
        return orderFulfillmentDate;
    }

    public void setOrderFulfillmentDate(LocalDate orderFulfillmentDate) {
        this.orderFulfillmentDate = orderFulfillmentDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(customerName, order.customerName) &&
                Objects.equals(getOrderNumber(), order.getOrderNumber()) &&
                Objects.equals(getBookName(), order.getBookName()) &&
                Objects.equals(getOrderStatus(), order.getOrderStatus()) &&
                Objects.equals(getOrderCreationDate(), order.getOrderCreationDate()) &&
                Objects.equals(getOrderFulfillmentDate(), order.getOrderFulfillmentDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, getOrderNumber(), getBookName(), getOrderStatus(), getOrderCreationDate(), getOrderFulfillmentDate());
    }
}
