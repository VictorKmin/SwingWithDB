import java.sql.*;

public class DBCoonect {
    String url ="jdbc:mysql://localhost:3306/bank";
    String username = "root";
    String password = "root";
    String res;

    GUI gui = new GUI();
    Connection connection;
    {
        try {
            connection = DriverManager.getConnection(url,username,password);
            String takeUser = "SELECT * FROM test WHERE test_id LIKE " + gui.getInpt();
            PreparedStatement ps = connection.prepareStatement(takeUser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);

                res = "ID is: " + s1 + " Name is:" + s2;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
