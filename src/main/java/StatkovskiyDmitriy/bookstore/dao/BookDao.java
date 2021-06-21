package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IBookDao;
import StatkovskiyDmitriy.bookstore.exception.DaoException;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDao implements IBookDao {

    private static BookDao instance;
    private final List<Book> books = new ArrayList<>();

    private BookDao() {

    }

    public static BookDao getInstance() {
        if (instance == null) {
            instance = new BookDao();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }


    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> getBooksByIds(List<String> ids, BookStatus status) {

        return books.stream()
                .filter(book -> ids.contains(book.getId()))
                .filter(stockUnit -> status.equals(stockUnit.getStatus()))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByName(List<String> name, BookStatus status) {

        return books.stream()
                .filter(book -> name.contains(book.getName()))
                .filter(book -> status.equals(book.getStatus()))
                .collect(Collectors.toList());
    }

    public Book getBookByBookId(String id) throws DaoException {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new DaoException("book by id not found, id: " + id));
    }

    public Book getBookByName(String name) throws DaoException {
        return books.stream()
                .filter(book -> book.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new DaoException("book by name not found, name: " + name));
    }
}