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
                    // Add Book (DB auto ID generation, no need to ask user for ID)
                    lib.addBook();
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
                        // DB version has no searchBook(), so we display matching row manually
                        System.out.println("Feature: Search is not available in DB version.");
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
                        System.out.print("Enter Issue Record ID to return: ");
                        int rid = Integer.parseInt(sc.nextLine().trim());

                        String result = lib.returnBook(rid);
                        System.out.println(result);

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
                    System.out.println("Total Books in DB = " + lib.totalBooksCount());
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
                    System.out.println("Exiting... Good luck!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Enter 1–10.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n===== Library Management System (SQLite Version) =====");
        System.out.println("1. Add Book");
        System.out.println("2. Display All Books");
        System.out.println("3. Search Book (Not Available)");
        System.out.println("4. Delete Book");
        System.out.println("5. Issue Book");
        System.out.println("6. Return Book");
        System.out.println("7. Show Issued Books");
        System.out.println("8. Total Books Count");
        System.out.println("9. Update Book");
        System.out.println("10. Exit");
    }
}
