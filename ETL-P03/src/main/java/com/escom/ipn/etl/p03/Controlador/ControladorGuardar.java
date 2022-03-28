/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p03.Controlador;

import com.escom.ipn.etl.p03.Conexion.Conexion;
import com.escom.ipn.etl.p03.DAO.TablaTranformada;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author DEZKS
 */
public class ControladorGuardar {
    
    public void guardar (List<TablaTranformada> datos){
        EntityManager en = this.entityManager();
        Iterator<TablaTranformada> data = datos.iterator();
        while(data.hasNext()){
            en.persist(data.next());
        }
    }
    
    private EntityManager entityManager(){
        return Conexion.getInstancia().getFactory().createEntityManager();
    }
    
}
