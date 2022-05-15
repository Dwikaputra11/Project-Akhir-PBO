package Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Class.User;

public class UserDao {
    private Connector con = new Connector();
    public User getUser(String username, String pass){
        System.out.println("GetUser()");
        try{
            String query = "select * from movies";
            User user = new User();
            PreparedStatement ptsm = con.koneksi.prepareStatement(query);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = ptsm.executeQuery(query);
            while(rs.next()){
                if(rs.getString("username").equals(username) && rs.getString("password").equals(pass)){
                    user.setUsername(username);
                    user.setPassword(pass);
                    return user;
                }
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }
    public boolean selectUser(String username, String pass){
        System.out.println("SelectUser()");
        try{
            String query = "select * from users";
            PreparedStatement ptsm = con.koneksi.prepareStatement(query);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = ptsm.executeQuery(query);
            while(rs.next()){
                if(rs.getString("username").equals(username)) return true; 
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    public void addUser(User user){
        System.out.println("AddUser()");
        String query = "insert into users(username,password) values (?,?)";
        PreparedStatement pstm;
        try {
            con.statement = con.koneksi.createStatement();
            pstm = con.koneksi.prepareStatement(query);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            // pstm.set(3, user.getOrder());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public boolean deleteUser(String username){
        System.out.println("DeleteUser()");
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
