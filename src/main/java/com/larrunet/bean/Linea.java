/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author kael
 */
@Entity
@Table(name = "LINEA")
public class Linea implements Serializable{
    @Id
    @GenericGenerator(name = "sequence_linea_id", strategy = "com.larrunet.util.generators.LineaIdGenerator")
    @GeneratedValue(generator = "sequence_linea_id")
    @Column(name = "CodLinea")
    private String codLinea;
    
    @Column(name = "DescripLinea")
    private String descripLinea;
    
    @Column(name = "EstadoLinea")
    private String estadoLinea;

    @OneToMany(mappedBy = "linea")
    private List<Hotspot> hotspots = new ArrayList<>();
    
    public Linea() {
    }

    public Linea(String codLinea, String descripLinea, String estadoLinea) {
        this.codLinea = codLinea;
        this.descripLinea = descripLinea;
        this.estadoLinea = estadoLinea;
    }

    public String getCodLinea() {
        return codLinea;
    }

    public void setCodLinea(String codLinea) {
        this.codLinea = codLinea;
    }

    public String getDescripLinea() {
        return descripLinea;
    }

    public void setDescripLinea(String descripLinea) {
        this.descripLinea = descripLinea;
    }

    public String getEstadoLinea() {
        return estadoLinea;
    }

    public void setEstadoLinea(String estadoLinea) {
        this.estadoLinea = estadoLinea;
    }

    public List<Hotspot> getHotspots() {
        return hotspots;
    }

    public void setHotspots(List<Hotspot> hotspots) {
        this.hotspots = hotspots;
    }
    
    @Override
    public String toString() {
        return "Linea{" + "codLinea=" + codLinea + ", descripLinea=" + descripLinea + ", estadoLinea=" + estadoLinea + '}';
    }

    
    
    
    
    
}
