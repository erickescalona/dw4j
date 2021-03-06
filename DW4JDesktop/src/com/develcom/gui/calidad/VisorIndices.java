/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.develcom.gui.calidad;

import com.develcom.dao.Expediente;
import com.develcom.dao.ManejoSesion;
import com.develcom.gui.tools.CentraVentanas;
import com.develcom.gui.tools.CreaObjetosDinamicos;
import com.develcom.tools.trazas.Traza;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import org.apache.log4j.Level;

/**
 *
 * @author develcom
 */
public class VisorIndices extends javax.swing.JDialog {

    private static final long serialVersionUID = -1100895079330380804L;
    private Traza traza = new Traza(VisorIndices.class);

    /**
     *
     * @param expediente
     */
    public VisorIndices() {
        Expediente expediente;

        try {
            expediente = ManejoSesion.getExpediente();
            initComponents();
            setModal(true);
            setTitle("Indices del Expediente: " + expediente.getIdExpediente());
            crearObjetos(expediente);
            CentraVentanas.centerDialog(this);
            setVisible(true);
        } catch (Exception e) {
            traza.trace("problemas al mostrar los indices", Level.ERROR, e);
        }

    }

    /**
     * Arma los indice dinamicos en el formulario
     */
    private void crearObjetos(Expediente expediente) {
        try {
            traza.trace("creando indices dinamicos", Level.INFO);
            GridBagConstraints constraints = new GridBagConstraints();
            CreaObjetosDinamicos uv = new CreaObjetosDinamicos();
            JPanel panelIndice;

            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            panelIndices.removeAll();
            panelIndices.setLayout(new FlowLayout(FlowLayout.LEFT));
            panelIndice = uv.mostrarIndices(expediente);
            panelIndices.add(panelIndice);
            panelIndices.updateUI();

        } catch (Exception e) {
            traza.trace("error al crear indices dinamicos", Level.INFO, e);
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

        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelIndices = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(224, 239, 255));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/develcom/gui/imagenes/develcom/Knob Cancel.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(224, 239, 255));

        panelIndices.setBackground(new java.awt.Color(224, 239, 255));

        javax.swing.GroupLayout panelIndicesLayout = new javax.swing.GroupLayout(panelIndices);
        panelIndices.setLayout(panelIndicesLayout);
        panelIndicesLayout.setHorizontalGroup(
            panelIndicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        panelIndicesLayout.setVerticalGroup(
            panelIndicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelIndices);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnCerrar)
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

        setVisible(false);
        dispose();

    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelIndices;
    // End of variables declaration//GEN-END:variables
}
