package StatkovskiyDmitriy.bookstoreProperties;

import StatkovskiyDmitriy.bookstore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PropertiesLoader {

    static Logger logger = LoggerFactory.getLogger(PropertiesLoader.getInstance().getClass());
    private static PropertiesLoader instance;
    BookService bookService = BookService.getInstance();
    private final String PROPERTY_PATH = "properties/src/StatkovskiyDmitriy/bookstoreProperties/iostreams.properties";

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
        try (FileReader reader = new FileReader(PROPERTY_PATH)) {
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
