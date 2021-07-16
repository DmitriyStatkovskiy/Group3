package StatkovskiyDmitriy.bookstoreUI;

import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.Request;

import java.time.LocalDate;
import java.util.List;

public interface IManager {
    public void deleteAllBooks();

    public void deleteAllOrders();

    public void deleteAllRequests();

    void setIncomingDate(String book, LocalDate date);

    public List<Request> sortRequestsByBookName();

    List<Request> sortRequestsQuantity();

    void changeRequestStatus(String name);

    List<Request> getRequests();

    void createRequest(String name);

    int showCompletedOrderValue(LocalDate from, LocalDate to);

    double showProfit(LocalDate from, LocalDate to);

    void showOrderDetails(String id);

    List<Order> sortCompletedOrdersByDate(LocalDate from, LocalDate to);

    List<Order> sortCompletedOrdersByPrice(LocalDate from, LocalDate to);

    List<Order> sortOrdersByStatus();

    List<Order> sortOrdersByCompletedDate();

    List<Order> sortOrdersByPrice();

    void changeOrderStatus(String orderId, String status);

    void cancelOrder(String orderId);

    void completeOrder(String orderId);

    void addBookToOrder(String orderId, String bookName);

    void addOrder();

    void setOldBooks(int month);

    void addBook(Book book);

    List<Book> getBooks();

    void changeStatus(String name);

    void addBookAndCloseRequest(String name);

    String showDescription(String name);

    List<Book> getOutOfStock();

    List<Book> sortByName();

    List<Book> sortByPrice();

    List<Book> sortByStatus();

    List<Book> sortOldByIncDate();

    List<Book> sortOldByPrice();

    List<Order> getOrders();
}
