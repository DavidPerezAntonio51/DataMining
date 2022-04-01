/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p04.Modelos;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
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
/*Modelo en el que se mapean los datos que iran directo a la base historica*/
@Entity
@Table(name = "tabla_de_hechos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TablaDeHechos.findAll", query = "SELECT t FROM TablaDeHechos t"),
    @NamedQuery(name = "TablaDeHechos.findById", query = "SELECT t FROM TablaDeHechos t WHERE t.id = :id"),
    @NamedQuery(name = "TablaDeHechos.findByNombreEstacion", query = "SELECT t FROM TablaDeHechos t WHERE t.nombreEstacion = :nombreEstacion"),
    @NamedQuery(name = "TablaDeHechos.findByAlcaldiaOMunicipio", query = "SELECT t FROM TablaDeHechos t WHERE t.alcaldiaOMunicipio = :alcaldiaOMunicipio"),
    @NamedQuery(name = "TablaDeHechos.findByEntidad", query = "SELECT t FROM TablaDeHechos t WHERE t.entidad = :entidad"),
    @NamedQuery(name = "TablaDeHechos.findByLatitud", query = "SELECT t FROM TablaDeHechos t WHERE t.latitud = :latitud"),
    @NamedQuery(name = "TablaDeHechos.findByLongitud", query = "SELECT t FROM TablaDeHechos t WHERE t.longitud = :longitud"),
    @NamedQuery(name = "TablaDeHechos.findByNoDiaSemana", query = "SELECT t FROM TablaDeHechos t WHERE t.noDiaSemana = :noDiaSemana"),
    @NamedQuery(name = "TablaDeHechos.findByNoSemana", query = "SELECT t FROM TablaDeHechos t WHERE t.noSemana = :noSemana"),
    @NamedQuery(name = "TablaDeHechos.findByFecha", query = "SELECT t FROM TablaDeHechos t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TablaDeHechos.findByMedicion", query = "SELECT t FROM TablaDeHechos t WHERE t.medicion = :medicion"),
    @NamedQuery(name = "TablaDeHechos.findByElemento", query = "SELECT t FROM TablaDeHechos t WHERE t.elemento = :elemento"),
    @NamedQuery(name = "TablaDeHechos.findByUnidadDeMedicion", query = "SELECT t FROM TablaDeHechos t WHERE t.unidadDeMedicion = :unidadDeMedicion")})
public class TablaDeHechos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre_estacion")
    private String nombreEstacion;
    @Column(name = "alcaldia_o_municipio")
    private String alcaldiaOMunicipio;
    @Column(name = "entidad")
    private String entidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "longitud")
    private Double longitud;
    @Column(name = "no_dia_semana")
    private Integer noDiaSemana;
    @Column(name = "no_semana")
    private Integer noSemana;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "medicion")
    private Double medicion;
    @Column(name = "elemento")
    private String elemento;
    @Column(name = "unidad_de_medicion")
    private String unidadDeMedicion;

    public TablaDeHechos() {
    }

    public TablaDeHechos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEstacion() {
        return nombreEstacion;
    }

    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }

    public String getAlcaldiaOMunicipio() {
        return alcaldiaOMunicipio;
    }

    public void setAlcaldiaOMunicipio(String alcaldiaOMunicipio) {
        this.alcaldiaOMunicipio = alcaldiaOMunicipio;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Integer getNoDiaSemana() {
        return noDiaSemana;
    }

    public void setNoDiaSemana(Integer noDiaSemana) {
        this.noDiaSemana = noDiaSemana;
    }

    public Integer getNoSemana() {
        return noSemana;
    }

    public void setNoSemana(Integer noSemana) {
        this.noSemana = noSemana;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getMedicion() {
        return medicion;
    }

    public void setMedicion(Double medicion) {
        this.medicion = medicion;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getUnidadDeMedicion() {
        return unidadDeMedicion;
    }

    public void setUnidadDeMedicion(String unidadDeMedicion) {
        this.unidadDeMedicion = unidadDeMedicion;
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
        if (!(object instanceof TablaDeHechos)) {
            return false;
        }
        TablaDeHechos other = (TablaDeHechos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TablaDeHechos{" + "id=" + id + ", nombreEstacion=" + nombreEstacion + ", alcaldiaOMunicipio=" + alcaldiaOMunicipio + ", entidad=" + entidad + ", latitud=" + latitud + ", longitud=" + longitud + ", noDiaSemana=" + noDiaSemana + ", noSemana=" + noSemana + ", fecha=" + fecha + ", medicion=" + medicion + ", elemento=" + elemento + ", unidadDeMedicion=" + unidadDeMedicion + '}';
    }

    
    
}
