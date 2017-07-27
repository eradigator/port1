package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Ship;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ShipGenerator extends Thread{

    private Semaphore sem = new Semaphore(2);

    @Override
    public void run() {

        int shipsToGenerateCount = 10;

        for (int i = 0; i < shipsToGenerateCount; i++) {
            int randomBoxCount = (int) (Math.random() * 100 + 100);
            new Ship(sem, randomBoxCount).start();

            try {
                int randomArrivalInterval = (int) (Math.random() * 10);
                TimeUnit.SECONDS.sleep(randomArrivalInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
