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
public class AntenaIdGenerator extends CustomIdGenerator{

    public AntenaIdGenerator(){
        query = "select count(CodAntena) as Id from ANTENA_EMISORA";
        prefix = "A";
        s = "000";
    }

}
