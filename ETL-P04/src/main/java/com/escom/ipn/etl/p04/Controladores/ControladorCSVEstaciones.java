/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p04.Controladores;

import com.escom.ipn.etl.p04.Modelos.CSVModel;
import com.escom.ipn.etl.p04.Modelos.CSVModeloCatalogo;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author DEZKS
 */
public class ControladorCSVEstaciones {
    private static final String PATHWORK = "C:\\Users\\DEZKS\\Downloads\\AnalisisPLuvial\\CSV\\";
    /*Extrae los datos de las estaciones*/
    public List<CSVModeloCatalogo> getData(String ruta){
        try {
            List<CSVModeloCatalogo> archivo = new CsvToBeanBuilder(new FileReader(PATHWORK+ruta)).withType(CSVModeloCatalogo.class).build().parse();
            this.extraerEncabezado(archivo);
            return this.removerVacios(archivo);
        } catch (CsvBadConverterException ex) {
            System.err.println(ex);
        } catch(FileNotFoundException ex){
            
        }
        return new ArrayList<CSVModeloCatalogo>();
    }
    /*Elimina el encabezado del catalogo*/
    private List<CSVModeloCatalogo> extraerEncabezado(List<CSVModeloCatalogo> archivo){
        archivo.remove(0);
        return archivo;
    }
    public List<CSVModeloCatalogo> unificar(List<CSVModeloCatalogo> existentes, Collection<CSVModeloCatalogo> nuevos){
        existentes.addAll(nuevos);
        return existentes;
    }
    /*En caso de haber registros vacios los elimina*/
    private List<CSVModeloCatalogo> removerVacios(List<CSVModeloCatalogo> datos){
        Iterator<CSVModeloCatalogo> temp = datos.iterator();
        while(temp.hasNext()){
            CSVModeloCatalogo fila = temp.next();
            if(fila.vacio()){
                temp.remove();
            }
        }
        return datos;
    }
}
