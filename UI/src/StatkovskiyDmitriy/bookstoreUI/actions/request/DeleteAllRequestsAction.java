package StatkovskiyDmitriy.bookstoreUI.actions.request;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class DeleteAllRequestsAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        manager.deleteAllRequests();
    }
}
