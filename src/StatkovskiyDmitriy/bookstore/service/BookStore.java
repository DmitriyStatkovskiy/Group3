package StatkovskiyDmitriy.bookstore.service;

import StatkovskiyDmitriy.bookstore.dao.OrderDao;
import StatkovskiyDmitriy.bookstore.dao.RequestDao;
import StatkovskiyDmitriy.bookstore.dao.StockDao;
import StatkovskiyDmitriy.bookstore.model.Order;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookStore {
    public StockDao stock = new StockDao();
    public RequestDao requests = new RequestDao();
    public OrderDao orders = new OrderDao();
    public ArrayList<Order> ordersFromRange = new ArrayList<>();

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

    public void range(LocalDate from, LocalDate to) {
        LocalDate start = from;
        LocalDate end = to.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

        List<LocalDate> dates = Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .collect(Collectors.toList());

        orders.findOut(dates);
       //return dates;
    }


}
