

package com.larrunet.gui;

import com.larrunet.bean.Personal;
import com.larrunet.bean.Usuario;
import com.larrunet.util.ApplicationIcon;
import com.larrunet.util.HashList;
import com.larrunet.util.Singleton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author kael
 */
public class FrmPrincipal extends javax.swing.JFrame {
    private int x,y;
    private Timer timer;
    private final int delay=1000;
    private final SimpleDateFormat sdf=new SimpleDateFormat("(dd/MM/yyyy) hh:mm:ss a");
    
    public FrmPrincipal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        set_Action();
        showTime();  
        setIconImage(ApplicationIcon.getInstance().getImage());
        showUser();
    }
    
    private void showTime(){
        timer=new Timer(delay, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar calendar=Calendar.getInstance();
                lblFecha.setText(DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime())+sdf.format(calendar.getTime()));
            }
            
        }
        );
        timer.start();
    }
    
   
    private void showUser(){
        Personal personal = Singleton.getInstance().getPersonal();
        Usuario usuario = personal.getUsuario();
        lblUsuario.setText("Usuario: "+usuario.getUsernameUsuario());
        
        String nombres_completo = personal.getNombrePersonal()+" "+personal.getApePaternoPersonal()+" "+personal.getApeMaternoPersonal();
        
        //JOptionPane.showMessageDialog(this, "Bienvenido "+nombres_completo);
    }
    

    //El setActionCommand debe contener lo que viene despues del IFrm_
    private void set_Action(){
        ActionMI al=new ActionMI();
        mi_cliente.addActionListener(al);
        mi_antenas.addActionListener(al);
        mi_lineas.addActionListener(al);
        mi_registro_pago.addActionListener(al);
        mi_personal.addActionListener(al);
        mi_vencimientos.addActionListener(al);
        
        mi_cliente.setActionCommand("Clientes");
        mi_antenas.setActionCommand("Antenas");
        mi_lineas.setActionCommand("Lineas");
        mi_registro_pago.setActionCommand("RegistrarPago");
        mi_personal.setActionCommand("Personal");
        mi_vencimientos.setActionCommand("VencServicios");
    }
    
    private void makeIFrame(String key){
        JInternalFrame iframe;
        iframe=(JInternalFrame) HashList.getInstance().getList().get(key);
        
        if(iframe==null){
            
            if(key.equalsIgnoreCase("Clientes")) iframe=new IFrm_Clientes();
            else if(key.equalsIgnoreCase("Antenas")) iframe=new IFrm_Antenas();
            else if(key.equalsIgnoreCase("Lineas")) iframe=new IFrm_Lineas();
            else if(key.equalsIgnoreCase("RegistrarPago")) iframe = new IFrm_RegistrarPago();
            else if(key.equalsIgnoreCase("Personal")) iframe = new IFrm_Personal();
            else if(key.equalsIgnoreCase("VencServicios")) iframe = new IFrm_VencServicios();

            HashList.getInstance().getList().put(key, iframe);
            
            x=desktop.getWidth()/2-iframe.getWidth()/2;
            y=desktop.getHeight()/2-iframe.getHeight()/2;
            iframe.setLocation(x, y);
            desktop.add(iframe);
            iframe.setVisible(true);
            
            
        }else{
            //hacer focus a la ventana existente
            try {
                iframe.setSelected(true);
            } catch (PropertyVetoException ex) {
                System.out.println("Error al realizar el focus sobre el InternalFrame");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mi_cliente = new javax.swing.JMenuItem();
        mi_antenas = new javax.swing.JMenuItem();
        mi_lineas = new javax.swing.JMenuItem();
        mi_personal = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mi_vencimientos = new javax.swing.JMenuItem();
        mi_registro_pago = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Pagos L@rrunet");
        setResizable(false);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblUsuario.setText("Usuario: admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("Mantenimiento");

        mi_cliente.setText("Clientes");
        jMenu1.add(mi_cliente);

        mi_antenas.setText("Antenas");
        jMenu1.add(mi_antenas);

        mi_lineas.setText("Lineas");
        jMenu1.add(mi_lineas);

        mi_personal.setText("Personal");
        jMenu1.add(mi_personal);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pagos");

        mi_vencimientos.setText("Vencimientos");
        jMenu2.add(mi_vencimientos);

        mi_registro_pago.setText("registrar nuevo pago");
        jMenu2.add(mi_registro_pago);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private class ActionMI implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            makeIFrame(e.getActionCommand());
         }
        
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem mi_antenas;
    private javax.swing.JMenuItem mi_cliente;
    private javax.swing.JMenuItem mi_lineas;
    private javax.swing.JMenuItem mi_personal;
    private javax.swing.JMenuItem mi_registro_pago;
    private javax.swing.JMenuItem mi_vencimientos;
    // End of variables declaration//GEN-END:variables
}
