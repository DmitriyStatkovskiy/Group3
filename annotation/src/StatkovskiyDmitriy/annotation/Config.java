package StatkovskiyDmitriy.annotation;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc);
}
