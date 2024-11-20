package Planes.PlanesType;

public class PublicPlane extends Plane {
    private double ticketPrice;
    private String flightDepTime;

    public PublicPlane(String model, int maxSpeed, int fuelCapacity, int capacity, int payload, int maxRange, double ticketPrice, String flightDepTime) {
        super(model, maxSpeed, fuelCapacity, capacity, payload, maxRange);
        this.ticketPrice = ticketPrice;
        this.flightDepTime = flightDepTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public String getFlightDepTime() {
        return flightDepTime;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setFlightDepTime(String flightDepTime) {
        this.flightDepTime = flightDepTime;
    }

    public double earningFromPlane(){
        return ticketPrice * capacity;
    }
}
