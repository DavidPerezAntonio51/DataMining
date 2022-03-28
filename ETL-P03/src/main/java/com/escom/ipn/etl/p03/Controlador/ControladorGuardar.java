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
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

/**
 *
 * @author DEZKS
 */
public class ControladorGuardar {
    
    public void guardar (TablaTranformada dato){
        EntityManager en = this.entityManager();
        try{
        en.getTransaction().begin();
        en.persist(dato);
        en.getTransaction().commit();
        }catch(EntityExistsException e){
            System.err.println(e);
        }finally{
            en.close();
        }
    }
    
    private EntityManager entityManager(){
        return Conexion.getInstancia().getFactory().createEntityManager();
    }
    
}
