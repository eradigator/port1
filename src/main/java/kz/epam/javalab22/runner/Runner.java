package kz.epam.javalab22.runner;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Port;

/**
 * Hello world!
 */
public class Runner {
    public static void main(String[] args) {

        Port port = new Port();
        port.getPierList().add(new Pier(10));
        port.getPierList().add(new Pier(10));

    }
}
