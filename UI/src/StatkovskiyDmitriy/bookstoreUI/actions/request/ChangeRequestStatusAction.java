package StatkovskiyDmitriy.bookstoreUI.actions.request;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class ChangeRequestStatusAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        String name;
        name = enterString("Enter book name");
        manager.changeRequestStatus(name);
    }
}
