# Student Data Entry System with MySQL Integration

**Name**: Daniel John Jacob  
**PRN**: 23070126027  
**Batch**: AIML A2

---

## Description

This Java-based application allows users to perform CRUD operations (Create, Read, Update, Delete) on student records using MySQL as the backend. JDBC is used for database connectivity.

---

## Java Files & Explanation

### 1. `Main.java`

**Purpose**:  
Entry point of the program. Displays the menu and takes user input.

**Methods**:
- `main(String[] args)`:  
  - Displays the menu options.
  - Based on user input, calls appropriate methods from `StudentApp`.

---

### 2. `Student.java`

**Purpose**:  
Model class that represents a student.

**Attributes**:
- `String name`
- `String prn`
- `int age`

**Constructor**:
- Initializes student data.

**Getters**:
- Returns the values of student fields.

---

### 3. `DBConnection.java`

**Purpose**:  
Provides a reusable method to establish a connection with the MySQL database.

**Method**:
- `getConnection()`:  
  - Loads the JDBC driver (`com.mysql.cj.jdbc.Driver`)
  - Connects to MySQL using `studentdb`, user `root`, and blank password.

---

### 4. `StudentApp.java`

**Purpose**:  
Handles all the functionality related to the database operations.

**Methods**:
- `addStudent(Student student)`  
  - Inserts student data into MySQL table.

- `displayStudents()`  
  - Retrieves and prints all student records.

- `searchStudentByPRN(String prn)`  
  - Searches for a student using their PRN.

- `deleteStudent(String prn)`  
  - Deletes a student record using PRN.

---

## Database Details

**Database Name**: `studentdb`  
**Table**: `students`

```sql
CREATE TABLE students (
    name VARCHAR(100),
    prn VARCHAR(20) PRIMARY KEY,
    age INT
);
```

---

## Requirements

- Java JDK 8 or higher
- MySQL
- MySQL Connector/J `.jar` file (added to classpath)

---

## How to Run

```bash
javac -cp ".;mysql-connector-j-9.3.0.jar" *.java
java -cp ".;mysql-connector-j-9.3.0.jar" Main
```

---

## Commit Guidelines

- Each class and method was committed separately.
- GitHub repo includes all `.java` files and this `README.md`.

---
