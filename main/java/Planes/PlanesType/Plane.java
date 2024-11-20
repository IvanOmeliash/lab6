package Planes.PlanesType;

public class Plane {
    protected String model;
    protected int maxSpeed;
    protected int fuelCapacity;
    protected int capacity;
    protected int payload;
    protected int maxRange;

    public Plane(String model, int maxSpeed, int fuelCapacity, int capacity, int payload, int maxRange) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.fuelCapacity = fuelCapacity;
        this.capacity = capacity;
        this.payload = payload;
        this.maxRange = maxRange;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPayload() {
        return payload;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }
}
