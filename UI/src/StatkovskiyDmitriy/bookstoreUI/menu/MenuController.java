package StatkovskiyDmitriy.bookstoreUI.menu;

import StatkovskiyDmitriy.bookstore.dao.BookDao;
import StatkovskiyDmitriy.bookstore.model.Book;

import java.util.Scanner;

public class MenuController {
    private static MenuController instance;
    private final Builder builder;
    private final Navigator navigator;

    private MenuController() {
        builder = Builder.getInstance();
        builder.buildMenu();
        navigator = Navigator.getInstance();
    }

    public static MenuController getInstance() {
        if (instance == null) {
            instance = new MenuController();
        }
        return instance;
    }

    public void run() {
        initDao();
        Integer index = -1;
        Scanner scanner = new Scanner(System.in);
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        while (!index.equals(123)) {
            index = scanner.nextInt();
            navigator.navigate(index);
            navigator.printMenu();
        }
    }

    private void initDao() {
        BookDao instance = BookDao.getInstance();
        Book bookA = new Book("AAA", "1", 10, "aaa");
        Book bookB = new Book("BBB", "2", 20, "bbb");
        Book bookC = new Book("CCC", "3", 30, "ccc");
        Book bookD = new Book("DDD", "4", 40, "ddd");
        Book bookE = new Book("EEE", "5", 50, "eee");
        instance.addBook(bookA);
        instance.addBook(bookB);
        instance.addBook(bookC);
        instance.addBook(bookD);
        instance.addBook(bookE);
    }
}
