package StatkovskiyDmitriy.bookstoreProperties;

import StatkovskiyDmitriy.bookstore.service.BookService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    BookService bookService = BookService.getInstance();
    static Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    private static PropertiesLoader instance;

    private PropertiesLoader() {
    }

    public static PropertiesLoader getInstance() {
        if (instance == null) {
            instance = new PropertiesLoader();
        }
        return instance;
    }

    public void loadPermissionAndDate() throws IOException {
        int month;
        boolean permission;
        Properties properties = new Properties();
        try (FileReader reader = new FileReader("properties/src/StatkovskiyDmitriy/bookstoreProperties/config-test.properties");) {
            properties.load(reader);

            month = Integer.parseInt(properties.getProperty("numberOfMonthToMarkBookAsOld"));
            permission = Boolean.getBoolean(properties.getProperty("permissionToAddRequest"));
        } catch (IOException exception) {
            logger.warn("config file not found");
            throw new IOException("property file not found ");
        }
        bookService.setNumberOfMonthToMarkBookAsOld(month);
        bookService.setPermissionToAddRequest(permission);
    }
}
