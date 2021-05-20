/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Pablo
 */
public class Compilador extends javax.swing.JFrame {

    NumeroLinea numeroLinea;
    
    public Compilador() {
        initComponents();
        numeroLinea = new NumeroLinea(ta_Codigo);
        jScrollPane1.setRowHeaderView(numeroLinea);
    }

    public void TablaSimbolos(){
        Object[] arraySimbolos = new Object[108];
        arraySimbolos[0] = "a";
        arraySimbolos[1] = "";
        arraySimbolos[2] = "";
        arraySimbolos[3] = "";
        arraySimbolos[4] = "";
        arraySimbolos[5] = "";
        arraySimbolos[6] = "";
        arraySimbolos[7] = "";
        arraySimbolos[8] = "";
        arraySimbolos[9] = "";
        arraySimbolos[10] = "";
        arraySimbolos[11] = "";
        arraySimbolos[12] = "";
        arraySimbolos[13] = "";
        arraySimbolos[14] = "";
        arraySimbolos[15] = "";
        arraySimbolos[16] = "";
        arraySimbolos[17] = "";
        arraySimbolos[18] = "";
        arraySimbolos[19] = "";
        arraySimbolos[20] = "";
        arraySimbolos[21] = "";
        arraySimbolos[22] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";
//        arraySimbolos[] = "";

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Codigo = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 700));

        ta_Codigo.setColumns(20);
        ta_Codigo.setRows(5);
        ta_Codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ta_CodigoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(ta_Codigo);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Linea", "Lexema", "Componente Léxico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jMenu1.setText("File");

        jMenuItem1.setText("New File");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Open");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Save");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Save As");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ta_CodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ta_CodigoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_ta_CodigoKeyPressed

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
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compilador().setVisible(true);
            }
        });
    }
    
    private DefaultTableModel m = new DefaultTableModel();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea ta_Codigo;
    // End of variables declaration//GEN-END:variables
}