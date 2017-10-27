/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.dao;

import com.larrunet.bean.Pago;
import com.larrunet.util.EMF;
import javax.persistence.EntityManager;

/**
 *
 * @author kael
 */
public class PagoDAO {
    
    
    public boolean registrarPago(Pago pago){
        boolean registrado = false;
        EntityManager manager = EMF.getInstance().createEntityManager();
        manager.getTransaction().begin();
        
        manager.persist(pago);
        
        manager.getTransaction().commit();
        
        registrado = pago.getIdPago()==null?false:true;
        manager.close();
        return registrado;
    }
}
