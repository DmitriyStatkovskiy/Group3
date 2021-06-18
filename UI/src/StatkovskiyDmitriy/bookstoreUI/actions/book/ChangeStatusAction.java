package StatkovskiyDmitriy.bookstoreUI.actions.book;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class ChangeStatusAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        String name;
        System.out.println("Change status");
        name = enterString("Enter book name: ");

        manager.changeStatus(name);
    }
}
