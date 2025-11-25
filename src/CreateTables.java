import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {
    public static void main(String[] args) {
        try {
            Connection conn = Database.connect();
            Statement stmt = conn.createStatement();

            // Books table
            stmt.execute(
                "CREATE TABLE IF NOT EXISTS books (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, " +
                "author TEXT, " +
                "isbn TEXT, " +
                "available INTEGER)"
            );

            // Issue Records table
            stmt.execute(
                "CREATE TABLE IF NOT EXISTS issue_records (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "book_id INTEGER, " +
                "student_name TEXT, " +
                "issue_date TEXT, " +
                "return_date TEXT)"
            );

            System.out.println("Tables Created Successfully!");

        } catch (Exception e) {
            System.out.println("Table Creation Error: " + e.getMessage());
        }
    }
}
