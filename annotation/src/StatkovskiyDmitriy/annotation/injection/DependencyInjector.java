package StatkovskiyDmitriy.annotation.injection;

import StatkovskiyDmitriy.annotation.injection.exceptions.InjectionException;

public class DependencyInjector {
    public static void run(Class<?> startClass, ApplicationContext applicationContext) {
        try {
            ClassScanner scanner = new ClassScanner();
            ObjectFactory factory = new ObjectFactory();
            applicationContext.setFactory(factory);
            applicationContext.createContext(scanner.findClasses(startClass));
        } catch (IllegalAccessException | ClassNotFoundException e) {
            throw new InjectionException("message from", e);
        }
    }
}
