package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Ship;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class PreUnloader extends Thread {

    private Semaphore sem = new Semaphore(2);

    PreUnloader(ConcurrentLinkedQueue<Ship> queue, Pier pier1, Pier pier2) {
        new Unloader(queue, pier1).start();
        //new Unloader1(queue, pier2).start();
    }

    @Override
    public void run() {
        try {
            {
                sem.acquire();
                sem.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
