// SQLDB.java
import java.sql.*;

public class SQLDB {
    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rset = null;

    public static void connect(String dbPath) {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getAllCourseOutcomes() {
        try {
            String query = "SELECT * FROM course_outcome";
            pstmt = conn.prepareStatement(query);
            return pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
