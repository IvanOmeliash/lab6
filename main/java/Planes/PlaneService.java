package Planes;

import Planes.PlanesType.*;

import java.util.*;

public class PlaneService {

    public static void totalPayload() {
        int totalPayload = PlaneDao.SQLtotalPayload();

        if (totalPayload > 0) {
            System.out.println("Total Payload of all planes is: " + totalPayload);
        } else {
            System.out.println("No planes found or payload data is zero.");
        }
    }

    public static void totalCapacity(){
        int totalCapacity = PlaneDao.SQLtotalCapacity();

        if (totalCapacity > 0) {
            System.out.println("Total Capacity of all planes is: " + totalCapacity);
        } else {
            System.out.println("No planes found or capacity data is zero.");
        }
    }

    public static void deletePlane(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter model to delete: ");
        String modelDelete = scan.nextLine();

        int rowsAffected = PlaneDao.SQLDeletePlane(modelDelete);

        if (rowsAffected > 0){
            System.out.println("Successful delete!");
        }
        else {
            System.out.println("Not found model to delete");
        }
    }

    public static void findPlaneByFuel() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter min fuel: ");
        int minFuel = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter max fuel: ");
        int maxFuel = scan.nextInt();
        scan.nextLine();

        ArrayList<Plane> planes = PlaneDao.SQLfindByFuel(minFuel, maxFuel);
        if (planes != null) {
            ShowPlanes.show(planes);
        }
    }


    public static void sortByRange(){
        ArrayList<Plane> planes = PlaneDao.SQLsortByRange();
        if (planes != null) {
            ShowPlanes.show(planes);
        }
    }

    public static void showPlanes(){
        ArrayList<Plane> planes = PlaneDao.SQLshowPlanes();
        if (planes != null) {
            ShowPlanes.show(planes);
        }
    }

    public static void addPlane(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter type of plane ");
        System.out.println("1. Public plane ");
        System.out.println("2. Private Jet ");
        System.out.println("3. Cargo Plane ");
        System.out.println("4. Military Plane ");
        int choice = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter model: ");
        String model = scan.nextLine();

        System.out.println("Enter max speed: ");
        int maxSpeed = scan.nextInt();
        scan.nextLine();

        System.out.println("Виберіть fuel capacity: ");
        int fuelCapacity = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter capacity: ");
        int Capacity = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter payload: ");
        int Payload = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter max range of flight: ");
        int maxRange = scan.nextInt();
        scan.nextLine();

        Plane plane = null;

        switch (choice){
            case 1:
                System.out.println("Enter ticket price: ");
                double ticketPrice = scan.nextDouble();
                scan.nextLine();

                System.out.println("Enter flight departure time: ");
                String flightDepTime = scan.nextLine();

                plane = new PublicPlane(model, maxSpeed, fuelCapacity, Capacity, Payload, maxRange, ticketPrice, flightDepTime);
                break;

            case 2:
                System.out.println("Enter owner of the plane: ");
                String Owner = scan.nextLine();

                plane = new PrivateJet(model, maxSpeed, fuelCapacity, Capacity, Payload, maxRange, Owner);
                break;

            case 3:
                System.out.println("Enter number of engines: ");
                int numOfEngines = scan.nextInt();
                scan.nextLine();

                System.out.println("Enter power of an engine: ");
                double powerOfEngine = scan.nextDouble();
                scan.nextLine();

                plane = new CargoPlane(model, maxSpeed, fuelCapacity, Capacity, Payload, maxRange, numOfEngines, powerOfEngine);
                break;

            case 4:
                System.out.println("Enter weapon type: ");
                String weaponType = scan.nextLine();

                System.out.println("Enter number of weapon: ");
                int numOfWeapon = scan.nextInt();
                scan.nextLine();

                plane = new MilitaryPlane(model, maxSpeed, fuelCapacity, Capacity, Payload, maxRange, weaponType, numOfWeapon);
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
        SQLServerConnection.insertPlane(plane);
        System.out.println("Successful inserting plane");
    }

}
