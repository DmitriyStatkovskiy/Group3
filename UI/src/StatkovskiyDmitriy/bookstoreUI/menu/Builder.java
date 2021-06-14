package StatkovskiyDmitriy.bookstoreUI.menu;

import StatkovskiyDmitriy.bookstoreUI.actions.book.*;
import StatkovskiyDmitriy.bookstoreUI.actions.order.*;
import StatkovskiyDmitriy.bookstoreUI.actions.request.*;

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
        rootMenu.addMenuItem(new MenuItem("Request Menu", () -> {
            System.out.println("");
        }, createRequestMenu()));
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

        MenuItem sort = new MenuItem("sort menu", () -> {
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
        MenuItem sortOldByPrice = new MenuItem("Sort old books by price", new SortOldByPriceAction(), sortBooksSortMenu);
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
        Menu sortMenu = createOrderSortMenu();
        MenuItem showAll = new MenuItem("show all orders", new GetAllOrdersAction(), orderMenu);
        MenuItem addOrder = new MenuItem("create new order", new AddOrderAction(), orderMenu);
        MenuItem addBookToOrder = new MenuItem("add book to order", new AddBookToOrderAction(), orderMenu);
        MenuItem completeOrder = new MenuItem("complete order", new CompleteOrderAction(), orderMenu);
        MenuItem cancelOrder = new MenuItem("cancel order", new CancelOrderAction(), orderMenu);
        MenuItem changeStatus = new MenuItem("change order status", new ChangeOrderStatusAction(), orderMenu);
        MenuItem getOrderDetails = new MenuItem("show order details", new GetOrderDetails(), orderMenu);
        MenuItem showCompletedOrders = new MenuItem("show completed orders value", new GetProfitAction(), orderMenu);
        MenuItem showProfitOverATime = new MenuItem("show earned money over a time", new GetProfitAction(), orderMenu);

        MenuItem sort = new MenuItem("sort menu", () -> {
        }, sortMenu);

        MenuItem previousMenu = new MenuItem("previous menu", () -> {
        }, rootMenu);

        orderMenu.addMenuItem(showAll);
        orderMenu.addMenuItem(addOrder);
        orderMenu.addMenuItem(addBookToOrder);
        orderMenu.addMenuItem(completeOrder);
        orderMenu.addMenuItem(cancelOrder);
        orderMenu.addMenuItem(changeStatus);
        orderMenu.addMenuItem(getOrderDetails);
        orderMenu.addMenuItem(showCompletedOrders);
        orderMenu.addMenuItem(showProfitOverATime);
        orderMenu.addMenuItem(sort);
        orderMenu.addMenuItem(previousMenu);

        return orderMenu;
    }

    private Menu createOrderSortMenu() {
        Menu sortOrderMenu = new Menu("--Sort Orders Menu--");

        MenuItem sortByCompletedDate = new MenuItem("sort by completed date", new SortOrdersByCompletedDateAction(), sortOrderMenu);
        MenuItem sortByPrice = new MenuItem("sort by price", new SortOrdersByPriceAction(), sortOrderMenu);
        MenuItem sortByStatus = new MenuItem("sort by status", new SortOrdersByStatusAction(), sortOrderMenu);
        MenuItem sortCompletedOrdersByDate = new MenuItem("sort completed orders by complete date over a period of time", new SortOrdersByCompletedDateAction(), sortOrderMenu);
        MenuItem sortCompletedOrdersByPrice = new MenuItem("sort completed orders by price over a period of time", new SortCompletedOrdersByPrice(), sortOrderMenu);

        MenuItem previousMenu = new MenuItem("main menu", () -> {
        }, rootMenu);

        sortOrderMenu.addMenuItem(sortByCompletedDate);
        sortOrderMenu.addMenuItem(sortByPrice);
        sortOrderMenu.addMenuItem(sortByStatus);
        sortOrderMenu.addMenuItem(sortCompletedOrdersByDate);
        sortOrderMenu.addMenuItem(sortCompletedOrdersByPrice);

        sortOrderMenu.addMenuItem(previousMenu);
        return sortOrderMenu;
    }

    private Menu createRequestMenu() {
        Menu requestMenu = new Menu("--Request Menu--");
        Menu sortMenu = createRequestSortMenu();
        MenuItem getAll = new MenuItem("show all requests", new GetRequestsAction(), requestMenu);
        MenuItem add = new MenuItem("create request", new AddRequestAction(), requestMenu);
        MenuItem changeStatus = new MenuItem("change status", new ChangeRequestStatusAction(), requestMenu);
        MenuItem sort = new MenuItem("sort menu", () -> {
        }, sortMenu);

        MenuItem previousMenu = new MenuItem("previous menu", () -> {
        }, rootMenu);

        requestMenu.addMenuItem(getAll);
        requestMenu.addMenuItem(add);
        requestMenu.addMenuItem(changeStatus);
        requestMenu.addMenuItem(sort);
        requestMenu.addMenuItem(previousMenu);
        return requestMenu;
    }

    private Menu createRequestSortMenu() {
        Menu sortMenu = new Menu("--Sort Requests--");
        MenuItem sortByQuantity = new MenuItem("sort by quantity", new SortByQuantityAction(), sortMenu);
        MenuItem sortByName = new MenuItem("sort by book name", new SortRequestsByBookNameAction(), sortMenu);

        MenuItem previousMenu = new MenuItem("previous menu", () -> {
        }, rootMenu);

        sortMenu.addMenuItem(sortByQuantity);
        sortMenu.addMenuItem(sortByName);
        sortMenu.addMenuItem(previousMenu);
        return sortMenu;
    }
}
