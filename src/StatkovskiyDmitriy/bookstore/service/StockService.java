package StatkovskiyDmitriy.bookstore.service;

import StatkovskiyDmitriy.bookstore.api.dao.IStockUnitDao;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.api.service.IStockService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.StockUnit;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;
import StatkovskiyDmitriy.bookstore.model.enums.StockUnitStatus;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StockService implements IStockService {
    private IStockUnitDao stockDao;
    private IRequestService requestService;

    public StockService(IStockUnitDao stockDao, IRequestService requestService) {
        this.stockDao = stockDao;
        this.requestService = requestService;
    }

    public List<Book> getOutOfStockBooks(Order order) {
        List<Book> books = order.getBooks();
        List<String> bookIds = books.stream()
                .map(book -> book.getId())
                .collect(Collectors.toList());
        List<StockUnit> stockUnits = stockDao.getStockUnitsByIds(bookIds, StockUnitStatus.OUT_OF_STOCK);
        return stockUnits.stream()
                .map(stockUnit -> stockUnit.getBook())
                .collect(Collectors.toList());
    }

    @Override
    public void addBook(Book book) {
        List<String> name = Collections.singletonList(book.getId());
        if (stockDao.getStockUnitsByIds(name, StockUnitStatus.OUT_OF_STOCK).size() != 0) {
            requestService.changeRequestStatusByBookName(book.getName(), RequestStatus.CLOSED);
        }
    }

    public List<StockUnit> sortBooksByName(IStockUnitDao stockDao) {
        List<StockUnit> books = stockDao.getAllUnits();

        return books.stream()
                .sorted(Comparator.comparing(o -> o.getBook().getName()))
                .collect(Collectors.toList());
    }

    public List<StockUnit> sortBooksByPrice(IStockUnitDao stockDao) {
        List<StockUnit> books = stockDao.getAllUnits();

        return books.stream()
                .sorted(Comparator.comparing(o -> o.getBook().getPrice()))
                .collect(Collectors.toList());

    }

    //        public List<StockUnit> sortUnitsByDate(IStockDao stockUnit){
//        List<StockUnit> units = stockUnit.getAllUnits();
//        return units.stream()
//                .sorted(Comparator.comparing(StockUnit::getIncomingDate))
//                .collect(Collectors.toList());
//
//    }
    public List<StockUnit> sortUnitsByStatus(IStockUnitDao stockUnit) {
        List<StockUnit> units = stockUnit.getAllUnits();
        return units.stream()
                .sorted(Comparator.comparing(StockUnit::getStatus))
                .collect(Collectors.toList());
    }

    public String showBookDescription(IStockUnitDao stockUnit, String book) {
        List<StockUnit> units = stockUnit.getAllUnits();
        StockUnit filteredBook = units.stream()
                .filter(unit -> unit.getBook().getName().equals(book))
                .findFirst()
                .get();
        return filteredBook.getBook().getDescription();
    }

    public List<StockUnit> getOldBooks(IStockUnitDao stockUnitDao) {
        List<StockUnit> books = stockUnitDao.getAllUnits();
        return books.stream()
                .filter(unit -> unit.getIncomingDate().isBefore(LocalDate.now().minusMonths(6)))
                .collect(Collectors.toList());
    }

    public List<StockUnit> sortOldBooksByIncomingDate(IStockUnitDao stockUnitDao) {
        List<StockUnit> books = getOldBooks(stockUnitDao);
        return books.stream()
                .sorted(Comparator.comparing(o -> o.getIncomingDate()))
                .collect(Collectors.toList());
    }

    public List<StockUnit> sortOldBooksByPrice(IStockUnitDao stockUnitDao) {
        List<StockUnit> books = getOldBooks(stockUnitDao);
        return books.stream()
                .sorted(Comparator.comparing(o -> o.getBook().getPrice()))
                .collect(Collectors.toList());
    }

    public StockUnit changeBookStatus(StockUnit stockUnit, StockUnitStatus status) {
        stockUnit.setStatus(status);
        return stockUnit;
    }

}
