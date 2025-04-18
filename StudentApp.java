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

    
}
