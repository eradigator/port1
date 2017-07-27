package kz.epam.javalab22.entity;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Ship extends Thread {

    private Semaphore sem;
    private int boxCount;

    public Ship(Semaphore sem, int boxCount) {
        this.sem = sem;
        this.boxCount = boxCount;
        System.out.println("Прибыл корабль: " + this.hashCode() + " Кол-во коробок: " + boxCount);
    }

    public void run() {
        try {
            {
                Pier pier1 = new Pier(8);

                sem.acquire();
                System.out.println("Количество ожидающих кораблей: " + sem.getQueueLength());

                long unloadTime = (long) boxCount / pier1.getUnloadingSpeed();

                System.out.println("Разгрузка корабля: " + this.hashCode() + " началась. " + "Время разгрузки: " + unloadTime);

                TimeUnit.SECONDS.sleep(unloadTime);

                System.out.println("Разгрузка корабля: " + this.hashCode() + " закончилась.");
                sem.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
