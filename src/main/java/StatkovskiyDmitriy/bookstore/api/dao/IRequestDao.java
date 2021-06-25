package StatkovskiyDmitriy.bookstore.api.dao;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;

import java.util.List;

public interface IRequestDao {

    Request createRequest(Book book);

    List<Request> getAll();

    Request getRequestById(String id);

    void deleteAll();

    void setRequests(List<Request> requests);
}
