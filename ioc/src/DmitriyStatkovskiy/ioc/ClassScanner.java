package DmitriyStatkovskiy.ioc;


import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ClassScanner {

    private final String CLASS_EXTENSION = ".class";
    private final Set<Class<?>> foundClasses;
    private String packageName = "";

    public ClassScanner() {
        this.foundClasses = new HashSet<>();

    }

    public Set<Class<?>> findClasses(Class<?> startClass) {

        String directory = getDirectory(startClass);
        File file = new File(directory);

        if (!file.isDirectory()) {
            throw new RuntimeException("File is not Directory" + directory);
        }

        try {
            for (File innerFile : Objects.requireNonNull(file.listFiles())) {
                scanDirectory(innerFile, packageName);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return foundClasses;
    }

    private String getDirectory(Class<?> clazz) {
        return clazz.getProtectionDomain().getCodeSource().getLocation().getFile();
    }


    private void scanDirectory(File file, String packageName) throws ClassNotFoundException {
        if (file.isDirectory()) {
            packageName += file.getName() + ".";
            for (File someFile : Objects.requireNonNull(file.listFiles())) {
                scanDirectory(someFile, packageName);
            }
        }
        if (!file.getName().endsWith(CLASS_EXTENSION)) {
            return;
        }
        String className = packageName + file.getName().replace(CLASS_EXTENSION, "");

        foundClasses.add(Class.forName(className));
    }
}
