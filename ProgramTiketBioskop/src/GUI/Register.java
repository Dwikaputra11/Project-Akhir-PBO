package GUI;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import Connection.Connector;

import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Register {
    // -- DEKLARASI PANEL & FRAME
    private static JPanel panel;
    private static JFrame frame;

    // -- DEKLARASI LABEL DAN TEXT FIELD LOGIN
    private static JLabel userLabelRegister;
    private static JTextField userTextRegister;
    private static JLabel passwordLabelRegister;
    private static JPasswordField passwordTextRegister;
    private static JButton registerButton;

    // -- DEKLARASI NAVIGASI ANTARA TOMBOL REGISTER DAN LOGIN
    private static JLabel goToLoginLabel;
    private static JLabel goToLoginButton;

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
        frame.setTitle("Register");

        // -- SET WARNA BACKGROUND & LAYOUT PANEL
        panel.setLayout(null);
        panel.setBackground(Color.white);

         // -- FONT USERNAME
         userLabelRegister = new JLabel("Username");
         userLabelRegister.setBounds(15,20,80,25);
         panel.add(userLabelRegister);
         // userLabelLogin.setFont(mainFont); TIDAK JADI DIPAKAI TAPI TETAP DITARUH SINI BIAR INGET SIAPA TAU BESOK KEPAKAI
         userLabelRegister.setForeground(Color.black);
 
         // -- TEXT FIELD INPUT USERNAME
         userTextRegister = new JTextField(20);
         userTextRegister.setBounds(100,20,165,25);
         panel.add(userTextRegister);
 
         // -- FONT PASSWORD
         passwordLabelRegister = new JLabel("Password");
         passwordLabelRegister.setBounds(15,60,80,25);
         panel.add(passwordLabelRegister);
         // passwordLabelRegister.setFont(mainFont);
         passwordLabelRegister.setForeground(Color.black);
 
         // -- TEXT FIELD INPUT PASSWORD
         passwordTextRegister = new JPasswordField();
         passwordTextRegister.setBounds(100,60,165,25);
         panel.add(passwordTextRegister);
 
         // -- BUTTON UNTUK REGISTER
         registerButton = new JButton("Daftar");
         registerButton.setBounds(135,105,90,25);
         registerButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                int jumlah = 0;
                String username = userTextRegister.getText();
                String password = new String(passwordTextRegister.getPassword());
                Boolean textFieldKosong = false;
                Boolean usernameSama = false;
                 try {
                    // -- MENGECEK APAKAH TEXT FIELD KOSONG
                    if((username.isEmpty()) || (password.isEmpty())) {
                        textFieldKosong = true;
                    }

                    if(textFieldKosong == false) {
                        // ---MENGECEK USERNAME YANG SAMA
                        String data[][] = new String[100][3]; // reminder : getJumlahData tu while loop kaya di bawah make resultSet.next() dengan int jumlah++ doang
                        String querySelect = "select * from users";
                        PreparedStatement pstmtSelect = connector.koneksi.prepareStatement(querySelect);
                        connector.statement = connector.koneksi.createStatement();
                        ResultSet resultSet = pstmtSelect.executeQuery(querySelect);

                        // -- MENGECEK APAKAH USERNAME ADA YANG SAMA
                        while (resultSet.next()) {
                            data[jumlah][0] = String.valueOf(resultSet.getInt("id")); // ngambil int jadikan string
                            data[jumlah][1] = resultSet.getString("username"); // ngambil string
                            data[jumlah][2] = resultSet.getString("password");
                            if(data[jumlah][1].equals(username)) {
                                usernameSama = true;
                                break;
                            }
                            jumlah++;
                        }

                        // -- JIKA USERNAME ADA YANG SAMA
                        if(usernameSama == true) {
                            JOptionPane.showMessageDialog(frame, "Username Telah Digunakan!");
                            userTextRegister.setText("");
                            passwordTextRegister.setText("");
                        } else {
                            // -- QUERY INSERT KE DATABASE
                            String queryInsert = "insert into users(username, password) values (?,?)";
                            PreparedStatement pstmtInsert = connector.koneksi.prepareStatement(queryInsert);
                            pstmtInsert.setString(1, getUsernameRegister());
                            pstmtInsert.setString(2, getPasswordRegister());
                            connector.statement = connector.koneksi.createStatement();
                            pstmtInsert.executeUpdate();
                            JOptionPane.showMessageDialog(frame, "Registrasi Berhasil!");
                        }
                    } else {
                        // -- JIKA TEXT FIELD KOSONG
                        JOptionPane.showMessageDialog(frame, "Username/Password tidak boleh kosong!");
                        userTextRegister.setText("");
                        passwordTextRegister.setText("");
                    }
                 } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                 }
             }
         });
         panel.add(registerButton);
         registerButton.setForeground(Color.black);

         // -- FONT SUDAH MEMILIKI AKUN?
        goToLoginLabel = new JLabel("Sudah Memiliki Akun?");
        goToLoginLabel.setBounds(105,115,250,125);
        goToLoginLabel.setForeground(Color.black);
        panel.add(goToLoginLabel);

        // -- TOMBOL MASUK KE HALAMAN LOGIN
        goToLoginButton = new JLabel("Masuk");
        goToLoginButton.setBounds(233,167,85,20);
        goToLoginButton.setForeground(new Color(0,51,204));
        goToLoginButton.addMouseListener(new MouseInputAdapter() {
            // -- APABILA TOMBOL DAFTAR DI CLICK
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Login login = new Login();
                    login.initialize();
                    frame.dispose();
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }

            // -- MEMUNCULKAN UNDERLINE APABILA MOUSE LEWAT TOMBOL DAFTAR
            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    Font font = goToLoginButton.getFont();
                    Map<TextAttribute,Object> attributes = new HashMap<>(font.getAttributes());
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                    goToLoginButton.setFont(font.deriveFont(attributes));
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        
            // -- MENGHILANGKAN UNDERLINE PADA TOMBOL DAFTAR APABILA MOUSE TIDAK LEWAT TOMBOL
            @Override
            public void mouseExited(MouseEvent e) {
                try {
                    Font font = goToLoginButton.getFont();
                    Map<TextAttribute,Object> attributes = new HashMap<>(font.getAttributes());
                    attributes.put(TextAttribute.UNDERLINE, -1);
                    goToLoginButton.setFont(font.deriveFont(attributes));
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });
        panel.add(goToLoginButton);

        frame.setLocationRelativeTo(null); // -- BIKIN WINDOW PROGRAM DI TENGAH LAYAR
        frame.setVisible(true);
    }

    public String getUsernameRegister() {
        return userTextRegister.getText();
    }

    public String getPasswordRegister() {
        return new String(passwordTextRegister.getPassword());
    }
}
