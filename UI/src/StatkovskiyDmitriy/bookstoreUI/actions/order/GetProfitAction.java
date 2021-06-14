package StatkovskiyDmitriy.bookstoreUI.actions.order;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

import java.time.LocalDate;

public class GetProfitAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        LocalDate dateFrom;
        LocalDate dateTo;
        System.out.println("Enter date 'From'");
        dateFrom = getDate();
        System.out.println("Enter date 'To'");
        dateTo = getDate();
        double profit = manager.showProfit(dateFrom,dateTo);
        System.out.println(profit);
    }
}
