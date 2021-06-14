package StatkovskiyDmitriy.bookstoreUI.actions.order;

import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

import java.util.List;

public class SortOrdersByCompletedDateAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Order> orders = manager.sortOrdersByCompletedDate();
        orders.forEach(System.out::println);
    }
}
