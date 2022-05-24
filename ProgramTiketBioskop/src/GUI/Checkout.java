package GUI;

import javax.swing.*;
<<<<<<< HEAD

import Class.Order;

=======
>>>>>>> a67b10a74726695e64afc8441935e9f092c7f555
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.util.ArrayList;

<<<<<<< HEAD
=======
import Class.Order;

>>>>>>> a67b10a74726695e64afc8441935e9f092c7f555
public class Checkout extends JFrame{
    // -- DEKLARASI PANEL & FRAME
    private static JFrame frame;
    private static JPanel panel;
    // private static JScrollPane scrollPane;

    private static JLabel labelJudul;
    private static JLabel labelPemesanan;
    private static JLabel labelUsername;
    private static JLabel labelNoBooking;
    private static JLabel labelFilm;
    private static JLabel labelTanggal;
    private static JLabel[] labelSeat;

    private static JLabel textUsername;
    private static JLabel textNoBooking;
    private static JLabel textFilm;
    private static JLabel textTanggal;
    private static JLabel[] textSeat;

    private static JButton btnCheckOut;

    final private static Font mainFont = new Font("TimesRoman", Font.BOLD, 20); 
    final private static Font secondaryFont = new Font("TimesRoman", Font.BOLD, 16);
    final private static Font thirdFont = new Font("TimesRoman", Font.PLAIN, 16);

    final int xTitleLabel = 50;
    final int widthTitleLabel = 150;
    final int heightTitleLabel = 30;

    final int xTextLabel = 200;
    final int widthTextLabel = 200;
    final int heightTextLabel = 30;

    private Order order;
<<<<<<< HEAD
    // private OrderDao orderDao = new OrderDao();

    public Checkout(Order order){
        this.order = order;
        int n = order.getSeat().size();
        labelPemesanan = new JLabel[n];
        labelNoBooking = new JLabel[n];
        labelUsername = new JLabel[n];
        labelFilm = new JLabel[n];
        labelTanggal= new JLabel[n];
        labelSeat = new JLabel[n];
=======

    public Checkout(Order order){
        labelPemesanan = new JLabel();
        labelNoBooking = new JLabel();
        labelUsername = new JLabel();
        labelFilm = new JLabel();
        labelTanggal= new JLabel();
        labelSeat = new JLabel[3];
>>>>>>> a67b10a74726695e64afc8441935e9f092c7f555
        
        textNoBooking = new JLabel();
        textUsername = new JLabel();
        textFilm = new JLabel();
        textTanggal = new JLabel();
        textSeat = new JLabel[3];

        btnCheckOut = new JButton();

        this.order = order;
    }

    public void initialize(){
        String username = order.getUsername();
        String namaFilm = order.getNamaFilm();
        int noBooking = order.getNoBooking();
        int totalBooking = order.getTotalBooking();

        frame = new JFrame();
        panel = new JPanel();

        frame.setSize(750, 450);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Checkout");

        panel.setLayout(null);
        panel.setBackground(Color.white);

        labelJudul = new JLabel("Checkout Pemesanan");
        labelJudul.setBounds(280,35,300,30);
        labelJudul.setFont(mainFont);
        labelJudul.setForeground(Color.black);
        panel.add(labelJudul);
        
        // Pemesanan
        labelPemesanan = new JLabel();
        labelPemesanan.setBounds(xTitleLabel,50,widthTitleLabel,heightTitleLabel);
        labelPemesanan.setFont(secondaryFont);
        panel.add(labelPemesanan);

<<<<<<< HEAD
        int yLabel = 50;
        for(int i = 0; i < order.getSeat().size(); i++){
            // Pemesanan
            labelPemesanan[i] = new JLabel();
            labelPemesanan[i].setText("No.Pemesanan : " + (i + 1));
            labelPemesanan[i].setBounds(xTitleLabel,yLabel,widthTitleLabel,heightTitleLabel);
            labelPemesanan[i].setFont(secondaryFont);
            panel.add(labelPemesanan[i]);
            yLabel += 50;
=======
        // No Booking
        labelNoBooking = new JLabel();
        labelNoBooking.setText("No.Booking");
        labelNoBooking.setBounds(xTitleLabel,100,widthTitleLabel,heightTitleLabel);
        labelNoBooking.setFont(secondaryFont);
        panel.add(labelNoBooking);
>>>>>>> a67b10a74726695e64afc8441935e9f092c7f555

        textNoBooking = new JLabel(": ");
        textNoBooking.setText(": " + noBooking);
        textNoBooking.setBounds(xTextLabel,100,widthTextLabel,heightTextLabel);
        textNoBooking.setFont(thirdFont);
        panel.add(textNoBooking);

<<<<<<< HEAD
            textNoBooking[i] = new JLabel();
            textNoBooking[i].setText(": " + order.getNoBooking());
            textNoBooking[i].setBounds(xTextLabel,yLabel,widthTextLabel,heightTextLabel);
            textNoBooking[i].setFont(thirdFont);
            panel.add(textNoBooking[i]);
            yLabel += 30;
=======
        // Username
        labelUsername = new JLabel();
        labelUsername.setText("Username");
        labelUsername.setBounds(xTitleLabel,130,widthTitleLabel,heightTitleLabel);
        labelUsername.setFont(secondaryFont);
        panel.add(labelUsername);
>>>>>>> a67b10a74726695e64afc8441935e9f092c7f555

        textUsername = new JLabel();
        textUsername.setText(": " + username);
        textUsername.setBounds(xTextLabel,130,widthTextLabel,heightTextLabel);
        textUsername.setFont(thirdFont);
        panel.add(textUsername);

<<<<<<< HEAD
            textUsername[i] = new JLabel();
            textUsername[i].setText(": " + order.getUsername());
            textUsername[i].setBounds(xTextLabel,yLabel,widthTextLabel,heightTextLabel);
            textUsername[i].setFont(thirdFont);
            panel.add(textUsername[i]);
            yLabel += 30;
=======
        // Nama Film
        labelFilm = new JLabel();
        labelFilm.setText("Nama Film");
        labelFilm.setBounds(xTitleLabel,160,widthTitleLabel,heightTitleLabel);
        labelFilm.setFont(secondaryFont);
        panel.add(labelFilm);
>>>>>>> a67b10a74726695e64afc8441935e9f092c7f555

        textFilm = new JLabel();
        textFilm.setText(": " + namaFilm);
        textFilm.setBounds(xTextLabel,160,widthTextLabel,heightTextLabel);
        textFilm.setFont(thirdFont);
        panel.add(textFilm);

<<<<<<< HEAD
            textFilm[i] = new JLabel();
            textFilm[i].setText(": " + order.getName());
            textFilm[i].setBounds(xTextLabel,yLabel,widthTextLabel,heightTextLabel);
            textFilm[i].setFont(thirdFont);
            panel.add(textFilm[i]);
            yLabel += 30;
=======
        // Tanggal
        labelTanggal = new JLabel();
        labelTanggal.setText("Tanggal");
        labelTanggal.setBounds(xTitleLabel,190,widthTitleLabel,heightTitleLabel);
        labelTanggal.setFont(secondaryFont);
        panel.add(labelTanggal);
>>>>>>> a67b10a74726695e64afc8441935e9f092c7f555

        textTanggal = new JLabel();
        textTanggal.setText(": 00-00-0000");
        textTanggal.setBounds(xTextLabel,190,widthTextLabel,heightTextLabel);
        textTanggal.setFont(thirdFont);
        panel.add(textTanggal);

<<<<<<< HEAD
            textTanggal[i] = new JLabel();
            textTanggal[i].setText(": " + order.getDate());
            textTanggal[i].setBounds(xTextLabel,yLabel,widthTextLabel,heightTextLabel);
            textTanggal[i].setFont(thirdFont);
            panel.add(textTanggal[i]);
            yLabel += 30;
=======
        int yLabel = 220;
>>>>>>> a67b10a74726695e64afc8441935e9f092c7f555

        for(int i = 0; i < totalBooking; i++){
            // Seat
            labelSeat[i] = new JLabel();
            labelSeat[i].setText("No.Seat");
            labelSeat[i].setBounds(xTitleLabel,yLabel,widthTitleLabel,heightTitleLabel);
            labelSeat[i].setFont(secondaryFont);
            panel.add(labelSeat[i]);

            textSeat[i] = new JLabel();
            textSeat[i].setText(": " + order.getSeat().get(i));
            textSeat[i].setBounds(xTextLabel,yLabel,widthTextLabel,heightTextLabel);
            textSeat[i].setFont(thirdFont);
            panel.add(textSeat[i]);
            yLabel += 30;
        }

        btnCheckOut.setText("Checkout");
        btnCheckOut.setBounds(320, 350, 100, 30);
        btnCheckOut.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                HomeUser user = new HomeUser();
                user.initialize();
                frame.dispose();
            }
            
        });
        panel.add(btnCheckOut);

        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR
        frame.setVisible(true); 
    }
<<<<<<< HEAD
=======


>>>>>>> a67b10a74726695e64afc8441935e9f092c7f555
}
