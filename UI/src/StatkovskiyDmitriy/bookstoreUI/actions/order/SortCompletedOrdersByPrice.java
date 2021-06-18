package StatkovskiyDmitriy.bookstoreUI.actions.order;

import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

import java.time.LocalDate;
import java.util.List;

public class SortCompletedOrdersByPrice extends AbstractAction implements IAction {
    @Override
    public void execute() {
        LocalDate dateFrom;
        LocalDate dateTo;
        System.out.println("Enter date 'From'");
        dateFrom = getDate();
        System.out.println("Enter date 'To'");
        dateTo = getDate();
        List<Order> orders = manager.sortCompletedOrdersByPrice(dateFrom, dateTo);
        orders.forEach(System.out::println);
    }
}
