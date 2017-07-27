package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.ShipList;
import kz.epam.javalab22.entity.ship.SmallShip;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShipGenerator extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 50 + 50);
            ShipList.getList().add(new SmallShip(a));

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
