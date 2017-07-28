package kz.epam.javalab22.operation;

import kz.epam.javalab22.entity.Pier;
import kz.epam.javalab22.entity.Ship;

public class PreUnloader extends Thread {


    @Override
    public void run() {
        new Unloader(new Ship(50),new Pier(6,1)).start();
        new Unloader(new Ship(50),new Pier(6,1)).start();
    }


}
