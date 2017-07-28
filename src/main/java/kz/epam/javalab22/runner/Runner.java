package kz.epam.javalab22.runner;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.operation.ShipGenerator;


public class Runner {
    public static void main(String[] args) {

        Pier pier1 = new Pier(7,2);
        ShipGenerator shipGenerator = new ShipGenerator(10,pier1);
        shipGenerator.start();
    }
}
