package StatkovskiyDmitriy.bookstore.model;

import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order implements Serializable {

    private String id;
    private String customerName;

    private OrderStatus status = OrderStatus.NEW;
    private LocalDate created;
    private LocalDate closed = null;
    private double price;

    private List<Book> books = new ArrayList<>();

    public Order() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Book> getAll() {
        return books;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getClosed() {
        return closed;
    }

    public void setClosed(LocalDate closed) {
        this.closed = closed;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    private String orderClosedDate() {
        if (closed == null) {
            return "In progress";
        }
        if (closed.equals(LocalDate.of(1970, 1, 1))) {
            return "Canceled";
        }
        return closed.toString();
    }

    private String printBooks() {
        String message = "";
        for (Book bookOld : books) {
            message += " name" + bookOld.getName() + " price" + bookOld.getPrice() + "/";
        }
        return message;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + id + '\'' +
                ", orderStatus='" + status + '\'' +
                ", orderCreationDate=" + created +
                ", Books:" + printBooks() +
                ", orderClosedDate=" + orderClosedDate() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.getPrice(), getPrice()) == 0 &&
                Objects.equals(getCustomerName(), order.getCustomerName()) &&
                Objects.equals(getId(), order.getId()) &&
                getStatus() == order.getStatus() &&
                Objects.equals(getCreated(), order.getCreated()) &&
                Objects.equals(getClosed(), order.getClosed()) &&
                Objects.equals(books, order.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerName(), getId(), getStatus(), getCreated(), getClosed(), getPrice(), books);
    }
}
