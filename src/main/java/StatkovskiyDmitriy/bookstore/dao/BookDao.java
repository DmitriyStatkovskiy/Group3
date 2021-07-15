package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.annotation.injection.annotation.Autowired;
import StatkovskiyDmitriy.annotation.injection.annotation.Component;
import StatkovskiyDmitriy.bookstore.api.dao.IBookDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class BookDao implements IBookDao, Serializable {

    private static BookDao instance;
    @Autowired
    private List<Book> books = new ArrayList<>();

    private BookDao() {

    }

    public static BookDao getInstance() {
        if (instance == null) {
            instance = new BookDao();
        }
        return instance;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void deleteAll() {
        books = new ArrayList<>();
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

    public Book getBookByBookId(String id) throws EntityNotFoundException {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("book by id not found, id: " + id));
    }

    public Book getBookByName(String name) throws EntityNotFoundException {
        return books.stream()
                .filter(book -> book.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("book by name not found, name: " + name));
    }
}