package StatkovskiyDmitriy.bookstoreUI;


import StatkovskiyDmitriy.bookstore.api.service.IBookService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.service.BookService;

import java.util.List;

public class BookStoreApplicationFacade {
    private static BookStoreApplicationFacade instance;
    private final IBookService bookService = BookService.getInstance();

    public static BookStoreApplicationFacade getInstance() {
        if (instance == null) {
            instance = new BookStoreApplicationFacade();
        }
        return instance;
    }


    public void addBook(Book book) {
        bookService.addBook(book);
    }

    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }
}
