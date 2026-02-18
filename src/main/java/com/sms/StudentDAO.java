package com.sms;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student student) {

        String sql = "INSERT INTO student (name, email, course, marks) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getCourse());
            stmt.setInt(4, student.getMarks());

            stmt.executeUpdate();

            System.out.println("Student added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // VIEW STUDENTS
    public List<Student> getAllStudent() {

        List<Student> students= new ArrayList<>();

        String sql = "SELECT * FROM student";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course"),
                        rs.getInt("marks")
                );

                students.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    // UPDATE STUDENT
    public void updateStudent(int id, String newCourse) {

        String sql = "UPDATE student SET course=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newCourse);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();

            if (rows > 0)
                System.out.println("Student updated successfully");
            else
                System.out.println("Student not found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {

        String sql = "DELETE FROM student WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            if (rows > 0)
                System.out.println("Student deleted successfully");
            else
                System.out.println("Student not found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
