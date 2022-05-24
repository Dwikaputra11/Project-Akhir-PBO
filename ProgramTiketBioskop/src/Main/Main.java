package Main;

import Class.Order;
import GUI.*;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        // Login login = new Login();
        // login.initialize();
        PemilihanSeat ps = new PemilihanSeat(order);
        ps.initialize();
        // Checkout checkout = new Checkout(order);
        // checkout.initialize();
    }
}
