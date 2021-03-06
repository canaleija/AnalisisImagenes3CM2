/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import MUESTREO.InstanciaEnGrises;
import MUESTREO.InstanciaImagenBinarizada;
import java.awt.Image;
import javax.swing.ImageIcon;
import mejoramiento.Contraste;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ContrasteInternalFrame extends javax.swing.JInternalFrame {

    private Image imagenReferencia;
    private InstanciaEnGrises grises;
    /**
     * Creates new form BinarizacionInternalFrame
     */
    public ContrasteInternalFrame(Image imagenReferencia) {
        initComponents();
        this.imagenReferencia = imagenReferencia;
        grises = new InstanciaEnGrises(imagenReferencia);
        
        this.jLabelImagenBin.setIcon(new ImageIcon(grises.generaImagenGrises()));
         
        grises.graficarHistograma();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelImagenBin = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jButton1.setText("Expansion Lineal ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Expansion Logaritmica ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagenBin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelImagenBin, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      // generamos la expansion lineal
        Contraste con = new Contraste(grises);
        Image iResultante = con.expansionLinealRestringida(245, 250);
        this.jLabelImagenBin.setIcon(new ImageIcon(iResultante));
         
        InstanciaEnGrises nuevaGrises = new InstanciaEnGrises(iResultante);
        nuevaGrises.generaImagenGrises();
        nuevaGrises.graficarHistograma();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // generamos la expansion lineal
        Contraste con = new Contraste(grises);
        Image iResultante = con.expansionLogaritmica(123);
        this.jLabelImagenBin.setIcon(new ImageIcon(iResultante));
         
        InstanciaEnGrises nuevaGrises = new InstanciaEnGrises(iResultante);
        nuevaGrises.generaImagenGrises();
        nuevaGrises.graficarHistograma();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabelImagenBin;
    // End of variables declaration//GEN-END:variables
}
