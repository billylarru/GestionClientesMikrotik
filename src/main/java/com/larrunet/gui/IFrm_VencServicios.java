/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.gui;

import com.larrunet.bean.Cliente;
import com.larrunet.bean.Pago;
import com.larrunet.bean.Servicio;
import com.larrunet.dao.ServicioDAO;
import com.larrunet.util.IFrameListener;
import com.larrunet.util.RowsRenderer;
import com.larrunet.util.TableMouseListener;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kael
 */
public class IFrm_VencServicios extends javax.swing.JInternalFrame {

    ServicioDAO daoservicios;
    List<Servicio> listaServicios;
    private JPopupMenu popupMenu;
    
    private JMenuItem menuItemCobrar, menuItemCortar;
    /**
     * Creates new form IFrm_Vencimientos
     */
    public IFrm_VencServicios() {
        initComponents();
        this.addInternalFrameListener(new IFrameListener());
        initObjects();
        makePopUp();
        renderizarFilas();
        rbtPorVencer.setSelected(true);
        listarServiciosPorVencer();
    }
    
    private void renderizarFilas(){
        RowsRenderer rr = new RowsRenderer(3);
        tblClientes.setDefaultRenderer(Object.class, rr);
    }
    
     private void makePopUp() {
        popupMenu = new JPopupMenu();
        menuItemCobrar = new JMenuItem("Cobrar");
        menuItemCortar = new JMenuItem("Cortar");

        IFrm_VencServicios.ActionTable at = new IFrm_VencServicios.ActionTable();

        menuItemCobrar.addActionListener(at);
        menuItemCortar.addActionListener(at);

        tblClientes.setComponentPopupMenu(popupMenu);
        tblClientes.addMouseListener(new TableMouseListener(tblClientes));

        popupMenu.add(menuItemCobrar);
        popupMenu.add(menuItemCortar);

    }
     
     
    private void initObjects(){
        daoservicios = new ServicioDAO();
    }
    
    
    
    public void listarTodosLosServicios(){
        listaServicios = daoservicios.listarTodosLosServicios();
        renderizarTabla(listaServicios);
    }
    
    public void listarServiciosPorVencer(){
        listaServicios = daoservicios.listarServiciosPorVencer();
        renderizarTabla(listaServicios);
    }
    
    public void listarServiciosCortados(){
        listaServicios = daoservicios.listarCortados();
        renderizarTabla(listaServicios);
    }
    
    private void renderizarTabla(List<Servicio> list){
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        model.setRowCount(0);
        
        Cliente cliente = null;
        for (Servicio servicio : list) {
            cliente = servicio.getCliente();
            List<Pago> listaPagos = cliente.getPagos();
            Pago pago = listaPagos.get(listaPagos.size()-1);
            Object[] row = {cliente.getNombresCompletos(), pago.getFechaInicio(), pago.getFechaVencimiento(), pago.getVenceEn()};
            model.addRow(row);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rbtPorVencer = new javax.swing.JRadioButton();
        rbtListarTodos = new javax.swing.JRadioButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rbtCortados = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setClosable(true);
        setTitle("Vencimientos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterio"));

        buttonGroup1.add(rbtPorVencer);
        rbtPorVencer.setText("Por vencer");
        rbtPorVencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtPorVencerActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtListarTodos);
        rbtListarTodos.setText("Listar todos");
        rbtListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtListarTodosActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar por Nombre:");

        buttonGroup1.add(rbtCortados);
        rbtCortados.setText("Cortados");
        rbtCortados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtCortadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtPorVencer)
                        .addGap(26, 26, 26)
                        .addComponent(rbtListarTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtCortados)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtPorVencer)
                    .addComponent(rbtListarTodos)
                    .addComponent(rbtCortados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Fecha Inicio", "Fecha Venc", "Vence"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtPorVencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtPorVencerActionPerformed
        listarServiciosPorVencer();
    }//GEN-LAST:event_rbtPorVencerActionPerformed

    private void rbtListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtListarTodosActionPerformed
        listarTodosLosServicios();
    }//GEN-LAST:event_rbtListarTodosActionPerformed

    private void rbtCortadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCortadosActionPerformed
       listarServiciosCortados();
    }//GEN-LAST:event_rbtCortadosActionPerformed

    private void cobrarServicio(){
        int selectedRow = tblClientes.getSelectedRow();
        Servicio servicio = listaServicios.get(selectedRow);
        
        Frame f = JOptionPane.getFrameForComponent(this);
        DialogRegistrarPago dialog = new DialogRegistrarPago(f, true, servicio);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    private void cortarServicio(){
        int selectedRow = tblClientes.getSelectedRow();
        Servicio servicio = listaServicios.get(selectedRow);
        
        daoservicios.cortarServicio(servicio);
        
        if(rbtPorVencer.isSelected()){
            listarServiciosPorVencer();
        }else if(rbtListarTodos.isSelected()){
            listarTodosLosServicios();
        }else if(rbtCortados.isSelected()){
            listarServiciosCortados();
        }
    }
    
  
    private class ActionTable implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem menu = (JMenuItem) e.getSource();

            if (menu == menuItemCobrar) {
                cobrarServicio();
            } else if (menu == menuItemCortar) {
                cortarServicio();
            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtCortados;
    private javax.swing.JRadioButton rbtListarTodos;
    private javax.swing.JRadioButton rbtPorVencer;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
