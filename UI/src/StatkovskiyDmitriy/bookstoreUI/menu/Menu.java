package StatkovskiyDmitriy.bookstoreUI.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    List<MenuItem> menuItems = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
