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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Period;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author kael
 */
@Entity
@Table(name = "PAGO")
public class Pago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPago")
    private Integer idPago;

    @Column(name = "FechaEmision")
    private LocalDateTime fechaEmision;

    @Column(name = "FechaInicio")
    private LocalDate fechaInicio;

    @Column(name = "FechaVenc")
    private LocalDate fechaVencimiento;

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

    @OneToMany(mappedBy = "pago", cascade = {CascadeType.ALL})
    private List<PagoParcial> pagosParcial = new ArrayList<>();

    public Pago() {
    }

    public Pago(Integer idPago, LocalDateTime fechaEmision, LocalDate fechaInicio, LocalDate fechaVencimiento, Double montoPago, String estadoPago) {
        this.idPago = idPago;
        this.fechaEmision = fechaEmision;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.montoPago = montoPago;
        this.estadoPago = estadoPago;
    }

    public Pago(Integer idPago, LocalDateTime fechaEmision, LocalDate fechaInicio, LocalDate fechaVencimiento, Double montoPago, Personal personal, Cliente cliente, String estadoPago) {
        this.idPago = idPago;
        this.fechaEmision = fechaEmision;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.montoPago = montoPago;
        this.personal = personal;
        this.cliente = cliente;
        this.estadoPago = estadoPago;
    }

    public Pago(Integer idPago, LocalDateTime fechaEmision, LocalDate fechaInicio, LocalDate fechaVencimiento, Double montoPago, Personal personal, Cliente cliente, String estadoPago, List<PagoParcial> pagosParcial) {
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

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
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
        pagosParcial.forEach(pp -> pp.setPago(this));
    }

    public void addPagoParcial(PagoParcial pagoParcial) {

        if (!pagosParcial.contains(pagoParcial)) {
            pagosParcial.add(pagoParcial);
            pagoParcial.setPago(this);
        }
    }

    public String getVenceEn() {
        String vence = "";
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaActual, fechaVencimiento);
        int dias = periodo.getDays();
        int meses = periodo.getMonths();
        int anios = periodo.getYears();

        if (dias < 0 && meses == 0 && anios == 0) {
            if (dias == -1) {
                vence = "Hace 1 día";
            } else {
                vence = "Hace " + Integer.toString(dias) + " días";
            }
        } else if (dias == 0 && meses == 0 && anios == 0) {
            vence = "Hoy";
        } else if (dias > 0 && meses == 0 && anios == 0) {
            if (dias == 1) {
                vence = "En 1 día";
            } else {
                vence = "En " + Integer.toString(dias) + " días";
            }
        } else if (dias >= 0 && meses > 0 && anios == 0) {
            vence = "En ";

            if (meses == 1) {
                vence += "1 mes";
            } else if (meses > 1) {
                vence += Integer.toString(meses) + " meses";
            }

            if (dias == 1) {
                vence += Integer.toString(dias) + " día";
            } else if (dias > 1) {
                vence += Integer.toString(dias) + " días";
            }
        } else {
            vence += Integer.toString(anios) + " años " + Integer.toString(meses) + " meses " + Integer.toString(dias) + " días";
        }

        return vence;
    }

    public boolean estaPorVencer(){
        boolean vencido = false;
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaActual, fechaVencimiento);
        int dias = periodo.getDays();
        int meses = periodo.getMonths();
        int anios = periodo.getYears();
        
        if(anios==0 && meses==0 && dias<=1){
            vencido = true;
        }
        return vencido;
    }
    
    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", fechaEmision=" + fechaEmision + ", fechaInicio=" + fechaInicio + ", fechaVencimiento=" + fechaVencimiento + ", montoPago=" + montoPago + ", estadoPago=" + estadoPago + '}';
    }

}
