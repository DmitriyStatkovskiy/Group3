package StatkovskiyDmitriy.bookstore.service;

import StatkovskiyDmitriy.bookstore.dao.OrderDao;
import StatkovskiyDmitriy.bookstore.dao.RequestDao;
import StatkovskiyDmitriy.bookstore.dao.StockDao;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.utils.TimeRange;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookStoreService {
    public StockDao stock = new StockDao();
    public RequestDao requests = new RequestDao();
    public OrderDao orders = new OrderDao();
    public ArrayList<Order> ordersFromRange = new ArrayList<>();
    public ArrayList<LocalDate> datesRange = new ArrayList<>();
    public ArrayList<LocalDate> completedOrdersDates = new ArrayList<>();

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

        if (orders.getOrderId(orderId).equals(orderId) && requests.getRequestStatus()) {
            orders.changeOrderStatus(orderId, "completed");
            stock.changeBookStatus(bookName);
        }
    }

    public void cancelOrder(String orderId) {
        if (orders.getOrderId(orderId).equals(orderId)) {
            orders.changeOrderStatus(orderId, "canceled");
        }
    }

    public void findOutProfit(LocalDate from, LocalDate to) {
        double profit = 0;
        completedOrdersDates = orders.findOutCompletedOrderDates();
        ArrayList<String> book = new ArrayList<>();

        TimeRange range = new TimeRange();
        datesRange = range.createList(from, to);


        completedOrdersDates.retainAll(datesRange);

        for (LocalDate date :
                completedOrdersDates) {
            if (date.equals(orders.getOrderFulfillmentDate(date))) {
                book.add(orders.getBookName(date));
            }
        }
        for (String s:
                book) {
            profit += stock.getBookPrice(s);
        }

        System.out.println(book);
        System.out.println(profit);
    }
}
