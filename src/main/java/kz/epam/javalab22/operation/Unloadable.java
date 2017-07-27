package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.ShipList;
import kz.epam.javalab22.entity.ship.SmallShip;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Unloadable implements Callable<String> {

    @Override
    public String call() throws Exception {

        SmallShip smallShip = ShipList.getShip();

        if (smallShip != null) {

            System.out.println("Разгрузка " + smallShip.hashCode() + " началась...");
            long unloadTime = (long) smallShip.getBoxCount() / 10;
            System.out.println("Время разгрузки: " + unloadTime + " ceк");
            try {
                TimeUnit.SECONDS.sleep(unloadTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Разгрузка завершена.");
        }

        return "finished";

    }
}
