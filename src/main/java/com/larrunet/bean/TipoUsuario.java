/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kael
 */
@Entity
@Table(name = "TIPO_USUARIO")
public class TipoUsuario implements Serializable {
    
    @Id
    @Column(name = "IdTipoUsuario")
    private Integer idTipoUsuario;
    
    @Column(name = "DescripTipoUsuario")
    private String descripTipoUsuario;
    
    @Column(name = "EstadoTipoUsuario")
    private String estadoTipoUsuario;
    
    @OneToMany(mappedBy = "tipoUsuario")
    private List<Usuario> usuarios = new ArrayList<>();

    public TipoUsuario() {
    }

    public TipoUsuario(Integer idTipoUsuario, String descripTipoUsuario, String estadoTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.descripTipoUsuario = descripTipoUsuario;
        this.estadoTipoUsuario = estadoTipoUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDescripTipoUsuario() {
        return descripTipoUsuario;
    }

    public void setDescripTipoUsuario(String descripTipoUsuario) {
        this.descripTipoUsuario = descripTipoUsuario;
    }

    public String getEstadoTipoUsuario() {
        return estadoTipoUsuario;
    }

    public void setEstadoTipoUsuario(String estadoTipoUsuario) {
        this.estadoTipoUsuario = estadoTipoUsuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "idTipoUsuario=" + idTipoUsuario + ", descripTipoUsuario=" + descripTipoUsuario + ", estadoTipoUsuario=" + estadoTipoUsuario + '}';
    }
    
    
    
}
