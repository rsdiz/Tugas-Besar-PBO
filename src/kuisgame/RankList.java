package kuisgame;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Rosyid Iz
 */
public class RankList extends javax.swing.JFrame {
    
    Connection conn;
    Statement s;
    DefaultTableModel scoreModel;
    CustomHeaderScore customHeader = new CustomHeaderScore();
    DefaultTableCellRenderer centerTxt = new DefaultTableCellRenderer();

    /**
     * Creates new form RankList
     */
    public RankList() {
        initComponents();
        conn = ConnectDB.getKoneksi();
        new EnableDrag(this);
        scoreModel = (DefaultTableModel) tableScore.getModel();
        tableScore.setModel(scoreModel);
        TableColumnModel tbl = tableScore.getColumnModel();
        tbl.getColumn(0).setPreferredWidth(30);
        tbl.getColumn(1).setPreferredWidth(190);
        tbl.getColumn(2).setPreferredWidth(80);
        centerTxt.setHorizontalAlignment(JLabel.CENTER);
        tableScore.getColumnModel().getColumn(0).setCellRenderer(centerTxt);
        tableScore.getColumnModel().getColumn(2).setCellRenderer(centerTxt);
        tableScore.getTableHeader().setBackground(Color.BLACK);
        tableScore.getTableHeader().setDefaultRenderer(customHeader);
        LoadData();
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
        panelRightWelcome = new javax.swing.JPanel();
        labelTopScore = new javax.swing.JLabel();
        panelScore = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableScore = new javax.swing.JTable();
        imgPiala = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        topUser1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        imgPiala1 = new javax.swing.JLabel();
        topUser2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        imgPiala2 = new javax.swing.JLabel();
        topUser3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        labelTopScore1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        buttonBackHome = new javax.swing.JButton();
        panelCustomBar = new javax.swing.JPanel();
        buttonMinimized = new javax.swing.JLabel();
        buttonClose = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(820, 560));
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

        panelRightWelcome.setBackground(new java.awt.Color(111, 90, 126));
        panelRightWelcome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTopScore.setFont(new java.awt.Font("THE CHAMP", 0, 34)); // NOI18N
        labelTopScore.setForeground(new java.awt.Color(255, 174, 143));
        labelTopScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTopScore.setText("BEST PLAYER");
        panelRightWelcome.add(labelTopScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 420, -1));

        panelScore.setBackground(new java.awt.Color(51, 51, 51));
        panelScore.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelScore.setOpaque(false);
        panelScore.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setFont(new java.awt.Font("THE CHAMP", 0, 12)); // NOI18N

        tableScore.setBackground(new java.awt.Color(51, 51, 51));
        tableScore.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        tableScore.setForeground(new java.awt.Color(255, 103, 125));
        tableScore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "NAMA", "SCORE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableScore.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableScore.setAutoscrolls(false);
        tableScore.setGridColor(new java.awt.Color(255, 103, 125));
        tableScore.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableScore.setRowHeight(35);
        tableScore.setRowSelectionAllowed(false);
        tableScore.getTableHeader().setReorderingAllowed(false);
        tableScore.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tableScore);

        panelScore.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 410));

        panelRightWelcome.add(panelScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 300, 410));

        imgPiala.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgPiala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kuisgame/piala-small.png"))); // NOI18N
        panelRightWelcome.add(imgPiala, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TOP #1");
        panelRightWelcome.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 90, 30));

        topUser1.setFont(new java.awt.Font("THE CHAMP Gradient", 0, 24)); // NOI18N
        topUser1.setForeground(new java.awt.Color(255, 173, 173));
        topUser1.setText("NAMA USER #1");
        panelRightWelcome.add(topUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));
        panelRightWelcome.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 420, 10));
        panelRightWelcome.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 420, 10));

        imgPiala1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgPiala1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kuisgame/piala-small.png"))); // NOI18N
        panelRightWelcome.add(imgPiala1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        topUser2.setFont(new java.awt.Font("THE CHAMP Gradient", 0, 24)); // NOI18N
        topUser2.setForeground(new java.awt.Color(255, 173, 173));
        topUser2.setText("NAMA USER #2");
        panelRightWelcome.add(topUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TOP #2");
        panelRightWelcome.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 90, 30));
        panelRightWelcome.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 420, 10));

        imgPiala2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgPiala2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kuisgame/piala-small.png"))); // NOI18N
        panelRightWelcome.add(imgPiala2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, -1, -1));

        topUser3.setFont(new java.awt.Font("THE CHAMP Gradient", 0, 24)); // NOI18N
        topUser3.setForeground(new java.awt.Color(255, 173, 173));
        topUser3.setText("NAMA USER #3");
        panelRightWelcome.add(topUser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TOP #3");
        panelRightWelcome.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 90, 30));
        panelRightWelcome.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 420, 10));

        labelTopScore1.setFont(new java.awt.Font("THE CHAMP", 0, 34)); // NOI18N
        labelTopScore1.setForeground(new java.awt.Color(255, 174, 143));
        labelTopScore1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTopScore1.setText("SCORE");
        panelRightWelcome.add(labelTopScore1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 300, -1));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelRightWelcome.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 10, 470));

        buttonBackHome.setBackground(new java.awt.Color(255, 103, 125));
        buttonBackHome.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        buttonBackHome.setForeground(new java.awt.Color(255, 255, 255));
        buttonBackHome.setText("BACK TO HOME");
        buttonBackHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackHomeActionPerformed(evt);
            }
        });
        panelRightWelcome.add(buttonBackHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 260, 50));

        panelBase.add(panelRightWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 500));

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

        getContentPane().add(panelCustomBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelBaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBaseMouseClicked

    }//GEN-LAST:event_panelBaseMouseClicked

    private void buttonMinimizedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMinimizedMouseClicked
        this.setState(FrameWelcome.ICONIFIED);
    }//GEN-LAST:event_buttonMinimizedMouseClicked

    private void buttonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCloseMouseClicked
        PlayMusic.stopMusic();
        this.dispose();
    }//GEN-LAST:event_buttonCloseMouseClicked

    private void buttonBackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackHomeActionPerformed
        this.setVisible(false);
        PlayMusic.setBGM("src/tetris.wav");
        FrameWelcome welcome = new FrameWelcome();
        this.dispose();
        welcome.setVisible(true);
    }//GEN-LAST:event_buttonBackHomeActionPerformed

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
            java.util.logging.Logger.getLogger(RankList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RankList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RankList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RankList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RankList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBackHome;
    private javax.swing.JLabel buttonClose;
    private javax.swing.JLabel buttonMinimized;
    private javax.swing.JLabel imgPiala;
    private javax.swing.JLabel imgPiala1;
    private javax.swing.JLabel imgPiala2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelTopScore;
    private javax.swing.JLabel labelTopScore1;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelCustomBar;
    private javax.swing.JPanel panelRightWelcome;
    private javax.swing.JPanel panelScore;
    private javax.swing.JTable tableScore;
    private javax.swing.JLabel topUser1;
    private javax.swing.JLabel topUser2;
    private javax.swing.JLabel topUser3;
    // End of variables declaration//GEN-END:variables

    private void LoadData() {
        // Mengambil data dari tabel user, kemudian di tambahkan ke scoreModel
        // Kemudian mengambil 3 nama dengan score tertinggi dari tabel user
        // lalu, menset label menjadi nama-nama tersebut
        try {
            s = conn.createStatement();
            String query = "SELECT * FROM user ORDER BY score DESC";
            ResultSet r = s.executeQuery(query);
            int i = 1;
            while(r.next()){
                Object [] obj = new Object[3];
                obj[0] = i;
                obj[1] = r.getString("nama");
                obj[2] = r.getInt("score");
                i++;
                scoreModel.addRow(obj);
            }
            String [] topUser = new String[3];
            query = "SELECT nama FROM user ORDER BY score DESC LIMIT 3";
            r = s.executeQuery(query);
            i = 0;
            while(r.next()) {
                topUser[i] = r.getString("nama");
                i++;
            }
            // set text label menjadi nama user
            topUser1.setText(topUser[0]);
            topUser2.setText(topUser[1]);
            topUser3.setText(topUser[2]);
        } catch (SQLException e) {
            System.out.println("Error: Tidak Bisa Mengambil Data Score!");
        }
    }
    
}