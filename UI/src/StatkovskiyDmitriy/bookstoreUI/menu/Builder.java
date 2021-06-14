package StatkovskiyDmitriy.bookstoreUI.menu;

import StatkovskiyDmitriy.bookstoreUI.actions.AddBookAction;
import StatkovskiyDmitriy.bookstoreUI.actions.GetBooksAction;
import StatkovskiyDmitriy.bookstoreUI.actions.SortBooksByName;

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
        Menu sortMenu = createBookSortMenu();
        MenuItem showAllBooks = new MenuItem("Show all books", new GetBooksAction(), bookMenu, rootMenu);
        MenuItem addBook = new MenuItem("add book", new AddBookAction(), bookMenu, rootMenu);
        MenuItem sortByName = new MenuItem("sort", ()->{},sortMenu,rootMenu);

        bookMenu.addMenuItem(showAllBooks);
        bookMenu.addMenuItem(addBook);
        bookMenu.addMenuItem(sortByName);
        return bookMenu;
    }

    private Menu createBookSortMenu(){
        Menu sortBooksSortMenu = new Menu("Sort Books");
        MenuItem sortByName = new MenuItem("Sort by name", new SortBooksByName(), sortBooksSortMenu, rootMenu);

        sortBooksSortMenu.addMenuItem(sortByName);
        return sortBooksSortMenu;
    }

    private Menu createOrderMenu(){
        Menu orderMenu = new Menu("Order Menu");

        return orderMenu;
    }

    private Menu createRequestMenu(){
        Menu requestMenu = new Menu("Request Menu");

        return requestMenu;
    }
}
