package StatkovskiyDmitriy.bookstoreUI.actions.request;

import StatkovskiyDmitriy.bookstore.model.Request;
import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

import java.util.List;

public class SortRequestsByBookNameAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Request> requests = manager.sortRequestsByBookName();
        requests.stream().forEach(System.out::println);
    }
}
