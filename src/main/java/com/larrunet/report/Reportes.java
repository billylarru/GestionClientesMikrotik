/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.report;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author alumno
 */
public class Reportes {

    public Reportes() {
    }
    
    
    
    public void mostrarInforme(String nombreInforme,Map parametros,Connection cn){
            JasperReport informe=null;
        String ruta=System.getProperty("user.dir")+"/src/main/java/com/larrunet/report/"+nombreInforme;
        try {
        
            informe=(JasperReport) JRLoader.loadObjectFromFile(ruta);
   
          JasperPrint jp= JasperFillManager.fillReport(informe, parametros,cn);         
             JasperViewer jv=new JasperViewer(jp,false) ; 
             jv.setLocationRelativeTo(null);
             jv.setVisible(true);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }
}
