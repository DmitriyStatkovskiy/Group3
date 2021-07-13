package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ObjectFactory {

    private static ObjectFactory ourInstance;

    static {
        try {
            ourInstance = new ObjectFactory();
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private Config config;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }


    public ObjectFactory() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        config = new JavaConfig("D:\\senla\\DmitriyStatkovskiy", new HashMap<>(Map.of(MenuController.class, MenuController.class)));
        for (Class<? extends ObjectConfigurator> aClass : config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    public <T> T createObject(Class<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, FileNotFoundException {
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = implClass.getDeclaredConstructor().newInstance();

        configurators.forEach(objectConfigurator -> {
            try {
                objectConfigurator.configure(t);
            } catch (FileNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return t;
    }
}
