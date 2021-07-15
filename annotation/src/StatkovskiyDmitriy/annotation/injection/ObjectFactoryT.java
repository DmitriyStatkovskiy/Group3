package StatkovskiyDmitriy.annotation.injection;

import StatkovskiyDmitriy.annotation.injection.exception.InjectionException;

public class ObjectFactoryT {
    public <T> T createBean(Class<T> aClass) {
        try {

            return aClass.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new InjectionException("Bean creation failed", e);
        }
    }
}
