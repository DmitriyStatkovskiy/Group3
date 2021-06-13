package StatkovskiyDmitriy.bookstoreUI.menu;

import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class MenuItem implements IAction {
    private String title;
    private IAction action;
    Menu nextMenu;

    public MenuItem(String title, IAction action, Menu nextMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }

    public void doAction() {

    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    @Override
    public void execute() {

    }
}
