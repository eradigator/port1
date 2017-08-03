package kz.epam.javalab22.entity;

public class Ship {

    private int boxCount;
    private ShipSize size;

    public Ship(ShipSize size, int boxCount) {
        this.boxCount = boxCount;
        this.size = size;
    }

    public int getBoxCount() {
        return boxCount;
    }

    public void setBoxCount(int boxCount) {
        this.boxCount = boxCount;
    }

    public ShipSize getSize() {
        return size;
    }
}
