/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.dao;

import com.larrunet.bean.Antena;
import com.larrunet.bean.Personal;
import com.larrunet.util.EMF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author kael
 */
public class PersonalDAO {
    
    public List<Personal> listar(){
        List<Personal> list;
        EntityManager manager = EMF.getInstance().createEntityManager();
        String jpql = "From Personal p where p.estadoPersonal!='ELIMINADO'";
        
        list = (List<Personal>) manager.createQuery(jpql).getResultList();
        
        list.forEach(p->p.getUsuario().getTipoUsuario().getIdTipoUsuario());
        
        manager.close();
        return list;
    }
    
    
    public boolean registrarPersonal(Personal personal){
        boolean registrado = false;
        EntityManager manager = EMF.getInstance().createEntityManager();
        manager.getTransaction().begin();
        
        manager.persist(personal);
        
        manager.getTransaction().commit();
        
        registrado = personal.getCodPersonal()==null?false:true;
        manager.close();
        return registrado;
    }
}
