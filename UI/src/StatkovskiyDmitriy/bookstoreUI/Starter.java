package StatkovskiyDmitriy.bookstoreUI;

import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;
import org.apache.log4j.PropertyConfigurator;


public class Starter {

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        MenuController.getInstance().run();
    }
}
