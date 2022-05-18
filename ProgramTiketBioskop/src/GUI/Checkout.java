package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
}
