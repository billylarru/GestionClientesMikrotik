/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.dao;

import com.larrunet.bean.Antena;
import com.larrunet.bean.Linea;
import com.larrunet.util.EMF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author kael
 */
public class LineaDAO {
    
    
    public List<Linea> listar(){
        List<Linea> list;
        EntityManager manager = EMF.getInstance().createEntityManager();
        String jpql = "From Linea l where l.estadoLinea!='ELIMINADO'";
        
        list = (List<Linea>) manager.createQuery(jpql).getResultList();
        
        manager.close();
        return list;
    }
    
    public boolean registrarLinea(Linea linea){
        boolean registrado = false;
        EntityManager manager = EMF.getInstance().createEntityManager();
        manager.getTransaction().begin();
        
        manager.persist(linea);
        
        manager.getTransaction().commit();
        
        registrado = linea.getCodLinea()==null?false:true;
        manager.close();
        return registrado;
    }
    
    public void modificarLinea(Linea linea){
        EntityManager manager = EMF.getInstance().createEntityManager();
        manager.getTransaction().begin();
        
        manager.merge(linea);
        
        manager.getTransaction().commit();
        manager.close();
    }
    
    public boolean eliminarLinea(Linea linea){
        boolean eliminado = false;
        linea.setEstadoLinea("ELIMINADO");
        modificarLinea(linea);
        eliminado = linea.getEstadoLinea().equals("ELIMINADO")?true:false;
        return eliminado;
    }
}
