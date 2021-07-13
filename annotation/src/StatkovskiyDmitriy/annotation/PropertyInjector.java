package StatkovskiyDmitriy.annotation;

import StatkovskiyDmitriy.bookstore.api.service.IBookService;

public class PropertyInjector {
    @InjectProperty("minusOne")
    private String setNumberOfMonthToMarkBookAsOld;

    public void injectDate() {
        System.out.println(setNumberOfMonthToMarkBookAsOld);
    }
}
