package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Ship;

import java.util.AbstractQueue;

public class PierUnloader extends Thread {

    private AbstractQueue<Ship> queue;
    private Pier pierLeft;
    private Pier pierRight;

    public PierUnloader(AbstractQueue<Ship> queue, Pier pierLeft, Pier pierRight) {
        this.queue = queue;
        this.pierLeft = pierLeft;
        this.pierRight = pierRight;
    }

    @Override
    public void run() {
        new ShipUnloader(queue, pierLeft).start();
        new ShipUnloader(queue, pierRight).start();
    }
}
