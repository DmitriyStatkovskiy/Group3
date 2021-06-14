package StatkovskiyDmitriy.bookstoreUI.actions;

import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;

public class GetBookDescriptionAction extends AbstractAction implements IAction {
    public void execute() {
        String name;
        System.out.println("Show book description:");
        name = enterString("Enter book name: ");

        System.out.println(facade.showDescription(name));
    }
}
