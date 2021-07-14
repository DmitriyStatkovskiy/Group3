package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.ser.TestSerialization;
import org.apache.log4j.PropertyConfigurator;

public class StarterAnn {

    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure("log4j.properties");
        TestSerialization testSerialization = ObjectFactory.getInstance().createObject(TestSerialization.class);
        testSerialization.deserialize();

        BookStore store = new BookStore();
        store.start();
        testSerialization.serialize();
    }
}
