import DmitriyStatkovskiy.ioc.injection.ApplicationContext;
import DmitriyStatkovskiy.ioc.injection.DependencyInjection;
import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure("log4j.properties");
        ApplicationContext applicationsContext = new ApplicationContext();
        DependencyInjection.run(MenuController.class, applicationsContext);

        System.out.println(123);
    }
}
