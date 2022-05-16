package Class;

import java.util.Random;

public class Order extends Film{
    private int noBooking;
    private String seat;
    private String username;

    public Order(int noBooking, String seat, String username, String name, String date) {
        super(name,date);
        this.noBooking = noBooking;
        this.seat = seat;
        this.username = username;
    }

    public Order(){

    }


    public int getNoBooking() {
        return this.noBooking;
    }

    public void setNoBooking(int noBooking) {
        this.noBooking = noBooking;
    }

    public String getSeat() {
        return this.seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "{" +
            " noBooking='" + getNoBooking() + "'" +
            ", seat='" + getSeat() + "'" +
            ", username='" + getUsername() + "'" +
            "}";
    }

    public String generateString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 4;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
            (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }
    
}