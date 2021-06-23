package StatkovskiyDmitriy.bookstoreUI.actions.book;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class SetOldAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        int month;
        month = enterInt("Enter a number of month to mark books as 'old'");
        manager.setOldBooks(month);
    }
}
