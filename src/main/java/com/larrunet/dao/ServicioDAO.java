/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.dao;

import com.larrunet.bean.Hotspot;
import com.larrunet.bean.Servicio;
import com.larrunet.util.EMF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author kael
 */
public class ServicioDAO {
    
    public List<Servicio> listar(){
        List<Servicio> list;
        EntityManager manager = EMF.getInstance().createEntityManager();
        String jpql = "From Servicio s where s.estadoServicio!='ELIMINADO'";
        
        list = (List<Servicio>) manager.createQuery(jpql).getResultList();
        
        for(Servicio servicio : list){
            servicio.getAntena().getCodAntena();
            servicio.getHotspots().forEach(h->h.getLinea().getCodLinea());
        }
        manager.close();
        return list;
    }
    
    public boolean registrarServicio(Servicio servicio){
        boolean registrado = false;
        EntityManager manager = EMF.getInstance().createEntityManager();
        manager.getTransaction().begin();
        
        manager.persist(servicio);
        
        manager.getTransaction().commit();
        
        registrado = servicio.getCodServicio()==null?false:true;
        manager.close();
        return registrado;
    }
    
    public void modificarServicio(Servicio servicio){
        EntityManager manager = EMF.getInstance().createEntityManager();
        manager.getTransaction().begin();
        
        manager.merge(servicio);
        
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void eliminarServicio(Servicio servicio){
        EntityManager manager = EMF.getInstance().createEntityManager();
        manager.getTransaction().begin();
        
        servicio.getCliente().setEstadoCliente("ELIMINADO");
        servicio.getHotspots().forEach(hotspot->hotspot.setEstadoHostpot("ELIMINADO"));
        servicio.setEstadoServicio("ELIMINADO");
        
        manager.merge(servicio);
        
        manager.getTransaction().commit();
        manager.close();
    }
}
