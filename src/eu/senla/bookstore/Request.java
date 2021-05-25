package eu.senla.bookstore;

public class Request {
    private String requestStatus;
    private String requestedBookName;

    public Request(String requestStatus, String requestedBookName) {
        this.requestStatus = requestStatus;
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

}
