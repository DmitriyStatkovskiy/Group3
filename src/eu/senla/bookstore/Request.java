package eu.senla.bookstore;

import java.util.Objects;

public class Request {
    private String requestStatus = "new";
    private String requestedBookName;

    public Request(String requestedBookName) {
        this.requestedBookName = requestedBookName;
    }

    public Request() {
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestedBookName() {
        return requestedBookName;
    }

    public void setRequestedBookName(String requestedBookName) {
        this.requestedBookName = requestedBookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(getRequestStatus(), request.getRequestStatus()) &&
                Objects.equals(getRequestedBookName(), request.getRequestedBookName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestStatus(), getRequestedBookName());
    }
}
