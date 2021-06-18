package StatkovskiyDmitriy.bookstoreUI.actions.order;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class CompleteOrderAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        String orderId;
        orderId = enterString("Enter order ID");
        manager.completeOrder(orderId);
    }
}
