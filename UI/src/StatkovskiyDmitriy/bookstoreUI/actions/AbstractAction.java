package StatkovskiyDmitriy.bookstoreUI.actions;

import StatkovskiyDmitriy.bookstoreUI.Manager;
import StatkovskiyDmitriy.bookstoreUI.exception.WrongFormatException;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class AbstractAction {
    protected Manager manager = Manager.getInstance();
    protected Scanner scanner = new Scanner(System.in);

    protected String enterString(String name) {
        System.out.println(name);
        return scanner.nextLine();
    }

    protected double enterDouble(String name) {
        System.out.println(name);
        double in;
        try {
            in = scanner.nextDouble();
        } catch (InputMismatchException exception) {
            throw new WrongFormatException("Wrong format, should be double", exception);
        }
        return in;
    }

    protected int enterInt(String name) {
        System.out.println(name);
        int in;
        try {
            in = scanner.nextInt();
        } catch (InputMismatchException exception) {
            throw new WrongFormatException("Wrong format, should be int", exception);
        }
        return in;
    }

    protected LocalDate getDate() {
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
