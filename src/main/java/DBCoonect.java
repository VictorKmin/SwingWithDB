import java.sql.*;

public class DBCoonect {
    String url = "jdbc:mysql://localhost:3306/bank";
    String username = "root";
    String password = "root";
    String res;

    Connection connection;
    GUI gui;

    public DBCoonect(GUI gui) {
        this.gui = gui;
    }


    public String doRequestWhenClick() {

        try {
            connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM test WHERE test_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(gui.getInpt().getText()));


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);

                res = "ID is: " + s1 + " Name is:" + s2;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
