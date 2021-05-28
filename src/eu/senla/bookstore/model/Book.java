package eu.senla.bookstore.model;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String name;
    private String edition;
    private double price;
    private String description;
    private LocalDate incomingDate;

    public LocalDate getIncomingDate() {
        return incomingDate;
    }

    public void setIncomingDate(LocalDate incomingDate) {
        this.incomingDate = incomingDate;
    }

    private boolean status;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book(String name, String edition, String description, double price, LocalDate incomingDate, boolean status) {
        this.name = name;
        this.edition = edition;
        this.price = price;
        this.description = description;
        this.incomingDate = incomingDate;
        this.status = status;
    }

    public Book() {
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String inStock() {
        if (status) {
            return "In stock";
        } else return "Out of stock";
    }

    @Override
    public String toString() {

        return "Book{" +
                "name: '" + name + '\'' +
                ", edition: '" + edition + '\'' +
                ", description: '" + description + '\'' +
                ", price = " + price +'\'' +
                ", incoming date: " + incomingDate +
                ", availability: " + inStock() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                status == book.status &&
                Objects.equals(name, book.name) &&
                Objects.equals(edition, book.edition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, edition, price, status);
    }
}