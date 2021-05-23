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
        jMenuBar1 = new javax.swing.JMenuBar();
        btnArchivo = new javax.swing.JMenu();
        btnNuevoArchiv = new javax.swing.JMenuItem();
        btnAbrir = new javax.swing.JMenuItem();
        btnGuardar = new javax.swing.JMenuItem();
        btnGuardarComo = new javax.swing.JMenuItem();
        btnEditar = new javax.swing.JMenu();
        btnEjecutar = new javax.swing.JMenu();
        btnAnalizadorLexico = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

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
        jScrollPane3.setViewportView(tbl_simb);
        if (tbl_simb.getColumnModel().getColumnCount() > 0) {
            tbl_simb.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_simb.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_simb.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        txt_consola.setColumns(20);
        txt_consola.setRows(5);
        jScrollPane2.setViewportView(txt_consola);

        btnArchivo.setText("Archivo");

        btnNuevoArchiv.setText("Nuevo archivo");
        btnArchivo.add(btnNuevoArchiv);

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        btnArchivo.add(btnAbrir);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnArchivo.add(btnGuardar);

        btnGuardarComo.setText("Guardar como");
        btnArchivo.add(btnGuardarComo);

        jMenuBar1.add(btnArchivo);

        btnEditar.setText("Editar");
        jMenuBar1.add(btnEditar);

        btnEjecutar.setText("Ejecutar");

        btnAnalizadorLexico.setText("Analizador Lexico");
        btnAnalizadorLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizadorLexicoActionPerformed(evt);
            }
        });
        btnEjecutar.add(btnAnalizadorLexico);

        jMenuBar1.add(btnEjecutar);

        jMenu3.setText("Tablas");

        jMenuItem1.setText("Tabla variables");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Tabla funciones");
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
        );

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
        }catch (Exception e){
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
        lista_token.clear();
//        if(tbl_simb.getRowCount()>0){
//            int p = tbl_simb.getRowCount()-1;
//            for (int i = 0; i < tbl_simb.getRowCount(); i++) {
//                m.removeRow(p);
//                p -=1;
//            }
//        }
        
        //Revisar tabla de palabras reservadas
        
        
        
        //agregar todo a la tabla
        DefaultTableModel m = (DefaultTableModel) tbl_simb.getModel();
        new AnalizadorLexico(lista_token).analizar(ta_Codigo.getText());
        for(int i = 0; i < lista_token.size(); i++){
            txt_consola.setText(txt_consola.getText() + "\n" + lista_token.get(i).toString());
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
    private javax.swing.JMenuItem btnAbrir;
    private javax.swing.JMenuItem btnAnalizadorLexico;
    private javax.swing.JMenu btnArchivo;
    private javax.swing.JMenu btnEditar;
    private javax.swing.JMenu btnEjecutar;
    private javax.swing.JMenuItem btnGuardar;
    private javax.swing.JMenuItem btnGuardarComo;
    private javax.swing.JMenuItem btnNuevoArchiv;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea ta_Codigo;
    private javax.swing.JTable tbl_simb;
    private javax.swing.JTextArea txt_consola;
    // End of variables declaration//GEN-END:variables
}