package eu.senla.bookstore;

import java.time.LocalDate;


public class Order { //66

    private String customerName;
    private String orderNumber;
    private String bookName;
    private String orderStatus;
    private LocalDate orderCreationDate;
    private LocalDate orderFulfillmentDate;

    public Order(String customerName, String orderNumber, String bookName, String orderStatus, LocalDate orderCreationDate) {
        this.customerName = customerName;
        this.orderNumber = orderNumber;
        this.bookName = bookName;
        this.orderStatus = orderStatus;
        this.orderCreationDate = orderCreationDate;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", bookName='" + bookName + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderCreationDate=" + orderCreationDate +
                ", orderFulfillmentDate=" + orderFulfillmentDate +
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
}
