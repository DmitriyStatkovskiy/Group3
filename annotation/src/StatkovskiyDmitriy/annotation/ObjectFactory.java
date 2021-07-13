package StatkovskiyDmitriy.annotation;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig("DmitriyStatkovskiy");

    public static ObjectFactory getOurInstance() {
        return ourInstance;
    }

    public ObjectFactory() {
    }

    public <T> T createObject(Class<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends T> implClass = type;
        if (type.isInterface()){
            implClass = config.getImplClass(type);
        }
       return implClass.getDeclaredConstructor().newInstance();
    }
}
