package StatkovskiyDmitriy.bookstoreUI.actions.book;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class DeleteAllAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        manager.deleteAllBooks();
    }
}
