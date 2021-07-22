package DmitriyStatkovskiy.ioc;

import DmitriyStatkovskiy.ioc.exception.InjectionException;

import java.lang.reflect.Constructor;


public class ObjectFactoryT {

    public <T> T createBean(Class<T> aClass) {
        try {
            Constructor<T> constructor = aClass.getDeclaredConstructor();
            constructor.setAccessible(true);

            return constructor.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new InjectionException("Bean creation failed", e);
        }
    }
}
