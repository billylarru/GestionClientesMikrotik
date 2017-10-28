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
public class PersonalIdGenerator extends CustomIdGenerator{

    public PersonalIdGenerator() {
        query = "select count(CodPersonal) as Id from PERSONAL";
        prefix = "P";
        s = "000";
    }
    
    
}
