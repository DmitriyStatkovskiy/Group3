package DmitriyStatkovskiy.ioc;

import DmitriyStatkovskiy.ioc.exception.InjectionException;

public class DependencyInjection {
    public static void run(Class<?> startClass, ApplicationContext applicationContext) {
        try {
            ClassScanner classScanner = new ClassScanner();
            ObjectFactoryT factory = new ObjectFactoryT();
            applicationContext.setFactory(factory);
            applicationContext.createContext(classScanner.findClasses(startClass));
        } catch (IllegalAccessException e) {
            throw new InjectionException("message from", e);
        }
    }
}
