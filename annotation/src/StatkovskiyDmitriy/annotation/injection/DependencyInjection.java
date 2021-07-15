package StatkovskiyDmitriy.annotation.injection;

import StatkovskiyDmitriy.annotation.injection.exception.InjectionException;

public class DependencyInjection {
    public static void run(Class<?> startClass, ApplicationContext applicationContext) {
        try {
            ClassScanner scanner = new ClassScanner();
            ObjectFactoryT factory = new ObjectFactoryT();
            applicationContext.setFactory(factory);
            applicationContext.createContext(scanner.findClasses(startClass));
        } catch (IllegalAccessException | ClassNotFoundException e) {
            throw new InjectionException("message from", e);
        }
    }
}
