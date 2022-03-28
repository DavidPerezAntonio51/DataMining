/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p03;

import com.escom.ipn.etl.p03.Controlador.ControladorData;
import com.escom.ipn.etl.p03.DAO.DatosMetro;
import java.util.List;

/**
 *
 * @author DEZKS
 */
public class main {

    public static void main(String[] args) {
        ControladorData controller = new ControladorData();
        List<DatosMetro> datos = controller.getFullData();
        for(DatosMetro fila: datos){
            System.out.println(fila);
        }
    }
    
}
