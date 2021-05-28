package eu.senla.bookstore.model;

import java.util.Objects;

public class Request {
    private String requestStatus = "open";
    private String requestedBookName;
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Request(String requestId,String requestedBookName) {
        this.requestedBookName = requestedBookName;
        this.requestId = requestId;
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

    @Override
    public String toString() {
        return "Request{" +
                "requestStatus='" + requestStatus + '\'' +
                ", requestedBookName='" + requestedBookName + '\'' +
                '}';
    }
}
