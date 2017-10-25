/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.gui;

import com.larrunet.bean.Hotspot;
import com.larrunet.bean.Linea;
import com.larrunet.dao.LineaDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author larru
 */
public class DialogHotspot extends javax.swing.JDialog {

    List<Hotspot> listaHotspot;
    Hotspot hotspot;

    LineaDAO daolineas;
    List<Linea> listaLineas;
    IFrm_Clientes iframe;

    private boolean campos_validados;
    private boolean editar;

    /**
     * Creates new form DialogHotspot
     */
    public DialogHotspot(java.awt.Frame parent, boolean modal, IFrm_Clientes iframe, List<Hotspot> hotspots) {
        super(parent, modal);
        this.iframe = iframe;
        initComponents();
        initObjects();
        listarLineas();
        this.listaHotspot = hotspots;
    }

    public DialogHotspot(java.awt.Frame parent, boolean modal, IFrm_Clientes iframe, Hotspot hotspot) {
        super(parent, modal);
        this.iframe = iframe;
        initComponents();
        initObjects();
        listarLineas();
        this.hotspot = hotspot;
        editar = true;
        cargarDatos();
    }

    void cargarDatos() {
        if (editar) {
            setTitle("Editar IP");
            btnAgregar.setText("Guardar cambios");
            txtIP.setText(hotspot.getIP());
            cboLinea.setSelectedItem(hotspot.getLinea().getDescripLinea());
        }
    }

    public void initObjects() {
        daolineas = new LineaDAO();
    }

    public void listarLineas() {
        listaLineas = daolineas.listar();
        for (Linea linea : listaLineas) {
            cboLinea.addItem(linea.getDescripLinea());
        }
    }

    public boolean existeHotspot(Hotspot hotspot) {
        boolean existe = false;

        for (Hotspot h : listaHotspot) {
            if (h.getIP().equals(hotspot.getIP())) {
                existe = true;
                break;
            }
        }

        return existe;
    }

    private void validar_campos() {
        if (txtIP.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una IP", "FALTA INGRESAR IP", JOptionPane.WARNING_MESSAGE);
            txtIP.requestFocus();
            campos_validados = false;
            return;
        }
        
        if(cboLinea.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Seleccione una linea", "FALTA SELECCIONAR LINEA", JOptionPane.WARNING_MESSAGE);
            cboLinea.requestFocus();
            campos_validados = false;
            return;
        }
        
        
        campos_validados = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        cboLinea = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar IP");

        jLabel10.setText("IP:");

        cboLinea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        jLabel11.setText("linea:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAgregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        validar_campos();

        if (campos_validados) {

            if (editar) {
                hotspot.setIP(txtIP.getText());
                int indiceLinea = cboLinea.getSelectedIndex();
                hotspot.setLinea(listaLineas.get(indiceLinea-1));
                iframe.mostrarHotspotsAgregados();
                dispose();
            } else {
                Hotspot hotspot = new Hotspot();
                hotspot.setIP(txtIP.getText());
                int indiceLinea = cboLinea.getSelectedIndex();
                hotspot.setLinea(listaLineas.get(indiceLinea-1));
                hotspot.setEstadoHostpot("ACTIVADO");
                if (!existeHotspot(hotspot)) {
                    listaHotspot.add(hotspot);
                    iframe.mostrarHotspotsAgregados();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "¡La IP " + hotspot.getIP() + " ya existe!");
                }
            }

        }


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cboLinea;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JTextField txtIP;
    // End of variables declaration//GEN-END:variables
}
