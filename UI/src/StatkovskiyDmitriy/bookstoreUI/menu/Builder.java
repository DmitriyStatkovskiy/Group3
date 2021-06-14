package StatkovskiyDmitriy.bookstoreUI.menu;

import StatkovskiyDmitriy.bookstoreUI.actions.*;

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
        }, createBookMenu()));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    private Menu createBookMenu() {
        Menu bookMenu = new Menu("Book Menu");
        Menu sortMenu = createBookSortMenu();
        MenuItem showAllBooks = new MenuItem("Show all books", new GetBooksAction(), bookMenu);
        MenuItem addBook = new MenuItem("add book", new AddBookAction(), bookMenu);
        MenuItem sortByName = new MenuItem("sort", () -> {
        }, sortMenu);
        MenuItem previousMenu = new MenuItem("previous menu", ()->{}, rootMenu);

        bookMenu.addMenuItem(showAllBooks);
        bookMenu.addMenuItem(addBook);
        bookMenu.addMenuItem(sortByName);
        bookMenu.addMenuItem(previousMenu);
        return bookMenu;
    }

    private Menu createBookSortMenu() {
        Menu sortBooksSortMenu = new Menu("Sort Books");
        MenuItem sortByName = new MenuItem("Sort by name", new SortBooksByNameAction(), sortBooksSortMenu);
        MenuItem sortByPrice = new MenuItem("Sort by price", new SortBooksByPriceAction(), sortBooksSortMenu);
        MenuItem sortByStatus = new MenuItem("Sort by status", new SortBooksByStatusAction(), sortBooksSortMenu);
        MenuItem sortOldByIncDate = new MenuItem("Sort old books by incoming date", new SortOldBooksByIncomingDateAction(), sortBooksSortMenu);
        MenuItem sortOldByPrice = new MenuItem("Sort old books by price", new SortOldBooksByPrice(), sortBooksSortMenu);
        MenuItem previousMenu = new MenuItem("previous", ()->{}, rootMenu);


        sortBooksSortMenu.addMenuItem(sortByName);
        sortBooksSortMenu.addMenuItem(sortByPrice);
        sortBooksSortMenu.addMenuItem(sortByStatus);
        sortBooksSortMenu.addMenuItem(sortOldByIncDate);
        sortBooksSortMenu.addMenuItem(sortOldByPrice);
        sortBooksSortMenu.addMenuItem(previousMenu);
        return sortBooksSortMenu;
    }

    private Menu createOrderMenu() {
        Menu orderMenu = new Menu("Order Menu");

        return orderMenu;
    }

    private Menu createRequestMenu() {
        Menu requestMenu = new Menu("Request Menu");

        return requestMenu;
    }
}
