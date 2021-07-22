package StatkovskiyDmitriy.task9;

import org.apache.log4j.PropertyConfigurator;

public class Main {
    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        Starter start = new Starter();
        start.taskOne();
        start.taskTwo();
        start.taskThree();
    }
}
