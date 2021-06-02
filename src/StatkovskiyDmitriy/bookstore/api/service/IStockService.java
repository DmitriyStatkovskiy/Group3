package StatkovskiyDmitriy.bookstore.api.service;

import StatkovskiyDmitriy.bookstore.api.dao.IStockUnitDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.StockUnit;

import java.util.List;

public interface IStockService {
    List<Book> getOutOfStockBooks(Order order);

    void addBook(Book book);

    List<StockUnit> sortBooksByName(IStockUnitDao stockDao);

    List<StockUnit> sortBooksByPrice(IStockUnitDao stockDao);

    List<StockUnit> sortUnitsByStatus(IStockUnitDao stockUnit);

    String showBookDescription(IStockUnitDao stockUnit, String book);

    List<StockUnit> getOldBooks(IStockUnitDao stockUnitDao);

    List<StockUnit> sortOldBooksByIncomingDate(IStockUnitDao stockUnitDao);

    List<StockUnit> sortOldBooksByPrice(IStockUnitDao stockUnitDao);

    // List<StockUnit> sortUnitsByDate(StockDao stockUnit);
}
