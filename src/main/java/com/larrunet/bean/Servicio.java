/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.bean;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.Period;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
/**
 *
 * @author kael
 */

@Entity
@Table(name = "SERVICIO")
public class Servicio implements Serializable{
    @Id
    @GenericGenerator(name = "sequence_servicio_id", strategy = "com.larrunet.util.generators.ServicioIdGenerator")
    @GeneratedValue(generator = "sequence_servicio_id")
    @Column(name = "CodServicio")
    private String codServicio;
    
    @Column(name = "PagoMensual")
    private double pagoMensual;
    
    @Column(name = "Observacion")
    private String observacion;
    
    @Column(name = "FechaInicio")
    private LocalDate fechaInicio;
    
    @Column(name = "FechaVenc")
    private LocalDate fechaVenc;
    
    @Column(name = "FechaCorte")
    private LocalDateTime fechaCorte;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "CodCliente")
    private Cliente cliente;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "CodAntena")
    private Antena antena;
    
    @Column(name = "EstadoServicio")
    private String estadoServicio;

    @OneToMany(mappedBy = "servicio", cascade = {CascadeType.ALL})
    private List<Hotspot> hotspots = new ArrayList<>();
    
    public Servicio() {
    }

    public Servicio(String codServicio, double pagoMensual, String observacion, LocalDateTime fechaCorte, Cliente cliente, Antena antena, String estadoServicio) {
        this.codServicio = codServicio;
        this.pagoMensual = pagoMensual;
        this.observacion = observacion;
        this.fechaCorte = fechaCorte;
        this.cliente = cliente;
        this.antena = antena;
        this.estadoServicio = estadoServicio;
    }

    public Servicio(String codServicio, double pagoMensual, String observacion, LocalDateTime fechaCorte, Cliente cliente, String estadoServicio) {
        this.codServicio = codServicio;
        this.pagoMensual = pagoMensual;
        this.observacion = observacion;
        this.fechaCorte = fechaCorte;
        this.cliente = cliente;
        this.estadoServicio = estadoServicio;
    }

    public Servicio(String codServicio, double pagoMensual, String observacion, LocalDateTime fechaCorte, String estadoServicio) {
        this.codServicio = codServicio;
        this.pagoMensual = pagoMensual;
        this.observacion = observacion;
        this.fechaCorte = fechaCorte;
        this.estadoServicio = estadoServicio;
    }
    
    
    
    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LocalDateTime getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(LocalDateTime fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        cliente.setServicio(this);
    }

    public Antena getAntena() {
        return antena;
    }

    public void setAntena(Antena antena) {
        this.antena = antena;
    }

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
    }
    
    public List<Hotspot> getHotspots() {
        return hotspots;
    }

    public void setHotspots(List<Hotspot> hotspots) {
        this.hotspots = hotspots;
        for(Hotspot hotspot : hotspots){
            hotspot.setServicio(this);
        }
    }
    
     public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(LocalDate fechaVenc) {
        this.fechaVenc = fechaVenc;
    }
    
    public void addHotspot(Hotspot hotspot){
        if(!hotspots.contains(hotspot)){
            hotspots.add(hotspot);
            hotspot.setServicio(this);
        }
    }

    public String getVenceEn() {
        String vence = "";
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaActual, fechaVenc);
        int dias = periodo.getDays();
        int meses = periodo.getMonths();
        int anios = periodo.getYears();

        if (dias < 0 && meses == 0 && anios == 0) {
            if (dias == -1) {
                vence = "Hace 1 día";
            } else {
                vence = "Hace " + Integer.toString(Math.abs(dias)) + " días";
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
        
        if(fechaInicio==null || fechaVenc==null) return vencido;
        
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaActual, fechaVenc);
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
        return "Servicio{" + "codServicio=" + codServicio + ", pagoMensual=" + pagoMensual + ", observacion=" + observacion + ", fechaCorte=" + fechaCorte + ", estadoServicio=" + estadoServicio + '}';
    }

   

     
}
