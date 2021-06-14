package StatkovskiyDmitriy.bookstoreUI.actions;

import StatkovskiyDmitriy.bookstore.model.Book;

import java.util.List;

public class SortBooksByPriceAction extends AbstractAction implements IAction{
    @Override
    public void execute() {
        List<Book> books = facade.sortByPrice();
        books.forEach(System.out::println);
    }
}
