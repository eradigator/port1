package kz.epam.javalab22.runner;

import kz.epam.javalab22.entity.Ship;
import kz.epam.javalab22.operation.Dispatcher;
import kz.epam.javalab22.operation.PierUnloader;
import kz.epam.javalab22.operation.ShipGenerator;

import java.util.AbstractQueue;


public class Runner {

    private static final int COUNTS_OF_SHIPS_TO_GENERATE = 10;

    public static void main(String[] args) {

        AbstractQueue<Ship> shipsQueue;
        shipsQueue = new ShipGenerator().generate(COUNTS_OF_SHIPS_TO_GENERATE);
        
        Dispatcher dispatcher = new Dispatcher(shipsQueue);
        dispatcher.start();

    }
}
