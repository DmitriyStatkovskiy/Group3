package StatkovskiyDmitriy.bookstoreUI;

import StatkovskiyDmitriy.bookstoreProperties.PropertiesLoader;
import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;
import StatkovskiyDmitriy.ser.TestSerialization;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

public class Starter {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PropertyConfigurator.configure("log4j.properties");

        TestSerialization testSerialization = new TestSerialization();

        testSerialization.deserialize();

        PropertiesLoader.getInstance().loadPermissionAndDate();
        MenuController.getInstance().run();

        testSerialization.serialize();

    }

    public void startUi() throws IOException, ClassNotFoundException{
        PropertyConfigurator.configure("log4j.properties");

        TestSerialization testSerialization = new TestSerialization();

        testSerialization.deserialize();

        PropertiesLoader.getInstance().loadPermissionAndDate();
        MenuController.getInstance().run();

        testSerialization.serialize();
    }
}
