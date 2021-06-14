package StatkovskiyDmitriy.bookstoreUI;


import StatkovskiyDmitriy.bookstore.api.service.IBookService;
import StatkovskiyDmitriy.bookstore.api.service.IOrderService;
import StatkovskiyDmitriy.bookstore.api.service.IRequestService;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.Request;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;
import StatkovskiyDmitriy.bookstore.model.enums.OrderStatus;
import StatkovskiyDmitriy.bookstore.model.enums.RequestStatus;
import StatkovskiyDmitriy.bookstore.service.BookService;
import StatkovskiyDmitriy.bookstore.service.OrderService;
import StatkovskiyDmitriy.bookstore.service.RequestService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Manager {
    private static Manager instance;
    private final IBookService bookService = BookService.getInstance();
    private final IOrderService orderService = OrderService.getInstance();
    private final IRequestService requestService = RequestService.getInstance();

    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }


    public void addBook(Book book) {
        bookService.addBook(book);
    }

    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    public void changeStatus(String name) {
        List<Book> books = bookService.getAllBooks().stream()
                .filter(book1 -> book1.getName().equals(name))
                .filter(book1 -> book1.getStatus().equals(BookStatus.IN_STOCK))
                .collect(Collectors.toList());
        if (books.size() != 0) {
            bookService.getAllBooks().stream()
                    .filter(book1 -> book1.getName().equals(name))
                    .forEach(book2 -> book2.setStatus(BookStatus.OUT_OF_STOCK));
        } else bookService.getAllBooks().stream()
                .filter(book1 -> book1.getName().equals(name))
                .forEach(book2 -> book2.setStatus(BookStatus.IN_STOCK));
    }

    public String showDescription(String name) {

        String description = bookService.getAllBooks().stream()
                .filter(book -> book.getName().equals(name))
                .findFirst()
                .get()
                .getDescription();
        return description;
    }

    public List<Book> getOutOfStock() {
        return bookService.getOutBooks();
    }

    public List<Book> sortByName() {
        return bookService.sortBooksByName();
    }

    public List<Book> sortByPrice() {
        return bookService.sortBooksByPrice();
    }

    public List<Book> sortByStatus() {
        return bookService.sortBooksByStatus();
    }

    public List<Book> sortOldByIncDate() {
        return bookService.sortOldBooksByIncomingDate();
    }

    public List<Book> sortOldByPrice() {
        return bookService.sortOldBooksByPrice();
    }

    public List<Order> getOrders() {
        return orderService.getAll();
    }

    public void addOrder() {
        orderService.createNew();
    }

    public void addBookToOrder(String orderId, String bookName) {
        Order order = orderService.getOrderById(orderId);
        Book book = bookService.getBookByName(bookName);
        orderService.addBook(order, book);
    }

    public void completeOrder(String orderId) {
        Order order = orderService.getOrderById(orderId);
        orderService.completeOrder(order);
    }

    public void cancelOrder(String orderId) {
        Order order = orderService.getOrderById(orderId);
        orderService.cancelOrder(order);
    }

    public void changeOrderStatus(String orderId, String status) {
        Order order = orderService.getOrderById(orderId);
        if (status.equals("cancel")) {
            cancelOrder(orderId);
        }
        if (status.equals("complete")) {
            completeOrder(orderId);
        } else orderService.changeOrderStatus(order, OrderStatus.NEW);
    }

    public List<Order> sortOrdersByPrice() {
        return orderService.sortOrdersByPrice();
    }

    public List<Order> sortOrdersByCompletedDate() {
        return orderService.sortOrdersByFulfillmentDate();
    }

    public List<Order> sortOrdersByStatus() {
        return orderService.sortOrdersByStatus();
    }

    public List<Order> sortCompletedOrdersByPrice(LocalDate from, LocalDate to) {
        return orderService.sortCompletedOrdersByPriceFromRange(from, to);
    }

    public List<Order> sortCompletedOrdersByDate(LocalDate from, LocalDate to) {
        return orderService.sortCompletedOrdersByCompletedDateFromRange(from, to);
    }

    public void showOrderDetails(String id) {
        Order order = orderService.getOrderById(id);
        System.out.println(order);
    }

    public double showProfit(LocalDate from, LocalDate to) {

        return orderService.calculateEarnedMoneyFromRange(from, to);
    }

    public int showCompletedOrderValue(LocalDate from, LocalDate to) {
        return orderService.numberOfCompletedOrdersFromRange(from, to);
    }

    public void createRequest(String name) {
        Book book = bookService.getBookByName(name);
        requestService.createRequest(book);
    }

    public List<Request> getRequests() {
        return requestService.getAll();
    }

    public void changeRequestStatus(String name) {
        Request request = requestService.getRequestByName(name);
        if (request.getStatus().equals(RequestStatus.OPEN)) {
            requestService.changeRequestStatusByBookName(name, RequestStatus.CLOSED);
        } else {
            requestService.changeRequestStatusByBookName(name, RequestStatus.OPEN);
        }
    }

    public List<Request> sortRequestsQuantity() {
        return requestService.sortRequestsByQuantity();
    }

    public List<Request> sortRequestsByBookName() {
        return requestService.sortRequestsByBookName();
    }
}
