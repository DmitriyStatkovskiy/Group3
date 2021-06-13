package StatkovskiyDmitriy.bookstoreUI.menu;

import StatkovskiyDmitriy.bookstoreUI.actions.AddBook;

public class Builder {
    private static Builder instance;
    private Menu rootMenu;


    private Builder() {
    }

    public static Builder getInstance() {
        if (instance == null) {
            instance = new Builder();
        }
        return instance;
    }

    public void buildMenu() {
        rootMenu = new Menu();
        rootMenu.addMenuItem(new MenuItem("Book Menu", () -> {
            System.out.println("book menu:");
        }, createBookMenu()));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    private Menu createBookMenu() {
        Menu bookMenu = new Menu();
        bookMenu.addMenuItem(new MenuItem("some action", () -> {
            System.out.println("tratata");
        }, bookMenu));
        rootMenu.addMenuItem(new MenuItem("Add book to stock", new AddBook(), rootMenu));
        return bookMenu;
    }
}
