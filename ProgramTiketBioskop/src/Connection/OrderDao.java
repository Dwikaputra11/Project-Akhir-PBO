package Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Class.Order;

public class OrderDao{
    private Connector con = new Connector();
    public Order getOrder(int noBooking){
        System.out.println("getOrder()");
        try{
            String query = "select * from orders where no_booking=?";
            Order order = new Order();
            PreparedStatement pstm = con.koneksi.prepareStatement(query);
            pstm.setInt(1,noBooking);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = pstm.executeQuery(query);
            int loop = 1;
            while(rs.next()){
                order.setNoBooking(noBooking);
                order.setUsername(rs.getString("username"));
                order.setName(rs.getString("film"));
                order.setDate(rs.getString("tanggal"));
                order.addSeats(rs.getString("seat"));
                order.setTotalBooking(loop);
            }
            return order;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public boolean isOrderExist(int noBooking){
        System.out.println("isOrderExist()");
        try{
            String query = "select * from orders";
            PreparedStatement pstm = con.koneksi.prepareStatement(query);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = pstm.executeQuery(query);
            while(rs.next()){
                if(rs.getInt("no_booking") == noBooking) return true; 
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }
    public void AddOrder(Order order){
        System.out.println("addOrder()");
        String query = "insert into orders (no_booking,username,film,date,seat) values (?,?,?,?,?)";
        PreparedStatement pstm;
        try {
            con.statement = con.koneksi.createStatement();
            pstm = con.koneksi.prepareStatement(query);
            int loop = order.getSeats().size();
            for(int i = 0; i < loop; i++){
                pstm.setInt(1, order.getNoBooking());
                pstm.setString(2, order.getUsername());
                pstm.setString(3, order.getName());
                pstm.setString(4, order.getDate());
                pstm.setString(5, order.getSeats().get(i));
                pstm.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public boolean deleteOrder(int noBooking){
        System.out.println("deleteOrder()");
        String query = "delete from orders where no_booking=?";
        PreparedStatement pstm;
        try{
           pstm = con.koneksi.prepareStatement(query);
           pstm.setInt(1, noBooking);
           pstm.executeQuery();
           return true;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }
}