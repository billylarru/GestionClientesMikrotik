/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kael
 */
public class EMF {
    private static EMF instance;
    private EntityManagerFactory emf;
    
    
    private EMF(){
        emf = Persistence.createEntityManagerFactory("persistencia");
    }
    
    public static EMF getInstance(){
        if (instance == null) instance = new EMF();
        return instance;
    }
    
    public EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
}
