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
@Table(name = "ANTENA_EMISORA")
public class Antena implements Serializable{
    @Id
    @GenericGenerator(name = "sequence_antena_id", strategy = "com.larrunet.util.AntenaIdGenerator")
    @GeneratedValue(generator = "sequence_antena_id")
    @Column(name = "CodAntena")
    private String codAntena;
    
    @Column(name = "DescripAntena")
    private String descripAntena;
    
    @Column(name = "EstadoAntena")
    private String estadoAntena;
    
    @OneToMany(mappedBy = "antena")
    private List<Servicio> servicios = new ArrayList<>();

    public Antena() {
    }

    public Antena(String codAntena, String descripAntena, String estadoAntena) {
        this.codAntena = codAntena;
        this.descripAntena = descripAntena;
        this.estadoAntena = estadoAntena;
    }

    public String getCodAntena() {
        return codAntena;
    }

    public void setCodAntena(String codAntena) {
        this.codAntena = codAntena;
    }

    public String getDescripAntena() {
        return descripAntena;
    }

    public void setDescripAntena(String descripAntena) {
        this.descripAntena = descripAntena;
    }

    public String getEstadoAntena() {
        return estadoAntena;
    }

    public void setEstadoAntena(String estadoAntena) {
        this.estadoAntena = estadoAntena;
    }

    @Override
    public String toString() {
        return "Antena{" + "codAntena=" + codAntena + ", descripAntena=" + descripAntena + ", estadoAntena=" + estadoAntena + '}';
    }
    
    
}
