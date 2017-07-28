package kz.epam.javalab22.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ship {

    private int boxCount;

    public Ship(int boxCount) {

        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss ");

        this.boxCount = boxCount;
        System.out.println(format.format(new Date()) +
                "Прибыл корабль: " + this.hashCode() + " Кол-во коробок: " + boxCount);
    }

    public int getBoxCount() {
        return boxCount;
    }

}
