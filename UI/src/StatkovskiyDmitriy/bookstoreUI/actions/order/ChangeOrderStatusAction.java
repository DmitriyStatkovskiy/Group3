package StatkovskiyDmitriy.bookstoreUI.actions.order;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class ChangeOrderStatusAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        String orderId;
        String status;
        orderId = enterString("Enter order ID");
        status = enterString("Enter status (complete, cancel, new)");
        manager.changeOrderStatus(orderId, status);
    }
}
