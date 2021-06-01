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

    public List<Request> getRequests() {
        return requests;
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


    public void printRequests() {
        for (Request request : requests) {
            System.out.println(request);
        }
        System.out.println();
    }
}
