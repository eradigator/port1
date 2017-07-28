package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Ship;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class Unloader1 extends Thread {

    private Ship ship;
    private Pier pier;

    ConcurrentLinkedQueue<Ship> queue = new ConcurrentLinkedQueue<>();

    Unloader1(ConcurrentLinkedQueue<Ship> queue, Pier pier) {
        this.queue = queue;
        this.pier = pier;
    }

    @Override
    public void run() {

        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss ");

        try {
            {
                pier.getSem().acquire();

                if ((ship = queue.poll()) != null) {
                    long unloadTime = (long) ship.getBoxCount() / pier.getUnloadingSpeed();
                    System.out.println(format.format(new Date()) + "Пирс1 - правая сторона: " +
                            "Разгрузка корабля: " + ship.hashCode() + " началась. " + "Время разгрузки: " + unloadTime);
                    TimeUnit.SECONDS.sleep(unloadTime);

                    System.out.println(format.format(new Date()) + "Пирс1 - правая сторона: " +
                            "Разгрузка корабля: " + ship.hashCode() +  " закончилась.");
                    pier.getSem().release();
                    System.out.println(format.format(new Date()) +
                            "Количество ожидающих кораблей: " + pier.getSem().getQueueLength());
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
