/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.util;

import com.larrunet.bean.Personal;

/**
 *
 * @author larru
 */
public class Singleton {
    private static Singleton instance;
    private Personal personal;
    
    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    
    
    public void logout(){
        personal = null;
    }
    
}
