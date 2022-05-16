package GUI;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class HomeAdmin extends JFrame {
    // -- DEKLARASI PANEL & FRAME
    private static JPanel panel;
    private static JFrame frame;

    // -- DEKLARASI FONT MAIN MENU
    private static JLabel menu;

    // -- DEKLARASI PILIHAN MENU
    private static JLabel tambah;
    private static JLabel edit;
    private static JLabel hapus;
    private static JLabel logout;

    // -- DEKLARASI FONT YANG DIGUNAKAN
    final private static Font mainFont = new Font("TimesRoman", Font.BOLD, 20); 
    final private static Font secondaryFont = new Font("TimesRoman", Font.BOLD, 15); 

    public void initialize() {
        // -- INSTANSIASI PANEL & FRAME
        panel = new JPanel();
        frame = new JFrame();
        
        // -- SET SIZE & TITLE FRAME
        frame.setSize(375, 265);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Homepage");

        // -- SET WARNA BACKGROUND & LAYOUT PANEL
        panel.setLayout(null);
        panel.setBackground(Color.white);

        // -- MAIN MENU TEXT
        menu = new JLabel("Main Menu");
        menu.setBounds(130,20,200,30);
        menu.setFont(mainFont);
        menu.setForeground(Color.black);
        panel.add(menu);

        // -- TAMBAHKAN FILM
        tambah = new JLabel("1.   Tambahkan Film");
        tambah.setBounds(95,70,170,30);
        tambah.setFont(secondaryFont);
        tambah.setForeground(Color.black);
        tambah.addMouseListener(new MouseInputAdapter() {
           @Override
           public void mouseClicked(MouseEvent ev) {
               try {
                   Tambah tambah = new Tambah();
                   tambah.initialize();
                   frame.dispose();
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }
           }
            // -- MEMUNCULKAN UNDERLINE APABILA MOUSE LEWAT TOMBOL TAMBAHKAN
            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    Font font = tambah.getFont();
                    Map<TextAttribute,Object> attributes = new HashMap<>(font.getAttributes());
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                    tambah.setFont(font.deriveFont(attributes));
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }

            // -- MENGHILANGKAN UNDERLINE PADA TOMBOL TAMBAH APABILA MOUSE TIDAK LEWAT TOMBOL
            @Override
            public void mouseExited(MouseEvent e) {
                try {
                    Font font = tambah.getFont();
                    Map<TextAttribute,Object> attributes = new HashMap<>(font.getAttributes());
                    attributes.put(TextAttribute.UNDERLINE, -1);
                    tambah.setFont(font.deriveFont(attributes));
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });
        panel.add(tambah);

        // -- EDIT FILM
        edit = new JLabel("2.   Edit Film");
        edit.setBounds(95,100,150,30);
        edit.setFont(secondaryFont);
        edit.setForeground(Color.black);
        edit.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent ev) {
                try {
                    Lihat edit = new Lihat();
                    edit.initialize();
                    frame.dispose();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
             // -- MEMUNCULKAN UNDERLINE APABILA MOUSE LEWAT TOMBOL EDIT FILM
             @Override
             public void mouseEntered(MouseEvent e) {
                 try {
                     Font font = edit.getFont();
                     Map<TextAttribute,Object> attributes = new HashMap<>(font.getAttributes());
                     attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                     edit.setFont(font.deriveFont(attributes));
                 } catch(Exception exception) {
                     System.out.println(exception.getMessage());
                 }
             }
 
             // -- MENGHILANGKAN UNDERLINE PADA TOMBOL EDIT FILM APABILA MOUSE TIDAK LEWAT TOMBOL
             @Override
             public void mouseExited(MouseEvent e) {
                 try {
                     Font font = edit.getFont();
                     Map<TextAttribute,Object> attributes = new HashMap<>(font.getAttributes());
                     attributes.put(TextAttribute.UNDERLINE, -1);
                     edit.setFont(font.deriveFont(attributes));
                 } catch(Exception exception) {
                     System.out.println(exception.getMessage());
                 }
             }
         });
        panel.add(edit);

        // -- HAPUS FILM
        hapus = new JLabel("3.   Hapus Film");
        hapus.setBounds(95,130,150,30);
        hapus.setFont(secondaryFont);
        hapus.setForeground(Color.black);
        hapus.addMouseListener(new MouseInputAdapter() {
           @Override
           public void mouseClicked(MouseEvent ev) {
               try {
                   Pemesanan hapus = new Pemesanan();
                   hapus.initialize();
                   frame.dispose();
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }
           }
            // -- MEMUNCULKAN UNDERLINE APABILA MOUSE LEWAT TOMBOL HAPUS FILM
            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    Font font = hapus.getFont();
                    Map<TextAttribute,Object> attributes = new HashMap<>(font.getAttributes());
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                    hapus.setFont(font.deriveFont(attributes));
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }

            // -- MENGHILANGKAN UNDERLINE PADA TOMBOL HAPUS FILM APABILA MOUSE TIDAK LEWAT TOMBOL
            @Override
            public void mouseExited(MouseEvent e) {
                try {
                    Font font = hapus.getFont();
                    Map<TextAttribute,Object> attributes = new HashMap<>(font.getAttributes());
                    attributes.put(TextAttribute.UNDERLINE, -1);
                    hapus.setFont(font.deriveFont(attributes));
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });
        panel.add(hapus);

        // -- MEKANISME TOMBOL LOGOUT
        logout = new JLabel("4.   Logout");
        logout.setBounds(95,160,150,30);
        logout.setFont(secondaryFont);
        logout.setForeground(Color.black);
        logout.addMouseListener(new MouseInputAdapter() {
            // -- APABILA TOMBOL LOGOUT DI CLICK
            @Override
            public void mouseClicked(MouseEvent ev) {
                try {
                    int opsiKonfirmasi = JOptionPane.showConfirmDialog(frame, "Yakin ingin logout?", "Konfirmasi",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (opsiKonfirmasi == JOptionPane.YES_OPTION) {
                        Login login = new Login();
                        login.initialize();
                        frame.dispose();
                    } 
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            // -- MEMUNCULKAN UNDERLINE APABILA MOUSE LEWAT TOMBOL LOGOUT
            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    Font font = logout.getFont();
                    Map<TextAttribute,Object> attributes = new HashMap<>(font.getAttributes());
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                    logout.setFont(font.deriveFont(attributes));
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }

            // -- MENGHILANGKAN UNDERLINE PADA TOMBOL LOGOUT APABILA MOUSE TIDAK LEWAT TOMBOL
            @Override
            public void mouseExited(MouseEvent e) {
                try {
                    Font font = logout.getFont();
                    Map<TextAttribute,Object> attributes = new HashMap<>(font.getAttributes());
                    attributes.put(TextAttribute.UNDERLINE, -1);
                    logout.setFont(font.deriveFont(attributes));
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
         });
        panel.add(logout);

        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR
        frame.setVisible(true); // -- MEMUNCULKAN WINDOW

    }
}
