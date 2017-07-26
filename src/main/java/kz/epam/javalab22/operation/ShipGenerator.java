package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.ship.SmallShip;

import java.util.concurrent.TimeUnit;

public class ShipGenerator {

    public static void main(String[] args) {
        new ShipGenerator().generate();
    }

    public void generate() {
        for (int i=0; i<10; i++) {
            int a = (int) (Math.random()* 50 + 50);
            SmallShip smallShip = new SmallShip(a);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(smallShip);

        }
    }
}
