package eu.senla.bookstore;

public class Main {
    public static void main(String[] args) {
        Stock bookStore = new Stock();
        bookStore.addBook("c", "ewe", 22, true);
        bookStore.addBook("b", "ewe", 12, true);
        bookStore.addBook("a", "ew322e", 54, true);
//        bookStore.stock.add(new Book("wewe", "fwef", 22, true));
//        for (Book s : bookStore.stock
//        ) {
//            System.out.println(s);
//
//        }
        for (Book s : bookStore.stock
        ) {
            System.out.println(s);
        }
        bookStore.sortByName();
        bookStore.sortByPrice();

        for (Book s : bookStore.stock
        ) {
            System.out.println(s);
        }
    }
}