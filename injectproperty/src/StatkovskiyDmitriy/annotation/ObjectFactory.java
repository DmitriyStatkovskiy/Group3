package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.bookstoreUI.menu.IMenuController;
import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;


public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
        this.config = new JavaConfig("DmitriyStatkovskiy", new HashMap<>(Map.of(IMenuController.class, MenuController.class)));
    }

    public <T> T createObject(Class<T> type) throws Exception {
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = implClass.getDeclaredConstructor().newInstance();

        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            String path = "injectproperty/src/StatkovskiyDmitriy/annotation/annotation.properties";
            Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
            Map<String, String> propertiesMap = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));

            if (annotation != null) {
                String value;
                if (annotation.value().isEmpty()) {
                    value = propertiesMap.get(field.getName());
                } else {
                    value = propertiesMap.get(annotation.value());
                }
                field.setAccessible(true);
                field.set(t, value);
            }
        }
        return t;
    }
}
