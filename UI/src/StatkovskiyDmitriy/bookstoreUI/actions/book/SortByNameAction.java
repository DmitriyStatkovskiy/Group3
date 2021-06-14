package StatkovskiyDmitriy.bookstoreUI.actions.book;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

import java.util.List;

public class SortByNameAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Book> books = facade.sortByName();
        books.forEach(System.out::println);
    }
}
