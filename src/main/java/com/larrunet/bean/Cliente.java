/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
/**
 *
 * @author kael
 */

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable{
    
    @Id
    @GenericGenerator(name = "sequence_cliente_id", strategy = "com.larrunet.util.generators.ClienteIdGenerator")
    @GeneratedValue(generator = "sequence_cliente_id")
    @Column(name = "CodCliente")
    private String codCliente;
    
    @Column(name = "NombresCliente")
    private String nombresCliente;
    
    @Column(name = "ApePaternoCliente")
    private String apePaternoCliente;
    
    @Column(name = "ApeMaternoCliente")
    private String apeMaternoCliente;
    
    @Column(name = "DireccionCliente")
    private String direccionCliente;
    
    @Column(name = "AliasCliente")
    private String aliasCliente;
    
    @Column(name = "FechaRegistroCliente")
    private LocalDateTime fechaRegistroCliente;
    
    @Column(name = "EstadoCliente")
    private String estadoCliente;
    
    @OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Servicio servicio;
    
    @OneToMany(mappedBy = "cliente")
    private List<Pago> pagos = new ArrayList<>();
    
    public Cliente() {
    }

    public Cliente(String codCliente, String nombresCliente, String apePaternoCliente, String apeMaternoCliente, String direccionCliente, String aliasCliente, LocalDateTime fechaRegistroCliente, String estadoCliente) {
        this.codCliente = codCliente;
        this.nombresCliente = nombresCliente;
        this.apePaternoCliente = apePaternoCliente;
        this.apeMaternoCliente = apeMaternoCliente;
        this.direccionCliente = direccionCliente;
        this.aliasCliente = aliasCliente;
        this.fechaRegistroCliente = fechaRegistroCliente;
        this.estadoCliente = estadoCliente;
    }

    public Cliente(String codCliente, String nombresCliente, String apePaternoCliente, String apeMaternoCliente, String direccionCliente, String aliasCliente, LocalDateTime fechaRegistroCliente, String estadoCliente, Servicio servicio) {
        this.codCliente = codCliente;
        this.nombresCliente = nombresCliente;
        this.apePaternoCliente = apePaternoCliente;
        this.apeMaternoCliente = apeMaternoCliente;
        this.direccionCliente = direccionCliente;
        this.aliasCliente = aliasCliente;
        this.fechaRegistroCliente = fechaRegistroCliente;
        this.estadoCliente = estadoCliente;
        this.servicio = servicio;
    }
    
    

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    public String getApePaternoCliente() {
        return apePaternoCliente;
    }

    public void setApePaternoCliente(String apePaternoCliente) {
        this.apePaternoCliente = apePaternoCliente;
    }

    public String getApeMaternoCliente() {
        return apeMaternoCliente;
    }

    public void setApeMaternoCliente(String apeMaternoCliente) {
        this.apeMaternoCliente = apeMaternoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getAliasCliente() {
        return aliasCliente;
    }

    public void setAliasCliente(String aliasCliente) {
        this.aliasCliente = aliasCliente;
    }
    

    public LocalDateTime getFechaRegistroCliente() {
        return fechaRegistroCliente;
    }

    public void setFechaRegistroCliente(LocalDateTime fechaRegistroCliente) {
        this.fechaRegistroCliente = fechaRegistroCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente 
                + ", nombresCliente=" + nombresCliente 
                + ", apePaternoCliente=" + apePaternoCliente 
                + ", apeMaternoCliente=" + apeMaternoCliente 
                + ", direccionCliente=" + direccionCliente 
                + ", aliasCliente=" + aliasCliente
                + ", fechaRegistroCliente=" 
                + fechaRegistroCliente 
                + ", estadoCliente=" 
                + estadoCliente
                +'}';
    }

    

     
}
