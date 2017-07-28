package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Ship;

import java.util.AbstractQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ShipGenerator extends Thread{

    private int shipsToGenerateCount;
    private Pier pier1 = new Pier(14,1);
    private Pier pier2 = new Pier(6,1);

    private ConcurrentLinkedQueue<Ship> queue = new ConcurrentLinkedQueue<>();

    public ShipGenerator(int shipsToGenerateCount) {
        this.shipsToGenerateCount = shipsToGenerateCount;
    }

    @Override
    public void run() {

        for (int i = 0; i < shipsToGenerateCount; i++) {
            int randomBoxCount = (int) (Math.random() * 100 + 100);

            queue.add(new Ship(randomBoxCount));
            new PreUnloader(queue,pier1,pier2);

            try {
                int randomArrivalInterval = (int) (Math.random() * 10);
                TimeUnit.SECONDS.sleep(randomArrivalInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
