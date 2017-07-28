package kz.epam.javalab22.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ship {

    private int boxCount;
    private ShipSize size;

    public Ship(ShipSize size, int boxCount) {

        this.boxCount = boxCount;
        this.size = size;

        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss ");
        System.out.println(format.format(new Date()) +
                "Прибыл корабль: " + this.hashCode() +
                " Размер: " + size +
                " Кол-во коробок: " + boxCount);
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
