package StatkovskiyDmitriy.bookstore.model;

import StatkovskiyDmitriy.bookstore.model.enums.BookStatus;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import static StatkovskiyDmitriy.bookstore.model.enums.BookStatus.IN_STOCK;

public class Book {

    private BookStatus status = IN_STOCK;
    private LocalDate incomingDate = LocalDate.now();

    private String id = UUID.randomUUID().toString();
    private String name;
    private String edition;
    private double price;
    private String description;
    private boolean isOld = false;

    public Book() {
    }

    public Book(String name, String edition, double price, String description) {
        this.name = name;
        this.edition = edition;
        this.price = price;
        this.description = description;
    }

    public Book(BookStatus status, LocalDate incomingDate, String id, String name, String edition, double price, String description) {
        this.status = status;
        this.incomingDate = incomingDate;
        this.id = id;
        this.name = name;
        this.edition = edition;
        this.price = price;
        this.description = description;
    }

    public Book(String name, String edition, double price, String description, BookStatus status) {
        this.status = status;
        this.name = name;
        this.edition = edition;
        this.price = price;
        this.description = description;
    }

    public Book(LocalDate incomingDate, String name, String edition, double price, String description) {
        this.incomingDate = incomingDate;
        this.name = name;
        this.edition = edition;
        this.price = price;
        this.description = description;
    }

    public boolean isOld() {
        return isOld;
    }

    public void setOld(boolean old) {
        isOld = old;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public LocalDate getIncomingDate() {
        return incomingDate;
    }

    public void setIncomingDate(LocalDate incomingDate) {
        this.incomingDate = incomingDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", edition='" + edition + '\'' +
                ", price=" + price +
                ", description=" + description +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.getPrice(), getPrice()) == 0 &&
                isOld() == book.isOld() &&
                getStatus() == book.getStatus() &&
                Objects.equals(getIncomingDate(), book.getIncomingDate()) &&
                Objects.equals(getId(), book.getId()) &&
                Objects.equals(getName(), book.getName()) &&
                Objects.equals(getEdition(), book.getEdition()) &&
                Objects.equals(getDescription(), book.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getIncomingDate(), getId(), getName(), getEdition(), getPrice(), getDescription(), isOld());
    }
}
