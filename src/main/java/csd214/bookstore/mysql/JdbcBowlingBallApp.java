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
            BowlingBall b1 = new BowlingBall(
                    15,
                    "Purple/Orange",
                    252.99,
                    42);
            insertBowlingBall(conn, b1);
            // 3. Read
            System.out.println("--- READING ---");
            listBowlingBalls(conn);
            // 4. Update
            System.out.println("--- UPDATING ---");
            updateBowlingBallPrice(conn, 1, 205.50);

            // 5. Delete
            System.out.println("--- DELETING ---");
            deleteBowlingBall(conn, 1);
            listBowlingBalls(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String sql = // not inserting, so concatenation is ok here?
                "CREATE TABLE IF NOT EXISTS BowlingBalls (" +
                    "BallId INT AUTO_INCREMENT PRIMARY KEY, " +
                    "WeightLbs INT NOT NULL, " +
                    "Color VARCHAR(50), " +
                    "Price DECIMAL(8,2) NOT NULL, " +
                    "Copies INT NOT NULL" +
                    ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'BowlingBalls' ready.");
        }
    }

    private static void insertBowlingBall(Connection conn, BowlingBall b) throws SQLException {
        // SECURITY: Use ? to prevent SQL Injection
        String sql = "INSERT INTO BowlingBalls (WeightLbs, Color, Price, Copies) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, b.getWeight());
            ps.setString(2, b.getColor());
            ps.setDouble(3, b.getPrice());
            ps.setInt(4, b.getCopies());
            ps.executeUpdate();
            System.out.println("Saved: " + b.getColor() + " Bowling Ball");
        }
    }
    private static void listBowlingBalls(Connection conn) throws SQLException {
        String sql = "SELECT * FROM BowlingBalls";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | Weight: %d lbs | Color: %s | Price: $%.2f%n | Copies: %d%n",
                        rs.getInt("BallId"),
                        rs.getInt("WeightLbs"),
                        rs.getString("Color"),
                        rs.getDouble("Price"),
                        rs.getInt("Copies"));
            }
        }
    }
    private static void updateBowlingBallPrice(Connection conn, int BallId, double newPrice) throws SQLException {
        String sql = "UPDATE BowlingBalls SET Price = ? WHERE BallId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newPrice);
            ps.setInt(2, BallId);
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " bowling ball(s).");
        }
    }

    private static void deleteBowlingBall(Connection conn, int BallId) throws SQLException {
        String sql = "DELETE FROM BowlingBalls WHERE BallId = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, BallId);
            ps.executeUpdate();
            System.out.println("Deleted bowling ball id: " + BallId);
        }
    }
}