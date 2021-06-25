package StatkovskiyDmitriy.bookstoreUI.actions.order;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

import java.time.LocalDate;

public class GetCompletedOrdersValueAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        LocalDate dateFrom;
        LocalDate dateTo;
        System.out.println("Enter date 'From'");
        dateFrom = enterDate("");
        System.out.println("Enter date 'To'");
        dateTo = enterDate("");
        int count = manager.showCompletedOrderValue(dateFrom, dateTo);
        System.out.println(count);
    }
}
