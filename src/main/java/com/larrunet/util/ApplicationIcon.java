
package com.larrunet.util;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ApplicationIcon {
    private final  Image image;
    private final  String url=System.getProperty("user.dir")+"\\src\\Imagenes\\";
    private final  String nameImage="icono.png";
    private static ApplicationIcon obj;
    
    private ApplicationIcon() {
        image=new ImageIcon(url+nameImage).getImage();
    }
    
    private static void createInstance(){
        if(obj==null)obj=new ApplicationIcon();
    }
    
    public static ApplicationIcon getInstance(){
        if(obj==null)createInstance();
        return obj;
    }
    
    public Image getImage() {
        return image;
    }
    
}
