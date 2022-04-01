/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p04.Controladores;

import com.escom.ipn.etl.p04.Modelos.CSVModel;
import com.escom.ipn.etl.p04.Modelos.CSVModeloCatalogo;
import com.escom.ipn.etl.p04.Modelos.TablaDeHechos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sourceforge.jtds.jdbc.DateTime;

/**
 *
 * @author DEZKS
 */
/*Aqui se ponen todas las reglas de transformacion*/
public class ControladorReglas {
    private Map<String, CSVModeloCatalogo> catalogo;
    private ControladorDB database = new ControladorDB();
    private List<TablaDeHechos> datos;
    /*Guarda todos los registros ya transformados en la base de datos*/
    public void guardar(){
        datos.forEach(dato->{
            database.guardar(dato);
        });
    }
    public Map<String, CSVModeloCatalogo> getCatalogo() {
        return catalogo;
    }
    /*nos ayuda a la carga del catalogo de estaciones*/
    public void setCatalogo(List<CSVModeloCatalogo> catalogo) {
        this.catalogo = new HashMap<String, CSVModeloCatalogo>();
        Iterator<CSVModeloCatalogo> iterador = catalogo.iterator();
        while(iterador.hasNext()){
            CSVModeloCatalogo fila = iterador.next();
            this.catalogo.putIfAbsent(fila.getClave(), fila);
        }
    }
    /*Se calcula el numero de la semana en base a la fecha*/
    private Integer obtenerNumeroSemana(String fecha){
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = formato.parse(fecha);
            calendario.setTime(date);
            return calendario.get(Calendar.WEEK_OF_YEAR);
        } catch (ParseException ex) {
            System.err.println(ex);
        }
        return 0;
    }
    /*Se obtiene el numero del dia de la semana, inicia con Domingo = 1*/
    private Integer obtenerNumeroDiaSemana(String fecha){
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = formato.parse(fecha);
            calendario.setTime(date);
            return calendario.get(Calendar.DAY_OF_WEEK);
        } catch (ParseException ex) {
            System.err.println(ex);
        }
        return 0;
    }
    /*Imprime en consola la conversion realizada*/
    public void mostrarConversion(){
        datos.forEach(fila -> {
            System.out.println(fila);
        });
    }
    /*Formatea la fecha a un formato aceptado por SQL Server*/
    private String formatearFecha(String fecha){
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoSalida = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate newFecha = LocalDate.parse(fecha,formatoEntrada);
        return newFecha.format(formatoSalida);
    }
    /*Convierte las columnas de las estaciones en filas y agrega los datos relevantes de estaciones*/
    public void convierte(CSVModel dato){
        final String ELEMENTO = "PP";
        final String MEDICION ="Milímetros de lluvia (mm)";
        this.datos = new ArrayList<>();
        String fecha = dato.getFecha();
        /*Cada registro de 17 columnas se convierte a 16 nunevos registros y se anexan los datos del catalogo*/
        for(int i=1;i<=16;i++){
            CSVModeloCatalogo datosEstacion;
            TablaDeHechos transformado = new TablaDeHechos();
            transformado.setFecha(this.formatearFecha(fecha));
            transformado.setElemento(ELEMENTO);
            transformado.setUnidadDeMedicion(MEDICION);
            transformado.setNoDiaSemana(this.obtenerNumeroDiaSemana(fecha));
            transformado.setNoSemana(this.obtenerNumeroSemana(fecha));
            /*Se usa un switch para manejar la columna correspondiente*/
            switch(i){
                case 1:
                    /*Se carga el catalogo correspondiente a la columna*/
                    datosEstacion = catalogo.get("LOM");
                    /*se verifica la existencia de un valor nulo en la columna*/
                    /*Si no hay nulo termina de ejecutar la transformacion en caso contrario la descarta*/
                    if(!dato.getLom().equals("-99")){
                        transformado.setMedicion(Double.parseDouble(dato.getLom()));
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 2:
                    datosEstacion = catalogo.get("TEC");
                    if(!dato.getTec().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getTec()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 3:
                    datosEstacion = catalogo.get("DIC");
                    if(!dato.getDic().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getDic()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 4:
                   datosEstacion = catalogo.get("MCM");
                    if(!dato.getMcm().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getMcm()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 5:
                    datosEstacion = catalogo.get("TLA");
                    if(!dato.getTla().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getTla()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 6:
                    datosEstacion = catalogo.get("XAL");
                    if(!dato.getXal().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getXal()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 7:
                    datosEstacion = catalogo.get("EDL");
                    if(!dato.getEdl().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getEdl()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 8:
                    datosEstacion = catalogo.get("IBM");
                    if(!dato.getIbm().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getIbm()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 9:
                    datosEstacion = catalogo.get("NEZ");
                    if(!dato.getNes().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getNes()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 10:
                    datosEstacion = catalogo.get("MON");
                    if(!dato.getMon().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getMon()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 11:
                    datosEstacion = catalogo.get("EAJ");
                    if(!dato.getEaj().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getEaj()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 12:
                    datosEstacion = catalogo.get("AJU");
                    if(!dato.getAju().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getAju()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 13:
                    datosEstacion = catalogo.get("MPA");
                    if(!dato.getMpa().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getMpa()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 14:
                    datosEstacion = catalogo.get("SNT");
                    if(!dato.getSnt().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getSnt()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 15:
                    datosEstacion = catalogo.get("COR");
                    if(!dato.getCor().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getCor()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
                case 16:
                    datosEstacion = catalogo.get("LAA");
                    if(!dato.getLaa().equals("-99")){
                        transformado.setAlcaldiaOMunicipio(datosEstacion.getAlcaldia_Municipio());
                        transformado.setEntidad(datosEstacion.getEntidad());
                        transformado.setLatitud(Double.parseDouble(datosEstacion.getLatitud()));
                        transformado.setLongitud(Double.parseDouble(datosEstacion.getLongitud()));
                        transformado.setNombreEstacion(datosEstacion.getNombre());
                        transformado.setMedicion(Double.parseDouble(dato.getLaa()));
                        datos.add(transformado);
                    }else{
                        return;
                    }
                break;
            }
        }
    }
}
