package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IRequestDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;

import java.util.ArrayList;
import java.util.List;

public class RequestDao implements IRequestDao {
    private List<Request> requests = new ArrayList<>();

    public List<Request> getRequests() {
        return requests;
    }

    @Override
    public Request createRequest(Book bookOld) {
        Request request = new Request(bookOld);
        requests.add(request);
        return request;
    }

    public Request getRequestById(String id) {
        return requests.stream()
                .filter(request -> request.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Request> getAll() {
        return requests;
    }
    
}
