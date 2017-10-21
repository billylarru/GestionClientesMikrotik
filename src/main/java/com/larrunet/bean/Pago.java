/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kael
 */
@Entity
@Table(name = "PAGO")
public class Pago implements Serializable {
    @Id
    @Column(name = "IdPago")
    private Integer idPago;
    
    @Column(name = "FechaEmision")
    private Date fechaEmision;
    
    @Column(name = "FechaInicio")
    private Date fechaInicio;
    
    @Column(name = "FechaVencimiento")
    private Date fechaVencimiento;
    
    @Column(name = "MontoPago")
    private Double montoPago;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodPersonal")
    private Personal personal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodCliente")
    private Cliente cliente;
    
    @Column(name = "EstadoPago")
    private String estadoPago;
    
    @OneToMany(mappedBy = "pago")
    private List<PagoParcial> pagosParcial;
    
    public Pago() {
    }

    public Pago(Integer idPago, Date fechaEmision, Date fechaInicio, Date fechaVencimiento, Double montoPago, String estadoPago) {
        this.idPago = idPago;
        this.fechaEmision = fechaEmision;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.montoPago = montoPago;
        this.estadoPago = estadoPago;
    }

    public Pago(Integer idPago, Date fechaEmision, Date fechaInicio, Date fechaVencimiento, Double montoPago, Personal personal, Cliente cliente, String estadoPago) {
        this.idPago = idPago;
        this.fechaEmision = fechaEmision;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.montoPago = montoPago;
        this.personal = personal;
        this.cliente = cliente;
        this.estadoPago = estadoPago;
    }

    public Pago(Integer idPago, Date fechaEmision, Date fechaInicio, Date fechaVencimiento, Double montoPago, Personal personal, Cliente cliente, String estadoPago, List<PagoParcial> pagosParcial) {
        this.idPago = idPago;
        this.fechaEmision = fechaEmision;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.montoPago = montoPago;
        this.personal = personal;
        this.cliente = cliente;
        this.estadoPago = estadoPago;
        this.pagosParcial = pagosParcial;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(Double montoPago) {
        this.montoPago = montoPago;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public List<PagoParcial> getPagosParcial() {
        return pagosParcial;
    }

    public void setPagosParcial(List<PagoParcial> pagosParcial) {
        this.pagosParcial = pagosParcial;
    }

    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", fechaEmision=" + fechaEmision + ", fechaInicio=" + fechaInicio + ", fechaVencimiento=" + fechaVencimiento + ", montoPago=" + montoPago + ", estadoPago=" + estadoPago + '}';
    }

    
    
    
}
