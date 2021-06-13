package StatkovskiyDmitriy.bookstoreUI.menu;

import StatkovskiyDmitriy.bookstoreUI.actions.IAction;

public class MenuItem {
    private String title;
    private IAction action;
    private Menu nextMenu;
    private Menu previousMenu;

    public MenuItem(String title, IAction action, Menu nextMenu, Menu previousMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
        this.previousMenu = previousMenu;
    }

    public void doAction() {
        action.execute();
    }

    public Menu getPreviousMenu() {
        return previousMenu;
    }

    public void setPreviousMenu(Menu previousMenu) {
        this.previousMenu = previousMenu;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }

}
