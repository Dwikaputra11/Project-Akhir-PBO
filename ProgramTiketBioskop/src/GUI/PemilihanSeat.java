package GUI;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PemilihanSeat extends JFrame {
    // -- DEKLARASI PANEL & FRAME
    private static JPanel panel;
    private static JFrame frame;

    // -- DEKLARASI TABEL KODE FILM
    private static JTable kodeTable;

    // -- DEKLARASI LABEL GAMBAR POSISI SEAT
    private static JLabel labelGambar;
    private static JLabel noSeat;

    // -- DEKLARASI TOMBOL KEMBALI DAN SUBMIT
    private static JButton backButton;
    private static JButton submitButton;
    private static JTextField submitTextField;

    final private static Font mainFont = new Font("TimesRoman", Font.BOLD, 17); 

    Border border = BorderFactory.createLineBorder(Color.gray,1);

    public void initialize() {
        // -- DEKLARASI PANEL & FRAME
        panel = new JPanel();
        frame = new JFrame();

        // -- SET SIZE & TITLE FRAME
        frame.setSize(1250, 650);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Pemesanan");

        // -- SET WARNA BACKGROUND & LAYOUT PANEL
        panel.setLayout(null);
        panel.setBackground(Color.white);

        // -- LABEL GAMBAR POSISI SEAT
        labelGambar = new JLabel();
        labelGambar.setBounds(600,70,600,350);
        labelGambar.setIcon(new ImageIcon("C:\\Users\\asus\\Documents\\Java\\Project-Akhir-PBO\\ProgramTiketBioskop\\img\\seat.png"));
        labelGambar.setBorder(border);
        panel.add(labelGambar);

        noSeat = new JLabel("Masukkan no Seat :");
        noSeat.setBounds(545, 470, 305, 25);
        noSeat.setFont(mainFont);
        noSeat.setForeground(Color.black);
        panel.add(noSeat);

        // -- TABEL SEAT TERSEDIA
        kodeTable = new JTable();
        kodeTable.setBounds(40,70,530,350);
        kodeTable.setBorder(border);
        panel.add(kodeTable);

        // -- JLABEL TOMBOL KEMBALI
        backButton = new JButton("kembali");
        backButton.setBounds(10,10,80,25);
        backButton.setForeground(Color.black);
        backButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HomeUser home = new HomeUser();
                    home.initialize();
                    frame.dispose();
                } catch (Exception error) {
                    System.out.println(error.getMessage());
                }
            }});
        panel.add(backButton);

        // -- SUBMIT FIELD
        submitTextField = new JTextField();
        // submitTextField.setFont(mainFont);
        submitTextField.setBounds(465, 500, 305, 25);
        submitTextField.setForeground(Color.black);
        panel.add(submitTextField);

        // -- SUBMIT BUTTON
        submitButton = new JButton("Submit");
        submitButton.setFont(mainFont);
        submitButton.setBounds(575, 550, 85, 35);
        submitButton.setForeground(Color.black);
        submitButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Checkout checkout = new Checkout();
                    checkout.initialize();
                    frame.dispose();
                } catch (Exception error) {
                    System.out.println(error.getMessage());
                }
            }
        });
        panel.add(submitButton);

        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR
        frame.setVisible(true); // -- MEMUNCULKAN WINDOW
    }
}
