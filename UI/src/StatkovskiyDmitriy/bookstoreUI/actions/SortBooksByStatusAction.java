package StatkovskiyDmitriy.bookstoreUI.actions;

import StatkovskiyDmitriy.bookstore.model.Book;

import java.util.List;

public class SortBooksByStatusAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Book> books = facade.sortByStatus();
        books.forEach(System.out::println);
    }
}
