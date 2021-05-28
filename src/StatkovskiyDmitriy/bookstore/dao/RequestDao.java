package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.model.Request;

import java.util.ArrayList;

import static java.util.Comparator.comparing;

//определиться с тем, какой из методов add лучше

public class RequestDao implements StatkovskiyDmitriy.bookstore.api.dao.RequestDao<Request> {
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

    public boolean getRequestStatus() {
        for (Request req :
                requests) {
            if (req.getRequestStatus().equals("closed")) {
                return true;
            }
        }
        return false;
    }

    public void addRequest(String id, String requestedBookName) {
        requests.add(new Request(id, requestedBookName));
    }
    @Override
    public void add(Request request) {
        requests.add(request);
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
    public void sortByName() {
        requests.sort(comparing(Request::getRequestedBookName));
    }

    public void sortById() {
        requests.sort(comparing(Request::getRequestId));
    }

    public void sortByStatus() {
        requests.sort(comparing(Request::getRequestStatus));
    }

}
