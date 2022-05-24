package GUI;

import javax.swing.*;
import javax.swing.border.Border;

// import com.toedter.calendar.JDateChooser;

import Class.Film;
import Connection.FilmDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.io.File;
// import java.text.SimpleDateFormat;
// import java.util.Random;

public class Delete extends JFrame {
    // -- DEKLARASI PANEL & FRAME
    private static JPanel panel;
    private static JFrame frame;

    // -- DEKLARASI TITLE TAMBAHKAN FILM
    private static JLabel menu;

    // -- DEKLARASI LABEL DAN TEXT FIELD FILE
    private static JLabel labelNama;
    // private static JLabel textFieldNama;
    private static JLabel labelKode;
    private static JLabel textFieldKode;
    private static JLabel labelSinopsis;
    private static JTextArea textSinopsis;
    private static JButton buttonSubmit;
    private static JLabel labelPenampilGambar;
    private static JLabel labelTanggal;
    private static JLabel pilihTanggal;

    // -- DEKLARASI LABEL DAN DROP FIELD IMAGE
    private static JLabel labelGambar;

    // -- DEKLARASI FONT YANG DIGUNAKAN
    final private static Font mainFont = new Font("TimesRoman", Font.BOLD, 20); 
    final private static Font secondaryFont = new Font("TimesRoman", Font.BOLD, 18); 
    // final private static Font thirdFont = new Font("TimesRoman", Font.PLAIN, 14);

    final private Border border = BorderFactory.createLineBorder(Color.gray,1);

    private Film film;
    private FilmDao filmDao = new FilmDao();

    public Delete(Film film){
        this.film = film;
    }

    public void initialize() {
        // -- INSTANSIASI PANEL & FRAME
        panel = new JPanel();
        frame = new JFrame();
        
        // -- SET SIZE & TITLE FRAME
        frame.setSize(750, 790);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Edit Film");

        // -- SET WARNA BACKGROUND & LAYOUT PANEL
        panel.setLayout(null);
        panel.setBackground(Color.white);

        // -- MAIN MENU TEXT
        menu = new JLabel("Menu Edit Film");
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
        labelNama = new JLabel(film.getName());
        labelNama.setBounds(200, 85, 290, 25);
        panel.add(labelNama);

        // -- LABEL KODE
        labelKode = new JLabel("Kode Film ");
        labelKode.setBounds(50,120,170,30);
        labelKode.setFont(secondaryFont);
        labelKode.setForeground(Color.black);
        panel.add(labelKode);

        // -- TEXTFIELD KODE FILM
        textFieldKode = new JLabel(film.getCode());
        textFieldKode.setBounds(200, 125, 290, 25);
        textFieldKode.setFont(secondaryFont);
        textFieldKode.setForeground(Color.black);
        panel.add(textFieldKode);

        // -- LABEL SINOPSIS
        labelSinopsis = new JLabel("Sinopsis Film ");
        labelSinopsis.setBounds(50,160,170,30);
        labelSinopsis.setFont(secondaryFont);
        labelSinopsis.setForeground(Color.black);
        panel.add(labelSinopsis);

        // -- TEXTAREA SINOPSIS
        textSinopsis = new JTextArea(film.getSynopsis());
        textSinopsis.setBounds(200, 165, 480, 205);
        textSinopsis.setLineWrap(true);
        textSinopsis.setEditable(false);
        textSinopsis.setForeground(Color.BLACK);
        panel.add(textSinopsis);

        // -- LABEL GAMBAR
        labelGambar = new JLabel("Poster Film ");
        labelGambar.setBounds(50,380,170,30);
        labelGambar.setFont(secondaryFont);
        labelGambar.setForeground(Color.black);
        panel.add(labelGambar);

        // -- BUTTON SUBMIT
        buttonSubmit = new JButton("Delete");
        buttonSubmit.setBounds(390, 680, 80, 25);
        buttonSubmit.setForeground(Color.black);
        buttonSubmit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JPanel panelConfirm = new JPanel();
                    panelConfirm.setSize(new Dimension(250, 50));
                    panelConfirm.setLayout(null);
                    JLabel label1 = new JLabel("Yakin ingin menghapus??");
                    label1.setVerticalAlignment(SwingConstants.BOTTOM);
                    label1.setBounds(70, 20, 250, 30);
                    label1.setHorizontalAlignment(SwingConstants.CENTER);
                    panelConfirm.add(label1);
                    UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
                    int res = JOptionPane.showConfirmDialog(null, panelConfirm, "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

                    if(res==0){
                        if(filmDao.deleteFilm(film.getCode())){
                            JOptionPane.showMessageDialog(frame, "Film Berhasil Dihapus!");
                        } 
                    } 
                            
                }catch(Exception exception){
                    System.err.println(exception.getMessage());
                }
            }
        });
        panel.add(buttonSubmit);
        // -- LABEL PENAMPIL GAMBAR
        labelPenampilGambar = new JLabel();
        labelPenampilGambar.setBounds(200,380,180,150);
        labelPenampilGambar.setFont(secondaryFont);
        labelPenampilGambar.setForeground(Color.black);
        labelPenampilGambar.setBorder(border);
        labelPenampilGambar.setIcon(new ImageIcon(new ImageIcon(film.getImageUrl()).getImage().getScaledInstance(labelPenampilGambar.getWidth(), labelPenampilGambar.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(labelPenampilGambar);


        // -- LABEL PILIH TANGGAL
        labelTanggal = new JLabel("Tanggal");
        labelTanggal.setBounds(50,500,180,150);
        labelTanggal.setFont(secondaryFont);
        labelTanggal.setForeground(Color.black);
        panel.add(labelTanggal);

        pilihTanggal = new JLabel();
        pilihTanggal.setBounds(200,565,250,30);
        pilihTanggal.setText(film.getDate());
        panel.add(pilihTanggal);

        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR
        frame.setVisible(true); // -- MEMUNCULKAN WINDOW
        
    }

}
