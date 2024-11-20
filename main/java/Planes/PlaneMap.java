package Planes;

import Planes.PlanesType.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaneMap {
    public static ArrayList<Plane> mapArray(ResultSet resultSet) throws SQLException {
        ArrayList<Plane> planes = new ArrayList<>();
        while (resultSet.next()) {
            String model = resultSet.getString("Model");
            int maxSpeed = resultSet.getInt("maxSpeed");
            int fuelCapacity = resultSet.getInt("fuelCapacity");
            int capacity = resultSet.getInt("Capacity");
            int payload = resultSet.getInt("Payload");
            int maxRange = resultSet.getInt("maxRange");
            double ticketPrice = resultSet.getDouble("ticketPrice");
            String flightDepTime = resultSet.getString("flightDepTime");
            String owner = resultSet.getString("Owner");
            int numOfEngines = resultSet.getInt("numOfEngines");
            double powerOfEngine = resultSet.getDouble("powerOfEngine");
            String weaponType = resultSet.getString("weaponType");
            int numOfWeapon = resultSet.getInt("numOfWeapon");

            Plane plane = null;

            if (ticketPrice > 0) {
                plane = new PublicPlane(model, maxSpeed, fuelCapacity, capacity, payload, maxRange, ticketPrice, flightDepTime);
            } else if (owner != null && !owner.isEmpty()) {
                plane = new PrivateJet(model, maxSpeed, fuelCapacity, capacity, payload, maxRange, owner);
            } else if (numOfEngines > 0 && powerOfEngine > 0) {
                plane = new CargoPlane(model, maxSpeed, fuelCapacity, capacity, payload, maxRange, numOfEngines, powerOfEngine);
            } else if (weaponType != null && numOfWeapon > 0) {
                plane = new MilitaryPlane(model, maxSpeed, fuelCapacity, capacity, payload, maxRange, weaponType, numOfWeapon);
            }

            if (plane != null) {
                planes.add(plane);
            }
        }
        return planes;
    }
}
