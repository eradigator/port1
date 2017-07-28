package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Ship;

import java.text.SimpleDateFormat;
import java.util.AbstractQueue;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class Unloader extends Thread {

    private Pier pier;
    private AbstractQueue<Ship> queue;

    Unloader(AbstractQueue<Ship> queue, Pier pier) {
        this.queue = queue;
        this.pier = pier;
    }

    @Override
    public void run() {

        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss ");

        try {
            {
                pier.getSem().acquire();

                Ship ship;

                if ((ship = queue.poll()) != null) {
                    long unloadTime = (long) ship.getBoxCount() / pier.getUnloadingSpeed();
                    System.out.println(format.format(new Date()) + pier.getName() +
                            "Разгрузка корабля: " + ship.hashCode() + " началась. " + "Время разгрузки: " + unloadTime);
                    TimeUnit.SECONDS.sleep(unloadTime);

                    System.out.println(format.format(new Date()) + pier.getName() +
                            "Разгрузка корабля: " + ship.hashCode() + " закончилась.");

                    System.out.println(format.format(new Date()) + pier.getName().substring(0,5) + " " +
                            "Количество ожидающих кораблей: " +  pier.getSem().getQueueLength());
                }
                pier.getSem().release();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
