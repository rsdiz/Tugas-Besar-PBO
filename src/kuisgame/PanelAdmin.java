/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuisgame;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Rosyid Iz
 */
public class PanelAdmin extends javax.swing.JFrame {
    
    private Connection conn;
    private Statement s;
    private DefaultTableModel soalModel;
    
    String updateSoal = "";
    String updateKunci = "";
    String updateJabawanA = "";
    String updateJabawanB = "";
    String updateJabawanC = "";
    String updateJabawanD = "";
    int updateID = 0, updateK = 0;
    

    /**
     * Creates new form PanelAdmin
     */
    public PanelAdmin() {
        initComponents();
        conn = ConnectDB.getKoneksi(); // koneksi ke database
        // buat model table
        soalModel = (DefaultTableModel) tableLihatSoal.getModel();
        tableLihatSoal.setModel(soalModel);
        TableColumnModel tbl = tableLihatSoal.getColumnModel();
        tbl.getColumn(0).setPreferredWidth(20); // atur ukuran kolom
        tbl.getColumn(1).setPreferredWidth(270);
        LoadData(); // load data dari database
        // mengambil nama username admin
        labelUsername.setText(new LoginAdmin().getUsername());
        clickKolom(); // method untuk edit data dari tabel
        new EnableDrag(this); // membuat fitur drag titleBar
        panelHomePage.setVisible(true); // menampilkan panelHome
        panelSoal.setVisible(false); // menyembunyikan panelSoal
    }
    
    void clickKolom(){
        tableLihatSoal.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    panelLihatSoal.setVisible(false);
                    panelTambahSoal.setVisible(true);
                    buttonTambahSoal.setVisible(false);
                    buttonSubmitSoal.setVisible(false);
                    buttonEditSoal.setVisible(true);
                    try {
                        s = conn.createStatement();
                        updateID = table.getSelectedRow() + 1;
                        String query = "SELECT * FROM soal INNER JOIN jawaban ON soal.id_soal = jawaban.id_soal WHERE soal.id_soal = " + updateID;
                        ResultSet r = s.executeQuery(query);
                        while(r.next()){
                            updateSoal = r.getString("soal");
                            updateKunci = r.getString("jawaban");
                            updateJabawanA = r.getString("jawaban_a");
                            updateJabawanB = r.getString("jawaban_b");
                            updateJabawanC = r.getString("jawaban_c");
                            updateJabawanD = r.getString("jawaban_d");
                        }
                        fieldPertanyaan.setText(updateSoal);
                        jawabanA.setText(updateJabawanA);
                        jawabanB.setText(updateJabawanB);
                        jawabanC.setText(updateJabawanC);
                        jawabanD.setText(updateJabawanD);
                        
                        switch (updateKunci) {
                            case "A":
                                radioA.setSelected(true);
                                updateK = 1;
                                break;
                            case "B":
                                radioB.setSelected(true);
                                updateK = 2;
                                break;
                            case "C":
                                radioC.setSelected(true);
                                updateK = 3;
                                break;
                            case "D":
                                radioD.setSelected(true);
                                updateK = 4;
                                break;
                            default:
                                break;
                        }
                        
                    } catch (SQLException e) {
                        System.out.println("Error: Tidak Bisa Mengambil Data Score!");
                    }
                    
                    
                } else if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
                    tableLihatSoal.setEnabled(false);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupJawaban = new javax.swing.ButtonGroup();
        panelBase = new javax.swing.JPanel();
        panelListDashboard = new javax.swing.JPanel();
        labelTitleApp = new javax.swing.JLabel();
        buttonKeluar = new javax.swing.JButton();
        buttonHomePage = new javax.swing.JButton();
        buttonSoal = new javax.swing.JButton();
        panelSoal = new javax.swing.JPanel();
        labelTitleSoal = new javax.swing.JLabel();
        buttonEditSoal = new javax.swing.JButton();
        buttonSubmitSoal = new javax.swing.JButton();
        buttonTambahSoal = new javax.swing.JButton();
        panelLihatSoal = new javax.swing.JScrollPane();
        tableLihatSoal = new javax.swing.JTable();
        panelTambahSoal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldPertanyaan = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jawabanB = new javax.swing.JTextField();
        radioB = new javax.swing.JRadioButton();
        radioA = new javax.swing.JRadioButton();
        jawabanA = new javax.swing.JTextField();
        radioC = new javax.swing.JRadioButton();
        jawabanC = new javax.swing.JTextField();
        jawabanD = new javax.swing.JTextField();
        radioD = new javax.swing.JRadioButton();
        panelHomePage = new javax.swing.JPanel();
        labelTitleApp1 = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        labelTotalSoal = new javax.swing.JLabel();
        countTotalSoal = new javax.swing.JLabel();
        labelTotalUser = new javax.swing.JLabel();
        countTotalUser = new javax.swing.JLabel();
        panelCustomBar = new javax.swing.JPanel();
        buttonClose = new javax.swing.JLabel();
        buttonMinimized = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 540));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(500, 540));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBaseMouseClicked(evt);
            }
        });
        panelBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelListDashboard.setBackground(new java.awt.Color(111, 90, 126));
        panelListDashboard.setMaximumSize(new java.awt.Dimension(185, 500));
        panelListDashboard.setMinimumSize(new java.awt.Dimension(185, 500));
        panelListDashboard.setPreferredSize(new java.awt.Dimension(185, 500));
        panelListDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitleApp.setFont(new java.awt.Font("THE CHAMP", 0, 48)); // NOI18N
        labelTitleApp.setForeground(new java.awt.Color(255, 174, 143));
        labelTitleApp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitleApp.setText("<html> <center>KUIS<br/> GAME</center> </html");
        panelListDashboard.add(labelTitleApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 180));

        buttonKeluar.setBackground(new java.awt.Color(205, 102, 132));
        buttonKeluar.setFont(new java.awt.Font("THE CHAMP", 0, 18)); // NOI18N
        buttonKeluar.setForeground(new java.awt.Color(240, 240, 240));
        buttonKeluar.setText("KELUAR");
        buttonKeluar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarActionPerformed(evt);
            }
        });
        panelListDashboard.add(buttonKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 170, 50));

        buttonHomePage.setBackground(new java.awt.Color(205, 102, 132));
        buttonHomePage.setFont(new java.awt.Font("THE CHAMP", 0, 18)); // NOI18N
        buttonHomePage.setForeground(new java.awt.Color(240, 240, 240));
        buttonHomePage.setText("HOME PAGE");
        buttonHomePage.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonHomePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHomePageActionPerformed(evt);
            }
        });
        panelListDashboard.add(buttonHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 170, 50));

        buttonSoal.setBackground(new java.awt.Color(205, 102, 132));
        buttonSoal.setFont(new java.awt.Font("THE CHAMP", 0, 18)); // NOI18N
        buttonSoal.setForeground(new java.awt.Color(240, 240, 240));
        buttonSoal.setText("SOAL");
        buttonSoal.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonSoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSoalActionPerformed(evt);
            }
        });
        panelListDashboard.add(buttonSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 170, 50));

        panelBase.add(panelListDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, -1));

        panelSoal.setBackground(new java.awt.Color(255, 255, 255));
        panelSoal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitleSoal.setFont(new java.awt.Font("THE CHAMP", 0, 36)); // NOI18N
        labelTitleSoal.setForeground(new java.awt.Color(255, 103, 125));
        labelTitleSoal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitleSoal.setText("<html> <center>SOAL</center> </html");
        labelTitleSoal.setToolTipText("");
        labelTitleSoal.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelSoal.add(labelTitleSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 60));

        buttonEditSoal.setBackground(new java.awt.Color(255, 103, 125));
        buttonEditSoal.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        buttonEditSoal.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditSoal.setText("UBAH");
        buttonEditSoal.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonEditSoal.setBorderPainted(false);
        buttonEditSoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditSoalActionPerformed(evt);
            }
        });
        panelSoal.add(buttonEditSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 270, 50));

        buttonSubmitSoal.setBackground(new java.awt.Color(255, 103, 125));
        buttonSubmitSoal.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        buttonSubmitSoal.setForeground(new java.awt.Color(255, 255, 255));
        buttonSubmitSoal.setText("TAMBAHKAN");
        buttonSubmitSoal.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonSubmitSoal.setBorderPainted(false);
        buttonSubmitSoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubmitSoalActionPerformed(evt);
            }
        });
        panelSoal.add(buttonSubmitSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 270, 50));

        buttonTambahSoal.setBackground(new java.awt.Color(255, 103, 125));
        buttonTambahSoal.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        buttonTambahSoal.setForeground(new java.awt.Color(255, 255, 255));
        buttonTambahSoal.setText("TAMBAH SOAL +");
        buttonTambahSoal.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonTambahSoal.setBorderPainted(false);
        buttonTambahSoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahSoalActionPerformed(evt);
            }
        });
        panelSoal.add(buttonTambahSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 270, 50));

        panelLihatSoal.setAlignmentX(0.0F);
        panelLihatSoal.setAlignmentY(0.0F);

        tableLihatSoal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "SOAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableLihatSoal.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableLihatSoal.setAutoscrolls(false);
        tableLihatSoal.setCellSelectionEnabled(true);
        tableLihatSoal.setRowHeight(40);
        tableLihatSoal.setRowMargin(2);
        tableLihatSoal.setUpdateSelectionOnSort(false);
        panelLihatSoal.setViewportView(tableLihatSoal);

        panelSoal.add(panelLihatSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 137, 290, 350));

        panelTambahSoal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldPertanyaan.setColumns(20);
        fieldPertanyaan.setRows(5);
        jScrollPane1.setViewportView(fieldPertanyaan);

        panelTambahSoal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 270, 120));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Pertanyaan:");
        panelTambahSoal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 30));

        jawabanB.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jawabanB.setText("Pilihan B");
        panelTambahSoal.add(jawabanB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 240, 40));

        buttonGroupJawaban.add(radioB);
        panelTambahSoal.add(radioB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        buttonGroupJawaban.add(radioA);
        panelTambahSoal.add(radioA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jawabanA.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jawabanA.setText("Pilihan A");
        panelTambahSoal.add(jawabanA, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 240, 40));

        buttonGroupJawaban.add(radioC);
        panelTambahSoal.add(radioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jawabanC.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jawabanC.setText("Pilihan C");
        panelTambahSoal.add(jawabanC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 240, 40));

        jawabanD.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jawabanD.setText("Pilihan D");
        panelTambahSoal.add(jawabanD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 240, 40));

        buttonGroupJawaban.add(radioD);
        panelTambahSoal.add(radioD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        panelSoal.add(panelTambahSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 290, 360));

        panelBase.add(panelSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 310, 500));

        panelHomePage.setBackground(new java.awt.Color(255, 255, 255));
        panelHomePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitleApp1.setFont(new java.awt.Font("THE CHAMP", 0, 36)); // NOI18N
        labelTitleApp1.setForeground(new java.awt.Color(255, 103, 125));
        labelTitleApp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitleApp1.setText("<html> <center>SELAMAT<br/>DATANG</center> </html");
        labelTitleApp1.setToolTipText("");
        labelTitleApp1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelHomePage.add(labelTitleApp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 120));

        labelUsername.setFont(new java.awt.Font("THE CHAMP", 0, 36)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(255, 103, 125));
        labelUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsername.setText("username");
        panelHomePage.add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 250, 40));

        labelTotalSoal.setBackground(new java.awt.Color(111, 90, 126));
        labelTotalSoal.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        labelTotalSoal.setForeground(new java.awt.Color(240, 240, 240));
        labelTotalSoal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotalSoal.setText("TOTAL SOAL");
        labelTotalSoal.setOpaque(true);
        panelHomePage.add(labelTotalSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 170, 50));

        countTotalSoal.setBackground(new java.awt.Color(255, 174, 143));
        countTotalSoal.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        countTotalSoal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countTotalSoal.setText("00");
        countTotalSoal.setOpaque(true);
        panelHomePage.add(countTotalSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 70, 50));

        labelTotalUser.setBackground(new java.awt.Color(111, 90, 126));
        labelTotalUser.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        labelTotalUser.setForeground(new java.awt.Color(240, 240, 240));
        labelTotalUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotalUser.setText("TOTAL user");
        labelTotalUser.setOpaque(true);
        panelHomePage.add(labelTotalUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 170, 50));

        countTotalUser.setBackground(new java.awt.Color(255, 174, 143));
        countTotalUser.setFont(new java.awt.Font("THE CHAMP", 0, 24)); // NOI18N
        countTotalUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countTotalUser.setText("00");
        countTotalUser.setOpaque(true);
        panelHomePage.add(countTotalUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 70, 50));

        panelBase.add(panelHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 310, 500));

        getContentPane().add(panelBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 500, 500));

        panelCustomBar.setBackground(new java.awt.Color(51, 51, 51));
        panelCustomBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonClose.setFont(new java.awt.Font("THE CHAMP", 0, 30)); // NOI18N
        buttonClose.setForeground(new java.awt.Color(255, 255, 255));
        buttonClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonClose.setText("X");
        buttonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCloseMouseClicked(evt);
            }
        });
        panelCustomBar.add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 40, 40));

        buttonMinimized.setFont(new java.awt.Font("THE CHAMP", 0, 30)); // NOI18N
        buttonMinimized.setForeground(new java.awt.Color(255, 255, 255));
        buttonMinimized.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonMinimized.setText("_");
        buttonMinimized.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMinimizedMouseClicked(evt);
            }
        });
        panelCustomBar.add(buttonMinimized, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 40, 40));

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

        getContentPane().add(panelCustomBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMinimizedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMinimizedMouseClicked
        this.setState(FrameWelcome.ICONIFIED);
    }//GEN-LAST:event_buttonMinimizedMouseClicked

    private void buttonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCloseMouseClicked
        PlayMusic play = new PlayMusic();
        play.stopMusic();
        this.dispose();
    }//GEN-LAST:event_buttonCloseMouseClicked

    private void panelBaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBaseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelBaseMouseClicked

    private void buttonHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomePageActionPerformed
        panelHomePage.setVisible(true);
        panelSoal.setVisible(false);
    }//GEN-LAST:event_buttonHomePageActionPerformed

    private void buttonSoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSoalActionPerformed
        panelSoal.setVisible(true);
        panelLihatSoal.setVisible(true);
        buttonTambahSoal.setVisible(true);
        buttonSubmitSoal.setVisible(false);
        panelTambahSoal.setVisible(false);
        panelHomePage.setVisible(false);
        buttonEditSoal.setVisible(false);
        tableLihatSoal.setEnabled(true);
        LoadData();
        
    }//GEN-LAST:event_buttonSoalActionPerformed

    private void buttonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarActionPerformed
        this.setVisible(false);
        FrameWelcome welcome = new FrameWelcome();
        this.dispose();
        welcome.setVisible(true);
    }//GEN-LAST:event_buttonKeluarActionPerformed

    private void buttonTambahSoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahSoalActionPerformed
        panelLihatSoal.setVisible(false);
        panelTambahSoal.setVisible(true);
        buttonTambahSoal.setVisible(false);
        buttonSubmitSoal.setVisible(true);
        buttonEditSoal.setVisible(false);
    }//GEN-LAST:event_buttonTambahSoalActionPerformed

    private void buttonSubmitSoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubmitSoalActionPerformed
        try {
            s = conn.createStatement();
            String query = "INSERT INTO soal VALUES(null,?,?)";
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, fieldPertanyaan.getText());
            if(radioA.isSelected()){
               p.setString(2, "A"); 
            }
            else if(radioB.isSelected()){
                p.setString(2, "B"); 
            }
            else if(radioC.isSelected()){
                p.setString(2, "C"); 
            }
            else if(radioD.isSelected()){
                p.setString(2, "D"); 
            }
            
            p.executeUpdate();
            p.close();
            
            query = "SELECT id_soal FROM soal ORDER BY id_soal DESC LIMIT 1";
            
            s = conn.createStatement();
      
            ResultSet r = s.executeQuery(query);
            int idSoal = 0;
            while(r.next()){
                idSoal = r.getInt("id_soal");
            }
            
            query = "INSERT INTO jawaban VALUES(null,?,?,?,?,?)";
            p = conn.prepareStatement(query);
            p.setInt(1, idSoal);
            p.setString(2, jawabanA.getText());
            p.setString(3, jawabanB.getText());
            p.setString(4, jawabanC.getText());
            p.setString(5, jawabanD.getText());
            
            p.executeUpdate();
            p.close();
            
            JOptionPane.showMessageDialog(this, "Berhasil Menambahkan Soal!", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
            fieldPertanyaan.setText("");
            jawabanA.setText("");
            jawabanB.setText("");
            jawabanC.setText("");
            jawabanD.setText("");
            buttonGroupJawaban.clearSelection();
            
        } catch (SQLException e) {
            System.out.println("Error: Tidak Bisa Mengambil Data Score!");
        }
            
    }//GEN-LAST:event_buttonSubmitSoalActionPerformed

    private void buttonEditSoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditSoalActionPerformed
        // ketika tombol editSoal di klik, maka data yang diinputkan user akan 
        // di simpan kedalam database
        try{
            updateSoal = fieldPertanyaan.getText();
            if(radioA.isSelected()) updateK = 1; 
            else if(radioB.isSelected()) updateK = 2;
            else if(radioC.isSelected()) updateK = 3;
            else if(radioD.isSelected()) updateK = 4;
            updateJabawanA = jawabanA.getText();
            updateJabawanB = jawabanB.getText();
            updateJabawanC = jawabanC.getText();
            updateJabawanD = jawabanD.getText();
            String sql = "UPDATE soal INNER JOIN jawaban ON soal.id_soal = jawaban.id_soal"
                        +" SET soal.soal = ? ,"
                        +"     soal.jawaban = ? ,"
                        +"     jawaban.jawaban_a = ? ,"
                        +"     jawaban.jawaban_b = ? ,"
                        +"     jawaban.jawaban_c = ? ,"
                        +"     jawaban.jawaban_d = ? WHERE soal.id_soal =  ?;";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, updateSoal);
            p.setInt(2, updateK);
            p.setString(3, updateJabawanA);
            p.setString(4, updateJabawanB);
            p.setString(5, updateJabawanC);
            p.setString(6, updateJabawanD);
            p.setInt(7, updateID);
            p.executeUpdate();
            p.close();
        }catch(Exception e){
            System.out.println("Error update");
        }
    }//GEN-LAST:event_buttonEditSoalActionPerformed

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
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buttonClose;
    private javax.swing.JButton buttonEditSoal;
    private javax.swing.ButtonGroup buttonGroupJawaban;
    private javax.swing.JButton buttonHomePage;
    private javax.swing.JButton buttonKeluar;
    private javax.swing.JLabel buttonMinimized;
    private javax.swing.JButton buttonSoal;
    private javax.swing.JButton buttonSubmitSoal;
    private javax.swing.JButton buttonTambahSoal;
    private javax.swing.JLabel countTotalSoal;
    private javax.swing.JLabel countTotalUser;
    private javax.swing.JTextArea fieldPertanyaan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField jawabanA;
    private javax.swing.JTextField jawabanB;
    private javax.swing.JTextField jawabanC;
    private javax.swing.JTextField jawabanD;
    private javax.swing.JLabel labelTitleApp;
    private javax.swing.JLabel labelTitleApp1;
    private javax.swing.JLabel labelTitleSoal;
    private javax.swing.JLabel labelTotalSoal;
    private javax.swing.JLabel labelTotalUser;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelCustomBar;
    private javax.swing.JPanel panelHomePage;
    private javax.swing.JScrollPane panelLihatSoal;
    private javax.swing.JPanel panelListDashboard;
    private javax.swing.JPanel panelSoal;
    private javax.swing.JPanel panelTambahSoal;
    private javax.swing.JRadioButton radioA;
    private javax.swing.JRadioButton radioB;
    private javax.swing.JRadioButton radioC;
    private javax.swing.JRadioButton radioD;
    private javax.swing.JTable tableLihatSoal;
    // End of variables declaration//GEN-END:variables

    private void LoadData() {
        try {
            if (soalModel.getRowCount() > 0) {
                for (int i = soalModel.getRowCount() - 1; i > -1; i--) {
                    soalModel.removeRow(i);
                }
            }
            s = conn.createStatement();
            String query = "SELECT * FROM soal";
            ResultSet r = s.executeQuery(query);
            while(r.next()){
                Object [] obj = new Object[3];
                obj[0] = r.getInt("id_soal");
                obj[1] = r.getString("soal");
                soalModel.addRow(obj);
            }
            
            s = conn.createStatement();
            query = "SELECT COUNT(*) AS user FROM user";
            r = s.executeQuery(query);
            String totalUser = "";
            while(r.next()){
                totalUser = r.getString("user");
            }
            countTotalUser.setText(totalUser);
            
            query = "SELECT COUNT(*) AS soal FROM soal";
            r = s.executeQuery(query);
            String totalSoal = "";
            while(r.next()){
                totalSoal = r.getString("soal");
            }
            countTotalSoal.setText(totalSoal);
            
            
        } catch (SQLException e) {
            System.out.println("Error: Tidak Bisa Mengambil Data Score!");
        }
    }
    
}


