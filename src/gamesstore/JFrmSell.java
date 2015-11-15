/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesstore;

import bd.DatabaseUtilit;
import bd.GameDAO;
import bd.ClientDAO;
import bd.SellDAO;
import bd.ChipsDAO;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author s2it_ggomes
 */
public final class JFrmSell extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private int linhaJTable;
    private GameDAO gamedao;
    private SellDAO selldao;    
    private ClientDAO clientDAO;
    private SellDAO sellDAO;
    private ChipsDAO chipsDAO;
    
    /**
     * Creates new form JFrmSell
     */
    public JFrmSell() {
        initComponents();
        this.gamedao = new GameDAO();
        this.selldao = new SellDAO();
        this.clientDAO = new ClientDAO();
        this.chipsDAO = new ChipsDAO();
        this.sellDAO = new SellDAO();
        this.linhaJTable = -1;
        this.configTableColumns();
        DatabaseUtilit.Conectar();
        this.setComboCategory();
        this.setComboClient();
    }
    
    public void setComboCategory() {
        jComboCategory.addItem("Chips");
        jComboCategory.addItem("Games");
    }
    
    public void saveSell() {
        TableModel model = (TableModel) jTableSell.getModel();
        String valor1 = (String) model.getValueAt(linhaJTable, 0);
        if(valor1 == "") {
            System.out.println(valor1);
            JOptionPane.showMessageDialog(null,"Selecione uma categoria primeiro!");  
        } else {
        int lastIdSell = this.sellDAO.searchLastIdSell();
        System.out.println("ultimo id = " + lastIdSell);
        int newIdSell = lastIdSell + 1;
        
        int contador = linhaJTable;
        while(contador != -1) {
            if(linhaJTable != -1) {
                Client client = new Client();
                
                client.setName((String) jComboClient.getSelectedItem());
                client.setIdClient(this.clientDAO.searchIdClient(client));
                System.out.println(client.getName());
                System.out.println(client.getIdClient());
                
                
                Game game = new Game();
                game.setName((String) model.getValueAt(linhaJTable, 0));
                game.setIdGame(this.gamedao.searchIdGame(game));

                System.out.println(game.getName());
                System.out.println(game.getIdGame());

                Chips chip = new Chips();
                if(this.jComboCategory.getSelectedItem() != "Games") {
                    chip.setName((String) model.getValueAt(linhaJTable, 0));
                    chip.setIdChip(this.chipsDAO.searchIdChip(chip));
                }
                
                System.out.println(chip.getName());
                System.out.println(chip.getIdChip());

                
                System.out.println("Novo id = " + newIdSell);
                Sell sell = new Sell(game, client, newIdSell, chip);
                this.selldao.insertSell(sell);
            }
            contador--;
            linhaJTable--;
        }
        
        this.clearTable();
        }
    }
    
    public void configTableColumns() {
        this.tableModel = (DefaultTableModel) jTableSell.getModel();
        tableModel.addColumn("Product");
    }
    
    public void insertProduct() {
        this.tableModel = (DefaultTableModel) jTableSell.getModel();
        tableModel.insertRow(tableModel.getRowCount(), new Object[] {jComboGames.getSelectedItem()});
        this.linhaJTable++;
    }
    
    public void clearTable() {
        this.tableModel = (DefaultTableModel) jTableSell.getModel();   
        this.tableModel.getDataVector().removeAllElements();
        this.jTableSell.updateUI();
    }

    public void setComboGame() {
        jComboGames.removeAllItems();
        List<Game> listGame = new ArrayList<>();
        listGame = this.gamedao.listAllGames();

        Iterator<Game> it = listGame.iterator();

        while (it.hasNext()) {
            Game g = it.next();
            String games = g.getName();
            jComboGames.addItem(games);
        }
    }
    
    public void setComboClient() {
        List<Client> listClient = new ArrayList<>();
        listClient = this.clientDAO.listAllClient();

        Iterator<Client> it = listClient.iterator();

        while (it.hasNext()) {
            Client c = it.next();
            String clients = c.getName();
            jComboClient.addItem(clients);
        }
    }
    
    public void setComboChips() {
        jComboGames.removeAllItems();
        ChipsDAO chipsdao = new ChipsDAO();
        List<Chips> listChips = new ArrayList<>();
        listChips = chipsdao.listAllChips();

        Iterator<Chips> it = listChips.iterator();

        while (it.hasNext()) {
            Chips chi = it.next();
            String chips = chi.getName();
            jComboGames.addItem(chips);
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
        jComboGames = new javax.swing.JComboBox<String>();
        jComboCategory = new javax.swing.JComboBox<String>();
        jComboClient = new javax.swing.JComboBox<String>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSell = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jComboGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboGamesActionPerformed(evt);
            }
        });

        jComboCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboCategoryItemStateChanged(evt);
            }
        });

        jButton1.setText("Add Product");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Client");

        jLabel3.setText("Category");

        jLabel4.setText("Product");

        jButton2.setText("Clear Products");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Checkout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboGames, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboClient, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(143, 143, 143)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboClient, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboGames, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jComboGames.getAccessibleContext().setAccessibleName("cmbProduct");
        jComboCategory.getAccessibleContext().setAccessibleName("cmbCategory");
        jComboClient.getAccessibleContext().setAccessibleName("cmbClient");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GameStore Sell");
        jLabel1.setName(""); // NOI18N

        jScrollPane1.setViewportView(jTableSell);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName("");
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleName("cmbClient");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.insertProduct();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboGamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboGamesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.clearTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.saveSell();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        DatabaseUtilit.Desconectar();
    }//GEN-LAST:event_formWindowClosing

    private void jComboCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboCategoryItemStateChanged
        if(this.jComboCategory.getSelectedItem() == "Games") {
            this.setComboGame();
        } else {
            this.setComboChips();
        }
    }//GEN-LAST:event_jComboCategoryItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboCategory;
    private javax.swing.JComboBox<String> jComboClient;
    private javax.swing.JComboBox<String> jComboGames;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSell;
    // End of variables declaration//GEN-END:variables

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
            java.util.logging.Logger.getLogger(JFrmSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmSell().setVisible(true);
            }
        });
    }

}

