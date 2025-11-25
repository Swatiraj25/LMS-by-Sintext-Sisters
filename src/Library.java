import java.sql.*;
import java.util.Scanner;

public class Library {

    public boolean addBook() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Book Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            Connection conn = Database.connect();

            String sql = "INSERT INTO books(name, author, quantity) VALUES(?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, name);
            stmt.setString(2, author);
            stmt.setInt(3, qty);

            stmt.executeUpdate();
            System.out.println("Book Added Successfully.");
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void displayBooks() {
        try {
            Connection conn = Database.connect();
            String sql = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("----- All Books -----");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("author") + " | Qty: " +
                        rs.getInt("quantity")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean deleteBook(int id) {
        try {
            Connection conn = Database.connect();
            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String issueBook(int id, String student) {
        try {
            Connection conn = Database.connect();

            String check = "SELECT quantity FROM books WHERE id=?";
            PreparedStatement chk = conn.prepareStatement(check);
            chk.setInt(1, id);
            ResultSet rs = chk.executeQuery();

            if (!rs.next()) return "Book not found!";
            int qty = rs.getInt("quantity");
            if (qty <= 0) return "Book out of stock!";

            conn.createStatement().execute(
                    "INSERT INTO issue_records(book_id, student_name, issue_date) VALUES("
                            + id + ", '" + student + "', date('now'))"
            );

            conn.createStatement().execute(
                    "UPDATE books SET quantity = quantity - 1 WHERE id=" + id
            );

            return "Book issued successfully to " + student;

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String returnBook(int recordId) {
        try {
            Connection conn = Database.connect();

            String sql = "SELECT book_id FROM issue_records WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, recordId);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) return "Issue record not found!";
            int bookId = rs.getInt("book_id");

            conn.createStatement().execute(
                    "UPDATE issue_records SET return_date=date('now') WHERE id=" + recordId
            );

            conn.createStatement().execute(
                    "UPDATE books SET quantity = quantity + 1 WHERE id=" + bookId
            );

            return "Book returned successfully.";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void showIssuedBooks() {
        try {
            Connection conn = Database.connect();
            String sql = "SELECT * FROM issue_records";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            System.out.println("----- Issued Books -----");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | Book ID: " +
                        rs.getInt("book_id") + " | Student: " +
                        rs.getString("student_name") + " | Issue: " +
                        rs.getString("issue_date") + " | Return: " +
                        rs.getString("return_date")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int totalBooksCount() {
        try {
            Connection conn = Database.connect();
            String sql = "SELECT COUNT(*) AS total FROM books";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            return rs.getInt("total");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public boolean updateBook(int id, String newName, String newAuthor, int newQty) {
        try {
            Connection conn = Database.connect();

            String sql = "UPDATE books SET name=?, author=?, quantity=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, newName);
            stmt.setString(2, newAuthor);
            stmt.setInt(3, newQty);
            stmt.setInt(4, id);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
