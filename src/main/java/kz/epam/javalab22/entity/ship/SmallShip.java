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
        System.out.println("Прибыл новый корабль: " +
                this.getClass().getSimpleName() + " " + this.hashCode() +
                " кол-во коробок: " + boxCount);
    }

    public int getBoxCount() {
        return boxCount;
    }

}
