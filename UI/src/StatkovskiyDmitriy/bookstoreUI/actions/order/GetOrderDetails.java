package StatkovskiyDmitriy.bookstoreUI.actions.order;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class GetOrderDetails extends AbstractAction implements IAction {
    @Override
    public void execute() {
        String id = enterString("Enter order ID");
        manager.showOrderDetails(id);
    }
}
