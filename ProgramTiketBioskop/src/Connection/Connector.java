package Connection;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connector {
    public Connection koneksi;
    public Statement statement;
    private final String url = "jdbc:mysql://localhost:3306/finalpbo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String username = "root";
    private final String pass = "";
    public Connector() {
        try {
            // Class.forName("com.mysql.jdbc.cj.driver");
            koneksi = (Connection)DriverManager.getConnection(url, username, pass);
            statement = (Statement)koneksi.createStatement();
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
            JOptionPane.showMessageDialog(null, "Koneksi Gagal!");
            System.exit(0);
        }
    }
}
