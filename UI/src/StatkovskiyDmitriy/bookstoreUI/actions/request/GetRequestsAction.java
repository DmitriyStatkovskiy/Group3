package StatkovskiyDmitriy.bookstoreUI.actions.request;

import StatkovskiyDmitriy.bookstore.model.Request;
import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

import java.util.List;

public class GetRequestsAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        List<Request> requests = manager.getRequests();
        requests.stream().forEach(System.out::println);
    }
}
