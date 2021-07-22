package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.bookstore.service.BookService;

public class PropertyInjector {
    @InjectProperty
    private String numberOfMonthToMarkBookAsOld;

    private BookService bookService = BookService.getInstance();

    public void injectDate() {
        if (numberOfMonthToMarkBookAsOld != null) {
            int count = Integer.parseInt(numberOfMonthToMarkBookAsOld);
            bookService.setNumberOfMonthToMarkBookAsOld(count);
        }
    }
}
