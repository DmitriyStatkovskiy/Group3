package StatkovskiyDmitriy.ser;

import StatkovskiyDmitriy.bookstore.service.BookService;
import StatkovskiyDmitriy.bookstore.service.OrderService;
import StatkovskiyDmitriy.bookstore.service.RequestService;

import java.io.*;

public class TestSerialization implements Serializable {

    public TestSerialization() {
    }

    public void serialize() throws IOException {
        AllDaoData allDaoData = new AllDaoData();
        FileOutputStream outputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(allDaoData);
        objectOutputStream.close();
    }

    public void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        AllDaoData allDaoData = (AllDaoData) objectInputStream.readObject();

        BookService.getInstance().setBooks(allDaoData.getBookService().getAllBooks());
        OrderService.getInstance().setOrders(allDaoData.getOrderService().getAll());
        RequestService.getInstance().setRequests(allDaoData.getRequestService().getAll());
    }

}