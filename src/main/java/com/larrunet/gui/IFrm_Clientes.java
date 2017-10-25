/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.gui;

import com.larrunet.bean.Antena;
import com.larrunet.bean.Cliente;
import com.larrunet.bean.Hotspot;
import com.larrunet.bean.Servicio;
import com.larrunet.dao.AntenaDAO;
import com.larrunet.dao.ClienteDAO;
import com.larrunet.dao.ServicioDAO;
import com.larrunet.util.IFrameListener;
import com.larrunet.util.TableMouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author larru
 */
public class IFrm_Clientes extends javax.swing.JInternalFrame {

    ServicioDAO daoservicios;
    AntenaDAO daoantenas;
    List<Antena> listaAntenas;
    private boolean campos_validados;

    List<Hotspot> hotspots = new ArrayList<>();
    List<Servicio> listaClientes;
    Servicio servicio;

    private JPopupMenu popupMenuHotspot, popupMenuCliente;
    private JMenuItem menuItemEditHotspot, menuItemDeleteHotspot;
    private JMenuItem menuItemEditCliente, menuItemDeleteCliente;

    private boolean editar = false;

    /**
     * Creates new form IFrmCliente
     */
    public IFrm_Clientes() {
        initComponents();
        initObjects();
        btnCancelar.setVisible(false);
        makePopUp();
        this.addInternalFrameListener(new IFrameListener());
        listarAntenas();
        listarClientes();
    }

    public void initObjects() {
        daoservicios = new ServicioDAO();
        daoantenas = new AntenaDAO();
    }

    public void listarAntenas() {
        listaAntenas = daoantenas.listarAntenas();
        for (Antena antena : listaAntenas) {
            cboAntenaEmisora.addItem(antena.getDescripAntena());
        }
    }

    private void listarClientes() {
        listaClientes = daoservicios.listar();
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        model.setRowCount(0);

        Cliente cliente = null;
        for (Servicio servicio : listaClientes) {
            cliente = servicio.getCliente();
            String nombres = cliente.getNombresCliente()+ " " + cliente.getApePaternoCliente()+ " " + cliente.getApeMaternoCliente();
            Object[] row = {cliente.getCodCliente(), nombres, servicio.getPagoMensual(), servicio.getEstadoServicio()};
            model.addRow(row);
        }

    }

    private void makePopUp() {
        popupMenuHotspot = new JPopupMenu();
        menuItemEditHotspot = new JMenuItem("Editar");
        menuItemDeleteHotspot = new JMenuItem("Eliminar");

        popupMenuCliente = new JPopupMenu();
        menuItemEditCliente = new JMenuItem("Editar");
        menuItemDeleteCliente = new JMenuItem("Eliminar");

        ActionTable at = new ActionTable();

        menuItemEditHotspot.addActionListener(at);
        menuItemDeleteHotspot.addActionListener(at);
        menuItemEditCliente.addActionListener(at);
        menuItemDeleteCliente.addActionListener(at);

        tblHotspot.setComponentPopupMenu(popupMenuHotspot);
        tblHotspot.addMouseListener(new TableMouseListener(tblHotspot));

        tblClientes.setComponentPopupMenu(popupMenuCliente);
        tblClientes.addMouseListener(new TableMouseListener(tblClientes));

        popupMenuHotspot.add(menuItemEditHotspot);
        popupMenuHotspot.add(menuItemDeleteHotspot);

        popupMenuCliente.add(menuItemEditCliente);
        popupMenuCliente.add(menuItemDeleteCliente);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgEstadoServicio = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAlias = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtPagoMensual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        rbtActivo = new javax.swing.JRadioButton();
        rbtCortado = new javax.swing.JRadioButton();
        rbtEnPruebas = new javax.swing.JRadioButton();
        cboAntenaEmisora = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHotspot = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setClosable(true);
        setTitle("Mantenimiento de clientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del cliente"));

        jLabel1.setText("Nombres:");

        jLabel2.setText("Apellido Paterno:");

        jLabel3.setText("Apellido Materno:");

        jLabel4.setText("IdCliente:");

        txtIdCliente.setEditable(false);

        jLabel5.setText("Direccion:");

        jLabel10.setText("Alias:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidoPaterno)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAlias))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Servicio"));

        jLabel6.setText("Pago mensual (S/.):");

        jLabel7.setText("observacion(opcional):");

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane1.setViewportView(txtObservacion);

        jLabel8.setText("Estado del servicio:");

        bgEstadoServicio.add(rbtActivo);
        rbtActivo.setSelected(true);
        rbtActivo.setText("Activo");

        bgEstadoServicio.add(rbtCortado);
        rbtCortado.setText("Cortado");

        bgEstadoServicio.add(rbtEnPruebas);
        rbtEnPruebas.setText("En pruebas");

        cboAntenaEmisora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        jLabel9.setText("Antena emisora:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(30, 30, 30)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboAntenaEmisora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(183, 183, 183))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(rbtActivo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rbtCortado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbtEnPruebas))
                        .addComponent(txtPagoMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPagoMensual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cboAntenaEmisora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rbtActivo)
                    .addComponent(rbtCortado)
                    .addComponent(rbtEnPruebas))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de red"));

        tblHotspot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IP", "linea"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblHotspot);

        btnAgregar.setText("+");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(btnRegistrar)
                .addGap(29, 29, 29)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar)))
        );

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdCliente", "Cliente", "Pago mensual", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tblClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregarHotspot();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnRegistrar.setText("Registrar");
        editar = false;
        btnCancelar.setVisible(false);
        limpiarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void agregarHotspot() {
        DialogHotspot dialog = new DialogHotspot(null, true, this, hotspots);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void validar_campos() {
        if (txtNombres.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre", "FALTA INGRESAR NOMBRES", JOptionPane.WARNING_MESSAGE);
            txtNombres.requestFocus();
            campos_validados = false;
            return;
        }

        if (txtApellidoPaterno.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el apellido paterno", "FALTA INGRESAR APELLIDO PATERNO", JOptionPane.WARNING_MESSAGE);
            txtApellidoPaterno.requestFocus();
            campos_validados = false;
            return;
        }

        if (txtApellidoMaterno.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el apellido materno", "FALTA INGRESAR APELLIDO MATERNO", JOptionPane.WARNING_MESSAGE);
            txtApellidoMaterno.requestFocus();
            campos_validados = false;
            return;
        }

        if (txtDireccion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una direccion", "FALTA INGRESAR DIRECCION", JOptionPane.WARNING_MESSAGE);
            txtDireccion.requestFocus();
            campos_validados = false;
            return;
        }

        if (txtPagoMensual.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el pago mensual", "FALTA INGRESAR PAGO MENSUAL", JOptionPane.WARNING_MESSAGE);
            txtPagoMensual.requestFocus();
            campos_validados = false;
            return;
        }

        if (cboAntenaEmisora.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una antena", "FALTA SELECCIONAR ANTENA", JOptionPane.WARNING_MESSAGE);
            cboAntenaEmisora.requestFocus();
            campos_validados = false;
            return;
        }

        if (tblHotspot.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una IP", "FALTA INGRESAR IP", JOptionPane.WARNING_MESSAGE);
            campos_validados = false;
            agregarHotspot();
            return;
        }

        campos_validados = true;
    }

    void registrar() {
        validar_campos();

        if (campos_validados) {

            if (editar) {
                Cliente cliente = servicio.getCliente();
                cliente.setNombresCliente(txtNombres.getText());
                cliente.setApePaternoCliente(txtApellidoPaterno.getText());
                cliente.setApeMaternoCliente(txtApellidoMaterno.getText());
                cliente.setDireccionCliente(txtDireccion.getText());
                cliente.setAliasCliente(txtAlias.getText());
                servicio.setPagoMensual(Double.parseDouble(txtPagoMensual.getText()));
                servicio.setObservacion(txtObservacion.getText());
                int indiceAntena = cboAntenaEmisora.getSelectedIndex();
                servicio.setAntena(listaAntenas.get(indiceAntena - 1));

                if (rbtActivo.isSelected()) {
                    servicio.setEstadoServicio("Activo");
                } else if (rbtCortado.isSelected()) {
                    servicio.setEstadoServicio("Cortado");
                } else if (rbtEnPruebas.isSelected()) {
                    servicio.setEstadoServicio("En pruebas");
                }

                daoservicios.modificarServicio(servicio);

                    listarClientes();
                    JOptionPane.showMessageDialog(this, "Cliente editado!", "Editar", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();


            } else {
                Servicio servicio = new Servicio();
                Cliente cliente = new Cliente();

                cliente.setNombresCliente(txtNombres.getText());
                cliente.setApePaternoCliente(txtApellidoPaterno.getText());
                cliente.setApeMaternoCliente(txtApellidoMaterno.getText());
                cliente.setDireccionCliente(txtDireccion.getText());
                cliente.setAliasCliente(txtAlias.getText());
                cliente.setServicio(servicio);
                cliente.setFechaRegistroCliente(LocalDateTime.now());
                
                servicio.setPagoMensual(Double.parseDouble(txtPagoMensual.getText()));
                servicio.setObservacion(txtObservacion.getText());

                if (rbtActivo.isSelected()) {
                    servicio.setEstadoServicio("Activo");
                } else if (rbtCortado.isSelected()) {
                    servicio.setEstadoServicio("Cortado");
                } else if (rbtEnPruebas.isSelected()) {
                    servicio.setEstadoServicio("En pruebas");
                }

                int indiceAntena = cboAntenaEmisora.getSelectedIndex();

                servicio.setAntena(listaAntenas.get(indiceAntena - 1));

                servicio.setCliente(cliente);
                servicio.setHotspots(hotspots);
                           
                if (daoservicios.registrarServicio(servicio)) {
                    JOptionPane.showMessageDialog(this, "Cliente registrado!", "Registro", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    listarClientes();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo registrar", "Falla de registro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

    private void limpiarCampos() {
        clearTxt(txtIdCliente);
        clearTxt(txtNombres);
        clearTxt(txtApellidoPaterno);
        clearTxt(txtApellidoMaterno);
        clearTxt(txtDireccion);
        clearTxt(txtPagoMensual);
        txtObservacion.setText(null);
        cboAntenaEmisora.setSelectedIndex(0);
        hotspots = null;
        limpiarTablaHotspots();
    }

    private void clearTxt(JTextField txt) {
        txt.setText(null);
    }

    public void mostrarHotspotsAgregados() {

        if (hotspots != null && hotspots.size() > 0) {
            DefaultTableModel model = (DefaultTableModel) tblHotspot.getModel();

            model.setRowCount(0);

            for (Hotspot hotspot : hotspots) {

                if ( !hotspot.getEstadoHostpot().equals("ELIMINADO") ) {
                    Object[] row = {hotspot.getIP(), hotspot.getLinea().getDescripLinea()};
                    model.addRow(row);
                }
            }
        }

    }

    private void limpiarTablaHotspots() {
        DefaultTableModel model = (DefaultTableModel) tblHotspot.getModel();
        model.setRowCount(0);
    }

    private void editarHotspot() {
        int selectedRow = tblHotspot.getSelectedRow();
        Hotspot hotspot = hotspots.get(selectedRow);

        DialogHotspot dialog = new DialogHotspot(null, true, this, hotspot);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }

    private void eliminarHotspot() {
        int selectedRow = tblHotspot.getSelectedRow();
        Hotspot hotspot = hotspots.get(selectedRow);

        String msg = "¿Está seguro de quitar la IP " + hotspot.getIP() + " ?";

        int respuesta = JOptionPane.showConfirmDialog(this, msg, "CONFIRMAR ELIMINACION", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            if (editar) {
                hotspot.setEstadoHostpot("ELIMINADO");
            } else {
                hotspots.remove(hotspot);
            }

            mostrarHotspotsAgregados();
        }

    }

    private void editarCliente() {
        int selectedRow = tblClientes.getSelectedRow();
        servicio = listaClientes.get(selectedRow);

        Cliente cliente = servicio.getCliente();

        txtIdCliente.setText(cliente.getCodCliente());
        txtNombres.setText(cliente.getNombresCliente());
        txtApellidoPaterno.setText(cliente.getApePaternoCliente());
        txtApellidoMaterno.setText(cliente.getApeMaternoCliente());
        txtDireccion.setText(cliente.getDireccionCliente());
        txtAlias.setText(cliente.getAliasCliente());

        txtPagoMensual.setText(Double.toString(servicio.getPagoMensual()));
        txtObservacion.setText(servicio.getObservacion());

        Antena antena = servicio.getAntena();

        cboAntenaEmisora.setSelectedItem(antena.getDescripAntena());

        switch (servicio.getEstadoServicio()) {
            case "Activo":
                rbtActivo.setSelected(true);
                break;
            case "Cortado":
                rbtCortado.setSelected(true);
                break;
            case "En pruebas":
                rbtEnPruebas.setSelected(true);
                break;
        }

        hotspots = servicio.getHotspots();
        mostrarHotspotsAgregados();

        editar = true;
        btnCancelar.setVisible(true);
        btnRegistrar.setText("Guardar cambios");
    }

    private void eliminarCliente() {
        int selectedRow = tblClientes.getSelectedRow();
        Servicio servicio = listaClientes.get(selectedRow);
        Cliente cliente = servicio.getCliente();
        String nombres_completos = cliente.getNombresCliente()+ " " + cliente.getApePaternoCliente()+ " " + cliente.getApeMaternoCliente();

        String msg = "¿Está seguro de eliminar el cliente " + nombres_completos + " ?";

        int respuesta = JOptionPane.showConfirmDialog(this, msg, "CONFIRMAR ELIMINACION", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

                daoservicios.eliminarServicio(servicio);
                JOptionPane.showMessageDialog(this, "¡Cliente eliminado exitosamente!", "Eliminacion", JOptionPane.INFORMATION_MESSAGE);
                listarClientes();
 

        }
    }

    private class ActionTable implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem menu = (JMenuItem) e.getSource();

            if (menu == menuItemEditHotspot) {
                editarHotspot();
            } else if (menu == menuItemDeleteHotspot) {
                eliminarHotspot();
            } else if (menu == menuItemEditCliente) {
                editarCliente();
            } else if (menu == menuItemDeleteCliente) {
                eliminarCliente();
            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgEstadoServicio;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboAntenaEmisora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbtActivo;
    private javax.swing.JRadioButton rbtCortado;
    private javax.swing.JRadioButton rbtEnPruebas;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblHotspot;
    private javax.swing.JTextField txtAlias;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextArea txtObservacion;
    private javax.swing.JTextField txtPagoMensual;
    // End of variables declaration//GEN-END:variables
}
