package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.bookstore.service.BookService;

public class PropertyInjector {
    @InjectProperty("minusOne")
    private String setNumberOfMonthToMarkBookAsOld;

    private BookService bookService = BookService.getInstance();

    public void injectDate() {
        int count = Integer.parseInt(setNumberOfMonthToMarkBookAsOld);
        bookService.setNumberOfMonthToMarkBookAsOld(count);
        System.out.println(setNumberOfMonthToMarkBookAsOld);
    }
}
