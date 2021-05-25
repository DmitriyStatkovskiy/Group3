package eu.senla.bookstore;

import java.util.ArrayList;

public class RequestService {
    ArrayList<Request> requests = new ArrayList<>();

    public void addRequest(String requestedBookName) {
        requests.add(new Request(requestedBookName));
    }

    public void closeRequest(String bookName) {
        for (Request request : requests
        ) {
            if (request.getRequestedBookName().equals(bookName)) {
                request.setRequestStatus("closed");
            }
        }
    }
}
