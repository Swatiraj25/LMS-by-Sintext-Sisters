# 📚 LMS-by-Sintext-Sisters  
A **Console-Based Library Management System** built using **Core Java**, demonstrating Object-Oriented Programming, Database Integration, Collections, Exception Handling, and a menu-based console interface.  

Designed as a **3rd Semester Java Subject Project** for academic submission and practical understanding of OOP + File Handling + JDBC.

---

# 🏅 Badges  
![Java](https://img.shields.io/badge/Java-Programming-orange)  
![SQLite](https://img.shields.io/badge/SQLite-Database-blue)  
![Status](https://img.shields.io/badge/Project-Active-brightgreen)  
![License](https://img.shields.io/badge/License-Open--Source-success)

---

# 🚀 Features

### 📘 Book Management
- Add new book  
- Update book details  
- Delete a book  
- Search book by ID  
- Display all books  

### 🔄 Issue / Return Management
- Issue a book to a student  
- Return a book  
- View list of issued books  

### 🧩 Additional Functionalities
- Auto-create SQLite database  
- Total book count  
- Input validation  
- Error-free menu experience  
- Clean modular OOP structure  

---

# 🛠️ Technologies Used

| Component | Technology |
|----------|------------|
| **Language** | Java (Core Java) |
| **Database** | SQLite |
| **Connectivity** | JDBC |
| **Data Structures** | ArrayList, Objects |
| **IDE (Optional)** | VS Code / IntelliJ / Eclipse |
| **Design** | Menu-driven console interface |

---

# 📁 Project Structure 

LMS-by-Sintext-Sisters/
│
├── Main.java → Handles menu & user input
├── Library.java → Core logic (add/delete/update/issue/return)
├── Book.java → Book model class
├── IssueRecord.java → Issued book model class
├── Database.java → SQLite DB connection (auto-create)
│
├── lib/
│ └── sqlite-jdbc.jar → SQLite database driver
│
└── README.md


---

# 🗄️ Database Details

- Database auto-generated:  


library.db

- No manual table creation required  
- Tables used:
- **books**
- **issued_books**

Database is created when program runs for the first time.

---

# ▶️ How to Run

### **Step 1 — Install Java JDK**
Check:


java -version
javac -version


---

### **Step 2 — Compile**


javac -cp ".;lib/sqlite-jdbc.jar" *.java


---

### **Step 3 — Run**


java -cp ".;lib/sqlite-jdbc.jar" Main


✔ Database will be auto-created  
✔ Program will start in console  

---

# 📸 Screenshots (Add Yours Here)

> You can take screenshots of the console output and place them in a folder `/screenshots/`.

Example:



screenshots/
│── menu.png
│── add_book.png
│── issue.png
│── return.png


Then add here:

```md
![Menu](screenshots/menu.png)
![Add Book](screenshots/add_book.png)

💡 Future Enhancements

Add login system (Admin + User)

Add due date & fine calculation

Export reports to text/PDF

GUI-based version using JavaFX

Cloud database support

User authentication system

🤝 Author

Swati Singh
Diploma / B.Tech – Computer Science Engineering
NIMS University, Jaipur

GitHub: https://github.com/Swatiraj25

📄 License

This project is open-source, free to use for academic learning and Java practice.

