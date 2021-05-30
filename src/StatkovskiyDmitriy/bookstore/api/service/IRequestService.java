package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

public interface IRequestService {
    Request createRequest(Book book);

    void changeRequestStatus(String id, RequestStatus status);

    Request addBookToRequest(Book book);
}
