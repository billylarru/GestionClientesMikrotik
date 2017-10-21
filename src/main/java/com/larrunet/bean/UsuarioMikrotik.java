/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.bean;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author kael
 */
@Entity
@Table(name = "USUARIO_MIKROTIK")
public class UsuarioMikrotik implements Serializable {
    
    @Id
    @Column(name = "CodUsuarioMikrotik")
    private String codUsuarioMikrotik;
    
    @Column(name = "UsernameMikrotik")
    private String usernameMikrotik;
    
    @Column(name = "PasswordMikrotik")
    private String passwordMikrotik;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CodUsuario")
    private Usuario usuario;
    
    @Column(name = "EstadoUsuarioMikrotik")
    private String estadoUsuarioMikrotik;

    public UsuarioMikrotik() {
    }

    public UsuarioMikrotik(String codUsuarioMikrotik, String usernameMikrotik, String passwordMikrotik, String estadoUsuarioMikrotik) {
        this.codUsuarioMikrotik = codUsuarioMikrotik;
        this.usernameMikrotik = usernameMikrotik;
        this.passwordMikrotik = passwordMikrotik;
        this.estadoUsuarioMikrotik = estadoUsuarioMikrotik;
    }

    public UsuarioMikrotik(String codUsuarioMikrotik, String usernameMikrotik, String passwordMikrotik, Usuario usuario, String estadoUsuarioMikrotik) {
        this.codUsuarioMikrotik = codUsuarioMikrotik;
        this.usernameMikrotik = usernameMikrotik;
        this.passwordMikrotik = passwordMikrotik;
        this.usuario = usuario;
        this.estadoUsuarioMikrotik = estadoUsuarioMikrotik;
    }

    public String getCodUsuarioMikrotik() {
        return codUsuarioMikrotik;
    }

    public void setCodUsuarioMikrotik(String codUsuarioMikrotik) {
        this.codUsuarioMikrotik = codUsuarioMikrotik;
    }

    public String getUsernameMikrotik() {
        return usernameMikrotik;
    }

    public void setUsernameMikrotik(String usernameMikrotik) {
        this.usernameMikrotik = usernameMikrotik;
    }

    public String getPasswordMikrotik() {
        return passwordMikrotik;
    }

    public void setPasswordMikrotik(String passwordMikrotik) {
        this.passwordMikrotik = passwordMikrotik;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEstadoUsuarioMikrotik() {
        return estadoUsuarioMikrotik;
    }

    public void setEstadoUsuarioMikrotik(String estadoUsuarioMikrotik) {
        this.estadoUsuarioMikrotik = estadoUsuarioMikrotik;
    }

    @Override
    public String toString() {
        return "UsuarioMikrotik{" + "codUsuarioMikrotik=" + codUsuarioMikrotik + ", usernameMikrotik=" + usernameMikrotik + ", passwordMikrotik=" + passwordMikrotik + ", estadoUsuarioMikrotik=" + estadoUsuarioMikrotik + '}';
    }
    
    
}
