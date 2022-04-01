/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p04;

import com.escom.ipn.etl.p04.Controladores.ControladorCSVDatos;
import com.escom.ipn.etl.p04.Controladores.ControladorCSVEstaciones;
import com.escom.ipn.etl.p04.Controladores.ControladorReglas;
import com.escom.ipn.etl.p04.Modelos.CSVModel;
import com.escom.ipn.etl.p04.Modelos.CSVModeloCatalogo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DEZKS
 */
public class main {
    public static void main(String[] args) {
        ControladorCSVDatos extractor = new ControladorCSVDatos();
        ControladorCSVEstaciones extractorE = new ControladorCSVEstaciones();
        ControladorReglas transformador = new ControladorReglas();
        /*Se reliza la extraccion de el catalogo de estaciones en CSV*/
        List<CSVModeloCatalogo> estaciones = extractorE.getData("CatalogoEstaciones.csv");
        /*cargamos el catalogo de estaciones en el objeto que ayudara a la transofrmacion*/
        transformador.setCatalogo(estaciones);
        /*Creamos una lista donde guardaremos todos los registros que se extraigan de los archivos CSV*/
        List<CSVModel> fulldata = new ArrayList<>();
        /*Extrae y unifica los datos desde el año 2000 hasta el año 2019*/
        for(int i = 2000; i<=2019; i++){
            extractor.unificar(fulldata, extractor.getData(i+"PPH.csv"));
        }
        /*Realiza la transformacion, nos muestra en consola la conversio y guarda los registros en la base de datos*/
        for(CSVModel dato: fulldata){
            transformador.convierte(dato);
            transformador.mostrarConversion(); 
            transformador.guardar();
        }
    }
    
}
