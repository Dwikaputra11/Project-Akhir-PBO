package GUI;

import javax.swing.*;
import java.awt.*;

public class Tambah extends JFrame {
    // -- DEKLARASI PANEL & FRAME
    private static JPanel panel;
    private static JFrame frame;

    // -- DEKLARASI TITLE TAMBAHKAN FILM
    private static JLabel menu;

    // -- DEKLARASI LABEL DAN TEXT FIELD FILE
    private static JLabel labelNama;
    private static JTextField textFieldNama;
    private static JLabel labelKode;
    private static JTextField textFieldKode;
    private static JLabel labelSinopsis;
    private static JTextField textFieldSinopsis;
    private static JButton buttonSubmit;

    // -- DEKLARASI LABEL DAN DROP FIELD IMAGE
    private static JLabel labelGambar;

    // -- DEKLARASI FONT YANG DIGUNAKAN
    final private static Font mainFont = new Font("TimesRoman", Font.BOLD, 20); 
    final private static Font secondaryFont = new Font("TimesRoman", Font.BOLD, 18); 

    public void initialize() {
        // -- INSTANSIASI PANEL & FRAME
        panel = new JPanel();
        frame = new JFrame();
        
        // -- SET SIZE & TITLE FRAME
        frame.setSize(750, 650);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Tambahkan Film");

        // -- SET WARNA BACKGROUND & LAYOUT PANEL
        panel.setLayout(null);
        panel.setBackground(Color.white);

        // -- MAIN MENU TEXT
        menu = new JLabel("Menu Tambahkan Film");
        menu.setBounds(280,20,300,30);
        menu.setFont(mainFont);
        menu.setForeground(Color.black);
        panel.add(menu);

        // -- LABEL NAMA
        labelNama = new JLabel("Nama Film ");
        labelNama.setBounds(50,80,170,30);
        labelNama.setFont(secondaryFont);
        labelNama.setForeground(Color.black);
        panel.add(labelNama);

        // -- TEXTFIELD NAMA
        textFieldNama = new JTextField(50);
        textFieldNama.setBounds(200, 85, 290, 25);
        panel.add(textFieldNama);

        // -- LABEL KODE
        labelKode = new JLabel("Kode Film ");
        labelKode.setBounds(50,120,170,30);
        labelKode.setFont(secondaryFont);
        labelKode.setForeground(Color.black);
        panel.add(labelKode);

        // -- TEXTFIELD KODE FILM
        textFieldKode = new JTextField(50);
        textFieldKode.setBounds(200, 125, 290, 25);
        panel.add(textFieldKode);

        // -- LABEL SINOPSIS
        labelSinopsis = new JLabel("Sinopsis Film ");
        labelSinopsis.setBounds(50,160,170,30);
        labelSinopsis.setFont(secondaryFont);
        labelSinopsis.setForeground(Color.black);
        panel.add(labelSinopsis);

        // -- TEXTFIELD SINOPSIS
        textFieldSinopsis = new JTextField(50);
        textFieldSinopsis.setBounds(200, 165, 480, 205);
        panel.add(textFieldSinopsis);

        // -- LABEL GAMBAR
        labelGambar = new JLabel("Poster Film ");
        labelGambar.setBounds(50,380,170,30);
        labelGambar.setFont(secondaryFont);
        labelGambar.setForeground(Color.black);
        panel.add(labelGambar);

        // -- BUTTON SUBMIT
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(390, 550, 80, 25);
        buttonSubmit.setForeground(Color.black);
        panel.add(buttonSubmit);


        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR
        frame.setVisible(true); // -- MEMUNCULKAN WINDOW

    }
}
