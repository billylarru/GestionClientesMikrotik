
package com.larrunet.util;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class IFrameListener implements InternalFrameListener{

  
    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        String propertyIFrame=e.getInternalFrame().toString();
        int beginIndex=propertyIFrame.indexOf("_");
        int endIndex=propertyIFrame.indexOf("[");
        String name=propertyIFrame.substring(beginIndex+1, endIndex);
        
        e.getInternalFrame().dispose();
        HashList.getInstance().getList().remove(name);
          
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        int icon_width=16;
        int icon_height=16;
        e.getInternalFrame().setFrameIcon(new ImageIcon(ApplicationIcon.getInstance().getImage().getScaledInstance(icon_width, icon_height, Image.SCALE_DEFAULT)));
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
    }

   
 

  

  
    
}
