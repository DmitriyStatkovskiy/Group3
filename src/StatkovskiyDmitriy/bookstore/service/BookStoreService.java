//package StatkovskiyDmitriy.bookstore.service;
//
//import StatkovskiyDmitriy.bookstore.dao.OrderDao;
//import StatkovskiyDmitriy.bookstore.dao.RequestDao;
//import StatkovskiyDmitriy.bookstore.dao.StockDao;
//import StatkovskiyDmitriy.bookstore.model.Order;
//import StatkovskiyDmitriy.bookstore.utils.TimeRange;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BookStoreService {
//
//    public StockDao stockDao = new StockDao();
//    public RequestDao requestDao = new RequestDao();
//    public OrderDao orderDao = new OrderDao();
//    public ArrayList<Order> ordersFromRange = new ArrayList<>();
//    public ArrayList<LocalDate> datesRange = new ArrayList<>();
//    public ArrayList<LocalDate> completedOrdersDates = new ArrayList<>();
//
////    public void addBookToStock(String name, String edition, String description, double price, LocalDate incDate) {
////        stockDao.addBook(name, edition, description, price, incDate, true);
////        if (requestDao.getRequestedBookName(name)) {
////            requestDao.closeRequest(name);
////        }
////    }
//
//    public void addNewOrder(String customerName, String orderID, String bookName, LocalDate date) {
//        orderDao.addOrder(customerName, orderID, bookName, date);
//        if (stockDao.getRequestedBookName(bookName)) {
//            requestDao.addRequest(orderID, bookName);
//        }
//    }
//
//    public void completeOrder(String orderId) {
//        String bookName = orderDao.getBookName(orderId);
//
//        if (orderDao.getOrderId(orderId).equals(orderId) && requestDao.getRequestStatus()) {
//            orderDao.changeOrderStatus(orderId, "completed");
//            stockDao.changeBookStatus(bookName);
//        }
//    }
//
//    public void cancelOrder(String orderId) {
//        if (orderDao.getOrderId(orderId).equals(orderId)) {
//            orderDao.changeOrderStatus(orderId, "canceled");
//        }
//    }
//
//    public void calculateProfit(LocalDate from, LocalDate to) {
//        double profit = 0;
//        List<Order> orderByRange = orderDao.findOrderByRange(from, to);
//        //orderDao.findOutCompletedOrderDates();
//        ArrayList<String> book = new ArrayList<>();
//
//        TimeRange range = new TimeRange();
//        datesRange = range.createList(from, to);
//
//
//        completedOrdersDates.retainAll(datesRange);
//        for (LocalDate date : completedOrdersDates) {
//            if (date.equals(orderDao.getOrderFulfillmentDate(date))) {
//                book.add(orderDao.getBookName(date));
//            }
//        }
//
//
//
//        System.out.println(orderByRange);
//        System.out.println(profit);
//    }
//}
