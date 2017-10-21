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

/**
 *
 * @author kael
 */
@Entity
@Table(name = "HOTSPOT")
public class Hotspot implements Serializable {
    
    @Id
    @Column(name = "IdHotspot")
    private Integer idHotspot;
    
    @Column(name = "IP")
    private String IP;
    
    @Column(name = "IdHotspot")
    private String idMikrotik;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "CodServicio")
    private Servicio servicio;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodLinea")
    private Linea linea;
    
    @Column(name = "EstadoHostpot")
    private String estadoHostpot;

    public Hotspot() {
    }

    public Hotspot(Integer idHotspot, String IP, String idMikrotik, String estadoHostpot) {
        this.idHotspot = idHotspot;
        this.IP = IP;
        this.idMikrotik = idMikrotik;
        this.estadoHostpot = estadoHostpot;
    }

    public Hotspot(Integer idHotspot, String IP, String idMikrotik, Linea linea, String estadoHostpot) {
        this.idHotspot = idHotspot;
        this.IP = IP;
        this.idMikrotik = idMikrotik;
        this.linea = linea;
        this.estadoHostpot = estadoHostpot;
    }

    public Hotspot(Integer idHotspot, String IP, String idMikrotik, Servicio servicio, Linea linea, String estadoHostpot) {
        this.idHotspot = idHotspot;
        this.IP = IP;
        this.idMikrotik = idMikrotik;
        this.servicio = servicio;
        this.linea = linea;
        this.estadoHostpot = estadoHostpot;
    }

    public Integer getIdHotspot() {
        return idHotspot;
    }

    public void setIdHotspot(Integer idHotspot) {
        this.idHotspot = idHotspot;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getIdMikrotik() {
        return idMikrotik;
    }

    public void setIdMikrotik(String idMikrotik) {
        this.idMikrotik = idMikrotik;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public String getEstadoHostpot() {
        return estadoHostpot;
    }

    public void setEstadoHostpot(String estadoHostpot) {
        this.estadoHostpot = estadoHostpot;
    }

    @Override
    public String toString() {
        return "Hotspot{" + "idHotspot=" + idHotspot + ", IP=" + IP + ", idMikrotik=" + idMikrotik + ", estadoHostpot=" + estadoHostpot + '}';
    }
    
    
}
