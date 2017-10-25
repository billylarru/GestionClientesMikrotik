/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.dao;

import com.larrunet.bean.Personal;
import com.larrunet.bean.Usuario;
import com.larrunet.util.EMF;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author kael
 */
public class UsuarioDAO {
    
    
    public Personal login(String username, String password){
        Personal personal = null;
        EntityManager manager = EMF.getInstance().createEntityManager();
        String jpql = "FROM Usuario u where u.usernameUsuario=?1 and u.passwordUsuario=?2 and u.estadoUsuario='HABILITADO'";
        Query query = manager.createQuery(jpql);
        query.setParameter(1, username);
        query.setParameter(2, password);
        
        try {
            Usuario usuario = (Usuario) query.getSingleResult();
            personal = usuario.getPersonal();
        } 
        catch(NoResultException e){
            personal = null;
            e.printStackTrace();
        }
        catch (Exception e) {
            personal = null;
            e.printStackTrace();
        }
        
        manager.close();
        return personal;
    }
}
