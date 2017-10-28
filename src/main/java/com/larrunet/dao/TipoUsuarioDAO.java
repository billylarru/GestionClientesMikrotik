/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.dao;

import com.larrunet.bean.Antena;
import com.larrunet.bean.TipoUsuario;
import com.larrunet.util.EMF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author kael
 */
public class TipoUsuarioDAO {
    
    
    public List<TipoUsuario> listar(){
        List<TipoUsuario> list;
        EntityManager manager = EMF.getInstance().createEntityManager();
        String jpql = "From TipoUsuario tu where tu.estadoTipoUsuario!='ELIMINADO'";
        
        list = (List<TipoUsuario>) manager.createQuery(jpql).getResultList();
        
        manager.close();
        return list;
    }
}
