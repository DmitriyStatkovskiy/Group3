package StatkovskiyDmitriy.bookstoreUI.menu;

import StatkovskiyDmitriy.bookstoreUI.actions.book.*;
import StatkovskiyDmitriy.bookstoreUI.actions.order.AddOrderAction;
import StatkovskiyDmitriy.bookstoreUI.actions.order.GetAllOrdersAction;

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
        rootMenu.addMenuItem(new MenuItem("Order Menu", () -> {
            System.out.println("");
        }, createOrderMenu()));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    private Menu createBookMenu() {
        Menu bookMenu = new Menu("--Book Menu--");
        Menu sortMenu = createBookSortMenu();

        MenuItem showAll = new MenuItem("show all books", new GetAllAction(), bookMenu);
        MenuItem add = new MenuItem("add book", new AddAction(), bookMenu);
        MenuItem showOutOfStock = new MenuItem("show out of stock books", new GetAllOutOfStockAction(), bookMenu);
        MenuItem changeStatus = new MenuItem("change status", new ChangeStatusAction(), bookMenu);
        MenuItem showDescription = new MenuItem("show book description", new GetDescriptionAction(), bookMenu);

        MenuItem sort = new MenuItem("sort", () -> {
        }, sortMenu);
        MenuItem previousMenu = new MenuItem("previous menu", () -> {
        }, rootMenu);

        bookMenu.addMenuItem(showAll);
        bookMenu.addMenuItem(add);
        bookMenu.addMenuItem(showOutOfStock);
        bookMenu.addMenuItem(changeStatus);
        bookMenu.addMenuItem(showDescription);
        bookMenu.addMenuItem(sort);
        bookMenu.addMenuItem(previousMenu);

        return bookMenu;
    }

    private Menu createBookSortMenu() {
        Menu sortBooksSortMenu = new Menu("--Sort Books Menu--");
        MenuItem sortByName = new MenuItem("Sort by name", new SortByNameAction(), sortBooksSortMenu);
        MenuItem sortByPrice = new MenuItem("Sort by price", new SortByPriceAction(), sortBooksSortMenu);
        MenuItem sortByStatus = new MenuItem("Sort by status", new SortByStatusAction(), sortBooksSortMenu);
        MenuItem sortOldByIncDate = new MenuItem("Sort old books by incoming date", new SortOldByIncomingDateAction(), sortBooksSortMenu);
        MenuItem sortOldByPrice = new MenuItem("Sort old books by price", new SortOldByPrice(), sortBooksSortMenu);
        MenuItem previousMenu = new MenuItem("main menu", () -> {
        }, rootMenu);

        sortBooksSortMenu.addMenuItem(sortByName);
        sortBooksSortMenu.addMenuItem(sortByPrice);
        sortBooksSortMenu.addMenuItem(sortByStatus);
        sortBooksSortMenu.addMenuItem(sortOldByIncDate);
        sortBooksSortMenu.addMenuItem(sortOldByPrice);
        sortBooksSortMenu.addMenuItem(previousMenu);
        return sortBooksSortMenu;
    }

    private Menu createOrderMenu() {
        Menu orderMenu = new Menu("--Order Menu--");
        MenuItem showAll = new MenuItem("show all orders", new GetAllOrdersAction(), orderMenu);
        MenuItem addOrder = new MenuItem("add new order", new AddOrderAction(), orderMenu);

        orderMenu.addMenuItem(showAll);
        orderMenu.addMenuItem(addOrder);
        return orderMenu;
    }

    private Menu createRequestMenu() {
        Menu requestMenu = new Menu("Request Menu");

        return requestMenu;
    }
}
