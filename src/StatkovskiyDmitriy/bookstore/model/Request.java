package StatkovskiyDmitriy.bookstore.model;

import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

import java.util.Objects;
import java.util.UUID;

public class Request {
    private RequestStatus status = RequestStatus.OPEN;
    private int quantity;
    private Book book;
    private String id = UUID.randomUUID().toString();

    public Request() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Request(Book book) {
        this.book = book;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return getStatus() == request.getStatus() &&
                Objects.equals(getBook(), request.getBook()) &&
                Objects.equals(getId(), request.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getBook(), getId());
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId='" + id + '\'' +
                "requestStatus='" + status + '\'' +
                ", requestedBookName='" + book.getName() + '\'' +
                '}';
    }
}
