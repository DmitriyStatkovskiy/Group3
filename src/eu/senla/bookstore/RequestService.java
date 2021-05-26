package eu.senla.bookstore;

import eu.senla.bookstore.interfaces.DaoApi;

import java.util.ArrayList;

public class RequestService implements DaoApi<Request> {
    ArrayList<Request> requests = new ArrayList<>();

    public boolean getRequestedBookName(String name) {
        for (Request req :
                requests) {
            if (req.getRequestedBookName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addRequest(String id, String requestedBookName) {
        requests.add(new Request(id, requestedBookName));
    }

    public void closeRequest(String bookName) {
        for (Request request : requests
        ) {
            if (request.getRequestedBookName().equals(bookName)) {
                request.setRequestStatus("closed");
            }
        }
    }

    public void printRequests() {
        for (Request request : requests
        ) {
            System.out.println(request);
        }
        System.out.println();
    }

    @Override
    public void add(Request request) {
        requests.add(request);
    }
}
