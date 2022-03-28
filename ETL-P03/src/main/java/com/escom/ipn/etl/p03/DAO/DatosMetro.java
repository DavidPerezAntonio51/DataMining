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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author DEZKS
 */
@Entity
@Table(name = "DatosMetro")
@NamedQueries({
    @NamedQuery(name = "DatosMetro.findAll", query = "SELECT d FROM DatosMetro d"),
    @NamedQuery(name = "DatosMetro.findById", query = "SELECT d FROM DatosMetro d WHERE d.id = :id"),
    @NamedQuery(name = "DatosMetro.findByFecha", query = "SELECT d FROM DatosMetro d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "DatosMetro.findByTipoIngreso", query = "SELECT d FROM DatosMetro d WHERE d.tipoIngreso = :tipoIngreso"),
    @NamedQuery(name = "DatosMetro.findByLinea1", query = "SELECT d FROM DatosMetro d WHERE d.linea1 = :linea1"),
    @NamedQuery(name = "DatosMetro.findByLinea2", query = "SELECT d FROM DatosMetro d WHERE d.linea2 = :linea2"),
    @NamedQuery(name = "DatosMetro.findByLinea3", query = "SELECT d FROM DatosMetro d WHERE d.linea3 = :linea3"),
    @NamedQuery(name = "DatosMetro.findByLinea4", query = "SELECT d FROM DatosMetro d WHERE d.linea4 = :linea4"),
    @NamedQuery(name = "DatosMetro.findByLinea5", query = "SELECT d FROM DatosMetro d WHERE d.linea5 = :linea5"),
    @NamedQuery(name = "DatosMetro.findByLinea6", query = "SELECT d FROM DatosMetro d WHERE d.linea6 = :linea6"),
    @NamedQuery(name = "DatosMetro.findByLinea7", query = "SELECT d FROM DatosMetro d WHERE d.linea7 = :linea7"),
    @NamedQuery(name = "DatosMetro.findByLinea8", query = "SELECT d FROM DatosMetro d WHERE d.linea8 = :linea8"),
    @NamedQuery(name = "DatosMetro.findByLinea9", query = "SELECT d FROM DatosMetro d WHERE d.linea9 = :linea9"),
    @NamedQuery(name = "DatosMetro.findByLineaA", query = "SELECT d FROM DatosMetro d WHERE d.lineaA = :lineaA"),
    @NamedQuery(name = "DatosMetro.findByLineaB", query = "SELECT d FROM DatosMetro d WHERE d.lineaB = :lineaB"),
    @NamedQuery(name = "DatosMetro.findByLinea12", query = "SELECT d FROM DatosMetro d WHERE d.linea12 = :linea12")})
public class DatosMetro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "FECHA")
    private String fecha;
    @Column(name = "TIPO_INGRESO")
    private String tipoIngreso;
    @Column(name = "LINEA_1")
    private Integer linea1;
    @Column(name = "LINEA_2")
    private Integer linea2;
    @Column(name = "LINEA_3")
    private Integer linea3;
    @Column(name = "LINEA_4")
    private Integer linea4;
    @Column(name = "LINEA_5")
    private Integer linea5;
    @Column(name = "LINEA_6")
    private Integer linea6;
    @Column(name = "LINEA_7")
    private Integer linea7;
    @Column(name = "LINEA_8")
    private Integer linea8;
    @Column(name = "LINEA_9")
    private Integer linea9;
    @Column(name = "LINEA_A")
    private Integer lineaA;
    @Column(name = "LINEA_B")
    private Integer lineaB;
    @Column(name = "LINEA_12")
    private String linea12;

    public DatosMetro() {
    }

    public DatosMetro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public Integer getLinea1() {
        return linea1;
    }

    public void setLinea1(Integer linea1) {
        this.linea1 = linea1;
    }

    public Integer getLinea2() {
        return linea2;
    }

    public void setLinea2(Integer linea2) {
        this.linea2 = linea2;
    }

    public Integer getLinea3() {
        return linea3;
    }

    public void setLinea3(Integer linea3) {
        this.linea3 = linea3;
    }

    public Integer getLinea4() {
        return linea4;
    }

    public void setLinea4(Integer linea4) {
        this.linea4 = linea4;
    }

    public Integer getLinea5() {
        return linea5;
    }

    public void setLinea5(Integer linea5) {
        this.linea5 = linea5;
    }

    public Integer getLinea6() {
        return linea6;
    }

    public void setLinea6(Integer linea6) {
        this.linea6 = linea6;
    }

    public Integer getLinea7() {
        return linea7;
    }

    public void setLinea7(Integer linea7) {
        this.linea7 = linea7;
    }

    public Integer getLinea8() {
        return linea8;
    }

    public void setLinea8(Integer linea8) {
        this.linea8 = linea8;
    }

    public Integer getLinea9() {
        return linea9;
    }

    public void setLinea9(Integer linea9) {
        this.linea9 = linea9;
    }

    public Integer getLineaA() {
        return lineaA;
    }

    public void setLineaA(Integer lineaA) {
        this.lineaA = lineaA;
    }

    public Integer getLineaB() {
        return lineaB;
    }

    public void setLineaB(Integer lineaB) {
        this.lineaB = lineaB;
    }

    public String getLinea12() {
        return linea12;
    }

    public void setLinea12(String linea12) {
        this.linea12 = linea12;
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
        if (!(object instanceof DatosMetro)) {
            return false;
        }
        DatosMetro other = (DatosMetro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ id=" + id+"," +" tipo_Ingreso="+tipoIngreso+ " ]";
    }
    
}
