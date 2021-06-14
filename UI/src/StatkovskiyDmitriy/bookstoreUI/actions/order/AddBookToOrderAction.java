package StatkovskiyDmitriy.bookstoreUI.actions.order;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class AddBookToOrderAction extends AbstractAction implements IAction {

    @Override
    public void execute() {
        String orderId;
        String bookName;

        orderId = enterString("Enter order ID");
        bookName = enterString("Enter book name");

        manager.addBookToOrder(orderId,bookName);
    }
}
