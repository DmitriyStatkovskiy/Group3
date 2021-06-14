package StatkovskiyDmitriy.bookstoreUI.actions.book;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class AddAction extends AbstractAction implements IAction {

    @Override
    public void execute() {
        String name, edition, description;
        double price;
        System.out.println("name/edition/description/price");
        name = enterString("Enter book name: ");
        edition = enterString("Enter edition: ");
        description = enterString("Enter description: ");
        price = enterDouble("Enter price: ");

        manager.addBook(new Book(name, edition, price, description));
    }

}
