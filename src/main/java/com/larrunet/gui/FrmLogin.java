

package com.larrunet.gui;

import com.larrunet.bean.Personal;
import com.larrunet.bean.Servidor;
import com.larrunet.dao.UsuarioDAO;
//import com.larrunet.datos.ConexionMikrotik;
import com.larrunet.util.ApplicationIcon;
import com.larrunet.util.GradientTranslucentPanel;
import com.larrunet.util.Singleton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import me.legrange.mikrotik.ApiConnection;
//import me.legrange.mikrotik.MikrotikApiException;

public class FrmLogin extends javax.swing.JFrame implements ActionListener,FocusListener{

    
    
    UsuarioDAO daousuario;
    private boolean validacion=true;
    
    public FrmLogin() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        setUndecorated(true);
        initComponents();
        initObjects();
        setIconImage(ApplicationIcon.getInstance().getImage());
        set_Action();
        //setBackground(new Color(0,0,0,0));
    }

    
    public void initObjects(){
        daousuario = new UsuarioDAO();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new GradientTranslucentPanel();
        txt_Clave = new javax.swing.JPasswordField();
        txt_Usuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_Acceder = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIO DE SESIÓN");
        setResizable(false);

        txt_Clave.setToolTipText("Ingrese su clave...");

        txt_Usuario.setToolTipText("Ingrese su usuario...");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Clave:");

        btn_Acceder.setText("Acceder");
        btn_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AccederActionPerformed(evt);
            }
        });

        btn_Salir.setText("Salir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Acceder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Salir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Clave)
                            .addComponent(txt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Salir)
                    .addComponent(btn_Acceder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AccederActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AccederActionPerformed

    private void set_Action(){
        btn_Acceder.addActionListener(this);
        btn_Salir.addActionListener(this);
        txt_Clave.addActionListener(this);
        txt_Usuario.addFocusListener(this);
        txt_Clave.addFocusListener(this);
        txt_Usuario.addKeyListener(new KeyEvents());
    }
    
    
    private Servidor getServer(){
        Servidor server = new Servidor();
        Properties propiedades = new Properties();
        InputStream entrada = null;
        try {
            entrada = new FileInputStream("src/com/larrunet/mikrotik.properties");
            propiedades.load(entrada);
            
            server.setHost(propiedades.getProperty("host"));
            server.setUser(propiedades.getProperty("user"));
            server.setPassword(propiedades.getProperty("password"));
            server.setPort(Integer.parseInt(propiedades.getProperty("port")));
            server.setSSLCertificate(Boolean.parseBoolean(propiedades.getProperty("sslcertificate")));
            server.setSSLConnection(Boolean.parseBoolean(propiedades.getProperty("sslconnection")));
            
        } catch (IOException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (entrada != null) {
            try {
                entrada.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
        return server;
    }
    
    
    
    private void validar_campos(){
        if(txt_Usuario.getText().trim().length()<=0){
            JOptionPane.showMessageDialog(null, "Ingrese un usuario", "FALTA INGRESAR USUARIO", JOptionPane.WARNING_MESSAGE);
            txt_Usuario.requestFocus();
            validacion=false;
            return;
        }
         if(String.copyValueOf(txt_Clave.getPassword()).trim().length()<=0){
            JOptionPane.showMessageDialog(null, "Ingrese su contraseña", "FALTA INGRESAR CONTRASEÑA", JOptionPane.WARNING_MESSAGE);
            txt_Clave.requestFocus();
            validacion=false;
            return;
        }
         validacion=true;
    }
    
    
    private void validar_credenciales(){
        validar_campos();
          if(validacion){
            String user=txt_Usuario.getText();
            String pass=String.copyValueOf(txt_Clave.getPassword());
            
            /*
            Servidor server = getServer();
            
            try {
                ApiConnection cn = ConexionMikrotik.getInstance().getConnection(server);
                System.out.println(cn.isConnected());
            } catch (MikrotikApiException ex) {
                Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
            
            Personal personal = daousuario.login(user, pass);
            
            if(personal!=null){
                Singleton.getInstance().setPersonal(personal);
                FrmPrincipal frame=new FrmPrincipal();
                frame.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña invalidos", ".:::DATOS INVALIDOS:::.", JOptionPane.ERROR_MESSAGE);
            }
            
            
            /*
            if(user.equals("admin") && pass.equals("admin")){
                FrmPrincipal frame=new FrmPrincipal();
                frame.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña invalidos", ".:::DATOS INVALIDOS:::.", JOptionPane.ERROR_MESSAGE);
            }
            */
          }
    }
    
    private void salir(){
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cerrar esta ventana?", "CONFIRMAR", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
             System.exit(0);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource()==btn_Acceder || evt.getSource()==txt_Clave){ 
            validar_credenciales();
        }else if(evt.getSource()==btn_Salir){
           salir();
        }
    }
    
        @Override
    public void focusGained(FocusEvent e) {
       try
        {
            KeyEvent ke = new KeyEvent(e.getComponent(), KeyEvent.KEY_PRESSED,
                    System.currentTimeMillis(), InputEvent.CTRL_MASK,
                    KeyEvent.VK_F1, KeyEvent.CHAR_UNDEFINED);
            e.getComponent().dispatchEvent(ke);
        }
        catch (Throwable e1){}
    }
        
    @Override
    public void focusLost(FocusEvent e) {}
    
    
    private class KeyEvents implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
        
        @Override
        public void keyPressed(KeyEvent e) {
         char key=e.getKeyChar();
            if(key==KeyEvent.VK_ENTER){
                txt_Clave.requestFocus();
            }
         
        }   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Acceder;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_Clave;
    private javax.swing.JTextField txt_Usuario;
    // End of variables declaration//GEN-END:variables


}
