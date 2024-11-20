package Planes.PlanesType;

public class CargoPlane extends Plane {
    private int numOfEngines;
    private double powerOfEngine;

    public CargoPlane(String model, int maxSpeed, int fuelCapacity, int capacity, int payload, int maxRange, int numOfEngines, double powerOfEngine) {
        super(model, maxSpeed, fuelCapacity, capacity, payload, maxRange);
        this.numOfEngines = numOfEngines;
        this.powerOfEngine = powerOfEngine;
    }

    public int getNumOfEngines() {
        return numOfEngines;
    }

    public double getPowerOfEngine() {
        return powerOfEngine;
    }

    public void setNumOfEngines(int numOfEngines) {
        this.numOfEngines = numOfEngines;
    }

    public void setPowerOfEngine(double powerOfEngine) {
        this.powerOfEngine = powerOfEngine;
    }

    public double totalPower(){
        return numOfEngines * powerOfEngine;
    }
}
