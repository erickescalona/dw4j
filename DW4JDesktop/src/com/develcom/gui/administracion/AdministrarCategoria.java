/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdministrarCategoria.java
 *
 * Created on 19/03/2012, 06:51:19 PM
 */
package com.develcom.gui.administracion;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Level;
import ve.com.develcom.administracion.AdministracionAgregar;
import ve.com.develcom.administracion.AdministracionBusqueda;
import com.develcom.administracion.Categoria;
import com.develcom.administracion.Libreria;
import com.develcom.administracion.Perfil;
import com.develcom.gui.Principal;
import com.develcom.gui.tools.CentraVentanas;
import com.develcom.gui.tools.ModeloTabla;
import com.develcom.tools.Constantes;
import com.develcom.tools.trazas.Traza;
import java.awt.Dimension;
import javax.xml.soap.SOAPException;
import javax.xml.ws.soap.SOAPFaultException;

/**
 *
 * @author erickescalona
 */
public class AdministrarCategoria extends javax.swing.JInternalFrame {

    /**
     * Modelo para la tabla
     */
    private ModeloTabla modelTable;
    /**
     * Modelo para la tabla de categorias existentes
     */
    private ModeloTabla modelTableExistentes;
    /**
     * Escribe trazas en el log
     */
    private Traza traza = new Traza(AdministrarCategoria.class);
    /**
     * Lista de librerias
     */
    private List<Libreria> librerias;
    /**
     * Lista de Categorias
     */
    private List<Categoria> listaCategorias;

    /**
     * Construtor, inica los componentes y llena la lista desplegable de las
     * librerias
     */
    public AdministrarCategoria() {
        initComponents();

        grupoBotonesEstatus.add(jrbActivo);
        grupoBotonesEstatus.add(jrbInactivo);

        tablaCategoria.setModel(armarTabla());
        tablaCatExistentes.setModel(armarTablaExistentes());

        tablaCategoria.setDragEnabled(false);
        tablaCatExistentes.setDragEnabled(false);
        
        cmbLibreria.setMaximumSize(new Dimension(35, 35));

        llenarComboLibreria();
        setTitle("Administrar Categorias");
        CentraVentanas.centrar(this, Principal.desktop);
        setVisible(true);
    }

    /**
     * Crea los titulos de la tabla
     *
     * @return DefaultTableModel
     */
    private DefaultTableModel armarTabla() {
        
        if(modelTable==null){
            modelTable = new ModeloTabla();

            modelTable.addColumn("Libreria");
            modelTable.addColumn("Categoria");
            modelTable.addColumn("Estatus");
        }else{
            modelTable.eliminarFilas();
        }

        return modelTable;

    }

    /**
     * Crea los titulos de la tabla de categorias existentes
     *
     * @return DefaultTableModel
     */
    private DefaultTableModel armarTablaExistentes() {
        
        if(modelTableExistentes==null){
            modelTableExistentes = new ModeloTabla();

            modelTableExistentes.addColumn("Categoria");
            modelTableExistentes.addColumn("Estatus");
        }else{
            modelTableExistentes.eliminarFilas();
        }

        return modelTableExistentes;

    }

    /**
     * Llena la lista desplegable de las librerias
     */
    private void llenarComboLibreria() {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.addElement("");


            librerias = new AdministracionBusqueda().buscarLibreria("", 0);

            traza.trace("buscando las libreria ", Level.INFO);

            for (Libreria l : librerias) {
                model.addElement(l.getDescripcion());
            }
            cmbLibreria.setModel(model);
        } catch (SOAPException ex) {
            traza.trace("error soap en el webservice", Level.ERROR, ex);
        } catch (SOAPFaultException ex) {
            traza.trace("error soapfault en el webservice", Level.ERROR, ex);
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

        grupoBotonesEstatus = new javax.swing.ButtonGroup();
        panelInferior = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCategoria = new javax.swing.JTable();
        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cmbLibreria = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jbAgregar = new javax.swing.JButton();
        jrbInactivo = new javax.swing.JRadioButton();
        jrbActivo = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jlCategoria = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCatExistentes = new javax.swing.JTable();
        jbCambioEstatus = new javax.swing.JButton();

        setBackground(new java.awt.Color(224, 239, 255));
        setTitle("Administrar Categorias");

        panelInferior.setBackground(new java.awt.Color(224, 239, 255));

        tablaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(tablaCategoria);

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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)))
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

        jPanel2.setBackground(new java.awt.Color(224, 239, 255));

        cmbLibreria.setPreferredSize(new java.awt.Dimension(300, 20));
        cmbLibreria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLibreriaActionPerformed(evt);
            }
        });

        jLabel2.setText("Librerias");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbLibreria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbLibreria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(224, 239, 255));

        jLabel6.setText("Nombre de la Categoria");

        txtCategoria.setToolTipText("");

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jrbInactivo.setBackground(new java.awt.Color(224, 239, 255));
        jrbInactivo.setText("Inactivo");

        jrbActivo.setBackground(new java.awt.Color(224, 239, 255));
        jrbActivo.setSelected(true);
        jrbActivo.setText("Activo");

        jLabel3.setText("Estatus");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jrbActivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbInactivo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
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
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbAgregar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jrbActivo)
                    .addComponent(jrbInactivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);

        jPanel3.setBackground(new java.awt.Color(224, 239, 255));

        jlCategoria.setText("Categorias existentes");

        tablaCatExistentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane3.setViewportView(tablaCatExistentes);

        jbCambioEstatus.setText("Cambiar de Estatus");
        jbCambioEstatus.setToolTipText("Cambiar de Estatus");
        jbCambioEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCambioEstatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCambioEstatus))
                    .addComponent(jlCategoria))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCambioEstatus)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInferior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Agrega las categorias a la tabla
     *
     * @param evt
     */
    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        agregarCategoria();
}//GEN-LAST:event_jbAgregarActionPerformed

    /**
     * Agrega las categorias a la tabla
     */
    private void agregarCategoria() {
        String categoria = "", libreria = "", estatus = "";
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

            categoria = txtCategoria.getText();

            if (!categoria.equalsIgnoreCase("")) {

//                if (categoria.matches(UtilidadPalabras.VALIDAR_CARACTERES_ESPECIALES)) {

                    for (Categoria cat : listaCategorias) {
                        String ca = cat.getCategoria();
                        if (ca.equalsIgnoreCase(categoria)) {
                            banLista = false;
                            break;
                        }
                    }

                    if (modelTable != null) {
                        ver = modelTable.getDataVector();
                        for (int i = 0; i < ver.size(); i++) {
                            Vector d = (Vector) ver.get(i);
                            String cat = d.get(1).toString();
                            if (cat.equalsIgnoreCase(categoria)) {
                                banTabla = false;
                                break;
                            }
                        }
                    }

                    if (banTabla) {
                        if (banLista) {
                            filas.add(libreria);
                            filas.add(categoria);
                            filas.add(estatus);
                            modelTable.addRow(filas);
                            tablaCategoria.setModel(modelTable);
                            tablaCategoria.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                            txtCategoria.setText("");
                            txtCategoria.setEditable(true);
                            jrbActivo.setSelected(true);
                        } else {
                            //JOptionPane.showMessageDialog(this, "Ya la categoria se encuentra en la lista de existentes", "Advertencia", JOptionPane.WARNING_MESSAGE);

                            int n = JOptionPane.showOptionDialog(this, "Ya la categoria se encuentra en la lista de existentes \n ¿desea modificarlo?",
                                    "¿?",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null, new Object[]{"SI", "NO"}, "NO");

                            if (n == JOptionPane.YES_OPTION) {
                                filas.add(libreria);
                                filas.add(categoria);
                                filas.add(estatus);
                                modelTable.addRow(filas);
                                tablaCategoria.setModel(modelTable);
                                tablaCategoria.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                                txtCategoria.setText("");
                                txtCategoria.setEditable(true);
                                jrbActivo.setSelected(true);
                            } else {
                                txtCategoria.setText("");
                                txtCategoria.setEditable(true);
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Ya la categoria se encuentra en la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }

//                } else {
//                    JOptionPane.showMessageDialog(this, "La categoria no debe tener caracteres especiales \n solo letras y/o numeros", "Advertencia", JOptionPane.WARNING_MESSAGE);
//                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe colocar un nombre de la categoria", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una libreria", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Guarda las Categorias en la base de datos
     *
     * @param evt
     */
    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        guardarCategoria();
}//GEN-LAST:event_jbSalvarActionPerformed

    /**
     * Guarda las Categorias en la base de datos
     */
    private void guardarCategoria() {

        DefaultTableModel md;
        List<Perfil> categorias = new ArrayList<Perfil>();
        Perfil categoria;
        Categoria cat;
        Libreria lib;
        Vector cats;
        List categ = new ArrayList();
        boolean resp, ban = true;
        int contCat = 0;



        try {

            md = (DefaultTableModel) tablaCategoria.getModel();
            cats = md.getDataVector();

            int n = JOptionPane.showOptionDialog(this, "Seguro que desea guardar las Categorias",
                    "¿?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"SI", "NO"}, "NO");

            if (n == JOptionPane.YES_OPTION) {

                if (!cats.isEmpty()) {
                    for (int i = 0; i < cats.size(); i++) {
                        Vector vCat = (Vector) cats.get(i);

                        categoria = new Perfil();
                        cat = new Categoria();
                        lib = new Libreria();

                        lib.setDescripcion(vCat.get(0).toString());
                        lib.setEstatus("1");
                        for (Libreria li : librerias) {
                            if (li.getDescripcion().equalsIgnoreCase(lib.getDescripcion())) {
                                lib.setIdLibreria(li.getIdLibreria());
                                break;
                            }
                        }

                        cat.setCategoria(vCat.get(1).toString());

                        if (vCat.get(2).toString().equalsIgnoreCase(jrbActivo.getText())) {
                            cat.setEstatus("1");
                        } else if (vCat.get(2).toString().equalsIgnoreCase(jrbInactivo.getText())) {
                            cat.setEstatus("2");
                        }

                        for (Categoria cate : listaCategorias) {
                            if (cat.getCategoria().equalsIgnoreCase(cate.getCategoria())) {
                                cat.setIdCategoria(cate.getIdCategoria());
                            }
                        }

                        if (verificarCategorias(cat.getCategoria(), cat.getEstatus())) {
                            contCat++;
                            categ.add(cat.getCategoria());
                        }

                        categoria.setLibreria(lib);
                        categoria.setCategoria(cat);

                        categorias.add(categoria);
                    }

                    if (contCat == 0) {

                        resp = new AdministracionAgregar().insertarCategoria(categorias);


                        if (ban) {
                            if (resp) {
                                JOptionPane.showMessageDialog(this, "Categorias guardadas con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                limpiarComponentes();
                            } else {
                                JOptionPane.showMessageDialog(this, "Problemas al guardar las categorias", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                limpiarComponentes();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "algunas categorias ya existen \n" + categ + "\nno se procede a guardar", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        ban = false;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "La tabla de categorias esta vacia", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (SOAPException ex) {
            traza.trace("error soap en el webservice", Level.ERROR, ex);
        } catch (SOAPFaultException ex) {
            traza.trace("error soapfault en el webservice", Level.ERROR, ex);
        }
    }

    /**
     * Comprueba si existe la categoria en la base de datos
     *
     * @param categoria La categoria
     * @return Verdadero si existe, falso en caso contrario
     */
    private boolean verificarCategorias(String categoria, String estatus) {
        boolean resp = false;
        List<Categoria> categorias;

        try {

            if (estatus.equalsIgnoreCase("1")) {
                estatus = Constantes.ACTIVO;
            } else {
                estatus = Constantes.INACTIVO;
            }

            categorias = new AdministracionBusqueda().buscarCategoria(categoria, 0, 0);

            for (Categoria c : categorias) {
                String cate = c.getCategoria();

                if (cate.equalsIgnoreCase(categoria)) {
                    resp = true;
                    for (Categoria cat : listaCategorias) {
                        String categ = cat.getCategoria();

                        if (categ.equalsIgnoreCase(categoria)) {
                            if (!cat.getEstatus().equalsIgnoreCase(estatus)) {
                                resp = false;
                            }
                        }
                    }
                }
            }

        } catch (SOAPException | SOAPFaultException ex) {
            traza.trace("error soapfault en el webservice", Level.ERROR, ex);
        }
        return resp;
    }

    /**
     * Cierra la ventana
     *
     * @param evt
     */
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed

        this.dispose();
}//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * llena la tabla con las Categorias existentes
     *
     * @param evt
     */
    private void cmbLibreriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLibreriaActionPerformed


        String lib = cmbLibreria.getSelectedItem().toString();

        modelTable = null;
        tablaCategoria.setModel(armarTabla());

        for (Libreria li : librerias) {
            if (lib.equalsIgnoreCase(li.getDescripcion())) {
                traza.trace("libreria selecionada " + li.getDescripcion() + " su id es " + li.getIdLibreria(), Level.INFO);
                llenarTablaCategoriaExistentes(li.getDescripcion(), li.getIdLibreria());
                break;
            }
        }

    }//GEN-LAST:event_cmbLibreriaActionPerformed

    /**
     * llena la tabla con las Categorias existentes
     *
     * @param lib Nombre de la Libreria
     * @param idLibreria El id de la Libreria
     */
    private void llenarTablaCategoriaExistentes(String lib, int idLibreria) {
        Vector filas;

        try {
            traza.trace("buscando las categorias de la libreria: " + lib, Level.INFO);
            traza.trace("id de la libreria: " + idLibreria, Level.INFO);

            jlCategoria.setAutoscrolls(true);            
            jlCategoria.setText("Categorias de la Libreria " + lib);
            listaCategorias = new AdministracionBusqueda().buscarCategoria("", idLibreria, 0);

            tablaCatExistentes.setModel(armarTablaExistentes());

            if (!listaCategorias.isEmpty()) {
                for (Categoria cat : listaCategorias) {
                    filas = new Vector();
                    traza.trace("categoria encontrada: " + cat.getCategoria(), Level.INFO);

                    filas.add(cat.getCategoria());
                    filas.add(cat.getEstatus());

                    modelTableExistentes.addRow(filas);
                    tablaCatExistentes.setModel(modelTableExistentes);
                }
                tablaCatExistentes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            }
        } catch (SOAPException ex) {
            traza.trace("error soap en el webservice", Level.ERROR, ex);
        } catch (SOAPFaultException ex) {
            traza.trace("error soapfault en el webservice", Level.ERROR, ex);
        }
    }

    private void jbCambioEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCambioEstatusActionPerformed

        //String categoria = ((String) tablaCatExistentes.getValueAt(tablaCatExistentes.getSelectedRow(), tablaCatExistentes.getSelectedColumn()));
        String categoria = ((String) tablaCatExistentes.getValueAt(tablaCatExistentes.getSelectedRow(), 0));

        txtCategoria.setText(categoria);
        txtCategoria.setEditable(false);

    }//GEN-LAST:event_jbCambioEstatusActionPerformed

    /**
     * Limpia los componentes
     */
    public void limpiarComponentes() {

        txtCategoria.setText("");

        grupoBotonesEstatus.clearSelection();
        jrbActivo.setSelected(true);

        tablaCategoria.setModel(armarTabla());
        tablaCatExistentes.setModel(armarTablaExistentes());
        //cmbLibreria.setSelectedItem("");
        llenarComboLibreria();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbLibreria;
    private javax.swing.ButtonGroup grupoBotonesEstatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JTable tablaCatExistentes;
    private javax.swing.JTable tablaCategoria;
    private javax.swing.JTextField txtCategoria;
    // End of variables declaration//GEN-END:variables
}
