import java.sql.*;

public class StudentJDBC {
    static final String DB_URL = "jdbc:mysql://localhost:3306/student_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Create
            String insertSql = "INSERT INTO Students (roll, name, marks) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSql);
            pstmt.setInt(1, 101);
            pstmt.setString(2, "John");
            pstmt.setInt(3, 88);
            pstmt.executeUpdate();

            // Read
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Students");
            while (rs.next()) {
                System.out.println(rs.getInt("roll") + " " + rs.getString("name") + " " + rs.getInt("marks"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
