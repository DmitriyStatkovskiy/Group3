package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IRequestDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class RequestDao implements IRequestDao {
    private List<Request> requests = new ArrayList<>();

//    public boolean getRequestedBookName(String name) {
//        for (Request req : requests) {
//            if (req.getRequestedBookName().equals(name)) {
//                return true;
//            }
//        }
//        return false;
//    }

//    public boolean getRequestStatus() {
//        for (Request req : requests) {
//            if (req.getRequestStatus().equals("closed")) {
//                return true;
//            }
//        }
//        return false;
//    }

    public List<Request> getRequests() {
        return requests;
    }

    public void addRequest(String id, String requestedBookName) {
     //   requests.add(new Request(id, requestedBookName));
    }


    @Override
    public Request createRequest(Book book) {
        Request request = new Request(book);
        requests.add(request);
        return request;
    }

    @Override
    public void changeRequestStatus(String id, RequestStatus status) {
        Request request1 = requests.stream()
                .filter(request -> request.getBook().getId().equals(id))
                .findFirst()
                .get();
        request1.setStatus(status);
    }

    @Override
    public Request addBookToRequest(Book book) {
        return null;
    }

    @Override
    public List<Request> getAll() {
        return requests;
    }

    @Override
    public Request getRequest(String id) {
        return null;
    }

    @Override
    public Request delete(String id) {
        return null;
    }

//    public void closeRequest(String bookName) {
//        for (Request request : requests) {
//            if (request.getRequestedBookName().equals(bookName)) {
//                request.setRequestStatus("closed");
//            }
//        }
//    }

    public void printRequests() {
        for (Request request : requests) {
            System.out.println(request);
        }
        System.out.println();
    }

//    public void sortByName() {
//        requests.sort(comparing(Request::getRequestedBookName));
//    }
//    public void sortById() {
//        requests.sort(comparing(Request::getId));
//    }
//
//    public void sortByStatus() {
//        requests.sort(comparing(Request::getRequestStatus));
//    }

}
