package kz.epam.javalab22.runner;

import kz.epam.javalab22.operation.ShipGenerator;


public class Runner {
    public static void main(String[] args) {

        ShipGenerator shipGenerator = new ShipGenerator();
        shipGenerator.start();
    }
}
