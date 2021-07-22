package StatkovskiyDmitriy.bookstoreUI.menu;

public interface IBuilder {
    void buildMenu();

    public Menu getRootMenu();

    public Menu createBookMenu();

    public Menu createBookSortMenu();

    public Menu createOrderMenu();

    public Menu createOrderSortMenu();

    public Menu createRequestMenu();

    public Menu createRequestSortMenu();

}
