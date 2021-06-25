package StatkovskiyDmitriy.ser;

import StatkovskiyDmitriy.bookstore.service.BookService;
import StatkovskiyDmitriy.bookstore.service.OrderService;
import StatkovskiyDmitriy.bookstore.service.RequestService;

import java.io.Serializable;

public class AllDaoData implements Serializable {
    private static final long serialVersionUID = 1L;

    private BookService bookService = BookService.getInstance();
    private OrderService orderService = OrderService.getInstance();
    private RequestService requestService = RequestService.getInstance();

    public AllDaoData() {
    }

    public BookService getBookService() {
        return bookService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public RequestService getRequestService() {
        return requestService;
    }
}
