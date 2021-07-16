package StatkovskiyDmitriy.bookstore.service;

import DmitriyStatkovskiy.ioc.annotation.Autowired;
import DmitriyStatkovskiy.ioc.annotation.Component;
import StatkovskiyDmitriy.bookstore.api.dao.IRequestDao;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RequestService implements IRequestService, Serializable {
    private static RequestService instance;
    @Autowired
    private IRequestDao requestDao;

    private RequestService() {

    }

    public static RequestService getInstance() {
        if (instance == null) {
            instance = new RequestService();
        }
        return instance;
    }

    public List<Request> getAll() {
        return requestDao.getAll();
    }

    @Override
    public Request createRequest(Book bookOld) {
        return requestDao.createRequest(bookOld);
    }

    @Override
    public void changeRequestStatus(String id, RequestStatus status) {
        requestDao.getRequestById(id).setStatus(status);
    }

    public void closeRequest(String id) {
        requestDao.getRequestById(id).setStatus(RequestStatus.CLOSED);
    }

    public Request getRequestByName(String name) throws EntityNotFoundException {
        Request request = requestDao.getAll().stream()
                .filter(request1 -> request1.getBook().getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("request by book name not found, book name: " + name));
        return request;
    }

    public void changeRequestStatusByBookName(String bookName, RequestStatus status) {
        List<Request> requests = requestDao.getAll();
        requests.stream()
                .filter(request -> request.getBook().getName().equals(bookName))
                .forEach(request -> request.setStatus(status));
    }

    public List<Request> sortRequestsByBookName() {
        List<Request> books = requestDao.getAll();
        return books.stream()
                .sorted(Comparator.comparing(o -> o.getBook().getName()))
                .collect(Collectors.toList());
    }

    public List<Request> sortRequestsByQuantity() {
        List<Request> requests = requestDao.getAll();
        List<String> allBookNames = requests.stream().
                map(book -> book.getBook().getName())
                .collect(Collectors.toList());
        Set<String> uniqName = requests.stream()
                .map(book -> book.getBook().getName())
                .collect(Collectors.toSet());
        String[] requestedBookNames = new String[uniqName.size()];
        uniqName.toArray(requestedBookNames);

        int[] numberOfRepetitions = new int[uniqName.size()];

        for (int i = 0; i < requestedBookNames.length; i++) {
            numberOfRepetitions[i] = Collections.frequency(allBookNames, requestedBookNames[i]);
        }

        for (int i = 0; i < requestedBookNames.length; i++) {
            int j = i;
            requests.stream()
                    .filter(request -> request.getBook().getName().equals(requestedBookNames[j]))
                    .forEach(request -> request.setQuantity(numberOfRepetitions[j]));
        }
        return requests.stream()
                .sorted(Comparator.comparing(o -> o.getQuantity()))
                .collect(Collectors.toList());
    }

    public void deleteAll() {
        requestDao.deleteAll();
    }

    public void setRequests(List<Request> requests) {
        requestDao.setRequests(requests);
    }
}
