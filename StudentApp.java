import java.util.*;
import java.sql.*;

public class StudentApp {
    Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n1. Add Student\n2. Display Students\n3. Search by PRN\n4. Delete Student\n5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchByPRN(); break;
                case 4: deleteStudent(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // Adds student to database
    public void addStudent() {
        try {
            sc.nextLine(); // clear buffer
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter PRN: ");
            String prn = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            String query = "INSERT INTO students(name, prn, age) VALUES (?, ?, ?)";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, prn);
            pst.setInt(3, age);
            pst.executeUpdate();

            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Displays all students from database
    public void displayStudents() {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", PRN: " + rs.getString("prn") + ", Age: " + rs.getInt("age"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Searches student by PRN
    public void searchByPRN() {
        try {
            sc.nextLine();
            System.out.print("Enter PRN: ");
            String prn = sc.nextLine();
            String query = "SELECT * FROM students WHERE prn = ?";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, prn);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Found: Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
}
