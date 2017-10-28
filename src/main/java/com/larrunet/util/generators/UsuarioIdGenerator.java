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
public class UsuarioIdGenerator extends CustomIdGenerator{

    public UsuarioIdGenerator() {
        query = "select count(CodUsuario) as Id from USUARIO";
        prefix = "U";
        s = "000";
    }
    
}
