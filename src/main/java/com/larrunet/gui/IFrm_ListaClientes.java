/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.gui;

import com.larrunet.bean.Antena;
import com.larrunet.bean.Cliente;
import com.larrunet.bean.Hotspot;
import com.larrunet.bean.Pago;
import com.larrunet.bean.Servicio;
import com.larrunet.dao.ServicioDAO;
import com.larrunet.util.IFrameListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kael
 */
public class IFrm_ListaClientes extends javax.swing.JInternalFrame {
    ServicioDAO daoservicios;
    List<Servicio> listaServicios;
    
    
    /**
     * Creates new form IFrm_ListaClientes
     */
    public IFrm_ListaClientes() {
        initComponents();
        this.addInternalFrameListener(new IFrameListener());
        initObjects();
        listarClientes();
    }
    
    
    void initObjects(){
        daoservicios = new ServicioDAO();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnExportarLista = new javax.swing.JButton();

        setClosable(true);
        setTitle("Lista Clientes");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Fecha inicio", "Fecha Venc", "IP", "Antena", "Direccion", "Observacion", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        btnExportarLista.setText("Exportar lista");
        btnExportarLista.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(776, Short.MAX_VALUE)
                .addComponent(btnExportarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(446, 446, 446))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExportarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listarClientes(){
        listaServicios = daoservicios.listarTodosLosClientes();
        renderizarTabla(listaServicios);
    }
    
    private void renderizarTabla(List<Servicio> list) {
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        model.setRowCount(0);

        Cliente cliente = null;
        for (Servicio servicio : list) {
            cliente = servicio.getCliente();
            
            Antena antena = servicio.getAntena();
            
            List<Hotspot> hotspots = servicio.getHotspots();
            List<Pago> listaPagos = cliente.getPagos();
            Pago pago = listaPagos.get(listaPagos.size() - 1);
            
            
            String IPs = getAllIP(hotspots);
            
            Object[] row = {
                cliente.getNombresCompletos(), 
                pago.getFechaInicio(), 
                pago.getFechaVencimiento(), 
                IPs, 
                antena.getDescripAntena(),
                cliente.getDireccionCliente(),
                servicio.getObservacion(),
                servicio.getEstadoServicio()
            };
            model.addRow(row);
        }
    }
    
    private String getAllIP(List<Hotspot> list){
        String allIP = "";
        for(Hotspot h: list){
            allIP+= h.getIP()+", ";
        }
        return allIP;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarLista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
