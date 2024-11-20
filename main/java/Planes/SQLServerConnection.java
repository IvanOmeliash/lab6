package Planes;

import Planes.PlanesType.*;

import java.sql.*;

public class SQLServerConnection {
    private static final String URL = "jdbc:sqlserver://DESKTOP-OR28MAF;databaseName=Planes;encrypt=false;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
        }
        return connection;
    }

    public static void insertPlane(Plane plane) {
        String sql;

        if (plane instanceof PublicPlane) {
            sql = "INSERT INTO Plane (Model, maxSpeed, fuelCapacity, Capacity, Payload, maxRange, ticketPrice, flightDepTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        } else if (plane instanceof PrivateJet) {
            sql = "INSERT INTO Plane (Model, maxSpeed, fuelCapacity, Capacity, Payload, maxRange, [Owner]) VALUES (?, ?, ?, ?, ?, ?, ?)";
        } else if (plane instanceof CargoPlane) {
        sql = "INSERT INTO Plane (Model, maxSpeed, fuelCapacity, Capacity, Payload, maxRange, numOfEngines, powerOfEngine) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        } else if (plane instanceof MilitaryPlane) {
        sql = "INSERT INTO Plane (Model, maxSpeed, fuelCapacity, Capacity, Payload, maxRange, weaponType, numOfWeapon) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        } else {
            sql = "INSERT INTO Plane (Model, maxSpeed, fuelCapacity, Capacity, Payload, maxRange) VALUES (?, ?, ?, ?, ?, ?)";
        }

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, plane.getModel());
            statement.setDouble(2, plane.getMaxSpeed());
            statement.setDouble(3, plane.getFuelCapacity());
            statement.setDouble(4, plane.getCapacity());
            statement.setDouble(5, plane.getPayload());
            statement.setDouble(6, plane.getMaxRange());

            if (plane instanceof PublicPlane) {
                statement.setDouble(7, ((PublicPlane) plane).getTicketPrice());
                statement.setString(8, ((PublicPlane) plane).getFlightDepTime());
            } else if (plane instanceof PrivateJet) {
                statement.setString(7, ((PrivateJet) plane).getOwner());
            } else if (plane instanceof CargoPlane){
                statement.setInt(7, ((CargoPlane) plane).getNumOfEngines());
                statement.setDouble(8, ((CargoPlane) plane).getPowerOfEngine());
            } else if (plane instanceof MilitaryPlane){
                statement.setString(7, ((MilitaryPlane) plane).getTypeOfWeapon());
                statement.setInt(8, ((MilitaryPlane) plane).getNumOfWeapon());
            }

            statement.executeUpdate();
            System.out.println("Plane inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
