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

    public static List<Date> getDaysBetweenDates(Date startDate, Date endDate)
    {
        List<Date> dates = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        while (calendar.getTime().before(endDate))
        {
            Date result = calendar.getTime();
            dates.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        return dates;
    }


//
//    public void findOutProfit(Date startDate, Date endDate){
//        double profit = 0;
//        List<Date> date = getDaysBetweenDates(startDate,endDate);
//        for (Order order:orders.getOrdrFlfllDate()
//             ) {
//
//        }
//    }
}
