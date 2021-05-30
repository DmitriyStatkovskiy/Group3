package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;

import java.util.List;

public interface IStockService {
    List<Book> getOutOfStockBooks(Order order);

    void addBook(Book book);
}
