package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.api.dao.IBookDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;

import java.util.List;

public interface IBookService {
    List<Book> getOutOfStockBooks(Order order);

    void addBook(Book book);

    List<Book> sortBooksByName(IBookDao bookDao);

    List<Book> sortBooksByPrice(IBookDao bookDao);

    List<Book> sortUnitsByStatus(IBookDao book);

    String showBookDescription(IBookDao bookDao, String book);

    List<Book> getOldBooks(IBookDao bookDao);

    List<Book> sortOldBooksByIncomingDate(IBookDao bookDao);

    List<Book> sortOldBooksByPrice(IBookDao bookDao);

    Book changeBookStatus(Book book, BookStatus status);

    // List<StockUnit> sortUnitsByDate(StockDao stockUnit);
}
