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

import java.util.ArrayList;
import java.util.Arrays;
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


}
