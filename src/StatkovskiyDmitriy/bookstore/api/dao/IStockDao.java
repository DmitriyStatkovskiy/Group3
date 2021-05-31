package StatkovskiyDmitriy.bookstore.api.dao;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.StockUnit;
import StatkovskiyDmitriy.bookstore.model.enums.StockUnitStatus;

import java.util.List;

public interface IStockDao {

    void addBook(Book book);

    List<StockUnit> getStockUnitsByIds(List<String> ids, StockUnitStatus status);

    Book getBook(Book book);

    List<StockUnit> getAllUnits();


}
