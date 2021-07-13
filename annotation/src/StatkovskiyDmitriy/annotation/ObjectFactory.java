package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.bookstoreUI.menu.MenuController;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

    public ObjectFactory() {
        config = new JavaConfig("D:\\senla\\DmitriyStatkovskiy", new HashMap<>(Map.of(MenuController.class, MenuController.class)));
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, FileNotFoundException {
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = implClass.getDeclaredConstructor().newInstance();

        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            String value;
            String path = "annotation/src/StatkovskiyDmitriy/annotation/config.properties";
            Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
            Map<String, String> propertiesMap = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));
            if (annotation != null) {

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
