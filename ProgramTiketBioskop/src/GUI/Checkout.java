package GUI;

import javax.swing.*;
<<<<<<< HEAD

=======
>>>>>>> a197f445067d1ca0cce31f4565cae0426666e554
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

<<<<<<< HEAD
public class Checkout {
    // -- DEKLARASI PANEL & FRAME
    private static JPanel panel;
    private static JFrame frame;

    // -- DEKLARASI LABEL GAMBAR POSISI SEAT
    private static JLabel labelTerimakasih;

    // -- DEKLARASI TOMBOL KEMBALI 
    private static JButton backButton;

    final private static Font mainFont = new Font("TimesRoman", Font.BOLD, 17); 

    public void initialize() {
        // -- DEKLARASI PANEL & FRAME
        panel = new JPanel();
        frame = new JFrame();

        // -- SET WARNA BACKGROUND & LAYOUT PANEL
        panel.setLayout(null);
        panel.setBackground(Color.white);

        // -- SET SIZE & TITLE FRAME
        frame.setSize(375, 265);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Pemesanan");

        // -- PANEL TERIMAKASIH
        labelTerimakasih = new JLabel("Pemesanan Berhasil!");
        labelTerimakasih.setBounds(100, 50, 205, 25);
        labelTerimakasih.setFont(mainFont);
        labelTerimakasih.setForeground(Color.black);
        panel.add(labelTerimakasih);

        // -- BUTTON KEMBALI KE MAIN MENU
        backButton = new JButton("Kembali ke Main Menu");
        backButton.setFont(mainFont);
        backButton.setBounds(75, 120, 205, 35);
        backButton.setForeground(Color.black);
        backButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HomeUser user = new HomeUser();
                    user.initialize();
                    frame.dispose();
                } catch (Exception error) {
                    System.out.println(error.getMessage());
                }
            }
        });
        panel.add(backButton);

        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR
        frame.setVisible(true); // -- MEMUNCULKAN WINDOW
    }
=======

public class Checkout extends JFrame{
    private static JFrame frame;
    private static JPanel panel;
    private static JScrollPane scrollPane;

    private static JLabel labelJudul;
    private static JLabel[] labelPemesanan;
    private static JLabel[] labelUsername;
    private static JLabel[] labelNoBooking;
    private static JLabel[] labelFilm;
    private static JLabel[] labelTanggal;
    private static JLabel[] labelSeat;

    private static JLabel[] textUsername;
    private static JLabel[] textNoBooking;
    private static JLabel[] textFilm;
    private static JLabel[] textTanggal;
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

    public Checkout(){
        int n = 2;
        labelPemesanan = new JLabel[n];
        labelNoBooking = new JLabel[n];
        labelUsername = new JLabel[n];
        labelFilm = new JLabel[n];
        labelTanggal= new JLabel[n];
        labelSeat = new JLabel[n];
        
        textNoBooking = new JLabel[n];
        textUsername = new JLabel[n];
        textFilm = new JLabel[n];
        textTanggal = new JLabel[n];
        textSeat = new JLabel[n];

        btnCheckOut = new JButton();
    }

    public void initialize(){
        frame = new JFrame();
        panel = new JPanel();

        frame.setSize(750, 790);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Checkout");

        panel.setLayout(null);
        panel.setBackground(Color.white);

        labelJudul = new JLabel("Checkout Pemesanan");
        labelJudul.setBounds(280,20,300,30);
        labelJudul.setFont(mainFont);
        labelJudul.setForeground(Color.black);
        panel.add(labelJudul);

        int yLabel = 50;
        for(int i = 0; i < 2; i++){
            // Pemesanan
            labelPemesanan[i] = new JLabel();
            labelPemesanan[i].setText("No.Pemesanan : " + (i + 1));
            labelPemesanan[i].setBounds(xTitleLabel,yLabel,widthTitleLabel,heightTitleLabel);
            labelPemesanan[i].setFont(secondaryFont);
            panel.add(labelPemesanan[i]);
            yLabel += 50;

            // No Booking
            labelNoBooking[i] = new JLabel();
            labelNoBooking[i].setText("No.Booking");
            labelNoBooking[i].setBounds(xTitleLabel,yLabel,widthTitleLabel,heightTitleLabel);
            labelNoBooking[i].setFont(secondaryFont);
            panel.add(labelNoBooking[i]);

            textNoBooking[i] = new JLabel();
            textNoBooking[i].setText(": A1");
            textNoBooking[i].setBounds(xTextLabel,yLabel,widthTextLabel,heightTextLabel);
            textNoBooking[i].setFont(thirdFont);
            panel.add(textNoBooking[i]);
            yLabel += 30;

            // Username
            labelUsername[i] = new JLabel();
            labelUsername[i].setText("Username");
            labelUsername[i].setBounds(xTitleLabel,yLabel,widthTitleLabel,heightTitleLabel);
            labelUsername[i].setFont(secondaryFont);
            panel.add(labelUsername[i]);

            textUsername[i] = new JLabel();
            textUsername[i].setText(": Nama");
            textUsername[i].setBounds(xTextLabel,yLabel,widthTextLabel,heightTextLabel);
            textUsername[i].setFont(thirdFont);
            panel.add(textUsername[i]);
            yLabel += 30;

            // Nama Film
            labelFilm[i] = new JLabel();
            labelFilm[i].setText("Nama Film");
            labelFilm[i].setBounds(xTitleLabel,yLabel,widthTitleLabel,heightTitleLabel);
            labelFilm[i].setFont(secondaryFont);
            panel.add(labelFilm[i]);

            textFilm[i] = new JLabel();
            textFilm[i].setText(": Nama");
            textFilm[i].setBounds(xTextLabel,yLabel,widthTextLabel,heightTextLabel);
            textFilm[i].setFont(thirdFont);
            panel.add(textFilm[i]);
            yLabel += 30;

            // Tanggal
            labelTanggal[i] = new JLabel();
            labelTanggal[i].setText("Tanggal");
            labelTanggal[i].setBounds(xTitleLabel,yLabel,widthTitleLabel,heightTitleLabel);
            labelTanggal[i].setFont(secondaryFont);
            panel.add(labelTanggal[i]);

            textTanggal[i] = new JLabel();
            textTanggal[i].setText(": 00-00-0000");
            textTanggal[i].setBounds(xTextLabel,yLabel,widthTextLabel,heightTextLabel);
            textTanggal[i].setFont(thirdFont);
            panel.add(textTanggal[i]);
            yLabel += 30;

            // Seat
            labelSeat[i] = new JLabel();
            labelSeat[i].setText("No.Seat");
            labelSeat[i].setBounds(xTitleLabel,yLabel,widthTitleLabel,heightTitleLabel);
            labelSeat[i].setFont(secondaryFont);
            panel.add(labelSeat[i]);

            textSeat[i] = new JLabel();
            textSeat[i].setText(": A1");
            textSeat[i].setBounds(xTextLabel,yLabel,widthTextLabel,heightTextLabel);
            textSeat[i].setFont(thirdFont);
            panel.add(textSeat[i]);
            yLabel += 60;
        }

        btnCheckOut.setText("Checkout");
        btnCheckOut.setBounds(320, 680, 100, 30);
        btnCheckOut.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                HomeUser user = new HomeUser();
                user.initialize();
                frame.dispose();
            }
            
        });
        panel.add(btnCheckOut);

        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR
        frame.setVisible(true); 
    }


>>>>>>> a197f445067d1ca0cce31f4565cae0426666e554
}
