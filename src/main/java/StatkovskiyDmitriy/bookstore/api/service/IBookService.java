package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;

import java.time.LocalDate;
import java.util.List;

public interface IBookService {
    List<Book> getOutOfStockBooks(Order order);

    List<Book> getOutOfStockBooks();

    void addBookToStock(Book book);

    List<Book> sortBooksByName();

    List<Book> sortBooksByPrice();

    List<Book> sortBooksByStatus();

    String showDescription(String book);

    List<Book> getOldBooks();

    List<Book> sortOldBooksByIncomingDate();

    List<Book> sortOldBooksByPrice();

    Book changeBookStatus(Book book, BookStatus status);

    List<Book> getAllBooks();

    void addBook(Book book);

    List<Book> getOutBooks();

    Book getBookByName(String name);

    void changeStatusByName(String name);

    List<Book> getOldBooksByFieldIsOld();

    void setOldBooks(int month);

    void setIncomingDate(String book, LocalDate date);

    public void addBookAndCloseRequest(String bookName);


}
