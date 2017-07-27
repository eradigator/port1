package kz.epam.javalab22.runner;

import kz.epam.javalab22.entity.Ship;

import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);
        for(int i=50;i<60;i++)
            new Ship(sem,i).start();
    }
}
