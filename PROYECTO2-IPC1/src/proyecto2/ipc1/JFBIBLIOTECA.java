/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.ipc1;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;

public class JFBIBLIOTECA extends javax.swing.JFrame {
    JFENTRADABIBLIOTECA datospermanentes;
    ACCIONES_A_EJECUTAR anterior;
    public String categoria,nombre;
    JFileChooser FCseleccionado = new JFileChooser();
    File archivo;
    boolean respuestacategoria;
    byte[] bytesInge;
    public FUNCIONESDEIMAGENES imagen = new FUNCIONESDEIMAGENES();
    /**
     * Creates new form JFBIBLIOTECA
     */
    public JFBIBLIOTECA(ACCIONES_A_EJECUTAR anterior) {
        this.anterior = anterior;
        anterior.setVisible(false);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent ant){
                anterior.setVisible(true);
            }
        });
        setVisible(true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        LBImagen = new javax.swing.JLabel();
        CbListadecategorias = new javax.swing.JComboBox<>();

        setTitle("Biblioteca de Datos");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 2, 24)); // NOI18N
        jLabel1.setText("BIBLIOTECA");

        jLabel2.setText("Categoria");

        jButton1.setText("<");

        jButton2.setText(">");

        jButton3.setText("Agregar Imagen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eiminar Imagen");

        jButton5.setText("Agregar Categoria");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Eliminar Categoria ");

        jButton7.setText("Salir ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(LBImagen);

        CbListadecategorias.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        CbListadecategorias.setToolTipText("Categorias");
        CbListadecategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbListadecategoriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(CbListadecategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addComponent(jButton2))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(133, 133, 133)
                                        .addComponent(jButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addComponent(jButton2)))
                                .addGap(0, 126, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jButton7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(CbListadecategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        regresar(evt);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (FCseleccionado.showDialog(null, "Abrir Archivo")==JFileChooser.APPROVE_OPTION) {
            respuestacategoria=anterior.anterior.listadousuario.getCabeza().categoria.buscarnodoregresivo(categoria);
            if (respuestacategoria==true) {
            archivo = FCseleccionado.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("jpg")) {
                    bytesInge = imagen.abrirImagen(archivo);
                    ImageIcon imagenser = new ImageIcon(bytesInge);
                    Icon servidor = new ImageIcon(imagenser.getImage().getScaledInstance(LBImagen.getWidth(), LBImagen.getHeight(), Image.SCALE_DEFAULT));
                    LBImagen.setIcon(servidor);
                }else{
                    JOptionPane.showMessageDialog(null, "el tipo de imagen es incorrecto debe de ser .JPG");
                }
            }    
            }else{
                JOptionPane.showMessageDialog(null, "La categoria no existe");
            }
            if (FCseleccionado.showDialog(null, "Guardar Imagen")==JFileChooser.APPROVE_OPTION) {
                archivo = FCseleccionado.getSelectedFile();
                if (archivo.getName().endsWith("jpg")||archivo.getName().endsWith("bmp")) {
                    respuestacategoria=anterior.anterior.listadousuario.getCabeza().categoria.buscarnodoregresivo(categoria);
                    if (respuestacategoria==true) {
                        nombre=archivo.getName();
                        anterior.anterior.listadousuario.getCabeza().categoria.buscarnodo(categoria, nombre);
                        String respuesta = imagen.GuardarImagen(archivo, bytesInge, categoria, anterior.anterior.valor);
                        if (respuesta!=null) {
                            JOptionPane.showMessageDialog(null, respuesta);
                        }else{
                            JOptionPane.showMessageDialog(null, "error al guardar imagen");
                        }      
                    }else{
                        JOptionPane.showMessageDialog(null, "La categoria no existe");
                    }
                }
            }else{
                
            }
    }//GEN-LAST:event_jButton3ActionPerformed
        else{
            
        }
    }
    private void CbListadecategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbListadecategoriasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CbListadecategoriasActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        enviar(evt);
    }//GEN-LAST:event_jButton5ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbListadecategorias;
    private javax.swing.JLabel LBImagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void regresar(ActionEvent evt) {
        hide();
        anterior.setVisible(true);
    }

    private void enviar(ActionEvent evt) {
        String valor = anterior.anterior.valor;
        boolean valorencontrado = anterior.anterior.listadousuario.buscardato(valor);
        if (valorencontrado==true) {
            categoria=JOptionPane.showInputDialog("Ingrese el nombre de la categoria");
            anterior.anterior.listadousuario.llamarcategoria(categoria);
        }
    }
}
