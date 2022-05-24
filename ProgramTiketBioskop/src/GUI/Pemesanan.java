package GUI;

import javax.swing.*;

import Class.Film;
import Connection.FilmDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.sql.Connection;

public class Pemesanan {
    // -- DEKLARASI PANEL & FRAME
    private static JPanel panel;
    private static JFrame frame;

    // -- DEKLARASI LABEL KODE FILM
    private static JLabel kodeLabel;

    // -- DEKLARASI TEXT FIELD KODE FILM
    private static JTextField kodeTextField;

    // -- DEKLARASI TOMBOL KEMBALI DAN SUBMIT
    private static JButton backButton;
    private static JButton submitButton;

    private String kode;
    private String username;

    // private OrderDao orderDao;
    private FilmDao filmDao = new FilmDao();

    private Film film;

    public Pemesanan(String username){
        this.username = username;
    }

    public void initialize() {

        // -- DEKLARASI PANEL & FRAME
        panel = new JPanel();
        frame = new JFrame();

        // -- SET SIZE & TITLE FRAME
        frame.setSize(375, 265);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Pemesanan");

        // -- SET WARNA BACKGROUND & LAYOUT PANEL
        panel.setLayout(null);
        panel.setBackground(Color.white);

        // -- LABEL KODE FILM
        kodeLabel = new JLabel("Masukkan Kode Film :");
        kodeLabel.setBounds(120,80,200,25);
        kodeLabel.setForeground(Color.black);
        panel.add(kodeLabel);

        // -- TEXT FIELD KODE FILM
        kodeTextField = new JTextField();
        kodeTextField.setBounds(80,115,200,20);
        panel.add(kodeTextField);

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

        // -- SUBMIT BUTTON
        submitButton = new JButton("Submit");
        submitButton.setBounds(140, 150, 85, 25);
        submitButton.setForeground(Color.black);
        submitButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    kode = kodeTextField.getText();
                    if(!kode.isBlank()){
                        if(filmDao.isFilmAdded(kode)){
                            film = filmDao.getFilm(kode);
                            PemilihanSeat seat = new PemilihanSeat(film,username);
                            seat.initialize();
                            frame.dispose();
                        }else{
                            throw new Exception("Film Tidak Terdaftar");
                        }
                    }else{
                        throw new Exception("Isi Field Kosong");
                    }
                } catch (Exception msg) {
                    JOptionPane.showMessageDialog(frame, msg.getMessage(), "Alert",JOptionPane.HEIGHT);
                }
            }
        });
        panel.add(submitButton);

        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR
        frame.setVisible(true); // -- MEMUNCULKAN WINDOW
    }
}
