package StatkovskiyDmitriy.bookstore.model;

import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

import java.util.Objects;
import java.util.UUID;

public class Request {
    private RequestStatus status = RequestStatus.OPEN;
    private int quantity;
    private Book bookOld;
    private String id = UUID.randomUUID().toString();

    public Request() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Request(Book bookOld) {
        this.bookOld = bookOld;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBookOld() {
        return bookOld;
    }

    public void setBookOld(Book bookOld) {
        this.bookOld = bookOld;
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
                Objects.equals(getBookOld(), request.getBookOld()) &&
                Objects.equals(getId(), request.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getBookOld(), getId());
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId='" + id + '\'' +
                "requestStatus='" + status + '\'' +
                ", requestedBookName='" + bookOld.getName() + '\'' +
                '}';
    }
}
