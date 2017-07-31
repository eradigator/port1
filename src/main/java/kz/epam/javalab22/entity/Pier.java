package kz.epam.javalab22.entity;

import java.util.concurrent.Semaphore;

public class Pier {

    private static final int SEMAPHORE_PERMITS_COUNT = 1;

    private String name;
    private int unloadingSpeed;
    private Semaphore sem;

    public Pier(String name, int unloadingSpeed) {
        this.unloadingSpeed = unloadingSpeed;
        this.name = name;
        this.sem = new Semaphore(SEMAPHORE_PERMITS_COUNT);
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
