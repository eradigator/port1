package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Ship;
import kz.epam.javalab22.entity.ShipSize;

import java.text.SimpleDateFormat;
import java.util.AbstractQueue;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;


public class ShipGenerator {

    private static final String DATE_FORMAT_PATTERN = "hh:mm:ss ";
    private static final String SHIP_HAS_BEEN_CREATED_STRING = "Создан корабль: ";
    private static final String SIZE_STRING = " Размер: ";
    private static final String BOX_COUNT_STRING = " Кол-во коробок: ";

    private static final int SMALL_SHIP_BOX_COUNT_EDGE = 75;
    private static final int MIDDLE_SHIP_BOX_COUNT_EDGE = 150;
    private static final int BIG_SHIP_BOX_COUNT_EDGE = 200;
    private static final int RANDOM_BOX_COUNT_RANGE = 150;
    private static final int RANDOM_BOX_COUNT_LOW_EDGE = 50;

    public AbstractQueue<Ship> generate(int shipsToGenerateCount) {

        AbstractQueue<Ship> queue = new ConcurrentLinkedQueue<>();
        Ship ship = null;

        for (int i = 0; i < shipsToGenerateCount; i++) {
            int randomBoxCount = (int) (Math.random() * RANDOM_BOX_COUNT_RANGE + RANDOM_BOX_COUNT_LOW_EDGE);

            if (randomBoxCount < SMALL_SHIP_BOX_COUNT_EDGE) {
                ship = new Ship(ShipSize.SMALL, randomBoxCount);
                queue.add(ship);
            } else if (randomBoxCount < MIDDLE_SHIP_BOX_COUNT_EDGE) {
                ship = new Ship(ShipSize.MEDIUM, randomBoxCount);
                queue.add(ship);
            } else if (randomBoxCount < BIG_SHIP_BOX_COUNT_EDGE) {
                ship = new Ship(ShipSize.BIG, randomBoxCount);
                queue.add(ship);
            }

            if (ship != null) {
                SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_PATTERN);
                System.out.println(format.format(new Date()) +
                        SHIP_HAS_BEEN_CREATED_STRING + this.hashCode() +
                        SIZE_STRING + ship.getSize() +
                        BOX_COUNT_STRING + ship.getBoxCount());
            }
        }
        return queue;
    }

}
