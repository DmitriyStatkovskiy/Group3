package StatkovskiyDmitriy.bookstore.model;

import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

import java.util.Objects;
import java.util.UUID;

public class Request {
    private RequestStatus status = RequestStatus.OPEN;
    private String requestStatus = "open";
    private Book book;
    private String id = UUID.randomUUID().toString();

    public Request() {
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

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return status == request.status &&
                Objects.equals(requestStatus, request.requestStatus) &&
                Objects.equals(book, request.book) &&
                Objects.equals(id, request.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, requestStatus, book, id);
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestStatus='" + status + '\'' +
                ", requestedBookName='" + book.getName() + '\'' +
                '}';
    }
}
