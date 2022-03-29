/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p04.ControladorLecturaCSV;

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
public class ControladorCSVDatos {
    private static final String PATHWORK = "C:\\Users\\DEZKS\\Downloads\\AnalisisPLuvial\\CSV\\";
            
    public List<CSVModel> getData(String ruta){
        try {
            List<CSVModel> archivo = new CsvToBeanBuilder(new FileReader(PATHWORK+ruta)).withType(CSVModel.class).build().parse();
            this.extraerEncabezado(archivo);
            return this.removerVacios(archivo);
        } catch (CsvBadConverterException ex) {
            System.err.println(ex);
        } catch(FileNotFoundException ex){
            
        }
        return new ArrayList<CSVModel>();
    }
    private List<CSVModel> extraerEncabezado(List<CSVModel> archivo){
        archivo.remove(0);
        return archivo;
    }
    public List<CSVModel> unificar(List<CSVModel> existentes, Collection<CSVModel> nuevos){
        existentes.addAll(nuevos);
        return existentes;
    }
    private List<CSVModel> removerVacios(List<CSVModel> datos){
        Iterator<CSVModel> temp = datos.iterator();
        while(temp.hasNext()){
            CSVModel fila = temp.next();
            if(fila.vacio()){
                temp.remove();
            }
        }
        return datos;
    }
}
