package StatkovskiyDmitriy.bookstoreUI.actions.order;

import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

import java.util.List;

public class GetAllOrdersAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Order> orders = manager.getOrders();
        orders.stream().forEach(System.out::println);
    }
}
