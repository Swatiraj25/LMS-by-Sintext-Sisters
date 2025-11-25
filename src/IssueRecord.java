// IssueRecord.java
// Issued books ka record store karega (bookId + studentName).
// Aap chaho to yahan issueDate bhi add kar sakte ho (optional).

public class IssueRecord {
    int bookId;
    String studentName;

    public IssueRecord(int bookId, String studentName) {
        this.bookId = bookId;
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + " | Student: " + studentName;
    }
}
