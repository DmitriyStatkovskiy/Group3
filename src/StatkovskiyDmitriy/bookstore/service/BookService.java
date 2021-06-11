package StatkovskiyDmitriy.bookstore.service;

import StatkovskiyDmitriy.bookstore.api.dao.IBookDao;
import StatkovskiyDmitriy.bookstore.api.service.IBookService;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookService implements IBookService {
    private IBookDao stockDao;
    private IRequestService requestService;

    public BookService(IBookDao stockDao, IRequestService requestService) {
        this.stockDao = stockDao;
        this.requestService = requestService;
    }

    public List<Book> getOutOfStockBooks(Order order) {
        List<Book> bookOlds = order.getBookOlds();
        List<String> bookIds = bookOlds.stream()
                .map(book -> book.getId())
                .collect(Collectors.toList());
        List<Book> books = stockDao.getStockUnitsByIds(bookIds, BookStatus.OUT_OF_STOCK);
        return books;
//        return books.stream()
//                .map(stockUnit -> stockUnit.getBook())
//                .collect(Collectors.toList());
    }

    @Override
    public void addBook(Book bookOld) {
        List<String> name = Collections.singletonList(bookOld.getId());
        if (stockDao.getStockUnitsByIds(name, BookStatus.OUT_OF_STOCK).size() != 0) {
            requestService.changeRequestStatusByBookName(bookOld.getName(), RequestStatus.CLOSED);
        }
    }

    public List<Book> sortBooksByName(IBookDao bookDao) {
        List<Book> books = bookDao.getAllUnits();

        return books.stream()
                .sorted(Comparator.comparing(o -> o.getName()))
                .collect(Collectors.toList());
    }

    public List<Book> sortBooksByPrice(IBookDao stockDao) {
        List<Book> books = stockDao.getAllUnits();

        return books.stream()
                .sorted(Comparator.comparing(book -> book.getPrice()))
                .collect(Collectors.toList());

    }

    //        public List<StockUnit> sortUnitsByDate(IStockDao stockUnit){
//        List<StockUnit> units = stockUnit.getAllUnits();
//        return units.stream()
//                .sorted(Comparator.comparing(StockUnit::getIncomingDate))
//                .collect(Collectors.toList());
//
//    }
    public List<Book> sortUnitsByStatus(IBookDao stockUnit) {
        List<Book> units = stockUnit.getAllUnits();
        return units.stream()
                .sorted(Comparator.comparing(Book::getStatus))
                .collect(Collectors.toList());
    }

    public String showBookDescription(IBookDao stockUnit, String book) {
        List<Book> units = stockUnit.getAllUnits();
        Book filteredBook = units.stream()
                .filter(unit -> unit.getName().equals(book))
                .findFirst()
                .get();
        return filteredBook.getDescription();
    }

    public List<Book> getOldBooks(IBookDao stockUnitDao) {
        List<Book> books = stockUnitDao.getAllUnits();
        return books.stream()
                .filter(unit -> unit.getIncomingDate().isBefore(LocalDate.now().minusMonths(6)))
                .collect(Collectors.toList());
    }

    public List<Book> sortOldBooksByIncomingDate(IBookDao stockUnitDao) {
        List<Book> books = getOldBooks(stockUnitDao);
        return books.stream()
                .sorted(Comparator.comparing(o -> o.getIncomingDate()))
                .collect(Collectors.toList());
    }

    public List<Book> sortOldBooksByPrice(IBookDao stockUnitDao) {
        List<Book> books = getOldBooks(stockUnitDao);
        return books.stream()
                .sorted(Comparator.comparing(o -> o.getPrice()))
                .collect(Collectors.toList());
    }

    public Book changeBookStatus(Book book, BookStatus status) {
        book.setStatus(status);
        return book;
    }

}
