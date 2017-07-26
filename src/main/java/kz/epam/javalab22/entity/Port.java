package kz.epam.javalab22.entity;

import java.util.ArrayList;
import java.util.List;

public class Port {

    List<Pier> pierList = new ArrayList<>();

    public List<Pier> getPierList() {
        return pierList;
    }

    public void setPierList(List<Pier> pierList) {
        this.pierList = pierList;
    }
}
