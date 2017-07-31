package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Ship;
import kz.epam.javalab22.entity.ShipSize;
import java.util.AbstractQueue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class ShipGenerator {

    private static final int SMALL_SHIP_BOX_COUNT_EDGE = 100;
    private static final int MIDDLE_SHIP_BOX_COUNT_EDGE = 175;
    private static final int BIG_SHIP_BOX_COUNT_EDGE = 250;
    private static final int RANDOM_BOX_COUNT_RANGE = 200;
    private static final int RANDOM_BOX_COUNT_LOW_EDGE = 50;


    public AbstractQueue<Ship> generate(int shipsToGenerateCount) {

        AbstractQueue<Ship> queue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < shipsToGenerateCount; i++) {
            int randomBoxCount = (int) (Math.random() * RANDOM_BOX_COUNT_RANGE + RANDOM_BOX_COUNT_LOW_EDGE);
            if (randomBoxCount < SMALL_SHIP_BOX_COUNT_EDGE) {
                queue.add(new Ship(ShipSize.SMALL, randomBoxCount));
            } else if (randomBoxCount < MIDDLE_SHIP_BOX_COUNT_EDGE) {
                queue.add(new Ship(ShipSize.MEDIUM, randomBoxCount));
            } else if (randomBoxCount < BIG_SHIP_BOX_COUNT_EDGE) {
                queue.add(new Ship(ShipSize.BIG, randomBoxCount));
            }
        }
        return queue;
    }

}
