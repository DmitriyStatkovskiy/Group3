package StatkovskiyDmitriy.ser;

import StatkovskiyDmitriy.bookstore.dao.BookDao;
import StatkovskiyDmitriy.bookstore.dao.OrderDao;
import StatkovskiyDmitriy.bookstore.dao.RequestDao;

import java.io.Serializable;

public class AllDaoData implements Serializable {
    private static final long serialVersionUID = 1L;
    private BookDao bookDao = BookDao.getInstance();
    private OrderDao orderDao = OrderDao.getInstance();
    private RequestDao requestDao = RequestDao.getInstance();

    public AllDaoData() {
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public RequestDao getRequestDao() {
        return requestDao;
    }
}
