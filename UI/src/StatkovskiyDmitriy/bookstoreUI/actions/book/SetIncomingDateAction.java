package StatkovskiyDmitriy.bookstoreUI.actions.book;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

import java.time.LocalDate;

public class SetIncomingDateAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        String book;
        LocalDate date;
        book = enterString("Enter book name");
        date = enterDate("Enter incoming date");
        manager.setIncomingDate(book,date);
    }
}
