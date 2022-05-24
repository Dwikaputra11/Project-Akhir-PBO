package Class;

import java.util.ArrayList;

    
public class Order extends Film{
    private int noBooking;
    private ArrayList<String> seats;
    private String seat;
    private String username;
    private int totalBooking;
    private String namaFilm;
 
    public Order(int noBooking,String username, String name, String date, ArrayList<String> seats) {
        super(name,date);
        this.noBooking = noBooking;
        this.seats = seats;
        this.username = username;
        this.totalBooking = 0;
        this.namaFilm = namaFilm;
    }

    public String getNamaFilm() {
        return this.namaFilm;
    }

    public void setNamaFilm(String namaFilm) {
        this.namaFilm = namaFilm;
    }

    // public Order(int noBooking,String username, String name, String date, String seat) {
    //     super(name,date);
    //     this.noBooking = noBooking;
    //     this.seat = seat;
    //     this.username = username;
    //     this.totalBooking = 0;
    // }

    public Order(){

    }

    public int getNoBooking() {
        return this.noBooking;
    }

    public void setNoBooking(int noBooking) {
        this.noBooking = noBooking;
    }

    // public String getSeat() {
    //     return this.seat;
    // }

    // public void setSeat(String seat) {
    //     this.seat = seat;
    // }

    public ArrayList<String> getSeats() {
        return this.seats;
    }

    public void setSeats(ArrayList<String> seats) {
        this.seats = seats;
    }
    public void addSeats(String seats){
        this.seats.add(seats);
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
            ", seats='" + getSeats() + "'" +
            ", username='" + getUsername() + "'" +
            "}";
    }
    
}