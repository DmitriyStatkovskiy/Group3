package StatkovskiyDmitriy.bookstore.api.dao;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

import java.util.List;

public interface IRequestDao {

    Request createRequest(Book book);

    void changeRequestStatus(String id, RequestStatus status);

    Request addBookToRequest(Book book);

    List<Request> getAll();
    Request getRequest(String id);

    Request delete(String id);
}
