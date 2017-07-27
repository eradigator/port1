package kz.epam.javalab22.entity;

import kz.epam.javalab22.entity.ship.SmallShip;

import java.util.ArrayDeque;

public class ShipList {

    private static ArrayDeque<SmallShip> list = new ArrayDeque<>();

    public static SmallShip getShip() {
        return list.poll();
    }

    public static ArrayDeque<SmallShip> getList() {
        return list;
    }
}
