package Connection;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connector {
    public Connection koneksi;
    public Statement statement;
    
    public Connector() {
        try {
            // Class.forName("com.mysql.jdbc.cj.driver");
            koneksi = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bioskop_pbo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            statement = (Statement)koneksi.createStatement();
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
            JOptionPane.showMessageDialog(null, "Koneksi Gagal!");
            System.exit(0);
        }
    }
}
