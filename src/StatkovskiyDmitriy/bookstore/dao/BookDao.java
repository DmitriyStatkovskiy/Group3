package StatkovskiyDmitriy.bookstore.dao;

import StatkovskiyDmitriy.bookstore.api.dao.IBookDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDao implements IBookDao {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> getBooksByIds(List<String> ids, BookStatus status) {

        return books.stream()
                .filter(book -> ids.contains(book.getId()))
                .filter(stockUnit -> status.equals(stockUnit.getStatus()))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByName(List<String> name, BookStatus status) {

        return books.stream()
                .filter(book -> name.contains(book.getName()))
                .filter(book -> status.equals(book.getStatus()))
                .collect(Collectors.toList());
    }

    public Book getBookByBookId(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void printStock() {
        System.out.println(books);
    }

    public void printStock(List<Book> book) {
        for (Book unit : book
        ) {
            System.out.println(unit);
        }
    }
}