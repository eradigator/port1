package kz.epam.javalab22.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ship {

    private static final String DATE_FORMAT_PATTERN = "hh:mm:ss ";
    private static final String SHIP_HAS_BEEN_CREATED_STRING = "Создан корабль: ";
    private static final String SIZE_STRING = " Размер: ";
    private static final String BOX_COUNT_STRING = " Кол-во коробок: ";

    private int boxCount;
    private ShipSize size;

    public Ship(ShipSize size, int boxCount) {

        this.boxCount = boxCount;
        this.size = size;

        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        System.out.println(format.format(new Date()) +
                SHIP_HAS_BEEN_CREATED_STRING + this.hashCode() +
                SIZE_STRING + size +
                BOX_COUNT_STRING + boxCount);
    }

    public int getBoxCount() {
        return boxCount;
    }

    public ShipSize getSize() {
        return size;
    }

    public void setSize(ShipSize size) {
        this.size = size;
    }
}
