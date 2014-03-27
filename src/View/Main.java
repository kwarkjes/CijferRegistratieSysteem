package View;

import Model.BeoordelingModel;
import Model.PlanningModel;
import java.awt.Graphics;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.tree.TreeSelectionModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chris
 */
public class Main extends javax.swing.JFrame {

    private MainForm mainform;
    /**
     * Creates new form Main
     */
    public Main() {
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
            } catch (Exception ex) { 
                ex.printStackTrace(); 
            }
        
        initComponents();
        jSplitPane1.setDividerLocation(450);
        //laatste kolom verbergen..
        tblPlanning.getColumn("ObjectLink").setMinWidth(0);
        tblPlanning.getColumn("ObjectLink").setMaxWidth(0);
        PanelTop.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlanning = new javax.swing.JTable();
        PanelMainLeft = new javax.swing.JPanel();
        PanelTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTentamen = new javax.swing.JLabel();
        lblVak = new javax.swing.JLabel();
        TabbedPane = new javax.swing.JTabbedPane();
        tabStudents = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInschrijvingen = new javax.swing.JTable();
        tabBeoordeling = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBeoordelingen = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        spinCijfer = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        memoOmschrijving = new javax.swing.JTextPane();
        BeoordelingToolbar = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        btn_refresh = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPlanning.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblPlanning.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Datum", "Tentamen", "Vak", "ObjectLink"
            }
        ) {
            Class[] types = new Class [] {
                java.util.Date.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPlanning.setToolTipText("");
        tblPlanning.setColumnSelectionAllowed(true);
        tblPlanning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlanningMouseClicked(evt);
            }
        });
        tblPlanning.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblPlanningKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPlanning);
        tblPlanning.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jLabel1.setText("Geselecteerde tentamen:");

        jLabel2.setText("Datum:");

        jLabel3.setText("Tentamen:");

        jLabel4.setText("Vak:");

        lblDate.setText("lblDate");

        lblTentamen.setText("lblTentamen");

        lblVak.setText("lblVak");

        javax.swing.GroupLayout PanelTopLayout = new javax.swing.GroupLayout(PanelTop);
        PanelTop.setLayout(PanelTopLayout);
        PanelTopLayout.setHorizontalGroup(
            PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(PanelTopLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDate)
                            .addComponent(lblTentamen)
                            .addComponent(lblVak))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTopLayout.setVerticalGroup(
            PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTentamen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblVak)))
        );

        tblInschrijvingen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Voornaam", "Achternaam", "Aanwezig", "Cijfer", "ObjectLink"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblInschrijvingen);
        if (tblInschrijvingen.getColumnModel().getColumnCount() > 0) {
            tblInschrijvingen.getColumnModel().getColumn(4).setMinWidth(0);
            tblInschrijvingen.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout tabStudentsLayout = new javax.swing.GroupLayout(tabStudents);
        tabStudents.setLayout(tabStudentsLayout);
        tabStudentsLayout.setHorizontalGroup(
            tabStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
        tabStudentsLayout.setVerticalGroup(
            tabStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1193, Short.MAX_VALUE)
        );

        TabbedPane.addTab("Afwezigheid", tabStudents);

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane4.setMinimumSize(new java.awt.Dimension(200, 200));

        tblBeoordelingen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Datum", "Cijfer", "Omschrijving", "Objectlink", "Naam"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBeoordelingen.setMinimumSize(new java.awt.Dimension(200, 200));
        jScrollPane4.setViewportView(tblBeoordelingen);
        if (tblBeoordelingen.getColumnModel().getColumnCount() > 0) {
            tblBeoordelingen.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblBeoordelingen.getColumnModel().getColumn(0).setMaxWidth(300);
            tblBeoordelingen.getColumnModel().getColumn(1).setPreferredWidth(75);
            tblBeoordelingen.getColumnModel().getColumn(1).setMaxWidth(100);
            tblBeoordelingen.getColumnModel().getColumn(3).setMinWidth(0);
            tblBeoordelingen.getColumnModel().getColumn(3).setPreferredWidth(0);
            tblBeoordelingen.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jSplitPane2.setTopComponent(jScrollPane4);

        jPanel1.setMinimumSize(new java.awt.Dimension(0, 330));
        jPanel1.setName(""); // NOI18N

        jLabel6.setText("Omschrijving:");

        spinCijfer.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), Float.valueOf(0.5f)));
        spinCijfer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spinCijferKeyTyped(evt);
            }
        });

        jLabel5.setText("Beoordelings cijfer:");

        memoOmschrijving.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                memoOmschrijvingKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(memoOmschrijving);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(spinCijfer, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(386, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spinCijfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSplitPane2.setBottomComponent(jPanel1);

        BeoordelingToolbar.setFloatable(false);
        BeoordelingToolbar.setRollover(true);
        BeoordelingToolbar.setToolTipText("");
        BeoordelingToolbar.setMinimumSize(new java.awt.Dimension(162, 40));
        BeoordelingToolbar.setPreferredSize(new java.awt.Dimension(100, 40));

        btnAdd.setText("Toevoegen");
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setMaximumSize(new java.awt.Dimension(91, 40));
        btnAdd.setMinimumSize(new java.awt.Dimension(91, 40));
        btnAdd.setPreferredSize(new java.awt.Dimension(91, 40));
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        BeoordelingToolbar.add(btnAdd);

        btnSave.setText("Opslaan");
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setMaximumSize(new java.awt.Dimension(69, 40));
        btnSave.setMinimumSize(new java.awt.Dimension(69, 40));
        btnSave.setPreferredSize(new java.awt.Dimension(69, 40));
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        BeoordelingToolbar.add(btnSave);

        btnDelete.setText("Verwijderen");
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        BeoordelingToolbar.add(btnDelete);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2)
                .addContainerGap())
            .addComponent(BeoordelingToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(BeoordelingToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabBeoordelingLayout = new javax.swing.GroupLayout(tabBeoordeling);
        tabBeoordeling.setLayout(tabBeoordelingLayout);
        tabBeoordelingLayout.setHorizontalGroup(
            tabBeoordelingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabBeoordelingLayout.setVerticalGroup(
            tabBeoordelingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPane.addTab("Beoordeling", tabBeoordeling);

        javax.swing.GroupLayout PanelMainLeftLayout = new javax.swing.GroupLayout(PanelMainLeft);
        PanelMainLeft.setLayout(PanelMainLeftLayout);
        PanelMainLeftLayout.setHorizontalGroup(
            PanelMainLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabbedPane)
        );
        PanelMainLeftLayout.setVerticalGroup(
            PanelMainLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLeftLayout.createSequentialGroup()
                .addComponent(PanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabbedPane))
        );

        jSplitPane1.setRightComponent(PanelMainLeft);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        btn_refresh.setText("Ververs planningen");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        fileMenu.add(btn_refresh);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPlanningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlanningMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblPlanningMouseClicked

    private void tblPlanningKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPlanningKeyPressed
        // TODO add your handling code here:
        
        // F5 Refresh???
    }//GEN-LAST:event_tblPlanningKeyPressed

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        mainform.AddBeoordeling();
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        mainform.SaveBeoordeling();
    }//GEN-LAST:event_btnSaveMouseClicked

    private void spinCijferKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spinCijferKeyTyped
        mainform.SetBeoordelingHasChanged();
    }//GEN-LAST:event_spinCijferKeyTyped

    private void memoOmschrijvingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memoOmschrijvingKeyTyped
        mainform.SetBeoordelingHasChanged();
    }//GEN-LAST:event_memoOmschrijvingKeyTyped

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        mainform.DeleteBeoordeling();
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        mainform.RefeshPlanningen();
    }//GEN-LAST:event_btn_refreshActionPerformed

    public void readBeoordelingData(BeoordelingModel beoordeling){
        try {
            spinCijfer.commitEdit();
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        beoordeling.setDocument(memoOmschrijving.getText());
        beoordeling.setCijfer(Double.valueOf(spinCijfer.getValue().toString()));
    }
    
    public void setBeoordelingEnabled(boolean enable){
        spinCijfer.setEnabled(enable);
        memoOmschrijving.setEditable(enable);
        
        if (! enable){
        spinCijfer.setValue(1);            
        memoOmschrijving.setText("");}
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar BeoordelingToolbar;
    private javax.swing.JPanel PanelMainLeft;
    private javax.swing.JPanel PanelTop;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JMenuItem btn_refresh;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTentamen;
    private javax.swing.JLabel lblVak;
    private javax.swing.JTextPane memoOmschrijving;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JSpinner spinCijfer;
    private javax.swing.JPanel tabBeoordeling;
    private javax.swing.JPanel tabStudents;
    private javax.swing.JTable tblBeoordelingen;
    private javax.swing.JTable tblInschrijvingen;
    private javax.swing.JTable tblPlanning;
    // End of variables declaration//GEN-END:variables

    public JTable getTblPlanning() {
        return tblPlanning;
    }
    
    public JTable getTblInschrijving() {
        return tblInschrijvingen;
    }    
    
    public JTable getTblBeoordelingen() {
        return tblBeoordelingen;
    }        
    
    public void SetPlanning(PlanningModel planning){
        PanelTop.setVisible(true);
        
        lblDate.setText(planning.getDatumtijd().toString());
        lblTentamen.setText(planning.getTentamenCode());
        lblVak.setText(planning.getlokaalcode());
    }
    
    public void SetBeoordeling(BeoordelingModel beoordeling){
        PanelTop.setVisible(true);
        
        spinCijfer.setValue(beoordeling.getCijfer());
        memoOmschrijving.setText(beoordeling.getDocument());
    }   
    
    public void SetMainForm(MainForm main){
        mainform = main;
    }
    
    public String GetCurrentTentamenCode(){
        return lblTentamen.getText();
    }

}