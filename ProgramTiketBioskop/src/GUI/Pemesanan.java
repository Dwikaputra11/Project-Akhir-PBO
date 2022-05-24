package GUI;

import javax.swing.*;

import Class.Film;
import Class.Order;

import Connection.FilmDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Pemesanan {
    // -- DEKLARASI PANEL & FRAME
    private static JPanel panel;
    private static JFrame frame;

    // -- DEKLARASI LABEL KODE FILM
    private static JLabel kodeLabel;

    // -- DEKLARASI TEXT FIELD KODE FILM
    private static JTextField kodeTextField;

    // -- DEKLARASI LABEL JUMLAH SEAT
    private static JLabel jumlahSeatText;

    // -- DEKLARASI TEXT FIELD JUMLAH SEAT
    private static JTextField inputJumlahSeat;

    // -- DEKLARASI TOMBOL KEMBALI DAN SUBMIT
    private static JButton backButton;
    private static JButton submitButton;


    private static FilmDao filmDao = new FilmDao();
    private static Film film;
    private Order order;
    private String kode;
    private String username;

    // private OrderDao orderDao;
    private FilmDao filmDao = new FilmDao();

    private String username;

    public Pemesanan(String username){
        this.username = username;
    }
    private static FilmDao filmDao = new FilmDao();
    private static ArrayList<Film> filmList;

    public void initialize() {
        Order order = new Order();

        // -- DEKLARASI PANEL & FRAME
        panel = new JPanel();
        frame = new JFrame();

        // -- SET SIZE & TITLE FRAME
        frame.setSize(475, 405);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Pemesanan");

        // -- SET WARNA BACKGROUND & LAYOUT PANEL
        panel.setLayout(null);
        panel.setBackground(Color.white);

        // -- LABEL KODE FILM
        kodeLabel = new JLabel("Masukkan Kode Film :");
        kodeLabel.setBounds(180,80,200,25);

        kodeLabel.setForeground(Color.black);
        panel.add(kodeLabel);

        // -- TEXT FIELD KODE FILM
        kodeTextField = new JTextField();
        kodeTextField.setBounds(140,115,200,20);
        panel.add(kodeTextField);

        // -- LABEL JUMLAH SEAT
        jumlahSeatText = new JLabel("Masukkan Jumlah Seat yang Hendak Dipesan :");
        jumlahSeatText.setBounds(110,200,400,25);
        jumlahSeatText.setForeground(Color.black);
        panel.add(jumlahSeatText);

        // -- TEXT FIELD JUMLAH SEAT
        inputJumlahSeat = new JTextField();
        inputJumlahSeat.setBounds(140,235,200,20);
        panel.add(inputJumlahSeat);

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
        submitButton.setBounds(190, 300, 85, 25);
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
                            throw new Exception("Field Tidak Boleh Kosong!");
                        }
                    } else {
                        throw new Exception("Tidak Ada Film Yang Terdaftar!");
                    }
                } catch (Exception msg) {
                    JOptionPane.showMessageDialog(frame, msg.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);

                    JOptionPane.showMessageDialog(frame, msg.getMessage(), "Alert",JOptionPane.HEIGHT);

                    if(filmDao.isContainFilm()) { // -- JALANKAN APABILA ADA DATA DALAM DATABASE
                        Boolean kodeSama = false;
                        Boolean kelebihanJumlahSeat = false;
                        String currentCodeIndex;
                        filmList = filmDao.getFilmList();
                        for(int i = 0; i < filmList.size(); i++) {
                            String inputCode = kodeTextField.getText();
                            currentCodeIndex = filmList.get(i).getCode();
                            if(currentCodeIndex.equals(inputCode)) {
                                kodeSama = true;
                                int code = Integer.parseInt(currentCodeIndex);
                                order.setNoBooking(code);
                                break;
                            }
                        }

                        String jumlahSeat = inputJumlahSeat.getText();

                        // -- MENGECEK APAKAH INPUT JUMLAH SEAT KOSONG
                        if(jumlahSeat.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Jumlah Seat Tidak Boleh Kosong!", "Warning", JOptionPane.ERROR_MESSAGE);
                        }

                        int intJumlahSeat = Integer.parseInt(jumlahSeat);

                        // -- MEMASTIKAN JUMLAH SEAT HANYA BISA DIISI ANGKA 1 - 3
                        if((intJumlahSeat < 1) || (intJumlahSeat > 3)) {
                            kelebihanJumlahSeat = true;
                        } 

                        // -- APABILA KODE FILM YANG DIMASUKKAN TIDAK ADA DALAM DATABASE
                        if((!kodeSama) || (kelebihanJumlahSeat)) {
                            if(!kodeSama){
                                kodeTextField.setText("");
                                JOptionPane.showMessageDialog(frame, "Tidak Ditemukan Kode Film!", "Warning", JOptionPane.ERROR_MESSAGE);
                            }
                            if(kelebihanJumlahSeat) {
                                inputJumlahSeat.setText("");
                                JOptionPane.showMessageDialog(frame, "Jumlah Seat hanya bisa diisi 1-3 seat!", "Warning", JOptionPane.ERROR_MESSAGE);
                            } 
                        } else {
                            order.setTotalBooking(intJumlahSeat);
                            PemilihanSeat seat = new PemilihanSeat(order);
                            seat.initialize();
                            frame.dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Tidak ada kode film dalam database!", "Warning", JOptionPane.ERROR_MESSAGE);
                    }
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
