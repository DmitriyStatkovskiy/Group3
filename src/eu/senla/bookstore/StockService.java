package eu.senla.bookstore;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.util.Comparator.comparing;

public class StockService {

    ArrayList<Book> stockList = new ArrayList<>();

    public void addBook(String name, String edition, String description, double price, LocalDate incDate, boolean isInStock) {
        Book book = new Book(name, edition, description, price, incDate, isInStock);
        stockList.add(book);

    }

    public void changeBookName(String name, String newName) {
        for (Book book : stockList
        ) {
            if (book.getName().equals(name)) {
                book.setName(newName);
            }
        }
    }

    public void changeBookStatus(String name) {

        for (Book book : stockList
        ) {
            if (book.getName().equals(name)) {
                book.setStatus(!book.getStatus());
            }
        }
    }

    public void changeBookStatusToFalse(String name) {
        for (Book book : stockList
        ) {
            if (book.getName().equals(name)) {
                book.setStatus(false);
            }
        }
    }

    public void sortByName() {
        stockList.sort(comparing(Book::getName));
    }

    public void sortByEdition() {
        stockList.sort(comparing(Book::getEdition));
    }

    public void sortByPrice() {
        stockList.sort(comparing(Book::getPrice));
    }

    public void sortByIsInStock() {
        stockList.sort(comparing(Book::getStatus));
    }

    public void printStock(){
        for (Book book: stockList
             ) {
            System.out.println(book);
        }
    }

}