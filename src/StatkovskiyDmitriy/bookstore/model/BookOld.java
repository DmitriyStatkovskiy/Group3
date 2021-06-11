//package StatkovskiyDmitriy.bookstore.model;
//
//import java.util.Objects;
//import java.util.UUID;
//
//public class BookOld {
//    private String id = UUID.randomUUID().toString();
//    private String name;
//    private String edition;
//    private double price;
//    private String description;
//
//    public BookOld(String name, String edition, double price, String description) {
//        this.name = name;
//        this.edition = edition;
//        this.price = price;
//        this.description = description;
//    }
//
//    public BookOld() {
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEdition() {
//        return edition;
//    }
//
//    public void setEdition(String edition) {
//        this.edition = edition;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//
//        return "Book{" +
//                "name: '" + name + '\'' +
//                ", edition: '" + edition + '\'' +
//                ", description: '" + description + '\'' +
//                ", price = " + price + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BookOld bookOld = (BookOld) o;
//        return Double.compare(bookOld.getPrice(), getPrice()) == 0 &&
//                Objects.equals(getId(), bookOld.getId()) &&
//                Objects.equals(getName(), bookOld.getName()) &&
//                Objects.equals(getEdition(), bookOld.getEdition()) &&
//                Objects.equals(getDescription(), bookOld.getDescription());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getName(), getEdition(), getPrice(), getDescription());
//    }
//}