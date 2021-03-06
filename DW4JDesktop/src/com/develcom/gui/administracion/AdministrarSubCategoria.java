/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdministrarSubCategoria.java
 *
 * Created on 19/03/2012, 06:51:40 PM
 */
package com.develcom.gui.administracion;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Level;
import ve.com.develcom.administracion.AdministracionAgregar;
import ve.com.develcom.administracion.AdministracionBusqueda;
import com.develcom.administracion.Categoria;
import com.develcom.administracion.Libreria;
import com.develcom.administracion.Perfil;
import com.develcom.administracion.SubCategoria;
import com.develcom.gui.Principal;
import com.develcom.gui.tools.CentraVentanas;
import com.develcom.gui.tools.ModeloTabla;
import com.develcom.tools.trazas.Traza;
import java.awt.Dimension;
import javax.xml.soap.SOAPException;
import javax.xml.ws.soap.SOAPFaultException;

/**
 *
 * @author erickescalona
 */
public class AdministrarSubCategoria extends javax.swing.JInternalFrame {

    /**
     * Modelo para la tabla
     */
    private ModeloTabla modelTable;
    /**
     * Modelo para la tabla
     */
    private ModeloTabla modelTableExistentes;
    /**
     * Escribe las trazas en el log
     */
    private Traza traza = new Traza(AdministrarSubCategoria.class);
    /**
     * Lista de Librerias
     */
    private List<Libreria> librerias;
    /**
     * Lista de Categorias
     */
    private List<Categoria> categorias;
    /**
     * *
     * Lista de SubCategorias
     */
    private List<SubCategoria> listaSubCategorias;
    /**
     * Para modificacion de SubCategorias
     */
    private boolean existe;

    /**
     * Constructor, inicia los componentes y llena la lista desplegables de las
     * Librerias
     */
    public AdministrarSubCategoria() {
        initComponents();

        grupoBotonesEstatus.add(jrbActivo);
        grupoBotonesEstatus.add(jrbInactivo);

        tablaSubCategoria.setModel(armarTabla());
        tablaSubCatExistentes.setModel(armarTablaExistentes());
        
        cmbLibreria.setMaximumSize(new Dimension(30, 30));
        cmbCategoria.setMaximumSize(new Dimension(30, 30));

        llenarComboLibreria();
        setTitle("Administrar SubCategorias");
        CentraVentanas.centrar(this, Principal.desktop);
        setVisible(true);
    }

    /**
     * Llena la lista desplegables con las Librerias
     */
    private void llenarComboLibreria() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            model.addElement("");


            librerias = new AdministracionBusqueda().buscarLibreria("", 0);

            traza.trace("buscando las libreria ", Level.INFO);

            for (Libreria l : librerias) {
                model.addElement(l.getDescripcion());
            }
            cmbLibreria.setModel(model);
        } catch (SOAPException ex) {
            traza.trace("error soapfault en el webservice", Level.ERROR, ex);
        } catch (SOAPFaultException ex) {
            traza.trace("error soapfault en el webservice", Level.ERROR, ex);
        }
    }

    /**
     * Coloca los titulos a la tabala
     *
     * @return retorna un DefaultTableModel
     */
    private DefaultTableModel armarTabla() {
        
        if(modelTable==null){
            modelTable = new ModeloTabla();
            
            modelTable.addColumn("Libreria");
            modelTable.addColumn("Categoria");
            modelTable.addColumn("SubCategoria");
            modelTable.addColumn("Estatus");
        }else{
            modelTable.eliminarFilas();
        }

        return modelTable;
    }

    /**
     * Coloca los titulos a la tabala
     *
     * @return retorna un DefaultTableModel
     */
    private DefaultTableModel armarTablaExistentes() {
        
        if(modelTableExistentes==null){
            modelTableExistentes = new ModeloTabla();

            modelTableExistentes.addColumn("SubCategoria");
            modelTableExistentes.addColumn("Estatus");
        }else{
            modelTableExistentes.eliminarFilas();
        }

        return modelTableExistentes;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotonesEstatus = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        cmbLibreria = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSubCategoria = new javax.swing.JTextField();
        jbAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jrbActivo = new javax.swing.JRadioButton();
        jrbInactivo = new javax.swing.JRadioButton();
        panelInferior = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSubCategoria = new javax.swing.JTable();
        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jlCategoria = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaSubCatExistentes = new javax.swing.JTable();
        jbCambioEstatus = new javax.swing.JButton();

        setBackground(new java.awt.Color(224, 239, 255));
        setTitle("Administrar SubCategorias");

        jPanel2.setBackground(new java.awt.Color(224, 239, 255));

        cmbLibreria.setPreferredSize(new java.awt.Dimension(300, 20));
        cmbLibreria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLibreriaActionPerformed(evt);
            }
        });

        jLabel2.setText("Librerias");

        jLabel3.setText("Categorias");

        cmbCategoria.setPreferredSize(new java.awt.Dimension(300, 20));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbLibreria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLibreria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(224, 239, 255));

        jLabel6.setText("Nombre de la SubCategoria");

        txtSubCategoria.setToolTipText("");

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jLabel4.setText("Estatus");

        jrbActivo.setBackground(new java.awt.Color(224, 239, 255));
        jrbActivo.setSelected(true);
        jrbActivo.setText("Activo");

        jrbInactivo.setBackground(new java.awt.Color(224, 239, 255));
        jrbInactivo.setText("Inactivo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jrbActivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbInactivo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbAgregar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jrbActivo)
                    .addComponent(jrbInactivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInferior.setBackground(new java.awt.Color(224, 239, 255));

        tablaSubCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(tablaSubCategoria);

        jbSalvar.setText("Guardar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cerrar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jbSalvar)
                        .addGap(121, 121, 121)
                        .addComponent(jbCancelar))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);

        jPanel4.setBackground(new java.awt.Color(224, 239, 255));

        jlCategoria.setText("SubCategorias existentes");

        tablaSubCatExistentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane3.setViewportView(tablaSubCatExistentes);

        jbCambioEstatus.setText("Cambiar de Estatus");
        jbCambioEstatus.setToolTipText("Cambiar de Estatus");
        jbCambioEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCambioEstatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCambioEstatus))
                    .addComponent(jlCategoria))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCambioEstatus)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInferior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Agrega las subcategorias a la tabla
     *
     * @param evt
     */
    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        agregarSubCategoria();
}//GEN-LAST:event_jbAgregarActionPerformed

    /**
     * Agrega las subcategorias a la tabla
     */
    private void agregarSubCategoria() {
        String subCategoria = "", categoria = "", libreria = "", estatus = "";
        Vector filas = new Vector();
        Vector ver;
        boolean banLista = true, banTabla = true;



        libreria = cmbLibreria.getSelectedItem().toString();

        if (jrbActivo.isSelected()) {
            estatus = jrbActivo.getText();
        } else if (jrbInactivo.isSelected()) {
            estatus = jrbInactivo.getText();
        }

        if (!libreria.equalsIgnoreCase("")) {

            categoria = cmbCategoria.getSelectedItem().toString();

            if (!categoria.equalsIgnoreCase("")) {

                subCategoria = txtSubCategoria.getText();

                if (!subCategoria.equalsIgnoreCase("")) {

                    for (SubCategoria subCat : listaSubCategorias) {
                        String ca = subCat.getSubCategoria();
                        if (ca.equalsIgnoreCase(subCategoria)) {
                            banLista = false;
                            break;
                        } else {
                            banLista = true;
                        }
                    }

                    if (modelTable != null) {
                        ver = modelTable.getDataVector();
                        for (int i = 0; i < ver.size(); i++) {
                            Vector d = (Vector) ver.get(i);
                            String subCat = d.get(2).toString();
                            if (subCat.equalsIgnoreCase(subCategoria)) {
                                banTabla = false;
                                break;
                            }
                        }
                    }


                    if (banTabla) {
                        if (banLista) {

                            filas.add(libreria);
                            filas.add(categoria);
                            filas.add(subCategoria);
                            filas.add(estatus);
                            modelTable.addRow(filas);
                            tablaSubCategoria.setModel(modelTable);
                            txtSubCategoria.setText("");
                            txtSubCategoria.setEditable(true);
                            jrbActivo.setSelected(true);

                        } else {
                            //JOptionPane.showMessageDialog(this, "Ya la SubCategoria se encuentra en la lista de existentes", "Advertencia", JOptionPane.WARNING_MESSAGE);

                            int n = JOptionPane.showOptionDialog(this, "Ya la SubCategoria se encuentra en la lista de existentes \n ¿desea modificarlo?",
                                    "¿?",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null, new Object[]{"SI", "NO"}, "NO");

                            if (n == JOptionPane.YES_OPTION) {
                                filas.add(libreria);
                                filas.add(categoria);
                                filas.add(subCategoria);
                                filas.add(estatus);
                                modelTable.addRow(filas);
                                tablaSubCategoria.setModel(modelTable);
                                txtSubCategoria.setText("");
                                txtSubCategoria.setEditable(true);
                                jrbActivo.setSelected(true);
                            } else {
                                txtSubCategoria.setText("");
                                txtSubCategoria.setEditable(true);
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Ya la SubCategoria se encuentra en la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);

                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Debe colocar SubCategoria", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una SubCategoria", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una libreria", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        guardarSubCategoria();
}//GEN-LAST:event_jbSalvarActionPerformed

    /**
     * Guarda Subcategorias
     */
    private void guardarSubCategoria() {

        DefaultTableModel md;
        List<Perfil> SubCategorias = new ArrayList<Perfil>();
        Perfil subCategoria;
        Categoria cat;
        Libreria lib;
        SubCategoria subCat;
        Vector cats;
        boolean resp = false;

        try {

            md = (DefaultTableModel) tablaSubCategoria.getModel();
            cats = md.getDataVector();


            int n = JOptionPane.showOptionDialog(this, "Seguro que desea guardar las SubCategorias",
                    "¿?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"SI", "NO"}, "NO");

            if (n == JOptionPane.YES_OPTION) {

                if (!cats.isEmpty()) {

                    for (int i = 0; i < cats.size(); i++) {
                        Vector vSubCat = (Vector) cats.get(i);

                        subCategoria = new Perfil();
                        cat = new Categoria();
                        lib = new Libreria();
                        subCat = new SubCategoria();

                        lib.setDescripcion(vSubCat.get(0).toString());

                        for (Libreria li : librerias) {
                            if (li.getDescripcion().equalsIgnoreCase(lib.getDescripcion())) {
                                lib.setIdLibreria(li.getIdLibreria());
                                if (li.getEstatus().equalsIgnoreCase("activo")) {
                                    lib.setEstatus("1");
                                } else if (li.getEstatus().equalsIgnoreCase("inactivo")) {
                                    lib.setEstatus("2");
                                }
                                break;
                            }
                        }

                        cat.setCategoria(vSubCat.get(1).toString());

                        for (Categoria ca : categorias) {
                            if (ca.getCategoria().equalsIgnoreCase(cat.getCategoria())) {
                                cat.setIdCategoria(ca.getIdCategoria());

                                if (ca.getEstatus().equalsIgnoreCase("activo")) {
                                    cat.setEstatus("1");
                                } else if (ca.getEstatus().equalsIgnoreCase("inactivo")) {
                                    cat.setEstatus("2");
                                }

                                break;
                            }
                        }

                        subCat.setSubCategoria(vSubCat.get(2).toString());

                        if (vSubCat.get(3).toString().equalsIgnoreCase(jrbActivo.getText())) {
                            subCat.setEstatus("1");
                        } else if (vSubCat.get(3).toString().equalsIgnoreCase(jrbInactivo.getText())) {
                            subCat.setEstatus("2");
                        }


                        for (SubCategoria sbc : listaSubCategorias) {
                            if (subCat.getSubCategoria().equalsIgnoreCase(sbc.getSubCategoria())) {
                                subCat.setIdSubCategoria(sbc.getIdSubCategoria());
                            }
                        }

                        subCategoria.setLibreria(lib);
                        subCategoria.setCategoria(cat);
                        subCategoria.setSubCategoria(subCat);

                        SubCategorias.add(subCategoria);
                    }

                    resp = new AdministracionAgregar().insertarSubCategoria(SubCategorias);

                    if (resp) {
                        JOptionPane.showMessageDialog(this, "SubCategorias guardadas con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        limpiarComponentes();
                    } else {
                        JOptionPane.showMessageDialog(this, "Problemas al guardar las categorias", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        limpiarComponentes();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "La tabla de subcategorias esta vacia", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (SOAPException | SOAPFaultException ex) {
            traza.trace("error soapfault en el webservice", Level.ERROR, ex);
        }

    }

    /**
     * Cierra la ventana
     *
     * @param evt evento click
     */
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * Llena la tabla con las SubCategorias desde el evento ItemStateChanged de
     * la lista desplegable de las Categorias
     *
     * @param cat nombre de categoria
     * @param idCat id de la categoria
     */
    private void llenarTablaSubCategoria(String cat, int idCat) {
        Vector filas;
        try {

            traza.trace("buscando las SubCategorias de la categoria: " + cat, Level.INFO);
            traza.trace("id de la categoria: " + idCat, Level.INFO);

//            jlCategoria.setText("SubCategorias de la categoria " + cat);

            listaSubCategorias = new AdministracionBusqueda().buscarSubCategoria("", idCat, 0);

            tablaSubCatExistentes.setModel(armarTablaExistentes());

            if (!listaSubCategorias.isEmpty()) {
                for (SubCategoria subCa : listaSubCategorias) {
                    filas = new Vector();

                    filas.add(subCa.getSubCategoria());
                    filas.add(subCa.getEstatus());

                    modelTableExistentes.addRow(filas);
                    tablaSubCatExistentes.setModel(modelTableExistentes);

                }
            } else {
            }
        } catch (SOAPException | SOAPFaultException ex) {
            traza.trace("error soapfault en el webservice", Level.ERROR, ex);
        }
    }

    private void jbCambioEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCambioEstatusActionPerformed

        //String subCategoria = ((String) tablaSubCatExistentes.getValueAt(tablaSubCatExistentes.getSelectedRow(), tablaSubCatExistentes.getSelectedColumn()));
        String subCategoria = ((String) tablaSubCatExistentes.getValueAt(tablaSubCatExistentes.getSelectedRow(), 0));

        txtSubCategoria.setText(subCategoria);
        txtSubCategoria.setEditable(false);
    }//GEN-LAST:event_jbCambioEstatusActionPerformed

    private void cmbLibreriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLibreriaActionPerformed

        String lib = cmbLibreria.getSelectedItem().toString();

        tablaSubCatExistentes.setModel(armarTablaExistentes());
        tablaSubCategoria.setModel(armarTabla());

        for (Libreria li : librerias) {
            if (lib.equalsIgnoreCase(li.getDescripcion())) {
                traza.trace("libreria selecionada " + li.getDescripcion() + " su id es " + li.getIdLibreria(), Level.INFO);
                llenarComboCategoria(li.getDescripcion(), li.getIdLibreria());
                break;
            }
        }
    }//GEN-LAST:event_cmbLibreriaActionPerformed

    /**
     * Llena la tabla con las SubCategorias existentes
     *
     * @param evt
     */
    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed

        String categoria = cmbCategoria.getSelectedItem().toString();

        traza.trace("Categoria seleccionada " + categoria, Level.INFO);

        tablaSubCategoria.setModel(armarTabla());

        for (Categoria cat : categorias) {
            if (categoria.equalsIgnoreCase(cat.getCategoria())) {
                llenarTablaSubCategoria(cat.getCategoria(), cat.getIdCategoria());
                break;
            }
        }
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    /**
     * Llena la lista desplegable con las categorias desde el evento
     * ItemStateChanged de la lista desplegable de las Librerias
     *
     * @param lib el nombre de la Libreria
     * @param idLib el id de la Libreria
     */
    private void llenarComboCategoria(String lib, int idLib) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            model.addElement("");

            traza.trace("buscando las Categorias de la libreria: " + lib, Level.INFO);
            traza.trace("id de la Libreria: " + idLib, Level.INFO);

            categorias = new AdministracionBusqueda().buscarCategoria("", idLib, 0);

            if (!categorias.isEmpty()) {
                for (Categoria ca : categorias) {
                    if(ca.getEstatus().equalsIgnoreCase("Activo")){
                        model.addElement(ca.getCategoria());
                    }                    
                }
                cmbCategoria.setModel(model);
            } else {
                cmbCategoria.setModel(model);
                JOptionPane.showMessageDialog(this, "La libreria " + lib + " no posee categorias", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SOAPException ex) {
            traza.trace("error soapfault en el webservice", Level.ERROR, ex);
        } catch (SOAPFaultException ex) {
            traza.trace("error soapfault en el webservice", Level.ERROR, ex);
        }
    }

    /**
     * Limpia los Componentes
     */
    public void limpiarComponentes() {

        txtSubCategoria.setText("");
        llenarComboLibreria();
        cmbCategoria.setModel(new DefaultComboBoxModel());

        grupoBotonesEstatus.clearSelection();
        jrbActivo.setSelected(true);

        tablaSubCategoria.setModel(armarTabla());
        tablaSubCatExistentes.setModel(armarTablaExistentes());

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JComboBox cmbLibreria;
    private javax.swing.ButtonGroup grupoBotonesEstatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbCambioEstatus;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlCategoria;
    private javax.swing.JRadioButton jrbActivo;
    private javax.swing.JRadioButton jrbInactivo;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JTable tablaSubCatExistentes;
    private javax.swing.JTable tablaSubCategoria;
    private javax.swing.JTextField txtSubCategoria;
    // End of variables declaration//GEN-END:variables
}
