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

    private String rutaReportes;
    private JasperReport informe;
    private JasperPrint jp;

    public Reportes() {
        rutaReportes = System.getProperty("user.dir") + "/src/main/java/com/larrunet/report/";
    }

    public void prepararInforme(String nombreInforme, Map parametros, Connection cn) {
        informe = null;
        String ruta = rutaReportes + nombreInforme;
        try {
            informe = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            jp = JasperFillManager.fillReport(informe, parametros, cn);   
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }

    }

    public void mostrarInforme() {

        if (informe != null && jp!=null) {
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Pago");
            jv.setLocationRelativeTo(null);
            jv.setVisible(true);
        }else{
            System.out.println("objeto JasperReport=null o objeto JasperPrint=null");
        }
    }

    public void mostrarInforme(String nombreInforme, Map parametros, Connection cn) {
        JasperReport informe = null;
        String ruta = rutaReportes + nombreInforme;
        try {

            informe = (JasperReport) JRLoader.loadObjectFromFile(ruta);

            JasperPrint jp = JasperFillManager.fillReport(informe, parametros, cn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Pago");
            jv.setLocationRelativeTo(null);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }
}
