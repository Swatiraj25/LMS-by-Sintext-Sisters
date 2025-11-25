import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:library.db";  // DB automatically create ho jayegi
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return conn;
    }
}
