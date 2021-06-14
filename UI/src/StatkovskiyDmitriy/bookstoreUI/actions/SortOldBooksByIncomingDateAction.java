package StatkovskiyDmitriy.bookstoreUI.actions;

import StatkovskiyDmitriy.bookstore.model.Book;

import java.util.List;

public class SortOldBooksByIncomingDateAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Book> books = facade.sortOldByIncDate();
        books.forEach(System.out::println);
    }
}
