package kz.epam.javalab22.runner;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.ship.SmallShip;
import kz.epam.javalab22.operation.ShipGenerator;
import kz.epam.javalab22.operation.ShipUnload;
import kz.epam.javalab22.operation.Unloadable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Hello world!
 */
public class Runner1 {
    public static void main(String[] args) {

        System.out.println("Главный поток начал работу");

        /*SmallShip ship1 = new SmallShip(50);
        SmallShip ship2 = new SmallShip(40);
        Pier pier1 = new Pier(10);*/

        /*ShipUnload unloader = new ShipUnload();*/

        List<Future<String>> list = new ArrayList<>();

        ShipGenerator generator = new ShipGenerator();

        generator.start();
        try {
            generator.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        ExecutorService ex = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            list.add(ex.submit(new Unloadable()));
            //ex.execute(new ShipUnload());
        }
        ex.shutdown();

        for
                (Future<String> future : list) {
            try {
                System.out.println(future.get() + " result fixed");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Главный поток завершил работу");

    }
}
