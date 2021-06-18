package StatkovskiyDmitriy.bookstoreUI;

import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Starter {
    static Logger logger = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Test log");
        logger.warn("Tratata");
        MenuController.getInstance().run();
    }
}
