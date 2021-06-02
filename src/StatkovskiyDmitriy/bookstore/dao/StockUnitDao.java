package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IStockUnitDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.StockUnit;
import StatkovskiyDmitriy.bookstore.model.enums.StockUnitStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StockUnitDao implements IStockUnitDao {

    private List<StockUnit> stockUnits = new ArrayList<>();

    public void addBook(Book book) {
        stockUnits.add(new StockUnit(book));

    }

    public List<StockUnit> getAllUnits() {
        return stockUnits;
    }

    public List<StockUnit> getStockUnitsByIds(List<String> ids, StockUnitStatus status) {

        return stockUnits.stream()
                .filter(stockUnit -> ids.contains(stockUnit.getBook().getId()))
                .filter(stockUnit -> status.equals(stockUnit.getStatus()))
                .collect(Collectors.toList());
    }

    public List<StockUnit> getStockUnitsByName(List<String> name, StockUnitStatus status) {

        return stockUnits.stream()
                .filter(stockUnit -> name.contains(stockUnit.getBook().getName()))
                .filter(stockUnit -> status.equals(stockUnit.getStatus()))
                .collect(Collectors.toList());
    }

    public void changeBookStatus(String id, StockUnitStatus status) {
        StockUnit stockUnit = getStockUnitByBookId(id);
        stockUnit.setStatus(status);
    }

    public StockUnit getStockUnitByBookId(String id) {
        return stockUnits.stream()
                .filter(unit -> unit.getBook().getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Book getBook(Book book) {

        return book;
    }

    public void printStock() {
        for (StockUnit stockUnit : stockUnits) {
            System.out.println(stockUnit);
        }
    }

    public void printStock(List<StockUnit> stockUnit) {
        for (StockUnit unit : stockUnit
        ) {
            System.out.println(unit);
        }
    }
}