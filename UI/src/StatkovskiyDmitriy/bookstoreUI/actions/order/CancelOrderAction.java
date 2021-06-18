package StatkovskiyDmitriy.bookstoreUI.actions.order;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class CancelOrderAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        String orderId;
        orderId = enterString("Enter order ID");
        manager.cancelOrder(orderId);
    }
}
