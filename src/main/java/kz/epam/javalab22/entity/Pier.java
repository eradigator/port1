package kz.epam.javalab22.entity;

import java.util.concurrent.Semaphore;

public class Pier {

    private String name;
    private int unloadingSpeed;
    private Semaphore sem = new Semaphore(1);

    public Pier(String name, int unloadingSpeed) {
        this.unloadingSpeed = unloadingSpeed;
        this.name = name;
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
