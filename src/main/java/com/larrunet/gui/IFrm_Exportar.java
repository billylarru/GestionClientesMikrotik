/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.gui;

import com.larrunet.util.DB;
import com.larrunet.util.IFrameListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author kael
 */
public class IFrm_Exportar extends javax.swing.JInternalFrame {

    private JFileChooser selector = new JFileChooser();
    private transient FileNameExtensionFilter filtro = new FileNameExtensionFilter("Todos los archivos *.sql", "sql");

    private String ruta;
    private boolean campos_validados;

    /**
     * Creates new form IFrm_Exportar
     */
    public IFrm_Exportar() {
        initComponents();
        this.addInternalFrameListener(new IFrameListener());
        // selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        selector.addChoosableFileFilter(filtro);
        selector.setApproveButtonText("Guardar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExportar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        jLabel1.setText("destino del backup:");

        txtDestino.setEditable(false);

        btnBuscar.setText("...");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void validarCampos() {
        if (txtDestino.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Especifique donde se guardará el backup", "FALTA INDICAR RUTA", JOptionPane.WARNING_MESSAGE);
            campos_validados = false;
            return;
        }
        campos_validados = true;
    }


    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        validarCampos();

        if (campos_validados) {
            exportar();
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        examinar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    void exportar() {
        Properties props = new Properties();
        InputStream is = getClass().getResourceAsStream("/META-INF/db.properties");
        try {
            props.load(is);
            
            String url = props.getProperty("javax.persistence.jdbc.url");
            
            int endIndex = url.indexOf("?");
            int beginIndex = url.lastIndexOf("/")+1;
            
            
            String bd = url.substring(beginIndex, endIndex);
            String user = props.getProperty("javax.persistence.jdbc.user");
            String password = props.getProperty("javax.persistence.jdbc.password");

            DB db = new DB(bd, user, password);
            db.Backupdbtosql(ruta);
        } catch (IOException ex) {
            Logger.getLogger(IFrm_Exportar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void examinar() {
        int seleccion = selector.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = selector.getSelectedFile();

            ruta = fichero.getAbsolutePath();

            if (!ruta.endsWith(".sql")) {
                ruta += ".sql";
            }

            txtDestino.setText(ruta);

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtDestino;
    // End of variables declaration//GEN-END:variables
}
