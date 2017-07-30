package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Ship;
import kz.epam.javalab22.entity.ShipSize;

import java.util.AbstractQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ShipGenerator extends Thread{

    private int shipsToGenerateCount;
    private Pier pier1Left = new Pier("Пирс1, левая сторона. ",3, new Semaphore(1));
    private Pier pier1Right = new Pier("Пирс1, правая сторона. ",2, new Semaphore(1));
    private Pier pier2Left = new Pier("Пирс2, левая сторона. ",9, new Semaphore(1));
    private Pier pier2Right = new Pier("Пирс2, правая сторона. ",7, new Semaphore(1));
    private Pier pier3Left = new Pier("Пирс3, левая сторона. ",12, new Semaphore(1));
    private Pier pier3Right = new Pier("Пирс3, правая сторона. ",10, new Semaphore(1));

    private AbstractQueue<Ship> queue = new ConcurrentLinkedQueue<>();

    public ShipGenerator(int shipsToGenerateCount) {
        this.shipsToGenerateCount = shipsToGenerateCount;
    }

    @Override
    public void run() {

        for (int i = 0; i < shipsToGenerateCount; i++) {
            int randomBoxCount = (int) (Math.random() * 200 + 50);

            if (randomBoxCount < 100) {
                queue.add(new Ship(ShipSize.SMALL,randomBoxCount));
                new Unloader(queue, pier1Left).start();
                new Unloader(queue, pier1Right).start();
            } else if (randomBoxCount < 175) {
                queue.add(new Ship(ShipSize.MEDIUM,randomBoxCount));
                new Unloader(queue, pier2Left).start();
                new Unloader(queue, pier2Right).start();
            } else {
                queue.add(new Ship(ShipSize.BIG,randomBoxCount));
                new Unloader(queue, pier3Left).start();
                new Unloader(queue, pier3Right).start();
            }

            try {
                int randomArrivalInterval = (int) (Math.random() * 5 + 5);
                TimeUnit.SECONDS.sleep(randomArrivalInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
