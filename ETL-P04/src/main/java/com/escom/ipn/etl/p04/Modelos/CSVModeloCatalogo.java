/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p04.Modelos;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author DEZKS
 */
/*Modelo usado para el catalogo de estaciones*/
public class CSVModeloCatalogo {
    @CsvBindByPosition(position = 0)
    private String Clave;
    @CsvBindByPosition(position = 1)
    private String Nombre;
    @CsvBindByPosition(position = 2)
    private String Alcaldia_Municipio;
    @CsvBindByPosition(position = 3)
    private String Entidad;
    @CsvBindByPosition(position = 4)
    private String Latitud;
    @CsvBindByPosition(position = 5)
    private String Longitud;

    public CSVModeloCatalogo() {
    }

    public CSVModeloCatalogo(String Clave, String Nombre, String Alcaldia_Municipio, String Entidad, String Latitud, String Longitud) {
        this.Clave = Clave;
        this.Nombre = Nombre;
        this.Alcaldia_Municipio = Alcaldia_Municipio;
        this.Entidad = Entidad;
        this.Latitud = Latitud;
        this.Longitud = Longitud;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getAlcaldia_Municipio() {
        return Alcaldia_Municipio;
    }

    public void setAlcaldia_Municipio(String Alcaldia_Municipio) {
        this.Alcaldia_Municipio = Alcaldia_Municipio;
    }

    public String getEntidad() {
        return Entidad;
    }

    public void setEntidad(String Entidad) {
        this.Entidad = Entidad;
    }

    public String getLatitud() {
        return Latitud;
    }

    public void setLatitud(String Latitud) {
        this.Latitud = Latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

    public void setLongitud(String Longitud) {
        this.Longitud = Longitud;
    }

    
    public boolean vacio(){
        return this.Alcaldia_Municipio.equals("")&&this.Clave.equals("")&&this.Entidad.equals("")
                &&this.Latitud.equals("")&&this.Longitud.equals("")&&this.Nombre.equals("");
    }
    
    @Override
    public String toString() {
        return "CSVModeloCatalogo{" + "Clave=" + Clave + ", Nombre=" + Nombre + ", Alcaldia_Municipio=" + Alcaldia_Municipio + ", Entidad=" + Entidad + ", Latitud=" + Latitud + ", Longitud=" + Longitud + '}';
    }
    
}
