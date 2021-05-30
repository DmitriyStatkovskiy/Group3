package StatkovskiyDmitriy.bookstore.model;

import StatkovskiyDmitriy.bookstore.model.enums.StockUnitStatus;

import java.time.LocalDate;
import java.util.Objects;

import static StatkovskiyDmitriy.bookstore.model.enums.StockUnitStatus.IN_STOCK;

public class StockUnit {
    private StockUnitStatus status = IN_STOCK;
    private LocalDate incomingDate = LocalDate.now();
    private Book book;

    public StockUnit() {
    }

    public StockUnit(Book book) {
        this.book = book;
    }

    public StockUnitStatus getStatus() {
        return status;
    }

    public void setStatus(StockUnitStatus status) {
        this.status = status;
    }

    public LocalDate getIncomingDate() {
        return incomingDate;
    }

    public void setIncomingDate(LocalDate incomingDate) {
        this.incomingDate = incomingDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockUnit stockUnit = (StockUnit) o;
        return status == stockUnit.status &&
                Objects.equals(incomingDate, stockUnit.incomingDate) &&
                Objects.equals(book, stockUnit.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, incomingDate, book);
    }
}
