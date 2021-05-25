package eu.senla.bookstore;

import java.util.ArrayList;
import static java.util.Comparator.comparing;

public class Stock {

    ArrayList<Book> stock = new ArrayList<>();

    @Override
    public String toString() {
        return "Stock{" +
                "stock=" + stock +
                '}';
    }

    public void addBook(String name, String edition, double price, boolean isInStock) {
        Book book = new Book(name, edition, price, isInStock);
        stock.add(book);
    }


    public void sortByName() {
        stock.sort(comparing(Book::getName));
    }
    public void sortByEdition(){
        stock.sort(comparing(Book::getEdition));
    }
    public void sortByPrice(){
        stock.sort(comparing(Book::getPrice));
    }
    public void sortByIsInStock(){
        stock.sort(comparing(Book::isInStock));
    }

}