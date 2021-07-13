package StatkovskiyDmitriy.annotation;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {
    @Getter
    private Reflections scanner;
    private Map<Class, Class> interfaceToImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> interfaceToImplClass) {
        this.scanner = new Reflections(packageToScan);
        this.interfaceToImplClass = interfaceToImplClass;
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return interfaceToImplClass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() != 1) {
                throw new RuntimeException("has 0 or more than 1 impl");
            }
            return classes.iterator().next();
        });
    }

    @Override
    public Reflections getScanner() {
        return scanner;
    }
}
