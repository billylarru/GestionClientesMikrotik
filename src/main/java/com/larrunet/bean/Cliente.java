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
    
    @Column(name = "DireccionCliente")
    private String direccionCliente;
    
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

    public Cliente(String codCliente, String nombresCliente, String direccionCliente, LocalDateTime fechaRegistroCliente, String estadoCliente) {
        this.codCliente = codCliente;
        this.nombresCliente = nombresCliente;
        this.direccionCliente = direccionCliente;
        this.fechaRegistroCliente = fechaRegistroCliente;
        this.estadoCliente = estadoCliente;
    }

    public Cliente(String codCliente, String nombresCliente, String direccionCliente, LocalDateTime fechaRegistroCliente, String estadoCliente, Servicio servicio) {
        this.codCliente = codCliente;
        this.nombresCliente = nombresCliente;
        this.direccionCliente = direccionCliente;
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

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
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
                + ", direccionCliente=" + direccionCliente 
                + ", fechaRegistroCliente=" 
                + fechaRegistroCliente 
                + ", estadoCliente=" 
                + estadoCliente
                +'}';
    }

    
    public String getNombresCompletos(){
        return nombresCliente;
    }
     
}
