package GUI;

import Connection.Connector;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Login extends JFrame {
    // -- DEKLARASI PANEL & FRAME
    private static JPanel panel;
    private static JFrame frame;
    
    // -- DEKLARASI LABEL DAN TEXT FIELD LOGIN
    private static JLabel userLabelLogin;
    private static JTextField userTextLogin;
    private static JLabel passwordLabelLogin;
    private static JPasswordField passwordTextLogin;
    private static JButton loginButton;

    // -- DEKLARASI NAVIGASI ANTARA TOMBOL REGISTER DAN LOGIN
    private static JLabel gotoRegisterLabel;
    private static JLabel goToRegisterButton;

    // final private static Font mainFont = new Font("Roboto", Font.BOLD, 13); FONT GAJADI DIPAKAI WKWK

    public void initialize() {
        Connector connector = new Connector();

        // -- INSTANSIASI PANEL & FRAME
        panel = new JPanel();
        frame = new JFrame();
        
        // -- SET SIZE & TITLE FRAME
        frame.setSize(375, 265);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Login");

        // -- SET WARNA BACKGROUND & LAYOUT PANEL
        panel.setLayout(null);
        panel.setBackground(Color.white);

        // -- FONT USERNAME
        userLabelLogin = new JLabel("Username");
        userLabelLogin.setBounds(15,20,80,25);
        // userLabelLogin.setFont(mainFont); TIDAK JADI DIPAKAI TAPI TETAP DITARUH SINI BIAR INGET SIAPA TAU BESOK KEPAKAI
        userLabelLogin.setForeground(Color.black);
        panel.add(userLabelLogin);

        // -- TEXT FIELD INPUT USERNAME
        userTextLogin = new JTextField(20);
        userTextLogin.setBounds(100,20,165,25);
        panel.add(userTextLogin);

        // -- FONT PASSWORD
        passwordLabelLogin = new JLabel("Password");
        passwordLabelLogin.setBounds(15,60,80,25);
        // passwordLabelLogin.setFont(mainFont);
        passwordLabelLogin.setForeground(Color.black);
        panel.add(passwordLabelLogin);

        // -- TEXT FIELD INPUT PASSWORD
        passwordTextLogin = new JPasswordField();
        passwordTextLogin.setBounds(100,60,165,25);
        panel.add(passwordTextLogin);

        // -- BUTTON UNTUK LOGIN
        loginButton = new JButton("Masuk");
        loginButton.setBounds(140,105,80,25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int jumlah = 0;
                String username = userTextLogin.getText();
                String password = new String(passwordTextLogin.getPassword());
                Boolean berhasilLogin = false;
                Boolean berhasilLoginAdmin = false;
                try { 
                    String data[][] = new String[100][3];
                    String query = "select * from users";
                    PreparedStatement pstmt = connector.koneksi.prepareStatement(query);
                    connector.statement = connector.koneksi.createStatement();
                    ResultSet resultSet = pstmt.executeQuery(query);

                    // -- MENGECEK USERNAME DAN PASSWORD ADMIN
                    if(("admin".equals(username)) && ("admin".equals(password))) {
                        berhasilLoginAdmin = true;
                    }

                    // -- MENGECEK USERNAME DAN PASSWORD USER
                    if (berhasilLoginAdmin.equals(false)) {
                        while (resultSet.next()) {
                            data[jumlah][0] = String.valueOf(resultSet.getInt("id")); // ngambil int jadikan string
                            data[jumlah][1] = resultSet.getString("username"); // ngambil string biasa
                            data[jumlah][2] = resultSet.getString("password");

                            // -- MENGECEK USERNAME DAN PASSWORD
                            if((data[jumlah][1].equals(username)) && (data[jumlah][2].equals(password))) {
                                berhasilLogin = true;
                                break;
                            }
                            jumlah++;
                        }
                    }

                    // -- JIKA BERHASIL LOGIN SEBAGAI ADMIN
                    if (berhasilLoginAdmin.equals(true)) {
                        HomeAdmin admin = new HomeAdmin();
                        admin.initialize();
                    }

                    // -- JIKA BERHASIL LOGIN SEBAGAI USER 
                    if (berhasilLogin.equals(true)) {
                        // JOptionPane.showMessageDialog(frame, "Login Berhasil!");
                        HomeUser user = new HomeUser();
                        user.initialize();
                    } 
                    
                    // -- JIKA TIDAK BERHASIL LOGIN
                    if (berhasilLogin.equals(false) && berhasilLoginAdmin.equals(false)){
                        JOptionPane.showMessageDialog(frame, "Kesalahan Username/Password!", "Alert", HEIGHT);
                    }
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });
        panel.add(loginButton);
        loginButton.setForeground(Color.black);

        // -- FONT BELUM MEMILIKI AKUN?
        gotoRegisterLabel = new JLabel("Belum Memiliki Akun?");
        gotoRegisterLabel.setBounds(105,115,250,125);
        gotoRegisterLabel.setForeground(Color.black);
        panel.add(gotoRegisterLabel);

        // -- TOMBOL MASUK KE HALAMAN PENDAFTARAN
        goToRegisterButton = new JLabel("Daftar");
        goToRegisterButton.setBounds(233,167,85,20);
        goToRegisterButton.setForeground(new Color(0,51,204));
        goToRegisterButton.addMouseListener(new MouseInputAdapter() {
            // -- APABILA TOMBOL DAFTAR DI CLICK
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Register register = new Register();
                    register.initialize();
                    frame.dispose();
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }

            // -- MEMUNCULKAN UNDERLINE APABILA MOUSE LEWAT TOMBOL DAFTAR
            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    Font font = goToRegisterButton.getFont();
                    Map<TextAttribute,Object> attributes = new HashMap<>(font.getAttributes());
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                    goToRegisterButton.setFont(font.deriveFont(attributes));
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }

            // -- MENGHILANGKAN UNDERLINE PADA TOMBOL DAFTAR APABILA MOUSE TIDAK LEWAT TOMBOL
            @Override
            public void mouseExited(MouseEvent e) {
                try {
                    Font font = goToRegisterButton.getFont();
                    Map<TextAttribute,Object> attributes = new HashMap<>(font.getAttributes());
                    attributes.put(TextAttribute.UNDERLINE, -1);
                    goToRegisterButton.setFont(font.deriveFont(attributes));
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });
        panel.add(goToRegisterButton);

        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR
        frame.setVisible(true); // -- MEMUNCULKAN WINDOW
    }
}