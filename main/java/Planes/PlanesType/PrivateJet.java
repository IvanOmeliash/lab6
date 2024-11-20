package Planes.PlanesType;

public class PrivateJet extends Plane {
    private String owner;

    public PrivateJet(String model, int maxSpeed, int fuelCapacity, int capacity, int payload, int maxRange, String owner) {
        super(model, maxSpeed, fuelCapacity, capacity, payload, maxRange);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean allowToFly(boolean allow){
        return allow;
    }
}
