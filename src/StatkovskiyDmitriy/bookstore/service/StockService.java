package StatkovskiyDmitriy.bookstore.service;

import StatkovskiyDmitriy.bookstore.api.dao.IStockDao;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.api.service.IStockService;
import StatkovskiyDmitriy.bookstore.dao.StockDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.StockUnit;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;
import StatkovskiyDmitriy.bookstore.model.enums.StockUnitStatus;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StockService implements IStockService {
    private IStockDao stockDao;
    private IRequestService requestService;

    public StockService(IStockDao stockDao, IRequestService requestService) {
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
        List<String> id = Arrays.asList(book.getId());
        if (stockDao.getStockUnitsByIds(id, StockUnitStatus.OUT_OF_STOCK).size() != 0) {
            requestService.changeRequestStatus(book.getId(), RequestStatus.CLOSED);
        }
    }

    public List<StockUnit> sortBooksByName(StockDao stockDao) {
        List<StockUnit> books = stockDao.getAllUnits();

        List<StockUnit> sorted = books.stream()
                .sorted(Comparator.comparing(o -> o.getBook().getName()))
                .collect(Collectors.toList());

        return sorted;
    }

    public List<StockUnit> sortBooksByPrice(StockDao stockDao) {
        List<StockUnit> books = stockDao.getAllUnits();

        List<StockUnit> sorted = books.stream()
                .sorted(Comparator.comparing(o -> o.getBook().getPrice()))
                .collect(Collectors.toList());

        return sorted;
    }

    //    public List<StockUnit> sortUnitsByDate(StockDao stockUnit){
//        List<StockUnit> units = stockUnit.getAllUnits();
//        List<StockUnit> sorted = units.stream()
//                .sorted(Comparator.comparing(StockUnit::getIncomingDate))
//                .collect(Collectors.toList());
//        for (StockUnit unit : sorted) {
//            System.out.println(unit);
//        }
//        return sorted;
//    }
    public List<StockUnit> sortUnitsByStatus(StockDao stockUnit) {
        List<StockUnit> units = stockUnit.getAllUnits();
        List<StockUnit> sorted = units.stream()
                .sorted(Comparator.comparing(StockUnit::getStatus))
                .collect(Collectors.toList());

        return sorted;
    }

    public String showBookDescription(StockDao stockUnit, String book) {
        List<StockUnit> units = stockUnit.getAllUnits();
        StockUnit filteredBook = units.stream()
                .filter(unit -> unit.getBook().getName().equals(book))
                .findFirst()
                .get();
        String description = filteredBook.getBook().getDescription();
        return description;
    }

}
