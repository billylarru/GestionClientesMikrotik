/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.util;

/**
 *
 * @author kael
 */
public class LineaIdGenerator extends CustomIdGenerator{

    public LineaIdGenerator() {
        query = "select count(CodLinea) as Id from LINEA";
        prefix = "L";
        s = "00";
    }
    
}
