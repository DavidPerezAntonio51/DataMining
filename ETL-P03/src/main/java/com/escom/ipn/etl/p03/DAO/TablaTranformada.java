/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p03.DAO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DEZKS
 */
/*Entidad Generada por JPA para realizar un mapeo Entidad-Objeto*/
@Entity
@Table(name = "tabla_tranformada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TablaTranformada.findAll", query = "SELECT t FROM TablaTranformada t"),
    @NamedQuery(name = "TablaTranformada.findById", query = "SELECT t FROM TablaTranformada t WHERE t.id = :id"),
    @NamedQuery(name = "TablaTranformada.findByLineaMetro", query = "SELECT t FROM TablaTranformada t WHERE t.lineaMetro = :lineaMetro"),
    @NamedQuery(name = "TablaTranformada.findByMonto", query = "SELECT t FROM TablaTranformada t WHERE t.monto = :monto"),
    @NamedQuery(name = "TablaTranformada.findByTipoIngreso", query = "SELECT t FROM TablaTranformada t WHERE t.tipoIngreso = :tipoIngreso"),
    @NamedQuery(name = "TablaTranformada.findByFecha", query = "SELECT t FROM TablaTranformada t WHERE t.fecha = :fecha")})
public class TablaTranformada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "linea_metro")
    private String lineaMetro;
    @Column(name = "monto")
    private Integer monto;
    @Column(name = "tipo_ingreso")
    private String tipoIngreso;
    @Column(name = "fecha")
    private String fecha;

    public TablaTranformada() {
    }

    public TablaTranformada(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineaMetro() {
        return lineaMetro;
    }

    public void setLineaMetro(String lineaMetro) {
        this.lineaMetro = lineaMetro;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TablaTranformada)) {
            return false;
        }
        TablaTranformada other = (TablaTranformada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escom.ipn.etl.p03.DAO.TablaTranformada[ id=" + id + " ]";
    }
    
}
