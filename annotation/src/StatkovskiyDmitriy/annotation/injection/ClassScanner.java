package StatkovskiyDmitriy.annotation.injection;

import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ClassScanner {
    private final String CLASS_EXTENSION = ".class";
    private final Set<Class<?>> foundClasses;

    public ClassScanner() {
        this.foundClasses = new HashSet<>();
    }

    public Set<Class<?>> findClasses(Class<?> startClass) throws ClassNotFoundException {
        String directory = getDirectory(startClass);
        File file = new File(directory);
        if (!file.isDirectory()) {
            throw new RuntimeException("invalid directory" + directory);
        }
        try {
            for (File innerFile : Objects.requireNonNull(file.listFiles())) {
                scanDirectory(innerFile);
            }
        } catch (ClassNotFoundException exception) {
            throw new ClassNotFoundException(exception.getMessage(), exception);
        }
        return foundClasses;
    }

    private String getDirectory(Class<?> clss) {
        return clss.getProtectionDomain().getCodeSource().getLocation().getFile();
    }

    private void scanDirectory(File file) throws ClassNotFoundException {
        String packageName = "";
        if (file.isDirectory()) {
            packageName += file.getName() + ".";
            for (File innerFile : Objects.requireNonNull(file.listFiles())) {
                scanDirectory(innerFile);
            }
        }
        if (!file.getName().endsWith(CLASS_EXTENSION)) {
            return;
        }
        String className = packageName + file.getName().replace(CLASS_EXTENSION, "");
        foundClasses.add(Class.forName(className));
    }

}
