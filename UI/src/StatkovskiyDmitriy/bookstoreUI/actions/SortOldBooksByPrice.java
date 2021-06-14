package StatkovskiyDmitriy.bookstoreUI.actions;

import StatkovskiyDmitriy.bookstore.model.Book;

import java.util.List;

public class SortOldBooksByPrice extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Book> books = facade.sortOldByPrice();
        books.forEach(System.out::println);
    }
}
