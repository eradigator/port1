package kz.epam.javalab22.entity;

import java.util.concurrent.Semaphore;

public class Pier {

    private int unloadingSpeed;
    private Semaphore sem;

    public Pier(int unloadingSpeed, int concurrentThreadsCount) {
        this.unloadingSpeed = unloadingSpeed;
        this.sem = new Semaphore(concurrentThreadsCount);

    }

    public int getUnloadingSpeed() {
        return unloadingSpeed;
    }

    public Semaphore getSem() {
        return sem;
    }
}
