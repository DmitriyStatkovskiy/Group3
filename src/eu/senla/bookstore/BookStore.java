package eu.senla.bookstore;


import java.time.LocalDate;

public class BookStore  {
    StockService stock = new StockService();
    RequestService requestList = new RequestService();
    OrderService orderList = new OrderService();

    public void addBookToStock(String name, String edition, String description, double price, LocalDate incDate){
        stock.addBook(name, edition, description, price, incDate, true);
        if(requestList.getRequestedBookName(name)){
            requestList.closeRequest(name);
        }
    }

}
