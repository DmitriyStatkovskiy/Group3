package eu.senla.bookstore;

import eu.senla.bookstore.interfaces.DaoApi;

import java.util.ArrayList;

public class RequestService implements DaoApi<Request> {
    ArrayList<Request> requests = new ArrayList<>();

    public boolean getRequestedBookName(String name){
        for (Request req :
                requests) {
            if(req.getRequestedBookName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void addRequest(String requestedBookName) {
        requests.add(new Request(requestedBookName));
    }

    public void closeRequest(String bookName) {
        for (Request request : requests
        ) {
            if (request.getRequestedBookName().equals(bookName)) {
                request.setRequestStatus("closed");
            }
        }
    }
    public void printRequests(){
        for (Request request:requests
        ) {
            System.out.println(request);
        }
    }
    @Override
    public void addSmth(Request request) {
        requests.add(request);
    }
}
