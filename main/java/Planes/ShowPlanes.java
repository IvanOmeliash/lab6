package Planes;

import Planes.PlanesType.*;

import java.util.ArrayList;

public class ShowPlanes {
    public static void show(ArrayList<Plane> planes){
        for(Plane plane : planes){
            System.out.println("Model: " + plane.getModel());
            System.out.println("Max Speed: " + plane.getMaxSpeed());
            System.out.println("Fuel Capacity: " + plane.getFuelCapacity());
            System.out.println("Capacity: " + plane.getCapacity());
            System.out.println("Payload: " + plane.getPayload());
            System.out.println("MaxRange: " + plane.getMaxRange());

            if(plane instanceof PublicPlane){
                PublicPlane publicPlane = (PublicPlane) plane;
                System.out.println("Ticket Price: " + publicPlane.getTicketPrice());
                System.out.println("Flight Departure time: " + publicPlane.getFlightDepTime());
                System.out.println("-----------------------------------------");
            }
            else if(plane instanceof PrivateJet){
                PrivateJet privateJet = (PrivateJet) plane;
                System.out.println("Owner: " + privateJet.getOwner());
                System.out.println("-----------------------------------------");
            }
            else if(plane instanceof CargoPlane){
                CargoPlane cargoPlane = (CargoPlane) plane;
                System.out.println("Number of Engines: " + cargoPlane.getNumOfEngines());
                System.out.println("Power of an Engine: " + cargoPlane.getPowerOfEngine());
                System.out.println("-----------------------------------------");
            }
            else if(plane instanceof MilitaryPlane){
                MilitaryPlane militaryPlane = (MilitaryPlane) plane;
                System.out.println("Weapon Type: " + militaryPlane.getTypeOfWeapon());
                System.out.println("Number of Weapon: " + militaryPlane.getNumOfWeapon());
                System.out.println("-----------------------------------------");
            }
        }
    }
}
