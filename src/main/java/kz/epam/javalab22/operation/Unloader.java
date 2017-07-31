package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Ship;

import java.text.SimpleDateFormat;
import java.util.AbstractQueue;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Unloader extends Thread {

    private static final String DATE_FORMAT_PATTERN = "hh:mm:ss ";
    private static final String SHIP_UNLOADING_STRING = "Разгрузка корабля: ";
    private static final String BEGAN_STRING = " началась. ";
    private static final String ENDED_STRING = " закончилась.";
    private static final String UNLOAD_TIME_STRING = "Время разгрузки: ";
    private static final String QUEUE_LENGTH_STRING = "Длина очереди: ";
    private static final String SPACE_DIVIDER = " ";
    private static final int START_INDEX_IN_PIER_NAME = 0;
    private static final int END_INDEX_IN_PIER_NAME = 5;

    private Pier pier;
    private AbstractQueue<Ship> queue;
    private Semaphore sem;

    Unloader(AbstractQueue<Ship> queue, Pier pier) {
        this.queue = queue;
        this.pier = pier;
        this.sem = pier.getSem();
    }

    @Override
    public void run() {

        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_PATTERN);

        try {
            {
                sem.acquire();

                Ship ship;

                if ((ship = queue.poll()) != null) {
                    long unloadTime = (long) ship.getBoxCount() / pier.getUnloadingSpeed();
                    System.out.println(format.format(new Date()) + pier.getName() +
                            SHIP_UNLOADING_STRING + ship.hashCode() + SPACE_DIVIDER + ship.getSize() +
                            BEGAN_STRING + UNLOAD_TIME_STRING + unloadTime);
                    TimeUnit.SECONDS.sleep(unloadTime);

                    System.out.println(format.format(new Date()) + pier.getName() +
                            SHIP_UNLOADING_STRING + ship.hashCode() + SPACE_DIVIDER + ship.getSize() +
                            ENDED_STRING);
                }

                sem.release();

                if (sem.hasQueuedThreads()) {
                    System.out.println(format.format(new Date()) +
                            pier.getName().substring(START_INDEX_IN_PIER_NAME, END_INDEX_IN_PIER_NAME) +
                            SPACE_DIVIDER + QUEUE_LENGTH_STRING + (sem.getQueueLength()));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
