package StatkovskiyDmitriy.server;

import DmitriyStatkovskiy.ioc.ApplicationContext;
import DmitriyStatkovskiy.ioc.DependencyInjection;
import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        ApplicationContext applicationsContext = new ApplicationContext();
        DependencyInjection.run(MenuController.class, applicationsContext);
        MenuController mC = applicationsContext.getBean(MenuController.class);
        mC.run();

        System.out.println(123);


    }
}
