/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.main;

import com.larrunet.bean.Linea;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kael
 */
public class Main {
    private static EntityManager manager;
    private static EntityManagerFactory emf;
    
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("persistencia");
        manager = emf.createEntityManager();
        
        
        Linea linea = new Linea("L1", "linea1", "ACTIVO");
        
        manager.getTransaction().begin();
        
        manager.persist(linea);
        
        manager.getTransaction().commit();
    }
}
