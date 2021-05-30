package StatkovskiyDmitriy.bookstore.service;

import StatkovskiyDmitriy.bookstore.api.dao.IRequestDao;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

public class RequestService implements IRequestService {
    private final IRequestDao requestDao;

    public RequestService(IRequestDao requestDao) {
        this.requestDao = requestDao;
    }

    @Override
    public Request createRequest(Book book) {
        return requestDao.createRequest(book);
    }

    @Override
    public void changeRequestStatus(String id, RequestStatus status) {
        requestDao.changeRequestStatus(id, status);
    }

    @Override
    public Request addBookToRequest(Book book) {
        return requestDao.addBookToRequest(book);
    }
}
