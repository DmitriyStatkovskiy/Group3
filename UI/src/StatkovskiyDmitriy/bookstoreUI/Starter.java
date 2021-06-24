package StatkovskiyDmitriy.bookstoreUI;

import StatkovskiyDmitriy.bookstoreProperties.PropertiesLoader;
import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

public class Starter {

    public static void main(String[] args) throws IOException {
        PropertiesLoader.getInstance().loadPermissionAndDate();
        PropertyConfigurator.configure("log4j.properties");
        MenuController.getInstance().run();
    }
}
