// Book.java
// Model class: ek Book object ko represent karta hai.

public class Book {
    int id;
    String name;
    String author;
    int quantity;

    public Book(int id, String name, String author, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
    }

    // toString() method se book details simple format me print hoti hain
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Author: " + author + " | Qty: " + quantity;
    }
}
