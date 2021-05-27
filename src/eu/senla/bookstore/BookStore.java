package eu.senla.bookstore;


import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

public class BookStore {
    StockService stock = new StockService();
    RequestService requests = new RequestService();
    OrderService orders = new OrderService();

    public void addBookToStock(String name, String edition, String description, double price, LocalDate incDate) {
        stock.addBook(name, edition, description, price, incDate, true);
        if (requests.getRequestedBookName(name)) {
            requests.closeRequest(name);
        }
    }

    public void addNewOrder(String customerName, String orderID, String bookName, LocalDate date) {
        orders.addOrder(customerName, orderID, bookName, date);
        if (stock.getRequestedBookName(bookName)) {
            requests.addRequest(orderID, bookName);
        }
    }

    public void completeOrder(String orderId) {
        String bookName = orders.getBookName(orderId);

        if (orders.getOrderId(orderId).equals(orderId)&&requests.getRequestStatus()) {
            orders.changeOrderStatus(orderId, "completed");
            stock.changeBookStatus(bookName);
        }
    }

    public void cancelOrder(String orderId) {
        if (orders.getOrderId(orderId).equals(orderId)) {
            orders.changeOrderStatus(orderId, "canceled");
        }
    }





}
