package StatkovskiyDmitriy.annotation;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {
    Map<String, String> propertiesMap;

    public InjectPropertyAnnotationObjectConfigurator() throws FileNotFoundException {
        String path = "annotation/src/StatkovskiyDmitriy/annotation/config.properties";
        Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
        propertiesMap = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));

    }

    @Override
    public void configure(Object t) throws FileNotFoundException, IllegalAccessException {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
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
    }
}
