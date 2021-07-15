package StatkovskiyDmitriy.bookstoreUI.menu;

import StatkovskiyDmitriy.annotation.injection.annotation.Autowired;
import StatkovskiyDmitriy.annotation.injection.annotation.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NavigableMap;

@Component
public class Navigator implements INavigator {
    static Logger logger = LoggerFactory.getLogger(Navigator.class);

    private static Navigator instance;
    @Autowired
    private Menu currentMenu;

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    private Navigator() {
    }

    public static Navigator getInstance() {
        if (instance == null) {
            instance = new Navigator();
        }
        return instance;
    }

    public void printMenu() {
        List<MenuItem> menuItems = currentMenu.getMenuItems();
        System.out.println("--" + currentMenu.getName() + "--");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i).getTitle());
        }

    }

    public void navigate(Integer index) {
        try {
            if (currentMenu != null) {
                MenuItem menuItem = currentMenu.getMenuItems().get(index);
                menuItem.doAction();
                currentMenu = menuItem.getNextMenu();
            }
        } catch (IndexOutOfBoundsException exception) {
            logger.warn("OutOfBoundException");
        } catch (Exception e) {
            logger.warn("exception", e);
            System.err.println(e.getMessage());
        }
    }
}
