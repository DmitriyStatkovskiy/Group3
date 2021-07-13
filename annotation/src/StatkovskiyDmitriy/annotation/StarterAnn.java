package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.bookstoreUI.Starter;
import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class StarterAnn {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PropertyConfigurator.configure("log4j.properties");
        MenuController menuController = ObjectFactory.getOurInstance().createObject(MenuController.class);

        menuController.run();
    }
}
