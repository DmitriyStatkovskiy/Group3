package StatkovskiyDmitriy.bookstoreUI.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddBook extends AbstractAction implements IAction {

    @Override
    public void execute() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter 1st param");
            String param1 = reader.readLine();
            System.out.println("enter 2nd param");
            int param2 = reader.read();
            Object book = facade.addBook(param1, param2);
            System.out.println(book);
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }

    }

}
