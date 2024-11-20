package Planes.PlanesType;

public class MilitaryPlane extends Plane {
    private String typeOfWeapon;
    private int numOfWeapon;

    public MilitaryPlane(String model, int maxSpeed, int fuelCapacity, int capacity, int payload, int maxRange, String typeOfWeapon, int numOfWeapon) {
        super(model, maxSpeed, fuelCapacity, capacity, payload, maxRange);
        this.typeOfWeapon = typeOfWeapon;
        this.numOfWeapon = numOfWeapon;
    }

    public String getTypeOfWeapon() {
        return typeOfWeapon;
    }

    public int getNumOfWeapon() {
        return numOfWeapon;
    }

    public void setTypeOfWeapon(String typeOfWeapon) {
        this.typeOfWeapon = typeOfWeapon;
    }

    public void setNumOfWeapon(int numOfWeapon) {
        this.numOfWeapon = numOfWeapon;
    }

    public void deployWeapon(int maxWeapon){
        if (numOfWeapon < maxWeapon){
            numOfWeapon = maxWeapon;
        }
    }
}
