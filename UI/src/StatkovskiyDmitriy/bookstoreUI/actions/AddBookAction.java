package StatkovskiyDmitriy.bookstoreUI.actions;

import StatkovskiyDmitriy.bookstore.model.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AddBookAction extends AbstractAction implements IAction {


    @Override
    public void execute() {
        String name, edition, description;
        double price;
        System.out.println("name',edition, price, description");
        name = enterString("Enter book name: ");
        edition = enterString("Enter edition: ");
        description = enterString("Enter description: ");
        price = enterDouble("Enter price: ");

        facade.addBook(new Book(name, edition, price, description));
    }

}
