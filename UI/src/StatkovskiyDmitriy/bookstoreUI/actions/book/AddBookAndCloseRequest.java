package StatkovskiyDmitriy.bookstoreUI.actions.book;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class AddBookAndCloseRequest extends AbstractAction implements IAction {
    @Override
    public void execute() {
        String name = enterString("Enter book name");
        manager.addBookAndCloseRequest(name);
    }
}
