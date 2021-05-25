package eu.senla.bookstore;

import java.util.Objects;

public class Book {
    private String name;
    private String edition;
    private double price;
    private boolean isInStock;

    public Book(String name, String edition, double price, boolean isInStock) {
        this.name = name;
        this.edition = edition;
        this.price = price;
        this.isInStock = isInStock;
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

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", edition='" + edition + '\'' +
                ", price=" + price +
                ", isInStock=" + isInStock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                isInStock == book.isInStock &&
                Objects.equals(name, book.name) &&
                Objects.equals(edition, book.edition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, edition, price, isInStock);
    }
}