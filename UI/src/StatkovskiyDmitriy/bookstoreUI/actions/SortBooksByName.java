package StatkovskiyDmitriy.bookstoreUI.actions;

import StatkovskiyDmitriy.bookstore.model.Book;

import java.util.List;

public class SortBooksByName extends AbstractAction implements IAction{
    @Override
    public void execute() {
        List<Book> books = facade.sortByName();
        books.stream().forEach(System.out::println);
    }
}
