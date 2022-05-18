package Class;

import java.util.ArrayList;
import java.util.Random;

    
public class Order extends Film{
    private int noBooking;
    private ArrayList<String> seat;
    private String username;
    private int totalBooking;
 
    public Order(int noBooking,String username, String name, String date, ArrayList<String> seat) {
        super(name,date);
        this.noBooking = noBooking;
        this.seat = seat;
        this.username = username;
        this.totalBooking = 0;
    }

    public Order(){

    }

    public int getNoBooking() {
        return this.noBooking;
    }

    public void setNoBooking(int noBooking) {
        this.noBooking = noBooking;
    }

    public ArrayList<String> getSeat() {
        return this.seat;
    }

    public void setSeat(ArrayList<String> seat) {
        this.seat = seat;
    }
    public void addSeat(String seat){
        this.seat.add(seat);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalBooking() {
        return this.totalBooking;
    }

    public void setTotalBooking(int totalBooking) {
        this.totalBooking = totalBooking;
    }


    @Override
    public String toString() {
        return "{" +
            " noBooking='" + getNoBooking() + "'" +
            ", seat='" + getSeat() + "'" +
            ", username='" + getUsername() + "'" +
            "}";
    }
    
}