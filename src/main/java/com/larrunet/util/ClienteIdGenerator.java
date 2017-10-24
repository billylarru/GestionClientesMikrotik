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
public class ClienteIdGenerator extends CustomIdGenerator{

    public ClienteIdGenerator() {
        query = "select count(CodCliente) as Id from CLIENTE";
        prefix = "C";
        s = "000";
    }
    
}
