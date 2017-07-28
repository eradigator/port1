package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Ship;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Unloader extends Thread {

    private Ship ship;
    private Pier pier;

    Unloader(Ship ship, Pier pier) {
        this.ship = ship;
        this.pier = pier;
    }

    @Override
    public void run() {

        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss ");

        try {
            {
                pier.getSem().acquire();
                System.out.println(format.format(new Date()) +
                        "Количество ожидающих кораблей: " + pier.getSem().getQueueLength());

                long unloadTime = (long) ship.getBoxCount() / pier.getUnloadingSpeed();
                System.out.println(format.format(new Date()) +
                        "Разгрузка корабля: " + ship.hashCode() + " началась. " + "Время разгрузки: " + unloadTime);
                TimeUnit.SECONDS.sleep(unloadTime);

                System.out.println(format.format(new Date()) +
                        "Разгрузка корабля: " + ship.hashCode() + " закончилась.");
                pier.getSem().release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
