package StatkovskiyDmitriy.ser;

import StatkovskiyDmitriy.bookstore.dao.BookDao;
import StatkovskiyDmitriy.bookstore.dao.OrderDao;
import StatkovskiyDmitriy.bookstore.dao.RequestDao;

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
        BookDao.getInstance().setBooks(allDaoData.getBookDao().getBooks());
        OrderDao.getInstance().setOrders(allDaoData.getOrderDao().getOrders());
        RequestDao.getInstance().setRequests(allDaoData.getRequestDao().getRequests());
    }

}