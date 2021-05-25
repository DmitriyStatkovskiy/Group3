package eu.senla.bookstore;

import java.util.ArrayList;

public class RequestService {
    ArrayList<Request> requests = new ArrayList<>();

    public void addRequest(String requestedBookName){
        requests.add(new Request("new",requestedBookName));
    }

}
