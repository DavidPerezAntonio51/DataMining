/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p03;

import com.escom.ipn.etl.p03.Controlador.ControladorData;
import com.escom.ipn.etl.p03.Controlador.ControladorGuardar;
import com.escom.ipn.etl.p03.DAO.DatosMetro;
import com.escom.ipn.etl.p03.DAO.TablaTranformada;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DEZKS
 */
public class main {
    
    public static void main(String[] args) {
        /*Se crean 2 controladores para ayudarnos con las operaciones sobre la base de datos*/
        ControladorData controller = new ControladorData();
        ControladorGuardar controller2 = new ControladorGuardar();
        /*Obtenemos una Lista con todos los registros de la base de datos*/
        List<DatosMetro> datos = controller.getFullData();
        /*Recorremos cada fila de esa lista*/
        for (DatosMetro fila : datos) {
            /*Por cada fila crearemos 12 nuevos registros*/
            for (int i = 1; i <= 12; i++) {
                /*Se crea un nuevo objeto-entidad que contiene la nueva estructura*/
                TablaTranformada temp = new TablaTranformada();
                /*Se copian los datos de la tabla original a la nueva estructura en el orden deseado*/
                temp.setFecha(fila.getFecha());
                temp.setTipoIngreso(fila.getTipoIngreso());
                /*Se realizan validaciones respecto a los posibles nulos y se clasifican con sus lineas correspondientes*/
                switch (i) {
                    case 1:
                        if (fila.getLinea1() != null) {
                            temp.setMonto(fila.getLinea1());
                            temp.setLineaMetro("LINEA_1");
                        } else {
                            temp.setMonto(0);
                            temp.setLineaMetro("LINEA_1");
                        }
                        break;
                    case 2:
                        if (fila.getLinea2() != null) {
                            temp.setMonto(fila.getLinea2());
                            temp.setLineaMetro("LINEA_2");
                        } else {
                            temp.setMonto(0);
                            temp.setLineaMetro("LINEA_2");
                        }
                        break;
                    case 3:
                        if (fila.getLinea3() != null) {
                            temp.setMonto(fila.getLinea3());
                            temp.setLineaMetro("LINEA_3");
                        } else {
                            temp.setMonto(0);
                            temp.setLineaMetro("LINEA_3");
                        }
                        break;
                    case 4:
                        if (fila.getLinea4() != null) {
                            temp.setMonto(fila.getLinea4());
                            temp.setLineaMetro("LINEA_4");
                        } else {
                            temp.setMonto(0);
                            temp.setLineaMetro("LINEA_4");
                        }
                        break;
                    case 5:
                        if (fila.getLinea5() != null) {
                            temp.setMonto(fila.getLinea5());
                            temp.setLineaMetro("LINEA_5");
                        } else {
                            temp.setMonto(0);
                            temp.setLineaMetro("LINEA_5");
                        }
                        break;
                    case 6:
                        if (fila.getLinea6() != null) {
                            temp.setMonto(fila.getLinea6());
                            temp.setLineaMetro("LINEA_6");
                        } else {
                            temp.setMonto(0);
                            temp.setLineaMetro("LINEA_6");
                        }
                        break;
                    case 7:
                        if (fila.getLinea7() != null) {
                            temp.setMonto(fila.getLinea7());
                            temp.setLineaMetro("LINEA_7");
                        } else {
                            temp.setMonto(0);
                            temp.setLineaMetro("LINEA_7");
                        }
                        break;
                    case 8:
                        if (fila.getLinea8() != null) {
                            temp.setMonto(fila.getLinea8());
                            temp.setLineaMetro("LINEA_8");
                        } else {
                            temp.setMonto(0);
                            temp.setLineaMetro("LINEA_8");
                        }
                        break;
                    case 9:
                        if (fila.getLinea9() != null) {
                            temp.setMonto(fila.getLinea9());
                            temp.setLineaMetro("LINEA_9");
                        } else {
                            temp.setMonto(0);
                            temp.setLineaMetro("LINEA_9");
                        }
                        break;
                    case 10:
                        if (fila.getLineaA() != null) {
                            temp.setMonto(fila.getLineaA());
                            temp.setLineaMetro("LINEA_A");
                        } else {
                            temp.setMonto(0);
                            temp.setLineaMetro("LINEA_A");
                        }
                        break;
                    case 11:
                        if (fila.getLineaB() != null) {
                            temp.setMonto(fila.getLineaB());
                            temp.setLineaMetro("LINEA_B");
                        } else {
                            temp.setMonto(0);
                            temp.setLineaMetro("LINEA_B");
                        }
                        break;
                    case 12:
                        if (fila.getLinea12() != null) {
                            int monto = (int) Double.parseDouble(fila.getLinea12());
                            temp.setMonto(monto);
                            temp.setLineaMetro("LINEA_12");
                        } else {
                            temp.setMonto(0);
                            temp.setLineaMetro("LINEA_12");
                        }
                        
                        break;
                }
                /*Se llama al controlador de la nueva tabla para realizar la persistencia del objeto transofrmado*/
                controller2.guardar(temp);
            }
        }
    }
    
}
