package eu.senla.bookstore;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Stock bookStore = new Stock();
        bookStore.addBook("c", "ewe", "22", 55.2, LocalDate.of(2020,12,3), true);
        bookStore.addBook("b", "ewe", "12", 32, LocalDate.now(), false);
        bookStore.addBook("a", "ew322e", "54", 123, LocalDate.now(), true);
        bookStore.addBook("d","aa2sdd","223d",23.41,LocalDate.of(1990,7,19), true);

        for (Book s : bookStore.stock
        ) {
            System.out.println(s);
        }

        bookStore.sortByName();


        for (Book s : bookStore.stock
        ) {
            System.out.println(s);
        }

        bookStore.changeBookStatus("c");

        bookStore.changeBookStatusToFalse("b");
        for (Book s : bookStore.stock) {
            System.out.println(s);
        }
    }
}