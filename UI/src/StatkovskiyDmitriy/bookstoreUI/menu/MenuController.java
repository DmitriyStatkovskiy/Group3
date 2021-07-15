package StatkovskiyDmitriy.bookstoreUI.menu;

import StatkovskiyDmitriy.annotation.injection.annotation.Autowired;
import StatkovskiyDmitriy.annotation.injection.annotation.Component;
import StatkovskiyDmitriy.bookstore.dao.BookDao;
import StatkovskiyDmitriy.bookstore.dao.OrderDao;
import StatkovskiyDmitriy.bookstore.model.Book;
import StatkovskiyDmitriy.bookstore.model.Order;
import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;
import StatkovskiyDmitriy.bookstore.service.OrderService;
import StatkovskiyDmitriy.bookstore.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class MenuController implements IMenuController {
    static Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private final Builder builder;
    @Autowired
    private final Navigator navigator;

    private static MenuController instance;

    private MenuController() {
        builder = Builder.getInstance();
        builder.buildMenu();
        navigator = Navigator.getInstance();
    }

    public static MenuController getInstance() {
        if (instance == null) {
            instance = new MenuController();
        }
        return instance;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Integer index = -1;

        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();

        while (!index.equals(80085)) {
            try {
                index = scanner.nextInt();
            } catch (InputMismatchException exception) {
                logger.error("entered String instead int");
                scanner.next();
            }
            navigator.navigate(index);
            navigator.printMenu();
        }
    }

    private void initDao() {
        BookDao bookInstance = BookDao.getInstance();
        OrderDao orderInstance = OrderDao.getInstance();
        OrderService orderService = OrderService.getInstance();
        RequestService requestService = RequestService.getInstance();
        Book bookA = new Book("AAA", "1", 10, "aaa");
        Book bookB = new Book("BBB", "2", 20, "bbb");
        Book bookC = new Book("CCC", "3", 30, "ccc");
        Book bookD = new Book("DDD", "4", 40, "ddd");
        Book bookE = new Book("EEE", "5", 50, "eee", BookStatus.OUT_OF_STOCK);
        bookInstance.addBook(bookA);
        bookInstance.addBook(bookB);
        bookInstance.addBook(bookD);
        bookInstance.addBook(bookE);
        bookInstance.addBook(bookC);

        Order order1 = orderInstance.createOrder();
        Order order2 = orderInstance.createOrder();
        orderService.addBook(order1, bookA);
        orderService.addBook(order2, bookB);
        orderService.addBook(order2, bookC);

        requestService.createRequest(bookE);
    }
}
