package StatkovskiyDmitriy.bookstore.service;

import StatkovskiyDmitriy.bookstore.api.dao.IRequestDao;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public void changeRequestStatusByBookName(String bookName, RequestStatus status) {
        List<Request> requests = requestDao.getAll();

        for (Request request : requests) {
            if (request.getBook().getName().equals(bookName)) {
                request.setStatus(status);
            }
        }
    }

    @Override
    public Request addBookToRequest(Book book) {
        return requestDao.addBookToRequest(book);
    }

    public List<Request> sortRequestsByBookName(IRequestDao requestDao) {
        List<Request> books = requestDao.getAll();
        List<Request> sorted = books.stream()
                .sorted(Comparator.comparing(o -> o.getBook().getName()))
                .collect(Collectors.toList());
        return sorted;
    }

}
