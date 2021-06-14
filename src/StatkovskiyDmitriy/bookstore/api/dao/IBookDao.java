package StatkovskiyDmitriy.bookstore.api.dao;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;

import java.util.List;

public interface IBookDao {

    void addBook(Book book);

    List<Book> getBooksByIds(List<String> ids, BookStatus status);

    List<Book> getBooksByName(List<String> name, BookStatus status);

    List<Book> getAllBooks();

    Book getBookByBookId(String id);

    Book getBookByName(String name);
}
