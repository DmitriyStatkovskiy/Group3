package eu.senla.bookstore;

public class Main {
    public static void main(String[] args) {
        Stock bookStore = new Stock();
        bookStore.addBook("c", "ewe", 22, false);
        bookStore.addBook("b", "ewe", 12, true);
        bookStore.addBook("a", "ew322e", 54, true);

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
        for (Book s : bookStore.stock) {
            System.out.println(s);
        }
    }
}