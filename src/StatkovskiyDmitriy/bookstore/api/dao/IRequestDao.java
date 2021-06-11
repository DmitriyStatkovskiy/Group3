package StatkovskiyDmitriy.bookstore.api.dao;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;

import java.util.List;

public interface IRequestDao {

    Request createRequest(Book book);

    // void changeRequestStatus(String id, RequestStatus status);

    List<Request> getAll();

    Request getRequestById(String id);
}
