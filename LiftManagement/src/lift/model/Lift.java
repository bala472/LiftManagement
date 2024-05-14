package lift.model;

import java.util.ArrayList;
import java.util.List;

public class Lift {
    private String name;
    private int currentFloor;
    private int capacity;
    private int destination;
    private List<Integer> access = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public List<Integer> getAccess() {
        return access;
    }

    public void setAccess(List<Integer> access) {
        this.access = access;
    }

}
