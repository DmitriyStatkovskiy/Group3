package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;

public class BookStore {

    private MenuController menuController = ObjectFactory.getInstance().createObject(MenuController.class);
    private PropertyInjector injector = ObjectFactory.getInstance().createObject(PropertyInjector.class);

    public void start() {
        injector.injectDate();
        menuController.run();
    }

    public BookStore() throws Exception {
    }
}
