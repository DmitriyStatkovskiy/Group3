package StatkovskiyDmitriy.bookstoreUI.actions;

import StatkovskiyDmitriy.bookstore.model.Book;

import java.util.List;

public class SortBooksByNameAction extends AbstractAction implements IAction{
    @Override
    public void execute() {
        List<Book> books = facade.sortByName();
        books.forEach(System.out::println);
    }
}
