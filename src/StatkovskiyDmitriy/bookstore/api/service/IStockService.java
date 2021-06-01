package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.api.dao.IStockDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.StockUnit;

import java.util.List;

public interface IStockService {
    List<Book> getOutOfStockBooks(Order order);

    void addBook(Book book);

    List<StockUnit> sortBooksByName(IStockDao stockDao);

    List<StockUnit> sortBooksByPrice(IStockDao stockDao);

    List<StockUnit> sortUnitsByStatus(IStockDao stockUnit);

    String showBookDescription(IStockDao stockUnit, String book);

    // List<StockUnit> sortUnitsByDate(StockDao stockUnit);
}
