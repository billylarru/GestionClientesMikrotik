/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*
*Fuente:https://es.stackoverflow.com/questions/51399/pintar-las-filas-de-un-jtable-segun-una-condicion-java
*/


public class RowsRenderer extends DefaultTableCellRenderer {

    private int columna;

    public RowsRenderer(int Colpatron) {
        this.columna = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        setBackground(Color.white);
        table.setForeground(Color.black);
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        
        switch(table.getValueAt(row, columna).toString()){
            case "En 1 día": case "Hoy":
                this.setBackground(Color.PINK);
                break;
        }
         
        if (table.getValueAt(row, columna).toString().startsWith("Hace")) {
            this.setBackground(Color.PINK);
        } 
        return this;
    }
}
