package StatkovskiyDmitriy.bookstore.service;

import StatkovskiyDmitriy.bookstore.api.dao.IBookDao;
import StatkovskiyDmitriy.bookstore.api.service.IBookService;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.dao.BookDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookService implements IBookService {
    static Logger logger = LoggerFactory.getLogger(BookService.class);
    private static BookService instance;
    private IBookDao bookDao = BookDao.getInstance();
    private IRequestService requestService;

    private BookService() {

    }

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    public BookService(IBookDao stockDao, IRequestService requestService) {
        this.bookDao = stockDao;
        this.requestService = requestService;
    }

    public List<Book> getOutOfStockBooks(Order order) {
        List<Book> bookOlds = order.getBooks();
        List<String> bookIds = bookOlds.stream()
                .map(book -> book.getId())
                .collect(Collectors.toList());
        List<Book> books = bookDao.getBooksByIds(bookIds, BookStatus.OUT_OF_STOCK);
        return books;
    }

    public List<Book> getOutOfStockBooks() {
        List<Book> books = bookDao.getAllBooks().stream()
                .filter(book -> book.getStatus().equals(BookStatus.OUT_OF_STOCK))
                .collect(Collectors.toList());
        return books;
    }

    public List<Book> getOutBooks() {
        List<Book> books = bookDao.getAllBooks();
        return books.stream()
                .filter(book -> book.getStatus().equals(BookStatus.OUT_OF_STOCK))
                .collect(Collectors.toList());
    }

    @Override
    public void addBookToStock(Book bookOld) throws EntityNotFoundException {
        List<String> name = Collections.singletonList(bookOld.getId());
        try {
            if (bookDao.getBooksByIds(name, BookStatus.OUT_OF_STOCK).size() != 0) {
                requestService.changeRequestStatusByBookName(bookOld.getName(), RequestStatus.CLOSED);
            }
        } catch (EntityNotFoundException exception) {
            logger.info("can't add book " + bookOld);
            throw new EntityNotFoundException("can't add book " + bookOld);
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

    public String showDescription(String book) throws EntityNotFoundException {
        List<Book> units = bookDao.getAllBooks();
        Book filteredBook = units.stream()
                .filter(unit -> unit.getName().equals(book))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("book not found, description can not be shown, book: " + book));
        return filteredBook.getDescription();
    }

    public List<Book> getOldBooks() {
        List<Book> books = bookDao.getAllBooks();
        return books.stream()
                .filter(unit -> unit.getIncomingDate().isBefore(LocalDate.now().minusMonths(6)))
                .collect(Collectors.toList());
    }

    public List<Book> sortOldBooksByIncomingDate() {
        List<Book> books = getOldBooksByFieldIsOld();
        return books.stream()
                .sorted(Comparator.comparing(o -> o.getIncomingDate()))
                .collect(Collectors.toList());
    }

    public List<Book> sortOldBooksByPrice() {
        List<Book> books = getOldBooksByFieldIsOld();
        return books.stream()
                .sorted(Comparator.comparing(o -> o.getPrice()))
                .collect(Collectors.toList());
    }

    public Book changeBookStatus(Book book, BookStatus status) {
        book.setStatus(status);
        return book;
    }

    public void changeStatusByName(String name) throws EntityNotFoundException {
        List<Book> books = bookDao.getAllBooks().stream()
                .filter(book -> book.getName().equals(name))
                .filter(book -> book.getStatus().equals(BookStatus.IN_STOCK))
                .collect(Collectors.toList());

        if (books.size() != 0) {
            bookDao.getAllBooks().stream()
                    .filter(book -> book.getName().equals(name))
                    .forEach(book -> book.setStatus(BookStatus.OUT_OF_STOCK));
        } else bookDao.getAllBooks().stream()
                .filter(book -> book.getName().equals(name))
                .forEach(book -> book.setStatus(BookStatus.IN_STOCK));
        try {
            Book book1 = bookDao.getAllBooks().stream()
                    .filter(book -> book.getName().equals(name))
                    .findFirst()
                    .get();
        } catch (EntityNotFoundException exception) {
            logger.info("Book " + name + " not found, status can't be changed ");
            throw new EntityNotFoundException("book " + name + " not found, status");
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public Book getBookByName(String name) {
        return bookDao.getBookByName(name);
    }

    public void setOldBooks(int month) {
        bookDao.getAllBooks().stream()
                .filter(book -> book.getIncomingDate().isBefore(LocalDate.now().minusMonths(month)))
                .forEach(book -> book.setOld(true));
    }

    public List<Book> getOldBooksByFieldIsOld() {
        List<Book> books = bookDao.getAllBooks();
        return books.stream().filter(Book::isOld).collect(Collectors.toList());
    }

    public void setIncomingDate(String book, LocalDate date) {
        bookDao.getAllBooks().stream()
                .filter(book1 -> book1.getName().equals(book))
                .findFirst()
                .get()
                .setIncomingDate(date);
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
