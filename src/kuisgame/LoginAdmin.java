/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuisgame;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rosyid Iz
 */
public class LoginAdmin extends javax.swing.JFrame {
    
    Connection conn;
    Statement s;
    private static String username = "";

    /**
     * Creates new form LoginAdmin
     */
    public LoginAdmin() {
        initComponents();
        conn = ConnectDB.getKoneksi();
        new EnableDrag(this);
    }
    
    public String getUsername() {
        return username;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backToHome = new javax.swing.JLabel();
        labelTitleApp = new javax.swing.JLabel();
        labelTitleApp1 = new javax.swing.JLabel();
        inputUsername = new javax.swing.JTextField();
        inputPassword = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        panelCustomBar = new javax.swing.JPanel();
        buttonMinimized = new javax.swing.JLabel();
        buttonClose = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(460, 500));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(111, 90, 126));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backToHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backToHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kuisgame/home-1-very-small.png"))); // NOI18N
        backToHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToHomeMouseClicked(evt);
            }
        });
        jPanel1.add(backToHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        labelTitleApp.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        labelTitleApp.setForeground(new java.awt.Color(255, 174, 143));
        labelTitleApp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitleApp.setText("<html> <center>LOGIN ADMIN</center> </html");
        labelTitleApp.setAlignmentY(0.0F);
        jPanel1.add(labelTitleApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 460, 30));

        labelTitleApp1.setFont(new java.awt.Font("THE CHAMP", 0, 85)); // NOI18N
        labelTitleApp1.setForeground(new java.awt.Color(255, 174, 143));
        labelTitleApp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitleApp1.setText("<html> <center>KUIS<br/> GAME</center> </html");
        labelTitleApp1.setAlignmentY(0.0F);
        jPanel1.add(labelTitleApp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 460, 170));

        inputUsername.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        inputUsername.setForeground(new java.awt.Color(255, 103, 125));
        inputUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputUsername.setText("USERNAME");
        inputUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 103, 125), 2));
        jPanel1.add(inputUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 260, 50));

        inputPassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        inputPassword.setForeground(new java.awt.Color(255, 103, 125));
        inputPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputPassword.setText("Password");
        inputPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 103, 125), 2));
        jPanel1.add(inputPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 260, 50));

        loginButton.setBackground(new java.awt.Color(205, 102, 132));
        loginButton.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        loginButton.setForeground(new java.awt.Color(240, 240, 240));
        loginButton.setText("LOGIN");
        loginButton.setAlignmentY(0.0F);
        loginButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 200, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 460, 510));

        panelCustomBar.setBackground(new java.awt.Color(51, 51, 51));
        panelCustomBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonMinimized.setFont(new java.awt.Font("THE CHAMP", 0, 30)); // NOI18N
        buttonMinimized.setForeground(new java.awt.Color(255, 255, 255));
        buttonMinimized.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonMinimized.setText("_");
        buttonMinimized.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMinimizedMouseClicked(evt);
            }
        });
        panelCustomBar.add(buttonMinimized, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 40, 40));

        buttonClose.setFont(new java.awt.Font("THE CHAMP", 0, 30)); // NOI18N
        buttonClose.setForeground(new java.awt.Color(255, 255, 255));
        buttonClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonClose.setText("X");
        buttonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCloseMouseClicked(evt);
            }
        });
        panelCustomBar.add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 40, 40));

        jToggleButton1.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kuisgame/speaker.png"))); // NOI18N
        jToggleButton1.setBorder(null);
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToggleButton1.setOpaque(true);
        jToggleButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/kuisgame/speaker-mute.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        panelCustomBar.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        getContentPane().add(panelCustomBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMinimizedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMinimizedMouseClicked
        this.setState(FrameWelcome.ICONIFIED);
    }//GEN-LAST:event_buttonMinimizedMouseClicked

    private void buttonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCloseMouseClicked
        PlayMusic.stopMusic();
        this.dispose();
    }//GEN-LAST:event_buttonCloseMouseClicked

    private void backToHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToHomeMouseClicked
        this.setVisible(false);
        FrameWelcome welcome = new FrameWelcome();
        this.dispose();
        welcome.setVisible(true);
    }//GEN-LAST:event_backToHomeMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        
    }//GEN-LAST:event_jPanel1MouseClicked

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // mengecek username dan password yang diinput user dengan database
        // apabila sukses user di alihkan ke halaman panel admin
        // jika salah, muncul peringatan
        try {
            username = inputUsername.getText();
            String password = String.valueOf(inputPassword.getPassword());
            System.out.println(username + " . " + password);
            s = conn.createStatement();
            String sql = "SELECT * FROM admin WHERE username='" + username +
                         "' AND password = '" + password + "'";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String user = r.getString("username");
                String pass = r.getString("password");
                if (username.equals(user) && password.equals(pass)) {
                    JOptionPane.showMessageDialog(this, "Berhasil Login!",
                                "LOGIN", JOptionPane.INFORMATION_MESSAGE);
                }
                this.setVisible(false);
                PanelAdmin admin = new PanelAdmin();
                this.dispose();
                admin.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(this, "Username atau Password salah!",
                                                "LOGIN", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: " + e);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
            PlayMusic.stopMusic();
        } else {
            PlayMusic.playMusic();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginAdmin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backToHome;
    private javax.swing.JLabel buttonClose;
    private javax.swing.JLabel buttonMinimized;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JTextField inputUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelTitleApp;
    private javax.swing.JLabel labelTitleApp1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel panelCustomBar;
    // End of variables declaration//GEN-END:variables

}
