package StatkovskiyDmitriy.annotation.injection;

import StatkovskiyDmitriy.annotation.injection.exceptions.InjectionException;

import java.lang.reflect.InvocationTargetException;

public class ObjectFactoryTask {

    public <T> T createBean(Class<T> aClass) {
        try {
            return aClass.getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new InjectionException("Bean creation failed", e);
        }
    }
}
