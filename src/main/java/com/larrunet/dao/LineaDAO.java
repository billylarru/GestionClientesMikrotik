/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.dao;

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
        String jpql = "From Linea";
        
        list = (List<Linea>) manager.createQuery(jpql).getResultList();
        
        manager.close();
        return list;
    }
}
