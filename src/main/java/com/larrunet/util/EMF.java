/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    /*
    *Fuente: https://stackoverflow.com/questions/19170876/persistence-xml-to-import-database-parameters-values-from-properties-file
    */
    private EMF(){
        Properties props = new Properties();
        try {
            InputStream is = getClass().getResourceAsStream("/META-INF/db.properties");
            props.load(is);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EMF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EMF.class.getName()).log(Level.SEVERE, null, ex);
        }
        emf = Persistence.createEntityManagerFactory("persistencia", props);
    }
    
    public static EMF getInstance(){
        if (instance == null) instance = new EMF();
        return instance;
    }
    
    public EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
}
