package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.bookstoreUI.menu.IMenuController;
import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;

public class BookStore {

    private IMenuController menuController = MenuController.getInstance();
    private PropertyInjector injector = ObjectFactory.getInstance().createObject(PropertyInjector.class);

    public void start() {
        injector.injectDate();
        menuController.run();
    }

    public BookStore() throws Exception {
    }
}
