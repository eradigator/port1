package kz.epam.javalab22.entity;

import java.util.concurrent.Semaphore;

public class Pier {

    private String name;
    private int unloadingSpeed;
    private Semaphore sem;

    public Pier(String name, int unloadingSpeed, int semaphoreThreadsCount) {
        this.unloadingSpeed = unloadingSpeed;
        this.name = name;
        this.sem = new Semaphore(semaphoreThreadsCount);
    }

    public String getName() {
        return name;
    }

    public int getUnloadingSpeed() {
        return unloadingSpeed;
    }

    public Semaphore getSem() {
        return sem;
    }
}
