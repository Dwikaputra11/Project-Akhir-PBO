package Main;

import Class.Order;
import GUI.*;

public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
=======
        Order order = new Order();
>>>>>>> a67b10a74726695e64afc8441935e9f092c7f555
        // Login login = new Login();
        // login.initialize();
        // Checkout checkout = new Checkout();
        // checkout.initialize();
<<<<<<< HEAD
        // Lihat lihat = new Lihat();
        // lihat.initialize();
        Login login = new Login();
        login.initialize();
        //Tambah tambah = new Tambah();
        //tambah.initialize();
        //Order order = new Order(001,"b1","dwika","doctor strange","01Qas","00-00-0000");
        // Kode editkode = new Kode();
        // editkode.initialize();
        // KodeDelete kodedelete = new KodeDelete();
        // kodedelete.initialize();
=======
        // Pemesanan pemesanan = new Pemesanan();
        // pemesanan.initialize();
        PemilihanSeat ps = new PemilihanSeat(order);
        ps.initialize();
        // Checkout checkout = new Checkout(order);
        // checkout.initialize();
>>>>>>> a67b10a74726695e64afc8441935e9f092c7f555
    }
}
