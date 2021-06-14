package StatkovskiyDmitriy.bookstoreUI.actions.book;

import StatkovskiyDmitriy.bookstoreUI.actions.AbstractAction;
import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class GetDescriptionAction extends AbstractAction implements IAction {
    public void execute() {
        String name;
        System.out.println("Show book description:");
        name = enterString("Enter book name: ");

        System.out.println(manager.showDescription(name));
    }
}
