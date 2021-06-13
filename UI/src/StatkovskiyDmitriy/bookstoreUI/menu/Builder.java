package StatkovskiyDmitriy.bookstoreUI.menu;

import StatkovskiyDmitriy.bookstoreUI.actions.AddBookAction;
import StatkovskiyDmitriy.bookstoreUI.actions.GetBooksAction;

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
        rootMenu = new Menu("Main menu");
        rootMenu.addMenuItem(new MenuItem("Book Menu", () -> {
            System.out.println("");
        }, createBookMenu(), rootMenu));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    private Menu createBookMenu() {
        Menu bookMenu = new Menu("Book Menu");
        MenuItem showAllBooks = new MenuItem("Show all books", new GetBooksAction(), bookMenu, rootMenu);
        MenuItem addBook = new MenuItem("add book", new AddBookAction(), bookMenu, rootMenu);

        bookMenu.addMenuItem(showAllBooks);
        bookMenu.addMenuItem(addBook);
        return bookMenu;
    }

}
