package StatkovskiyDmitriy.bookstoreUI;


import StatkovskiyDmitriy.bookstore.api.service.IBookService;
import StatkovskiyDmitriy.bookstore.api.service.IOrderService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;
import StatkovskiyDmitriy.bookstore.service.BookService;
import StatkovskiyDmitriy.bookstore.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

public class Manager {
    private static Manager instance;
    private final IBookService bookService = BookService.getInstance();
    private final IOrderService orderService = OrderService.getInstance();

    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }


    public void addBook(Book book) {
        bookService.addBook(book);
    }

    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    public void changeStatus(String name) {
        List<Book> books = bookService.getAllBooks().stream()
                .filter(book1 -> book1.getName().equals(name))
                .filter(book1 -> book1.getStatus().equals(BookStatus.IN_STOCK))
                .collect(Collectors.toList());
        if (books.size() != 0) {
            bookService.getAllBooks().stream()
                    .filter(book1 -> book1.getName().equals(name))
                    .forEach(book2 -> book2.setStatus(BookStatus.OUT_OF_STOCK));
        } else bookService.getAllBooks().stream()
                .filter(book1 -> book1.getName().equals(name))
                .forEach(book2 -> book2.setStatus(BookStatus.IN_STOCK));
    }

    public String showDescription(String name) {

        String description = bookService.getAllBooks().stream()
                .filter(book -> book.getName().equals(name))
                .findFirst()
                .get()
                .getDescription();
        return description;
    }

    public List<Book> getOutOfStock() {
        return bookService.getOutBooks();
    }

    public List<Book> sortByName() {
        return bookService.sortBooksByName();
    }

    public List<Book> sortByPrice() {
        return bookService.sortBooksByPrice();
    }

    public List<Book> sortByStatus() {
        return bookService.sortBooksByStatus();
    }

    public List<Book> sortOldByIncDate() {
        return bookService.sortOldBooksByIncomingDate();
    }

    public List<Book> sortOldByPrice() {
        return bookService.sortOldBooksByPrice();
    }
    public List<Order> getOrders() {
        return orderService.getAll();
    }

    public void addOrder(){
        orderService.createNew();
    }

}
