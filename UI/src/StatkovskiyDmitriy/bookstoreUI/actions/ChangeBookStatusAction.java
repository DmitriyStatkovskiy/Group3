package StatkovskiyDmitriy.bookstoreUI.actions;

public class ChangeBookStatusAction extends AbstractAction implements IAction {
    @Override
    public void execute() {
        String name;
        System.out.println("Change status");
        name = enterString("Enter book name: ");

        facade.changeStatus(name);
    }
}
