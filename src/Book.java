// Main.java
// Menu-driven program. Ye program user se input lega aur Library methods call karega.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            showMenu();
            System.out.print("Enter choice: ");
            int ch;
            try {
                ch = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (ch) {
                case 1:
                    // Add Book
                    try {
                        System.out.print("Enter Book ID (integer): ");
                        int id = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Enter Book Name: ");
                        String name = sc.nextLine().trim();

                        System.out.print("Enter Author Name: ");
                        String author = sc.nextLine().trim();

                        System.out.print("Enter Quantity: ");
                        int qty = Integer.parseInt(sc.nextLine().trim());

                        Book b = new Book(id, name, author, qty);
                        boolean added = lib.addBook(b);
                        if (added) System.out.println("Book added successfully.");
                        else System.out.println("Book with this ID already exists!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. ID and Quantity should be numbers.");
                    }
                    break;

                case 2:
                    // Display Books
                    lib.displayBooks();
                    break;

                case 3:
                    // Search Book
                    try {
                        System.out.print("Enter Book ID to search: ");
                        int sid = Integer.parseInt(sc.nextLine().trim());
                        Book found = lib.searchBook(sid);
                        if (found != null) System.out.println("Found: " + found);
                        else System.out.println("Book not found!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                    break;

                case 4:
                    // Delete Book
                    try {
                        System.out.print("Enter Book ID to delete: ");
                        int did = Integer.parseInt(sc.nextLine().trim());
                        boolean deleted = lib.deleteBook(did);
                        if (deleted) System.out.println("Book deleted successfully.");
                        else System.out.println("Book not found!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                    break;

                case 5:
                    // Issue Book
                    try {
                        System.out.print("Enter Book ID to issue: ");
                        int iid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Enter Student Name: ");
                        String student = sc.nextLine().trim();
                        String res = lib.issueBook(iid, student);
                        System.out.println(res);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                    break;

                case 6:
                    // Return Book
                    try {
                        System.out.print("Enter Book ID to return: ");
                        int rid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Enter Student Name (same as issued): ");
                        String sname = sc.nextLine().trim();
                        String rres = lib.returnBook(rid, sname);
                        System.out.println(rres);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                    break;

                case 7:
                    // Show Issued Books
                    lib.showIssuedBooks();
                    break;

                case 8:
                    // Total Books Count
                    System.out.println("Total distinct book entries: " + lib.totalBooksCount());
                    break;

                case 9:
                    // Update Book
                    try {
                        System.out.print("Enter Book ID to update: ");
                        int uid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Enter new Name: ");
                        String nn = sc.nextLine().trim();
                        System.out.print("Enter new Author: ");
                        String na = sc.nextLine().trim();
                        System.out.print("Enter new Quantity: ");
                        int nq = Integer.parseInt(sc.nextLine().trim());
                        boolean upd = lib.updateBook(uid, nn, na, nq);
                        if (upd) System.out.println("Book updated successfully.");
                        else System.out.println("Book not found!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case 10:
                    // Exit
                    System.out.println("Exiting... Good luck for your exam!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Choose 1-10.");
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n===== Library Management System =====");
        System.out.println("1. Add Book");
        System.out.println("2. Display All Books");
        System.out.println("3. Search Book by ID");
        System.out.println("4. Delete Book by ID");
        System.out.println("5. Issue Book");
        System.out.println("6. Return Book");
        System.out.println("7. Show Issued Books");
        System.out.println("8. Total Book Entries");
        System.out.println("9. Update Book Details");
        System.out.println("10. Exit");
    }
}
