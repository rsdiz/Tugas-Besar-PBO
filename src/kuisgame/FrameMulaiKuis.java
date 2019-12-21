package kuisgame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Timer;

/**
 *
 * @author Rosyid Iz
 */
public final class FrameMulaiKuis extends javax.swing.JFrame {
    String soal, player;
    String A, B, C, D;
    private int urutan = 1;
    String jawaban;
    int score = 0;
    /**
     * Creates new form FrameMulaiKuis
     */
    public FrameMulaiKuis() {
        initComponents();
        enableDrag(this);
        getNamePlayer();
        tampilSoal();
    }

    void getNamePlayer() {
        try {
            // Membuat Koneksi
            Connection conn = ConnectDB.getKoneksi();
            Statement s = conn.createStatement();
            // Membuat Query SELECT
            String sql = "SELECT nama FROM user ORDER BY id DESC LIMIT 1";
            ResultSet r = s.executeQuery(sql);
            while(r.next()){
                labelPlayer.setText(r.getString("nama"));
            }
        } catch(SQLException e) {
            System.out.println("Terjadi Error! Gagal mengambil nama");
        }
    }
    
    void setScore(int score) {
        try {
            // Membuat Koneksi
            Connection conn = ConnectDB.getKoneksi();
            Statement s = conn.createStatement();
            // Membuat Query SELECT
            String sql = "UPDATE user SET score = ? ORDER BY id DESC LIMIT 1";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, score);
            p.executeUpdate();
            p.close();
        } catch(SQLException e) {
            System.out.println("Terjadi Error! Nama tidak tersimpan");
        }
    }
    
    private void toEnd(){
        if( this.urutan > getBatas() ) {
            setScore(score);
            this.setVisible(false);
            FrameSelesai end = new FrameSelesai();
            this.dispose();
            end.setVisible(true);
        }
    }
    
    private int getBatas(){
        int jmlSoal = 0;
        try {
            // Membuat Koneksi
            Connection conn = ConnectDB.getKoneksi();
            Statement s = conn.createStatement();
            // Membuat Query SELECT
            String sql = "SELECT COUNT(*) AS jumlah FROM soal";
            ResultSet r = s.executeQuery(sql);
            while(r.next()){
                jmlSoal = r.getInt("jumlah");
            }
        } catch(SQLException e) {
            System.out.println("Terjadi Error!");
        }
        return jmlSoal;
    }
    
    boolean getJawaban(String jawabanUser){
        String benar = "";
        try {
            // Membuat Koneksi
            Connection conn = ConnectDB.getKoneksi();
            Statement s = conn.createStatement();
            // Membuat Query SELECT
            String sql = "SELECT * FROM soal WHERE soal.id_soal = " + urutan ;
            ResultSet r = s.executeQuery(sql);
            while(r.next()){
                benar = r.getString("jawaban");
            }
        } catch(SQLException e) {
            System.out.println("Terjadi Error!");
        }
        return jawabanUser.equals(benar);
    }
    
    void tampilSoal(){
        try {
            // Membuat Koneksi
            Connection conn = ConnectDB.getKoneksi();
            Statement s = conn.createStatement();
            // Membuat Query SELECT
            String sql = "SELECT * FROM soal INNER JOIN jawaban ON soal.id_soal = jawaban.id_soal WHERE soal.id_soal = " + urutan ;
            
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                soal = r.getString("soal");
                A = r.getString("jawaban_a");
                B = r.getString("jawaban_b");
                C = r.getString("jawaban_c");
                D = r.getString("jawaban_d");
            }
            // Membuat data di dalam database baris per baris
            jLabel3.setText(soal);
            buttonA.setText(A);
            buttonB.setText(B);
            buttonC.setText(C);
            buttonD.setText(D);
            
        } catch(SQLException e) {
            System.out.println("Terjadi Error!");
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

        panelBase = new javax.swing.JPanel();
        panelInfo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelPlayer = new javax.swing.JLabel();
        panelSoal = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        buttonC = new javax.swing.JButton();
        buttonA = new javax.swing.JButton();
        buttonB = new javax.swing.JButton();
        buttonD = new javax.swing.JButton();
        hitungMundur = new javax.swing.JProgressBar();
        panelCustomBar = new javax.swing.JPanel();
        buttonMinimized = new javax.swing.JLabel();
        buttonClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBase.setBackground(new java.awt.Color(255, 255, 255));
        panelBase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBaseMouseClicked(evt);
            }
        });
        panelBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInfo.setBackground(new java.awt.Color(111, 90, 126));
        panelInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("00:00");
        panelInfo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 80, -1));

        labelPlayer.setFont(new java.awt.Font("THE CHAMP", 0, 18)); // NOI18N
        labelPlayer.setForeground(new java.awt.Color(255, 255, 255));
        labelPlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPlayer.setText("nama");
        panelInfo.add(labelPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, 40));

        panelBase.add(panelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 500));

        panelSoal.setBackground(new java.awt.Color(252, 246, 246));
        panelSoal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelSoal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 660, -1));

        jLabel1.setFont(new java.awt.Font("THE CHAMP", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(205, 102, 132));
        jLabel1.setText("KUIS");
        panelSoal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 40));

        jPanel3.setBackground(new java.awt.Color(205, 102, 132));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 560, 180));

        panelSoal.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 620, 240));

        buttonC.setBackground(new java.awt.Color(205, 102, 132));
        buttonC.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        buttonC.setForeground(new java.awt.Color(51, 51, 51));
        buttonC.setText("JAWABAN 2");
        buttonC.setBorder(null);
        buttonC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCMouseClicked(evt);
            }
        });
        panelSoal.add(buttonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 290, 50));

        buttonA.setBackground(new java.awt.Color(205, 102, 132));
        buttonA.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        buttonA.setForeground(new java.awt.Color(51, 51, 51));
        buttonA.setText("JAWABAN 1");
        buttonA.setBorder(null);
        buttonA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAMouseClicked(evt);
            }
        });
        panelSoal.add(buttonA, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 290, 50));

        buttonB.setBackground(new java.awt.Color(205, 102, 132));
        buttonB.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        buttonB.setForeground(new java.awt.Color(51, 51, 51));
        buttonB.setText("JAWABAN 3");
        buttonB.setBorder(null);
        buttonB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBMouseClicked(evt);
            }
        });
        panelSoal.add(buttonB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 290, 50));

        buttonD.setBackground(new java.awt.Color(205, 102, 132));
        buttonD.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        buttonD.setForeground(new java.awt.Color(51, 51, 51));
        buttonD.setText("JAWABAN 4");
        buttonD.setBorder(null);
        buttonD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDMouseClicked(evt);
            }
        });
        panelSoal.add(buttonD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 290, 50));

        hitungMundur.setForeground(new java.awt.Color(51, 255, 0));
        hitungMundur.setMaximum(60);
        hitungMundur.setToolTipText("");
        hitungMundur.setValue(60);
        hitungMundur.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                hitungMundurAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        panelSoal.add(hitungMundur, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 620, 30));

        panelBase.add(panelSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 660, 500));

        getContentPane().add(panelBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 820, 520));

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
        panelCustomBar.add(buttonMinimized, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 40, 40));

        buttonClose.setFont(new java.awt.Font("THE CHAMP", 0, 30)); // NOI18N
        buttonClose.setForeground(new java.awt.Color(255, 255, 255));
        buttonClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonClose.setText("X");
        buttonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCloseMouseClicked(evt);
            }
        });
        panelCustomBar.add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 40, 40));

        getContentPane().add(panelCustomBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAMouseClicked
        jawaban = "A";
        if(getJawaban(jawaban)){
            this.score += 10;
        }
        this.urutan++;
        toEnd();
        tampilSoal();
    }//GEN-LAST:event_buttonAMouseClicked

    private void buttonCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCMouseClicked
        jawaban = "C";
        if(getJawaban(jawaban)){
            this.score += 10;
        }
        this.urutan++;
        toEnd();
        tampilSoal();
    }//GEN-LAST:event_buttonCMouseClicked

    private void buttonBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBMouseClicked
        jawaban = "B";
        if(getJawaban(jawaban)){
            this.score += 10;
        }
        this.urutan++;
        toEnd();
        tampilSoal();
    }//GEN-LAST:event_buttonBMouseClicked

    private void buttonDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDMouseClicked
        jawaban = "D";
        if(getJawaban(jawaban)){
            this.score += 10;
        }
        this.urutan++;
        toEnd();
        tampilSoal();
    }//GEN-LAST:event_buttonDMouseClicked

    private void panelBaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBaseMouseClicked

    }//GEN-LAST:event_panelBaseMouseClicked

    private void buttonMinimizedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMinimizedMouseClicked
        this.setState(FrameWelcome.ICONIFIED);
    }//GEN-LAST:event_buttonMinimizedMouseClicked

    private void buttonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_buttonCloseMouseClicked
    
    private void hitungMundurAncestorAdded(javax.swing.event.AncestorEvent evt) {
        hitungMundur.setValue(100);
        ActionListener listener = new ActionListener() {
            int counter = 60;
            @Override
            public void actionPerformed(ActionEvent ae) {
                counter--;
                hitungMundur.setValue(counter);
                if (urutan > getBatas()) {
                    timer.stop();
                } else if (counter < 1) {
                    timer.stop();
                    urutan = getBatas() + 1;
                    toEnd();
                }
            }
        };
        timer = new Timer(100, listener);
        timer.start();
    }    

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
            java.util.logging.Logger.getLogger(FrameMulaiKuis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMulaiKuis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMulaiKuis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMulaiKuis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMulaiKuis().setVisible(true);
            }
        });
    }
    private Timer timer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonA;
    private javax.swing.JButton buttonB;
    private javax.swing.JButton buttonC;
    private javax.swing.JLabel buttonClose;
    private javax.swing.JButton buttonD;
    private javax.swing.JLabel buttonMinimized;
    private javax.swing.JProgressBar hitungMundur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelPlayer;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelCustomBar;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelSoal;
    // End of variables declaration//GEN-END:variables

    private void enableDrag(Component c) {
        DragListener customBar = new DragListener();
        c.addMouseListener(customBar);
        c.addMouseMotionListener(customBar);
    }
}
