/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;


import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Pablo
 */
public class Compilador extends javax.swing.JFrame {

    NumeroLinea numeroLinea;
    ArrayList<Token> lista_token = new ArrayList();
    ArrayList<Token> lista_errores = new ArrayList();
    ArrayList<String> lista_identificadores = new ArrayList<>();
    String [] palabrasReservadas;
    //para archivos
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    
    public Compilador() {
        initComponents();
        numeroLinea = new NumeroLinea(ta_Codigo);
        jScrollPane1.setRowHeaderView(numeroLinea); 
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Codigo = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_simb = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_consola = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnArchivo = new javax.swing.JMenu();
        btnAbrir = new javax.swing.JMenuItem();
        btnGuardar = new javax.swing.JMenuItem();
        btnEjecutar = new javax.swing.JMenu();
        btnAnalizadorLexico = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        bntTablaPalReserv = new javax.swing.JMenuItem();
        btnTablaIdentificadores = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ta_Codigo.setColumns(20);
        ta_Codigo.setRows(5);
        ta_Codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ta_CodigoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(ta_Codigo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 9, 810, 390));

        tbl_simb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 92, 103)));
        tbl_simb.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_simb.setGridColor(new java.awt.Color(51, 92, 103));
        jScrollPane3.setViewportView(tbl_simb);
        if (tbl_simb.getColumnModel().getColumnCount() > 0) {
            tbl_simb.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_simb.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_simb.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(824, 9, 410, 390));

        txt_consola.setColumns(20);
        txt_consola.setRows(5);
        jScrollPane2.setViewportView(txt_consola);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 404, 1150, 270));

        jPanel1.setBackground(new java.awt.Color(51, 92, 103));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(224, 159, 62));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("P");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 540, 50, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(224, 159, 62));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("J");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 410, 50, 60));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(224, 159, 62));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("A");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 480, 50, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rueda.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 600, -1, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 680));

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 153));

        btnArchivo.setText("Archivo");

        btnAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_abrir.png"))); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        btnArchivo.add(btnAbrir);

        btnGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnArchivo.add(btnGuardar);

        jMenuBar1.add(btnArchivo);

        btnEjecutar.setText("Ejecutar");

        btnAnalizadorLexico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnAnalizadorLexico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lexico.png"))); // NOI18N
        btnAnalizadorLexico.setText("Analizador Lexico");
        btnAnalizadorLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizadorLexicoActionPerformed(evt);
            }
        });
        btnEjecutar.add(btnAnalizadorLexico);

        jMenuBar1.add(btnEjecutar);

        jMenu3.setText("Tablas");

        bntTablaPalReserv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        bntTablaPalReserv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reservadas.png"))); // NOI18N
        bntTablaPalReserv.setText("Tabla Palabras Reservadas");
        bntTablaPalReserv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntTablaPalReservActionPerformed(evt);
            }
        });
        jMenu3.add(bntTablaPalReserv);

        btnTablaIdentificadores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnTablaIdentificadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/id.png"))); // NOI18N
        btnTablaIdentificadores.setText("Tabla de Identificadores");
        btnTablaIdentificadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaIdentificadoresActionPerformed(evt);
            }
        });
        jMenu3.add(btnTablaIdentificadores);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if(seleccionar.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){ //Se aprueba que el evento a realizar sea abrir
           archivo=seleccionar.getSelectedFile(); //se selecciona el archivo
           if(archivo.canRead()){
               if(archivo.getName().endsWith("txt")){ //verifica que el archivo tenga extencion .txt
                   String documento = AbrirArchivo(archivo); 
                   ta_Codigo.setText(documento); //Se envia el texto al textArea
               }else{
                   JOptionPane.showMessageDialog(null,"Archivo no compatible");  //si el archivo no es compatible
               }
           }
       }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void ta_CodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ta_CodigoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_ta_CodigoKeyPressed

    //se crean estos metodos
    public String AbrirArchivo(File archivo){
        String documento = "";
        try{
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read())!=-1){
                char caracter = (char)ascci;
                documento+=caracter;
            }
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error al Abrir. "+e);
        }
        return documento;
    }
    
    
    public String GuardarArchivo (File archivo, String documento){
        String mensaje = null;
        try{
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "Archivo Guardado";
        } catch(Exception e){
        }
        return mensaje;
    }
    private void btnAnalizadorLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizadorLexicoActionPerformed
        //limpiar tabla
        DefaultTableModel m = (DefaultTableModel) tbl_simb.getModel();
        lista_token.clear();
        lista_errores.clear();
        lista_identificadores.clear();
        txt_consola.setText("");
        if(m.getRowCount()>0){
            int p = m.getRowCount()-1, t = m.getRowCount();
            for (int i = 0; i < t; i++) {
                m.removeRow(p);
                p--;
            }
        }
        
        //agregar todo a la tabla        
        new AnalizadorLexico(lista_token, lista_errores, lista_identificadores).analizar(ta_Codigo.getText());
        
        for (int i = 0; i < lista_errores.size(); i++) {
            txt_consola.setText(txt_consola.getText() + "\n" + lista_errores.get(i).toStringErr());
        }
        
        for(int i = 0; i < lista_token.size(); i++){
            m.addRow(new Object[]{lista_token.get(i).getFila(), lista_token.get(i).getLexema(), lista_token.get(i).getTipo()} );
        }
        
    }//GEN-LAST:event_btnAnalizadorLexicoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       if(seleccionar.showDialog(null, "Guardar")==JFileChooser.APPROVE_OPTION){
            archivo = seleccionar.getSelectedFile(); //seleccionar carpeta donde guardar
            if(archivo.getName().endsWith("txt")){ //se verifica que el nombre del archivo finalice en txt
                String Documento = ta_Codigo.getText(); //se obtiene el texto del textArea
                String mensaje = GuardarArchivo(archivo, Documento); //se llama al metodo guardar archivo
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null, mensaje);
                }else{
                    JOptionPane.showMessageDialog(null, "Archivo No Compatible"); //si no es .txt
                }
            }else{
                JOptionPane.showMessageDialog(null, "Guardar Documento de Texto"); //si cumple se guarda
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void bntTablaPalReservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntTablaPalReservActionPerformed
        TablasPalReservada TPR = new TablasPalReservada();
        TPR.setVisible(true);
    }//GEN-LAST:event_bntTablaPalReservActionPerformed

    private void btnTablaIdentificadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaIdentificadoresActionPerformed
        tablaIdentificadores TID = new tablaIdentificadores();
        
        TID.setVisible(true);
    }//GEN-LAST:event_btnTablaIdentificadoresActionPerformed

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
    private javax.swing.JMenuItem bntTablaPalReserv;
    private javax.swing.JMenuItem btnAbrir;
    private javax.swing.JMenuItem btnAnalizadorLexico;
    private javax.swing.JMenu btnArchivo;
    private javax.swing.JMenu btnEjecutar;
    private javax.swing.JMenuItem btnGuardar;
    private javax.swing.JMenuItem btnTablaIdentificadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea ta_Codigo;
    private javax.swing.JTable tbl_simb;
    private javax.swing.JTextArea txt_consola;
    // End of variables declaration//GEN-END:variables
}