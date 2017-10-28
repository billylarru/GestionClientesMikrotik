/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author kael
 */
@Entity
@Table(name = "PERSONAL")
public class Personal implements Serializable {
    @Id
    @Column(name = "CodPersonal")
    private String codPersonal;
    
    @Column(name = "NombresPersonal")
    private String nombrePersonal;
    
    @Column(name = "ApePaternoPersonal")
    private String apePaternoPersonal;
    
    @Column(name = "ApeMaternoPersonal")
    private String apeMaternoPersonal;
    
    @Column(name = "FechaRegistroPersonal")
    private LocalDateTime fechaRegistroPersonal;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "CodUsuario")
    private Usuario usuario;
    
    @Column(name = "EstadoPersonal")
    private String estadoPersonal;
    
    @OneToMany(mappedBy = "personal")
    private List<Pago> pagos = new ArrayList<>();
    
    @OneToMany(mappedBy = "personal")
    private List<PagoParcial> pagosParcial = new ArrayList<>();

    public Personal() {
    }

    public Personal(String codPersonal, String nombrePersonal, String apePaternoPersonal, String apeMaternoPersonal, LocalDateTime fechaRegistroPersonal, String estadoPersonal) {
        this.codPersonal = codPersonal;
        this.nombrePersonal = nombrePersonal;
        this.apePaternoPersonal = apePaternoPersonal;
        this.apeMaternoPersonal = apeMaternoPersonal;
        this.fechaRegistroPersonal = fechaRegistroPersonal;
        this.estadoPersonal = estadoPersonal;
    }

    public Personal(String codPersonal, String nombrePersonal, String apePaternoPersonal, String apeMaternoPersonal, LocalDateTime fechaRegistroPersonal, Usuario usuario, String estadoPersonal) {
        this.codPersonal = codPersonal;
        this.nombrePersonal = nombrePersonal;
        this.apePaternoPersonal = apePaternoPersonal;
        this.apeMaternoPersonal = apeMaternoPersonal;
        this.fechaRegistroPersonal = fechaRegistroPersonal;
        this.usuario = usuario;
        this.estadoPersonal = estadoPersonal;
    }

    public String getEstadoPersonal() {
        return estadoPersonal;
    }

    public void setEstadoPersonal(String estadoPersonal) {
        this.estadoPersonal = estadoPersonal;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public String getApePaternoPersonal() {
        return apePaternoPersonal;
    }

    public void setApePaternoPersonal(String apePaternoPersonal) {
        this.apePaternoPersonal = apePaternoPersonal;
    }

    public String getApeMaternoPersonal() {
        return apeMaternoPersonal;
    }

    public void setApeMaternoPersonal(String apeMaternoPersonal) {
        this.apeMaternoPersonal = apeMaternoPersonal;
    }

    public LocalDateTime getFechaRegistroPersonal() {
        return fechaRegistroPersonal;
    }

    public void setFechaRegistroPersonal(LocalDateTime fechaRegistroPersonal) {
        this.fechaRegistroPersonal = fechaRegistroPersonal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        usuario.setPersonal(this);
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public List<PagoParcial> getPagosParcial() {
        return pagosParcial;
    }

    public void setPagosParcial(List<PagoParcial> pagosParcial) {
        this.pagosParcial = pagosParcial;
    }

    public String getCodPersonal() {
        return codPersonal;
    }

    public void setCodPersonal(String codPersonal) {
        this.codPersonal = codPersonal;
    }

    @Override
    public String toString() {
        return "Personal{" + "codPersonal=" + codPersonal + ", nombrePersonal=" + nombrePersonal + ", apePaternoPersonal=" + apePaternoPersonal + ", apeMaternoPersonal=" + apeMaternoPersonal + ", fechaRegistroPersonal=" + fechaRegistroPersonal + ", estadoPersonal=" + estadoPersonal + '}';
    }
    
    
    
}
