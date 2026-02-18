package com.sms;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();
                    sc.nextLine();

                    Student student = new Student(0, name, email, course, marks);
                    dao.addStudent(student);

                    break;


                case 2:

                    List<Student> students = dao.getAllStudent();

                    System.out.println("------------------------------------------------------------");
                    System.out.printf("%-5s %-15s %-20s %-10s %-5s\n",
                            "ID", "Name", "Email", "Course", "Marks");
                    System.out.println("------------------------------------------------------------");

                    for (Student s : students) {

                        System.out.printf("%-5d %-15s %-20s %-10s %-5d\n",
                                s.getId(),
                                s.getName(),
                                s.getEmail(),
                                s.getCourse(),
                                s.getMarks());
                    }

                    System.out.println("------------------------------------------------------------");

                    break;


                case 3:

                    System.out.print("Enter student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine();

                    dao.updateStudent(updateId, newCourse);

                    break;


                case 4:

                    System.out.print("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    dao.deleteStudent(deleteId);

                    break;


                case 5:

                    System.out.println("Exiting system...");
                    sc.close();
                    System.exit(0);


                default:

                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
