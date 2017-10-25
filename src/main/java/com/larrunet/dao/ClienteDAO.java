/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.dao;

import com.larrunet.bean.Cliente;
import com.larrunet.bean.Linea;
import com.larrunet.util.EMF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author kael
 */
public class ClienteDAO {
    
    public List<Cliente> listar(){
        List<Cliente> list;
        EntityManager manager = EMF.getInstance().createEntityManager();
        String jpql = "From Cliente";
        
        list = (List<Cliente>) manager.createQuery(jpql).getResultList();
        
        manager.close();
        return list;
    }
}
