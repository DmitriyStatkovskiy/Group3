package StatkovskiyDmitriy.bookstoreUI.actions;

import StatkovskiyDmitriy.bookstore.model.Book;

import java.util.List;

public class GetBooksAction extends AbstractAction implements IAction {

    @Override
    public void execute() {
        List<Book> books = facade.getBooks();
        books.stream().forEach(System.out::println);
    }
}
