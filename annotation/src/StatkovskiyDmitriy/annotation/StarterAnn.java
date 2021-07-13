package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.bookstore.service.BookService;
import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;
import lombok.SneakyThrows;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class StarterAnn {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, FileNotFoundException {
        PropertyConfigurator.configure("log4j.properties");
        PropertyInjector injector = ObjectFactory.getInstance().createObject(PropertyInjector.class);

        injector.injectDate();
        MenuController menuController = ObjectFactory.getInstance().createObject(MenuController.class);

        menuController.run();
    }
}
