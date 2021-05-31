package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.dao.StockDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.StockUnit;

import java.util.List;

public interface IStockService {
    List<Book> getOutOfStockBooks(Order order);

    void addBook(Book book);

    List<StockUnit> sortBooksByName(StockDao stockDao);

    List<StockUnit> sortBooksByPrice(StockDao stockDao);

    List<StockUnit> sortUnitsByStatus(StockDao stockUnit);

    // List<StockUnit> sortUnitsByDate(StockDao stockUnit);
}
