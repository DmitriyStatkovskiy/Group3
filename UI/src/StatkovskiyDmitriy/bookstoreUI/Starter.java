package StatkovskiyDmitriy.bookstoreUI;

import StatkovskiyDmitriy.bookstoreProperties.PropertiesLoader;
import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;
import StatkovskiyDmitriy.ser.TestSerialization;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.io.Serializable;

public class Starter {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        TestSerialization testSerialization = new TestSerialization();

//TODO: придумать, что десерилизовать при первом запуске

        testSerialization.deserialize();

        PropertiesLoader.getInstance().loadPermissionAndDate();
        PropertyConfigurator.configure("log4j.properties");
        MenuController.getInstance().run();

        testSerialization.serialize();

    }
}
