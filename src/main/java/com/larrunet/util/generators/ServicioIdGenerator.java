/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.util.generators;

/**
 *
 * @author kael
 */
public class ServicioIdGenerator extends CustomIdGenerator{

    public ServicioIdGenerator() {
        query = "select count(CodServicio) as Id from SERVICIO";
        prefix = "S";
        s = "0000";
    }
    
    
}
