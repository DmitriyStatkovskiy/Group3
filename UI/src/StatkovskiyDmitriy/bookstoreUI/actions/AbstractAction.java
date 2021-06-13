package StatkovskiyDmitriy.bookstoreUI.actions;

import StatkovskiyDmitriy.bookstoreUI.BookStoreApplicationFacade;

import java.util.Scanner;

public abstract class AbstractAction {
    protected BookStoreApplicationFacade facade = BookStoreApplicationFacade.getInstance();
    protected Scanner scanner = new Scanner(System.in);

    protected String enterString(String name) {
        System.out.println(name);
        return scanner.nextLine();
    }

    protected double enterDouble(String name) {
        System.out.println(name);
        return scanner.nextDouble();
    }


}
