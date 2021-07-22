package StatkovskiyDmitriy.annotation;

import org.apache.log4j.PropertyConfigurator;

public class StarterAnn {

    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure("log4j.properties");

        BookStore store = new BookStore();
        store.start();
    }
}
