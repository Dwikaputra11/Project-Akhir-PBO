package Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Class.User;

public class UserDao {
    private Connector con = new Connector();
    public User getUser(String username, String pass){
        try{
            String query = "select * from movies where pass="+pass;
            User user = new User();
            PreparedStatement ptsm = con.koneksi.prepareStatement(query);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = ptsm.executeQuery(query);
            rs.next();
            user.setPassword(rs.getString("password"));
            user.setUsername(rs.getString("username"));
            return user;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public boolean addFilm(User user){
        String query = "insert into users value (?,?,?,?)";
        PreparedStatement pstm;
        try {
            pstm = con.koneksi.prepareStatement(query);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            // pstm.set(3, user.getOrder());
            pstm.executeUpdate();
            return true; 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    public boolean deleteFilm(String username){
        String query = "delete from users where username="+username;
        PreparedStatement pstm;
        try{
           pstm = con.koneksi.prepareStatement(query);
           pstm.executeQuery();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }

}
