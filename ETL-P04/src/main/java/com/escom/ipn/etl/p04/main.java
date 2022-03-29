/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p04;

import com.escom.ipn.etl.p04.ControladorLecturaCSV.ControladorCSV;
import com.escom.ipn.etl.p04.Modelos.CSVModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author DEZKS
 */
public class main {
    public static void main(String[] args) {
        ControladorCSV extractor = new ControladorCSV();
        int Registros = 0;
        List<CSVModel> fulldata = new ArrayList<>();
        for(int i = 2000; i<=2019; i++){
            extractor.unificar(fulldata, extractor.getData(i+"PPH.csv"));
        }
        for(CSVModel dato: fulldata){
            Registros++;
        }
        System.out.println(Registros);
    }
    
}
