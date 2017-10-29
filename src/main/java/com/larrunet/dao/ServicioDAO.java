/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.dao;

import com.larrunet.bean.Hotspot;
import com.larrunet.bean.Pago;
import com.larrunet.bean.Servicio;
import com.larrunet.util.EMF;
import java.util.ArrayList;
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
    
    public Servicio buscarServicioPorCod(String codServicio){
        Servicio servicio = null;
        EntityManager manager = EMF.getInstance().createEntityManager();

        servicio = manager.find(Servicio.class, codServicio);
        
        servicio.getAntena().getCodAntena();
        servicio.getHotspots().forEach(h->h.getLinea().getCodLinea());

        manager.close();
        return servicio;
    }
    
    public List<Hotspot> getHotspotsByCodServicio(String codServicio){
        List<Hotspot>  list = new ArrayList<>();
        EntityManager manager = EMF.getInstance().createEntityManager();

        Servicio servicio = manager.find(Servicio.class, codServicio);
        
        list = servicio.getHotspots();
        list.forEach(h->h.getLinea().getCodLinea());

        manager.close();
        return list;
    }
    
    public List<Servicio> buscarPorNombre(String texto){
        List<Servicio> list;
        EntityManager manager = EMF.getInstance().createEntityManager();
        
        String exp_nombresCompletos = "CONCAT(c.nombresCliente, ' ', c.apePaternoCliente, ' ', c.apeMaternoCliente)";
        String subquery = "Select c.codCliente from Cliente c where "+exp_nombresCompletos+" like '%"+texto+"%'";
        String jpql = "From Servicio s where s.estadoServicio!='ELIMINADO' and (s.cliente.codCliente in ("+subquery+") or s.cliente.aliasCliente like'%"+texto+"%')";
        
        list = (List<Servicio>) manager.createQuery(jpql).getResultList();
        
        for(Servicio servicio : list){
            servicio.getAntena().getCodAntena();
            servicio.getHotspots().forEach(h->h.getLinea().getCodLinea());
        }

        manager.close();
        return list;
    }
    
    /**
     * lista todos los servicios habilitados sin importar el tiempo de vencimiento
     * @return 
     */
    public List<Servicio> listarTodosLosServiciosPorEstado(String estado){
        List<Servicio> list;
        EntityManager manager = EMF.getInstance().createEntityManager();
        String jpql = "select s From Servicio s "+
                "JOIN s.cliente c "+
                "JOIN c.pagos p "+
                "where "+
                "p.idPago=(select max(sp.idPago) from Pago sp where sp.cliente.codCliente=c.codCliente) "+
                "and "+
                "s.estadoServicio='"+estado+"'";
        
        list = (List<Servicio>) manager.createQuery(jpql).getResultList();
        
        for(Servicio servicio : list){
            System.out.println(servicio.getCliente().getPagos());
            servicio.getCliente().getPagos().forEach(p->p.getIdPago());
        }
        manager.close();
        return list;
    }
    
    public List<Servicio> listarTodosLosServicios(){
        List<Servicio> list;
        list = listarTodosLosServiciosPorEstado("HABILITADO");
        return list;
    }
    
    
    
    public List<Servicio> listarServiciosPorVencer(){
        List<Servicio> list = new ArrayList<>();
        List<Servicio> temp;
        
        temp = listarTodosLosServicios();
              
        for(Servicio s : temp){
            List<Pago> pagos = s.getCliente().getPagos();
            Pago pago = pagos.get(pagos.size()-1);
            
            if(pago.estaPorVencer()){
                list.add(s);
            }
            
        }
           
        return list;
    }
    
    public List<Servicio> listarCortados(){
        List<Servicio> list = new ArrayList<>();
        
        list = listarTodosLosServiciosPorEstado("CORTADO");
                       
        return list;
    }
}
