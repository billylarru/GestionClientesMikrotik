/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
/**
 *
 * @author kael
 */

@Entity
@Table(name = "PAGO_PARCIAL")
public class PagoParcial implements Serializable {
    
    @Id
    @Column(name = "IdPagoParcial")
    private Integer idPagoParcial;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodPago")
    private Pago pago;
    
    @Column(name = "Monto")
    private Double monto;
    
    @Column(name = "FechaPago")
    private LocalDateTime fechaPago;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodPersonal")
    private Personal personal;
    
    @Column(name = "EstadoPagoParcial")
    private String estadoPagoParcial;

    public PagoParcial() {
    }

    public PagoParcial(Integer idPagoParcial, Double monto, LocalDateTime fechaPago, String estadoPagoParcial) {
        this.idPagoParcial = idPagoParcial;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.estadoPagoParcial = estadoPagoParcial;
    }

    public PagoParcial(Integer idPagoParcial, Pago pago, Double monto, LocalDateTime fechaPago, Personal personal, String estadoPagoParcial) {
        this.idPagoParcial = idPagoParcial;
        this.pago = pago;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.personal = personal;
        this.estadoPagoParcial = estadoPagoParcial;
    }

    public Integer getIdPagoParcial() {
        return idPagoParcial;
    }

    public void setIdPagoParcial(Integer idPagoParcial) {
        this.idPagoParcial = idPagoParcial;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public String getEstadoPagoParcial() {
        return estadoPagoParcial;
    }

    public void setEstadoPagoParcial(String estadoPagoParcial) {
        this.estadoPagoParcial = estadoPagoParcial;
    }

    @Override
    public String toString() {
        return "PagoParcial{" + "idPagoParcial=" + idPagoParcial + ", monto=" + monto + ", fechaPago=" + fechaPago + ", estadoPagoParcial=" + estadoPagoParcial + '}';
    }
    
    
}
