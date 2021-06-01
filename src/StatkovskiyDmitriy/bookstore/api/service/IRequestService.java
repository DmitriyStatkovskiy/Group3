package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.dao.RequestDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

import java.util.List;

public interface IRequestService {
    Request createRequest(Book book);

    void changeRequestStatus(String id, RequestStatus status);

    void changeRequestStatusByBookName(String bookName, RequestStatus status);

    List<Request> sortRequestsByBookName(RequestDao requestDao);

    Request addBookToRequest(Book book);
}
