package kz.epam.javalab22.entity.ship;

public class SmallShip {

    private int boxCount;

    @Override
    public String toString() {
        return "SmallShip{" +
                "boxCount=" + boxCount +
                '}';
    }

    public SmallShip(int boxCount) {
        this.boxCount = boxCount;
    }

    public int getBoxCount() {
        return boxCount;
    }

    public void setBoxCount(int boxCount) {
        this.boxCount = boxCount;
    }
}
