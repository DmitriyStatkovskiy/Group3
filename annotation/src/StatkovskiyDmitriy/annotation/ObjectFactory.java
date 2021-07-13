package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config;

    public static ObjectFactory getOurInstance() {
        return ourInstance;
    }

    public ObjectFactory() {
        config = new JavaConfig("DmitriyStatkovskiy", new HashMap<>(Map.of(MenuController.class, MenuController.class)));
    }

    public <T> T createObject(Class<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = implClass.getDeclaredConstructor().newInstance();
        return t;
    }
}
