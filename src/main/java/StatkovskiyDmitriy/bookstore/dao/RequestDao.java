package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IRequestDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RequestDao implements IRequestDao, Serializable {
    private static RequestDao instance;
    private List<Request> requests = new ArrayList<>();

    private RequestDao() {
    }

    public static RequestDao getInstance() {
        if (instance == null) {
            instance = new RequestDao();
        }
        return instance;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Request> getRequests() {
        return requests;
    }

    @Override
    public Request createRequest(Book book) {
        Request request = new Request(book);
        requests.add(request);
        return request;
    }

    public Request getRequestById(String id) throws EntityNotFoundException {
        return requests.stream()
                .filter(request -> request.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("request by id not found, id: " + id));
    }

    @Override
    public List<Request> getAll() {
        return requests;
    }

    public void deleteAll() {
        requests = new ArrayList<>();
    }
}
