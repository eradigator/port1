package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Ship;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ShipGenerator extends Thread{

    private int shipsToGenerateCount;
    private Pier pier;

    public ShipGenerator(int shipsToGenerateCount, Pier pier) {
        this.shipsToGenerateCount = shipsToGenerateCount;
        this.pier = pier;
    }

    @Override
    public void run() {

        //new PreUnloader().start();

        for (int i = 0; i < shipsToGenerateCount; i++) {
            int randomBoxCount = (int) (Math.random() * 100 + 100);

            new Unloader(new Ship(randomBoxCount),pier).start();

            try {
                int randomArrivalInterval = (int) (Math.random() * 10);
                TimeUnit.SECONDS.sleep(randomArrivalInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
