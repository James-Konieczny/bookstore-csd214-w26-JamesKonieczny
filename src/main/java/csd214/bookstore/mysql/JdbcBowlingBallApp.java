package csd214.bookstore.mysql;

import csd214.bookstore.pojos.BowlingBall;
import java.sql.*;
import java.util.UUID;

public class JdbcBowlingBallApp {
    private static final String URL = "jdbc:mysql://localhost:3333/bookstore";
    private static final String USER = "csd214";
    private static final String PASS = "itstudies12345";
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            // 1. Create Table
            createTable(conn);
            // 2. Insert
            System.out.println("--- INSERTING ---");
            BowlingBall bb = new BowlingBall(UUID.randomUUID().toString(), "BowlingSupply", 269.20, "Motive", true, "Advanced", 15, "Blue", "Reactive Resin", "Asymmetrical");
            insertBowlingBall(conn, bb);
            // 3. Read
            System.out.println("--- READING ---");
            listBowlingBall(conn);
            // 4. Update
            System.out.println("--- UPDATING ---");
            updateBowlingBallPrice(conn, "BowlingSupply", 240.42);

            // 5. Delete
            System.out.println("--- DELETING ---");
            deleteBowlingBall(conn, "BowlingSupply");
            listBowlingBall(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS BowlingBalls (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "ProductID VARCHAR(50), " +
                "Name VARCHAR(100) NOT NULL, " +
                "Price DECIMAL(10,2) NOT NULL, " +
                "Brand VARCHAR(100), " +
                "MaintenanceRequired BOOLEAN NOT NULL, " +
                "SkillLevel VARCHAR(50), " +
                "Weight INT NOT NULL CHECK (Weight BETWEEN 6 AND 16), " +
                "Color VARCHAR(50), " +
                "Coverstock VARCHAR(50), " +
                "Core VARCHAR(50) )";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'BowlingBalls' ready.");
        }
    }
    private static void insertBowlingBall(Connection conn, BowlingBall b) throws SQLException {
        // SECURITY: Use ? to prevent SQL Injection
        String sql = "INSERT INTO BowlingBalls (ProductID, Name, Price, Brand, MaintenanceRequired, SkillLevel, Weight, Color, Coverstock, Core) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getProductId()); // UUID
            ps.setString(2, b.getName());
            ps.setDouble(3, b.getPrice());

            ps.setString(4, b.getBrand());
            ps.setBoolean(5, b.isMaintenanceRequired());
            ps.setString(6, b.getSkillLevel());

            ps.setInt(7, b.getWeight());
            ps.setString(8, b.getColor());
            ps.setString(9, b.getCoverstock());
            ps.setString(10, b.getCore());
            ps.executeUpdate();
            System.out.println("Saved: " + b.getName() + "(" + b.getWeight() + "lbs, " + b.getColor() + " Ball).");
        }
    }
    private static void listBowlingBall(Connection conn) throws SQLException {
        String sql = "SELECT * FROM BowlingBalls";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | UUID: %s | Name: %s | Price: $%.2f%n | Brand: %s | Maintenance Required: %b | Skill Level: %s | Weight: %d | Color: %s | Coverstock: %s | Core: %s",
                        rs.getInt("id"),
                        rs.getString("ProductID"),
                        rs.getString("Name"),
                        rs.getDouble("Price"),
                        rs.getString("Brand"),
                        rs.getBoolean("MaintenanceRequired"),
                        rs.getString("SkillLevel"),
                        rs.getInt("Weight"),
                        rs.getString("Color"),
                        rs.getString("Coverstock"),
                        rs.getString("Core"));
            }
        }
    }
    private static void updateBowlingBallPrice(Connection conn, String name, double newPrice) throws SQLException {
        String sql = "UPDATE BowlingBalls SET Price = ? WHERE Name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newPrice);
            ps.setString(2, name);
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " Bowling Ball(s).");
        }
    }

    private static void deleteBowlingBall(Connection conn, String name) throws SQLException {
        String sql = "DELETE FROM BowlingBalls WHERE Name = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            int rows = ps.executeUpdate();
            System.out.println("Deleted " + rows + " Bowling Ball(s) named '" + name + "'.");
        }
    }
}
