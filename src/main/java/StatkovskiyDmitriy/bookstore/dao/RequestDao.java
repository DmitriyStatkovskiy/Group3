package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IRequestDao;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RequestDao implements IRequestDao {
    private static RequestDao instance;
    private final List<Request> requests = new ArrayList<Request>();

    private RequestDao() {

    }

    public static RequestDao getInstance() {
        if (instance == null) {
            instance = new RequestDao();
        }
        return instance;
    }

    public List<Request> getRequests() {
        return requests;
    }

    @Override
    public Request createRequest(Book bookOld) {
        Request request = new Request(bookOld);
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

}
