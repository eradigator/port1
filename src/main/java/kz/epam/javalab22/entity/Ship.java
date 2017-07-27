package kz.epam.javalab22.entity;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Ship extends Thread {

    private Semaphore sem;
    private int boxCount;

    public Ship(Semaphore sem, int boxCount) {
        this.sem = sem;
        this.boxCount = boxCount;
    }

    public void run() {
        try {
            {
                sem.acquire();

                long unloadTime = (long) boxCount / 10;

                System.out.println("Разгрузка корабля: " + this.hashCode() + " началась. " +
                        "Время разгрузки: " + unloadTime);
                TimeUnit.SECONDS.sleep(unloadTime);
                System.out.println("Разгрузка корабля: " + this.hashCode() + " закончилась.");
                sem.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
