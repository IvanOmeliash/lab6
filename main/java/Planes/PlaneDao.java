package Planes;

import Planes.PlanesType.Plane;

import java.sql.*;
import java.util.ArrayList;

import static Planes.SQLServerConnection.getConnection;

public class PlaneDao {
    public static int SQLtotalPayload(){
        String sql = "SELECT SUM(Payload) AS TotalPayload FROM Plane";
        int total = 0;

        try (Connection conn = getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            if (resultSet.next()) {
                total = resultSet.getInt("TotalPayload");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static int SQLtotalCapacity(){
        String sql = "SELECT SUM(Capacity) AS TotalCapacity FROM Plane";
        int totalCapacity = 0;

        try (Connection conn = getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            if (resultSet.next()) {
                totalCapacity = resultSet.getInt("TotalCapacity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalCapacity;
    }

    public static int SQLDeletePlane(String modelDelete){
        String sql = "DELETE FROM Plane WHERE model = ?";
        int rowsAffected = 0;

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, modelDelete);

            rowsAffected = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    public static ArrayList<Plane> SQLfindByFuel(int minFuel, int maxFuel){
        String sql = "SELECT * FROM Plane WHERE fuelCapacity BETWEEN ? AND ?";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, minFuel);
            statement.setInt(2, maxFuel);

            try (ResultSet resultSet = statement.executeQuery()) {
                return PlaneMap.mapArray(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Plane> SQLsortByRange(){
        String sql = "SELECT * FROM Plane\n" +
                "ORDER BY maxRange ASC";

        try (Connection conn = getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            return PlaneMap.mapArray(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Plane> SQLshowPlanes(){
        String sql = "SELECT * FROM Plane";

        try (Connection conn = getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            return PlaneMap.mapArray(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
