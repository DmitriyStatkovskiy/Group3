package StatkovskiyDmitriy.bookstore.api.dao;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;

import java.util.List;

public interface IBookDao {

    void addBook(Book book);

    List<Book> getStockUnitsByIds(List<String> ids, BookStatus status);

    List<Book> getStockUnitsByName(List<String> name, BookStatus status);

    List<Book> getAllUnits();

    public Book getStockUnitByBookId(String id);
}
