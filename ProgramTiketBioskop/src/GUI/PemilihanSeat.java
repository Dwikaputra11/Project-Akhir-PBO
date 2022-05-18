package GUI;

import javax.swing.*;
import javax.swing.border.Border;

import Class.Film;
import Class.Order;
import Connection.OrderDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class PemilihanSeat extends JFrame {
    // -- DEKLARASI PANEL & FRAME
    private static JPanel panel;
    private static JFrame frame;

    // -- DEKLARASI TABEL KODE FILM
    private static JTable kodeTable;

    // -- DEKLARASI LABEL GAMBAR POSISI SEAT
    private static JLabel labelGambar;
    private static JLabel labelSeat;

    // -- DEKLARASI TOMBOL KEMBALI DAN SUBMIT
    private static JButton backButton;
    private static JButton submitButton;
    private static JTextField noSeat;

    final private static Font mainFont = new Font("TimesRoman", Font.BOLD, 17); 

    Border border = BorderFactory.createLineBorder(Color.gray,1);

    private Film film;
    private static OrderDao orderDao = new OrderDao();
    private int noBooking;
    private String username;
    private ArrayList<String> seats = new ArrayList<>();
    private String seat;

    public PemilihanSeat(Film film,String username){
        this.film = film;
        this.username =  username;
    }

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

        labelSeat = new JLabel("Masukkan no Seat :");
        labelSeat.setBounds(545, 470, 305, 25);
        labelSeat.setFont(mainFont);
        labelSeat.setForeground(Color.black);
        panel.add(labelSeat);

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
        noSeat = new JTextField();
        // submitTextField.setFont(mainFont);
        noSeat.setBounds(465, 500, 305, 25);
        noSeat.setForeground(Color.black);
        panel.add(noSeat);

        // -- SUBMIT BUTTON
        submitButton = new JButton("Submit");
        submitButton.setFont(mainFont);
        submitButton.setBounds(575, 550, 85, 35);
        submitButton.setForeground(Color.black);
        submitButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    seat = noSeat.getText().toUpperCase();
                    if(!seat.isBlank()){
                        JPanel panelConfirm = new JPanel();
                        panelConfirm.setSize(new Dimension(250, 50));
                        panelConfirm.setLayout(null);
                        JLabel label1 = new JLabel("Yakin dengan pemesanan ?");
                        label1.setVerticalAlignment(SwingConstants.BOTTOM);
                        label1.setBounds(70, 20, 250, 30);
                        label1.setHorizontalAlignment(SwingConstants.CENTER);
                        panelConfirm.add(label1);
                        UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
                        int res = JOptionPane.showConfirmDialog(null, panelConfirm, "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
    
                        if(res==0){ 
                            noBooking = generatedNumber();
                            seats.add(seat);
                            Order order = new Order(noBooking,username,film.getName(),film.getDate(),seats);
                            orderDao.AddOrder(order);
                            Checkout checkout = new Checkout(order);
                            checkout.initialize();
                            frame.dispose();
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
    public static int generatedNumber(){
        int leftLimit = 48; // letter '0'
        int rightLimit = 57; // letter '9'
        int targetStringLength = 6;
        int generatedNumber;
        do{
            Random random = new Random();
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int) 
                (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            generatedNumber = Integer.parseInt(buffer.toString());
        }while(orderDao.isOrderExist(generatedNumber));

        return generatedNumber;
    }
}
