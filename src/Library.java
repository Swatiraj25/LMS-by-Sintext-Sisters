// Library.java
// Saara core logic yahin hai: books list, issued list, aur sare operations.

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<IssueRecord> issuedBooks;

    public Library() {
        books = new ArrayList<>();
        issuedBooks = new ArrayList<>();
    }

    // 1) Add book - agar same ID already ho to reject karega.
    public boolean addBook(Book b) {
        if (searchBook(b.id) != null) {
            return false; // duplicate id
        }
        books.add(b);
        return true;
    }

    // 2) Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in library.");
            return;
        }
        System.out.println("----- All Books -----");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // 3) Search book by ID
    public Book searchBook(int id) {
        for (Book b : books) {
            if (b.id == id) return b;
        }
        return null;
    }

    // 4) Delete book by ID
    public boolean deleteBook(int id) {
        Book b = searchBook(id);
        if (b != null) {
            // ensure that if book is issued, we may still allow deletion.
            // (Optionally check issuedBooks to prevent deletion if issued)
            books.remove(b);
            return true;
        }
        return false;
    }

    // 5) Issue book to a student
    public String issueBook(int id, String student) {
        Book b = searchBook(id);
        if (b == null) return "Book not found!";
        if (b.quantity <= 0) return "Book out of stock!";
        // decrease quantity and add issue record
        b.quantity--;
        issuedBooks.add(new IssueRecord(id, student));
        return "Book issued successfully to " + student + ".";
    }

    // 6) Return book (by id and student name)
    public String returnBook(int id, String student) {
        IssueRecord found = null;
        for (IssueRecord ir : issuedBooks) {
            if (ir.bookId == id && ir.studentName.equalsIgnoreCase(student.trim())) {
                found = ir;
                break;
            }
        }
        if (found == null) return "No matching issued record found!";
        issuedBooks.remove(found);
        Book b = searchBook(id);
        if (b != null) {
            b.quantity++;
        }
        return "Book returned successfully by " + student + ".";
    }

    // 7) Show all issued books
    public void showIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books are currently issued.");
            return;
        }
        System.out.println("----- Issued Books -----");
        for (IssueRecord ir : issuedBooks) {
            System.out.println(ir);
        }
    }

    // 8) Total books count (distinct book entries)
    public int totalBooksCount() {
        return books.size();
    }

    // 9) Update book details
    public boolean updateBook(int id, String newName, String newAuthor, int newQty) {
        Book b = searchBook(id);
        if (b == null) return false;
        b.name = newName;
        b.author = newAuthor;
        b.quantity = newQty;
        return true;
    }
}
