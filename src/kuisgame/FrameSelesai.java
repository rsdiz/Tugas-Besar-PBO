package kuisgame;

import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rosyid Iz
 */
public class FrameSelesai extends javax.swing.JFrame {
    
    Connection conn;
    Statement s;

    /**
     * Creates new form FrameSelesai
     */
    public FrameSelesai() {
        initComponents();
        conn = ConnectDB.getKoneksi();
        new EnableDrag(this);
        getScore();
    }
    
    private void getScore() {
        // mengambil score user setelah selesai mengerjakan kuis
        try {
            s = conn.createStatement();
            // Membuat Query SELECT
            String sql = "SELECT score FROM user ORDER BY id DESC LIMIT 1";
            ResultSet r = s.executeQuery(sql);
            while(r.next()){
                labelScore.setText(r.getString("score"));
            }
        } catch(SQLException e) {
            System.out.println("Terjadi Error! Gagal mengambil score");
        }
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
        closePanel = new javax.swing.JPanel();
        X = new javax.swing.JLabel();
        panelBase = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        buttonHomePage = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        buttonRankList = new javax.swing.JLabel();
        labelScore = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(252, 246, 246));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closePanel.setBackground(new java.awt.Color(205, 102, 132));
        closePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closePanelMouseClicked(evt);
            }
        });

        X.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        X.setForeground(new java.awt.Color(255, 255, 255));
        X.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        X.setText("X");
        closePanel.add(X);

        jPanel1.add(closePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 30, 30));

        panelBase.setBackground(new java.awt.Color(111, 90, 126));
        panelBase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBaseMouseClicked(evt);
            }
        });
        panelBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("THE CHAMP", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 174, 143));
        jLabel1.setText("<html>\n<center>\nSELAMAT!<br>\nANDA TELAH MENYELESAIKAN KUIS!\n</center>\n</html>");
        panelBase.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 103, 125));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TOTAL SCORE");
        panelBase.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        jPanel3.setBackground(new java.awt.Color(90, 73, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 2));
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 80));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonHomePage.setFont(new java.awt.Font("THE CHAMP", 0, 22)); // NOI18N
        buttonHomePage.setForeground(new java.awt.Color(240, 240, 240));
        buttonHomePage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonHomePage.setText("< HOME PAGE");
        buttonHomePage.setPreferredSize(new java.awt.Dimension(123, 23));
        buttonHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonHomePageMouseClicked(evt);
            }
        });
        jPanel3.add(buttonHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 3, 350, 80));

        panelBase.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 350, 80));

        jPanel4.setBackground(new java.awt.Color(90, 73, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 2));
        jPanel4.setPreferredSize(new java.awt.Dimension(350, 80));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonRankList.setFont(new java.awt.Font("THE CHAMP", 0, 22)); // NOI18N
        buttonRankList.setForeground(new java.awt.Color(240, 240, 240));
        buttonRankList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonRankList.setText("RANK LIST >");
        buttonRankList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRankListMouseClicked(evt);
            }
        });
        jPanel4.add(buttonRankList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 80));

        panelBase.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        labelScore.setFont(new java.awt.Font("THE CHAMP", 0, 36)); // NOI18N
        labelScore.setForeground(new java.awt.Color(255, 103, 125));
        labelScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelScore.setText("0000");
        labelScore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 103, 125), 2));
        labelScore.setOpaque(true);
        panelBase.add(labelScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 130, 70));

        jPanel1.add(panelBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 700, 400));

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
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closePanelMouseClicked
        PlayMusic play = new PlayMusic();
        play.stopMusic();
        this.dispose();
    }//GEN-LAST:event_closePanelMouseClicked

    private void buttonHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonHomePageMouseClicked
        this.setVisible(false);
        FrameWelcome welcome = new FrameWelcome();
        this.dispose();
        welcome.setVisible(true);
    }//GEN-LAST:event_buttonHomePageMouseClicked

    private void buttonRankListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRankListMouseClicked
        this.setVisible(false);
        RankList rankList = new RankList();
        this.dispose();
        rankList.setVisible(true);
    }//GEN-LAST:event_buttonRankListMouseClicked

    private void panelBaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBaseMouseClicked

    }//GEN-LAST:event_panelBaseMouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
            new PlayMusic().stopMusic();
        } else {
            new PlayMusic().playMusic();
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
            java.util.logging.Logger.getLogger(FrameSelesai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameSelesai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameSelesai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameSelesai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameSelesai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel X;
    private javax.swing.JLabel buttonHomePage;
    private javax.swing.JLabel buttonRankList;
    private javax.swing.JPanel closePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelScore;
    private javax.swing.JPanel panelBase;
    // End of variables declaration//GEN-END:variables
}
