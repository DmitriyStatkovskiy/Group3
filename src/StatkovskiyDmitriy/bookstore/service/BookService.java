package StatkovskiyDmitriy.bookstore.service;

import StatkovskiyDmitriy.bookstore.api.dao.IBookDao;
import StatkovskiyDmitriy.bookstore.api.service.IBookService;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookService implements IBookService {
    private IBookDao bookDao;
    private IRequestService requestService;

    public BookService(IBookDao stockDao, IRequestService requestService) {
        this.bookDao = stockDao;
        this.requestService = requestService;
    }

    public List<Book> getOutOfStockBooks(Order order) {
        List<Book> bookOlds = order.getBookOlds();
        List<String> bookIds = bookOlds.stream()
                .map(book -> book.getId())
                .collect(Collectors.toList());
        List<Book> books = bookDao.getBooksByIds(bookIds, BookStatus.OUT_OF_STOCK);
        return books;
    }

    @Override
    public void addBook(Book bookOld) {
        List<String> name = Collections.singletonList(bookOld.getId());
        if (bookDao.getBooksByIds(name, BookStatus.OUT_OF_STOCK).size() != 0) {
            requestService.changeRequestStatusByBookName(bookOld.getName(), RequestStatus.CLOSED);
        }
    }

    public List<Book> sortBooksByName() {
        List<Book> books = bookDao.getAllBooks();

        return books.stream()
                .sorted(Comparator.comparing(o -> o.getName()))
                .collect(Collectors.toList());
    }

    public List<Book> sortBooksByPrice() {
        List<Book> books = bookDao.getAllBooks();

        return books.stream()
                .sorted(Comparator.comparing(book -> book.getPrice()))
                .collect(Collectors.toList());

    }

    public List<Book> sortBooksByStatus() {
        List<Book> units = bookDao.getAllBooks();
        return units.stream()
                .sorted(Comparator.comparing(Book::getStatus))
                .collect(Collectors.toList());
    }

    public String showBookDescription(String book) {
        List<Book> units = bookDao.getAllBooks();
        Book filteredBook = units.stream()
                .filter(unit -> unit.getName().equals(book))
                .findFirst()
                .get();
        return filteredBook.getDescription();
    }

    public List<Book> getOldBooks() {
        List<Book> books = bookDao.getAllBooks();
        return books.stream()
                .filter(unit -> unit.getIncomingDate().isBefore(LocalDate.now().minusMonths(6)))
                .collect(Collectors.toList());
    }

    public List<Book> sortOldBooksByIncomingDate() {
        List<Book> books = getOldBooks();
        return books.stream()
                .sorted(Comparator.comparing(o -> o.getIncomingDate()))
                .collect(Collectors.toList());
    }

    public List<Book> sortOldBooksByPrice() {
        List<Book> books = getOldBooks();
        return books.stream()
                .sorted(Comparator.comparing(o -> o.getPrice()))
                .collect(Collectors.toList());
    }

    public Book changeBookStatus(Book book, BookStatus status) {
        book.setStatus(status);
        return book;
    }
    public void printStock(List<Book> book) {
        for (Book unit : book
        ) {
            System.out.println(unit);
        }
    }
    public void printStock() {
        System.out.println(bookDao.getAllBooks());
    }
}
