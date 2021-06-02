package StatkovskiyDmitriy.bookstore.api.dao;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.StockUnit;
import StatkovskiyDmitriy.bookstore.model.enums.StockUnitStatus;

import java.util.List;

public interface IStockUnitDao {

    void addBook(Book book);

    List<StockUnit> getStockUnitsByIds(List<String> ids, StockUnitStatus status);

    List<StockUnit> getStockUnitsByName(List<String> name, StockUnitStatus status);

    List<StockUnit> getAllUnits();


}
