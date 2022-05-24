package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Class.Order;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PemilihanSeat extends JFrame {
    // -- DEKLARASI PANEL & FRAME
    private static JPanel panel;
    private static JFrame frame;

    // -- DEKLARASI TABEL KODE FILM
    private static JTable kodeTable;

    // -- DEKLARASI LABEL GAMBAR POSISI SEAT
    private static JLabel labelGambar;;
    private static String[] seatNumber;
    // private static ArrayList<String>[] cobaTampil;
    private static JLabel[] seatLabel;
    private static JTextField[] submitField;

    private Order order;

    // -- DEKLARASI TOMBOL KEMBALI DAN SUBMIT
    private static JButton backButton;
    private static JButton submitButton;

    final private static Font mainFont = new Font("TimesRoman", Font.BOLD, 17); 

    Border border = BorderFactory.createLineBorder(Color.gray,1);


    public PemilihanSeat(Order order) {
        this.order = order;
    }

    public void initialize() {
        PemilihanSeat.seatNumber = new String[3];
        PemilihanSeat.seatLabel = new JLabel[3];
        PemilihanSeat.submitField = new JTextField[3];
        // PemilihanSeat.cobaTampil = new ArrayList<String>[3];

        Object[][] data = {{"masuk","keluar","besok"},{"satellite"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"},{"sad"}};
        Object[] namaKolom = {"Nama", "No Hp", "Usia", "E-mail", "Dwika"};

        DefaultTableModel dtm = new DefaultTableModel(data, namaKolom);

        // -- DEKLARASI PANEL & FRAME
        panel = new JPanel();
        frame = new JFrame();

        // -- SET SIZE & TITLE FRAME
        frame.setSize(1250, 650);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Pemilihan Seat");

        // -- SET WARNA BACKGROUND & LAYOUT PANEL
        panel.setLayout(null);
        panel.setBackground(Color.white);

        // -- LABEL GAMBAR POSISI SEAT
        labelGambar = new JLabel();
        labelGambar.setBounds(600,70,600,350);
        labelGambar.setIcon(new ImageIcon("C:\\dev\\Java\\Project-Akhir-PBO\\ProgramTiketBioskop\\img\\seat.png"));
        labelGambar.setBorder(border);
        panel.add(labelGambar);

        JScrollPane sp = new JScrollPane();

        // -- TABEL SEAT TERSEDIA
        kodeTable = new JTable(dtm);
        kodeTable.setBounds(40,70,530,350);
        kodeTable.setBorder(border);
        sp.setViewportView(kodeTable);
        add(new JScrollPane(kodeTable));
        panel.add(kodeTable);

        validate();

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
        
        int xLabel1 = 145;
        int xLabel2 = 65;
         // -- MENAMPILKAN FIELD PENGISIAN SEAT
         for(int i = 0; i < totalBooking; i++) {
            // -- LABEL NO SEAT
                seatLabel[i] = new JLabel("Masukkan Seat no " + (i + 1) + " :");
                seatLabel[i].setBounds(xLabel1, 470, 305, 25);
                seatLabel[i].setFont(mainFont);
                seatLabel[i].setForeground(Color.black);
                panel.add(seatLabel[i]);
    
                xLabel1 += 400;
    
            // -- SUBMIT FIELD 
                submitField[i] = new JTextField();
                submitField[i].setBounds(xLabel2, 500, 305, 25);
                submitField[i].setForeground(Color.black);
                panel.add(submitField[i]);
    
                xLabel2 += 400;
                // cobaTampil[i] = order.getSeat();
            }

        // -- SUBMIT BUTTON
        submitButton = new JButton("Submit");
        submitButton.setBounds(575, 550, 85, 35);
        submitButton.setForeground(Color.black);
        submitButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    // Cek Field Kosong
                    if(isFilled()){
                        int res = JOptionPane.showConfirmDialog(frame, "Yakin dengan Pemesanan",
                         "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
                        
                        // Hasil Confirm = YES
                        if(res == JOptionPane.YES_OPTION){ 
                            noBooking = generatedNumber();
                            order.setNoBooking(noBooking);
                            ArrayList<String> seats = new ArrayList<>();
                            for(int i = 0; i < totalBooking; i++){
                                seats.add(submitField[i].getText().toUpperCase());
                            }
                            order.setSeats(seats);
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

    // Fungsi Field Kosong
    boolean isFilled(){
        for(int i = 0; i < totalBooking; i++){
            if(submitField[i].getText().isBlank()) return false;
        }
        return true;
    }
}
