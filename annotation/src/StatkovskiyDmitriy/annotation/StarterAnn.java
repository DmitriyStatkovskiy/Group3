package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.bookstoreUI.Starter;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class StarterAnn {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PropertyConfigurator.configure("log4j.properties");
        Starter star = ObjectFactory.getOurInstance().createObject(Starter.class);

        star.startUi();
    }
}
