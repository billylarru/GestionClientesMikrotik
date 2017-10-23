/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.main;

import com.larrunet.gui.FrmLogin;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author kael
 */
public class Main {

    public static void main(String[] args) {
        init();
    }
    
    public static void init(){
          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    try {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        
                        FrmLogin frame=new FrmLogin();
                        frame.setResizable(false);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                               
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                }
            }
    }
    
}
