package StatkovskiyDmitriy.bookstoreUI.actions.request;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class AddRequestAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        String name;
        name = enterString("Enter book name");
        manager.createRequest(name);
    }
}
