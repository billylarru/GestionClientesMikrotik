/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.dao;

import com.larrunet.bean.Antena;
import com.larrunet.util.EMF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author kael
 */
public class AntenaDAO {
    
    
    public List<Antena> listarAntenas(){
        List<Antena> list;
        EntityManager manager = EMF.getInstance().createEntityManager();
        String jpql = "From Antena a where a.estadoAntena!='ELIMINADO'";
        
        list = (List<Antena>) manager.createQuery(jpql).getResultList();
        
        manager.close();
        return list;
    }
    
    public boolean registrarAntena(Antena antena){
        boolean registrado = false;
        EntityManager manager = EMF.getInstance().createEntityManager();
        manager.getTransaction().begin();
        
        manager.persist(antena);
        
        manager.getTransaction().commit();
        
        registrado = antena.getCodAntena()==null?false:true;
        manager.close();
        return registrado;
    }
    
    public void modificarAntena(Antena antena){
        EntityManager manager = EMF.getInstance().createEntityManager();
        manager.getTransaction().begin();
        
        manager.merge(antena);
        
        manager.getTransaction().commit();
        manager.close();
    }
    
    public boolean eliminarAntena(Antena antena){
        boolean eliminado = false;
        antena.setEstadoAntena("ELIMINADO");
        modificarAntena(antena);
        eliminado = antena.getEstadoAntena().equals("ELIMINADO")?true:false;
        return eliminado;
    }
}
