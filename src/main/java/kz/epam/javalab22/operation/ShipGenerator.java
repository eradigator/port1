package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Ship;
import kz.epam.javalab22.entity.ShipSize;

import java.util.AbstractQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;


public class ShipGenerator extends Thread {

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

    private static final int SMALL_SHIP_BOX_COUNT_EDGE = 100;
    private static final int MIDDLE_SHIP_BOX_COUNT_EDGE = 175;
    private static final int BIG_SHIP_BOX_COUNT_EDGE = 250;
    private static final int RANDOM_BOX_COUNT_RANGE = 200;
    private static final int RANDOM_BOX_COUNT_LOW_EDGE = 50;
    private static final int RANDOM_ARRIVAL_INTERVAL_RANGE = 7;
    private static final int RANDOM_ARRIVAL_INTERVAL_LOW_EDGE = 1;

    private Pier pier1Left = new Pier(PIER1_LEFT_NAME, P1L_UNLOADING_SPEED);
    private Pier pier1Right = new Pier(PIER1_RIGHT_NAME, P1R_UNLOADING_SPEED);
    private Pier pier2Left = new Pier(PIER2_LEFT_NAME, P2L_UNLOADING_SPEED);
    private Pier pier2Right = new Pier(PIER2_RIGHT_NAME, P2R_UNLOADING_SPEED);
    private Pier pier3Left = new Pier(PIER3_LEFT_NAME, P3L_UNLOADING_SPEED);
    private Pier pier3Right = new Pier(PIER3_RIGHT_NAME, P3R_UNLOADING_SPEED);

    private AbstractQueue<Ship> queueS = new ConcurrentLinkedQueue<>();
    private AbstractQueue<Ship> queueM = new ConcurrentLinkedQueue<>();
    private AbstractQueue<Ship> queueB = new ConcurrentLinkedQueue<>();

    private Integer shipsToGenerateCount;

    public ShipGenerator(int shipsToGenerateCount) {
        this.shipsToGenerateCount = shipsToGenerateCount;
    }

    @Override
    public void run() {
        this.generate();
    }

    private void generate() {
        for (int i = 0; i < shipsToGenerateCount; i++) {
            int randomBoxCount = (int) (Math.random() * RANDOM_BOX_COUNT_RANGE + RANDOM_BOX_COUNT_LOW_EDGE);

            if (randomBoxCount < SMALL_SHIP_BOX_COUNT_EDGE) {
                queueS.add(new Ship(ShipSize.SMALL, randomBoxCount));
                new Unloader(queueS, pier1Left).start();
                new Unloader(queueS, pier1Right).start();
            } else if (randomBoxCount < MIDDLE_SHIP_BOX_COUNT_EDGE) {
                queueM.add(new Ship(ShipSize.MEDIUM, randomBoxCount));
                new Unloader(queueM, pier2Left).start();
                new Unloader(queueM, pier2Right).start();
            } else if (randomBoxCount < BIG_SHIP_BOX_COUNT_EDGE) {
                queueB.add(new Ship(ShipSize.BIG, randomBoxCount));
                new Unloader(queueB, pier3Left).start();
                new Unloader(queueB, pier3Right).start();
            }

            try {
                int randomArrivalInterval = (int) (Math.random() * RANDOM_ARRIVAL_INTERVAL_RANGE +
                        RANDOM_ARRIVAL_INTERVAL_LOW_EDGE);
                TimeUnit.SECONDS.sleep(randomArrivalInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
