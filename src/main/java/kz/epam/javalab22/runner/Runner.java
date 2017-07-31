package kz.epam.javalab22.runner;

import kz.epam.javalab22.operation.ShipGenerator;

public class Runner {

    private static final int COUNTS_OF_SHIPS_TO_GENERATE = 10;

    public static void main(String[] args) {

        ShipGenerator shipGenerator = new ShipGenerator(COUNTS_OF_SHIPS_TO_GENERATE);
        shipGenerator.start();
    }
}
