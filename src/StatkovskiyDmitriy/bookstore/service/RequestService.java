package StatkovskiyDmitriy.bookstore.service;

import StatkovskiyDmitriy.bookstore.api.dao.IRequestDao;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Request;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
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
        requestDao.getRequestById(id).setStatus(status);
    }

    public void changeRequestStatusByBookName(String bookName, RequestStatus status) {
        List<Request> requests = requestDao.getAll();
        requests.stream()
                .filter(request -> request.getBook().getName().equals(bookName))
                .forEach(request -> request.setStatus(status));
    }

    public List<Request> sortRequestsByBookName(IRequestDao requestDao) {
        List<Request> books = requestDao.getAll();
        return books.stream()
                .sorted(Comparator.comparing(o -> o.getBook().getName()))
                .collect(Collectors.toList());
    }

    public List<Request> sortRequestsByQuantity(IRequestDao requestDao) {
        List<Request> requests = requestDao.getAll();             //комметы для себя, потом удалю
        List<String> allBookNames = requests.stream().            //все названия книг
                map(book -> book.getBook().getName())
                .collect(Collectors.toList());
        Set<String> uniqName = requests.stream()                  //получаю все уникальные
                .map(book -> book.getBook().getName())
                .collect(Collectors.toSet());
        String[] requestedBookNames = new String[uniqName.size()];//делаю из сет массив стрингов
        uniqName.toArray(requestedBookNames);

        int[] numberOfRepetitions = new int[uniqName.size()];     //массив для количества повторений

        for (int i = 0; i < requestedBookNames.length; i++) {                                     //беру уникальное имя из массива,
            numberOfRepetitions[i] = Collections.frequency(allBookNames, requestedBookNames[i]);  //прохожу по всем именам и записываю количество повторений
        }

        for (int i = 0; i < requestedBookNames.length; i++) {     //заполняю Request.quantity
            int j = i;
            requests.stream()
                    .filter(request -> request.getBook().getName().equals(requestedBookNames[j]))
                    .forEach(request -> request.setQuantity(numberOfRepetitions[j]));
        }
        return requests.stream()
                .sorted(Comparator.comparing(o -> o.getQuantity()))
                .collect(Collectors.toList());
    }
}
