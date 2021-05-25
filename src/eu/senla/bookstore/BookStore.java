package eu.senla.bookstore;


import java.time.LocalDate;

public class BookStore  {
    StockService stock = new StockService();
    RequestService requestList = new RequestService();
    OrderService orderList = new OrderService();

    public void addAnotherBook(String name, String edition, String description, double price, LocalDate incDate, boolean isInStock){
        stock.addBook(name, edition, description, price, incDate, isInStock);
        if(requestList.getRequestedBookName(name)){
            requestList.closeRequest(name);
        }
    }

}
