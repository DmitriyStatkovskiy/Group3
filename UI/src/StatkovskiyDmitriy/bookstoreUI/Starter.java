package StatkovskiyDmitriy.bookstoreUI;

import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Starter {
    static Logger logger = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Info: Test log");
        logger.warn("Warning: PewPew");
        logger.error("Error: Tratata");
        MenuController.getInstance().run();
    }
}
