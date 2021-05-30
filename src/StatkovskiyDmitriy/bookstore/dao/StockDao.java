package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IStockDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.StockUnit;
import StatkovskiyDmitriy.bookstore.model.enums.StockUnitStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class StockDao implements IStockDao {

    private List<StockUnit> stockUnits = new ArrayList<>();
    private List<Book> stockList = new ArrayList<>();

    public void addBook(Book book) {
        stockUnits.add(new StockUnit(book));

    }

    public List<StockUnit> getStockUnitsByIds(List<String> ids, StockUnitStatus status) {

        return stockUnits.stream()
                .filter(stockUnit -> ids.contains(stockUnit.getBook().getId()))
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

    public boolean getRequestedBookName(String name) {
        for (Book book : stockList) {
            if (book.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public double getBookPrice(String bookName) {

        for (Book book : stockList) {
            if (book.getName().equals(bookName)) {
                return book.getPrice();
            }
        }
        return 0;
    }

    public void changeBookName(String name, String newName) {
        for (Book book : stockList) {
            if (book.getName().equals(name)) {
                book.setName(newName);
            }
        }
    }

    public void changeBookStatus(String name) {

        for (Book book : stockList) {
            if (book.getName().equals(name)) {
                book.setStatus(!book.getStatus());
            }
        }
    }

//    public void changeBookStatusToFalse(String name) {
//        for (Book book : stockList) {
//            if (book.getName().equals(name)) {
//                book.setStatus(false);
//            }
//        }
//    }
//
//    public void sortByName() {
//        stockList.sort(comparing(Book::getName));
//    }
//
//    public void sortByEdition() {
//        stockList.sort(comparing(Book::getEdition));
//    }
//
//    public void sortByPrice() {
//        stockList.sort(comparing(Book::getPrice));
//    }
//
//    public void sortByStatus() {
//        stockList.sort(comparing(Book::getStatus));
//    }

    public void printStock() {
        for (Book book : stockList) {
            System.out.println(book);
        }
        System.out.println();
    }




    @Override
    public Book getBook(Book book) {
        return book;
    }

    @Override
    public void removeBookFromStock(Book book) {
        stockList.remove(book);
    }
}