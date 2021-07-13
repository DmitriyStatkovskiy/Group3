package StatkovskiyDmitriy.annotation;

import java.io.FileNotFoundException;

public interface ObjectConfigurator {
    void configure(Object t) throws FileNotFoundException, IllegalAccessException;
}
