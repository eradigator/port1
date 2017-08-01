package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Ship;
import kz.epam.javalab22.entity.ShipSize;

import java.text.SimpleDateFormat;
import java.util.AbstractQueue;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Dispatcher extends Thread {

    private final String PIER1_LEFT_NAME = "Пирс1, левая сторона. ";
    private final String PIER1_RIGHT_NAME = "Пирс1, правая сторона. ";
    private final String PIER2_LEFT_NAME = "Пирс2, левая сторона. ";
    private final String PIER2_RIGHT_NAME = "Пирс2, правая сторона. ";
    private final String PIER3_LEFT_NAME = "Пирс3, левая сторона. ";
    private final String PIER3_RIGHT_NAME = "Пирс3, правая сторона. ";



    private final int P1L_UNLOADING_SPEED = 2;
    private final int P1R_UNLOADING_SPEED = 1;
    private final int P2L_UNLOADING_SPEED = 5;
    private final int P2R_UNLOADING_SPEED = 4;
    private final int P3L_UNLOADING_SPEED = 8;
    private final int P3R_UNLOADING_SPEED = 10;

    private static final String ARRIVED_TO_DISPATCHER_STRING = "Прибыл в диспетчерскую";
    private static final String SPACE_DIVIDER = " ";
    private static final int RANDOM_ARRIVAL_INTERVAL_RANGE = 5;
    private static final int RANDOM_ARRIVAL_INTERVAL_LOW_EDGE = 1;

    private Pier pier1Left = new Pier(PIER1_LEFT_NAME, P1L_UNLOADING_SPEED);
    private Pier pier1Right = new Pier(PIER1_RIGHT_NAME, P1R_UNLOADING_SPEED);
    private Pier pier2Left = new Pier(PIER2_LEFT_NAME, P2L_UNLOADING_SPEED);
    private Pier pier2Right = new Pier(PIER2_RIGHT_NAME, P2R_UNLOADING_SPEED);
    private Pier pier3Left = new Pier(PIER3_LEFT_NAME, P3L_UNLOADING_SPEED);
    private Pier pier3Right = new Pier(PIER3_RIGHT_NAME, P3R_UNLOADING_SPEED);

    private AbstractQueue<Ship> queue = new ConcurrentLinkedQueue<>();
    private AbstractQueue<Ship> queueS = new ConcurrentLinkedQueue<>();
    private AbstractQueue<Ship> queueM = new ConcurrentLinkedQueue<>();
    private AbstractQueue<Ship> queueB = new ConcurrentLinkedQueue<>();

    private static final String DATE_FORMAT_PATTERN = "hh:mm:ss ";
    private SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_PATTERN);


    public Dispatcher(AbstractQueue<Ship> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Ship ship;

        while (!queue.isEmpty()) {

            ship = queue.poll();

            switch (ship.getSize()) {
                case SMALL:
                    queueS.add(ship);

                    System.out.println(format.format(new Date()) + ship.hashCode() + SPACE_DIVIDER +
                            ship.getSize() + SPACE_DIVIDER + ARRIVED_TO_DISPATCHER_STRING);
                    new PierUnloader(queueS, pier1Left).start();
                    new PierUnloader(queueS, pier1Right).start();
                    break;
                case MEDIUM:
                    queueM.add(ship);
                    System.out.println(format.format(new Date()) + ship.hashCode() + SPACE_DIVIDER +
                            ship.getSize() + SPACE_DIVIDER + ARRIVED_TO_DISPATCHER_STRING);
                    new PierUnloader(queueM, pier2Left).start();
                    new PierUnloader(queueM, pier2Right).start();
                    break;
                case BIG:
                    queueB.add(ship);
                    System.out.println(format.format(new Date()) + ship.hashCode() + SPACE_DIVIDER +
                            ship.getSize() + SPACE_DIVIDER + ARRIVED_TO_DISPATCHER_STRING);
                    new PierUnloader(queueB, pier3Left).start();
                    new PierUnloader(queueB, pier3Right).start();
                    break;
            }

            sleep();
        }
    }

    private void sleep() {
        int randomArrivalInterval = (int) (Math.random() * RANDOM_ARRIVAL_INTERVAL_RANGE +
                RANDOM_ARRIVAL_INTERVAL_LOW_EDGE);
        try {
            TimeUnit.SECONDS.sleep(randomArrivalInterval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


