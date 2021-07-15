package StatkovskiyDmitriy.annotation.injection;

import StatkovskiyDmitriy.annotation.injection.exception.InjectionException;

import java.lang.reflect.Field;


public class ObjectFactoryT {
    public <T> T createBean(Class<T> aClass) {
        try {

            aClass.getDeclaredConstructor().setAccessible(true);
            return aClass.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new InjectionException("Bean creation failed", e);
        }
    }
}
