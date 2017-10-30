/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.dao;

import com.larrunet.bean.Pago;
import com.larrunet.gui.panel.PnlRegistroPagos;
import com.larrunet.util.EMF;
import java.sql.Connection;
import javax.persistence.EntityManager;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

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
        manager.merge(pago.getCliente().getServicio());
        manager.getTransaction().commit();
        
        registrado = pago.getIdPago()==null?false:true;
        manager.close();
        return registrado;
    }
    
    public boolean registrarPago(Pago pago, PnlRegistroPagos panelPagos){
        boolean registrado = false;
        EntityManager manager = EMF.getInstance().createEntityManager();
        manager.getTransaction().begin();
        
        manager.persist(pago);
        manager.merge(pago.getCliente().getServicio());
        manager.getTransaction().commit();
        
        registrado = pago.getIdPago()==null?false:true;
        
        if(registrado){
            SharedSessionContractImplementor session = (SharedSessionContractImplementor)manager.getDelegate();
            Connection connection = session.connection();
            panelPagos.prepararInforme(pago, connection);
        }
        
        manager.close();
        return registrado;
    }
}
