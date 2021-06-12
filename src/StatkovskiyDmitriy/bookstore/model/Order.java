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
    private OrderStatus status = OrderStatus.NEW;
    private LocalDate orderCreatedDate;
    private LocalDate orderClosedDate = null;
    private double orderPrice;

    private List<Book> bookOlds = new ArrayList<>();

    public Order() {
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Book> getBookOlds() {
        return bookOlds;
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

    public LocalDate getOrderCreatedDate() {
        return orderCreatedDate;
    }

    public void setOrderCreatedDate(LocalDate orderCreatedDate) {
        this.orderCreatedDate = orderCreatedDate;
    }

    public LocalDate getOrderClosedDate() {
        return orderClosedDate;
    }

    public void setOrderClosedDate(LocalDate orderClosedDate) {
        this.orderClosedDate = orderClosedDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setBookOlds(List<Book> bookOlds) {
        this.bookOlds = bookOlds;
    }

    private String orderClosedDate() {

        if (orderClosedDate == null) {
            return "In progress";
        }
        if (orderClosedDate.equals(LocalDate.of(1970, 1, 1))) {
            return "Canceled";
        }
        return orderClosedDate.toString();
    }

    private String printBooks() {
        String message = "";
        for (Book bookOld : bookOlds) {
            message += " " + bookOld.getName() + " " + bookOld.getPrice() + " ";
        }
        return message;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderStatus='" + status + '\'' +
                ", orderCreationDate=" + orderCreatedDate +
                ", Books" + printBooks() +
                ", orderClosedDate=" + orderClosedDate() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.getOrderPrice(), getOrderPrice()) == 0 &&
                Objects.equals(getCustomerName(), order.getCustomerName()) &&
                Objects.equals(getOrderNumber(), order.getOrderNumber()) &&
                Objects.equals(getBookName(), order.getBookName()) &&
                getStatus() == order.getStatus() &&
                Objects.equals(getOrderCreatedDate(), order.getOrderCreatedDate()) &&
                Objects.equals(getOrderClosedDate(), order.getOrderClosedDate()) &&
                Objects.equals(getBookOlds(), order.getBookOlds());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerName(), getOrderNumber(), getBookName(), getStatus(), getOrderCreatedDate(), getOrderClosedDate(), getOrderPrice(), getBookOlds());
    }
}
