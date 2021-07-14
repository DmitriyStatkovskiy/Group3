package StatkovskiyDmitriy.annotation.injection;

import StatkovskiyDmitriy.annotation.injection.annotation.Autowired;
import StatkovskiyDmitriy.annotation.injection.annotation.Component;
import StatkovskiyDmitriy.annotation.injection.exception.InjectionException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplicationContext {
    private final Map<Class<?>, Object> context;
    private final Map<Class<?>, Class<?>> classInterfaceMap;
    private ObjectFactoryT factory;

    public void setFactory(ObjectFactoryT factory) {
        this.factory = factory;
    }

    public ApplicationContext() {
        this.context = new HashMap<>();
        this.classInterfaceMap = new HashMap<>();
    }

    public void createContext(Set<Class<?>> classes) throws IllegalAccessException {
        for (Class<?> aClass : classes) {
            if (!aClass.isAnnotationPresent(Component.class)) {
                continue;
            }
            Class<?>[] interfaces = aClass.getInterfaces();
            if (interfaces.length == 0) {
                classInterfaceMap.put(aClass, aClass);
                continue;
            }

            for (Class<?> anInterface : interfaces) {
                if (classInterfaceMap.containsValue(anInterface)) {
                    classInterfaceMap.put(aClass, anInterface);
                }
            }
        }
        fillContext();
    }

    private void fillContext() throws IllegalAccessException {
        for (Class<?> aClass : classInterfaceMap.keySet()) {
            Object bean = factory.createBean(aClass);
            context.put(aClass, bean);
            injectDependencies(aClass, bean);
        }
    }

    private void injectDependencies(Class<?> aClass, Object bean) throws IllegalAccessException {
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (!aClass.isAnnotationPresent(Autowired.class)) {
                continue;
            }
            Object instance = this.getBean(field.getType());
            field.setAccessible(true);
            field.set(bean, instance);
            injectDependencies(instance.getClass(), instance);
        }
    }

    public <T> T getBean(Class<T> type) {
        Set<Map.Entry<Class<?>, Class<?>>> classSet = classInterfaceMap.entrySet().stream()
                .filter(entry -> type.equals(entry.getValue()))
                .collect(Collectors.toSet());
        if (classSet.size() != 1) {
            throw new InjectionException("msg");
        }

        Class<?> aClass = classSet.stream()
                .findFirst()
                .get()
                .getKey();
        if (context.containsKey(aClass)) {
            return (T) context.get(aClass);
        }
        Object bean = factory.createBean(aClass);
        context.put(aClass, bean);
        return (T) bean;
    }
}
