package StatkovskiyDmitriy.bookstore.model;

import java.time.LocalDate;
import java.util.Objects;

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

    private String fulfillmentDate() {

        if (orderFulfillmentDate == null) {
            return "In progress";
        }
        if (orderFulfillmentDate.equals(LocalDate.of(1970, 1, 1))) {
            return "Canceled";
        }
        return orderFulfillmentDate.toString();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ",customerName= '" + customerName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderCreationDate=" + orderCreationDate +
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
