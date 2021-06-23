package StatkovskiyDmitriy.bookstoreUI.actions;

import StatkovskiyDmitriy.bookstoreUI.Manager;
import StatkovskiyDmitriy.bookstoreUI.exception.WrongFormatException;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class AbstractAction {
    protected Manager manager = Manager.getInstance();
    protected Scanner scanner = new Scanner(System.in);

    protected String enterString(String message) {
        System.out.println(message);
        return scanner.next();
    }

    protected double enterDouble(String message) {
        System.out.println(message);
        double in;
        try {
            in = scanner.nextDouble();
        } catch (InputMismatchException exception) {
            throw new WrongFormatException("Wrong format, should be double", exception);
        }
        return in;
    }

    protected int enterInt(String message) {
        System.out.println(message);
        int in;
        try {
            in = scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new WrongFormatException("Wrong format, should be int", exception);
        }
        return in;
    }

    protected LocalDate enterDate(String message) {
        System.out.println(message);
        LocalDate date;
        int day;
        int month;
        int year;
        day = enterInt("Enter day");
        month = enterInt("Enter month");
        year = enterInt("Enter year");
        date = LocalDate.of(year, month, day);
        return date;
    }
}
