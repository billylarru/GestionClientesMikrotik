/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author kael
 */

@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @GenericGenerator(name = "sequence_usuario_id", strategy = "com.larrunet.util.generators.UsuarioIdGenerator")
    @GeneratedValue(generator = "sequence_usuario_id")
    @Column(name = "CodUsuario")
    private String codUsuario;
    
    @Column(name = "UsernameUsuario")
    private String usernameUsuario;
    
    @Column(name = "PasswordUsuario")
    private String passwordUsuario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTipoUsuario")
    private TipoUsuario tipoUsuario;
    
    @Column(name = "EstadoUsuario")
    private String estadoUsuario;
    
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Personal personal;
    
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private UsuarioMikrotik usuarioMikrotik;

    public Usuario() {
    }

    public Usuario(String codUsuario, String usernameUsuario, String passwordUsuario, String estadoUsuario) {
        this.codUsuario = codUsuario;
        this.usernameUsuario = usernameUsuario;
        this.passwordUsuario = passwordUsuario;
        this.estadoUsuario = estadoUsuario;
    }

    public Usuario(String codUsuario, String usernameUsuario, String passwordUsuario, TipoUsuario tipoUsuario, String estadoUsuario, Personal personal, UsuarioMikrotik usuarioMikrotik) {
        this.codUsuario = codUsuario;
        this.usernameUsuario = usernameUsuario;
        this.passwordUsuario = passwordUsuario;
        this.tipoUsuario = tipoUsuario;
        this.estadoUsuario = estadoUsuario;
        this.personal = personal;
        this.usuarioMikrotik = usuarioMikrotik;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getUsernameUsuario() {
        return usernameUsuario;
    }

    public void setUsernameUsuario(String usernameUsuario) {
        this.usernameUsuario = usernameUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public UsuarioMikrotik getUsuarioMikrotik() {
        return usuarioMikrotik;
    }

    public void setUsuarioMikrotik(UsuarioMikrotik usuarioMikrotik) {
        this.usuarioMikrotik = usuarioMikrotik;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codUsuario=" + codUsuario + ", usernameUsuario=" + usernameUsuario + ", passwordUsuario=" + passwordUsuario + ", estadoUsuario=" + estadoUsuario + '}';
    }
    
    
}
