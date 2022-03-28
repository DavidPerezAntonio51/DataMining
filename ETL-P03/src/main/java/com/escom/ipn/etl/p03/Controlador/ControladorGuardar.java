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
/*Controlador que trabaja exclusivamente sobre la nueva tabla transformada*/
public class ControladorGuardar {
    /*Se encarga de guardar en la base de datos el objeto transformado*/
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
    /*Nos regresa el EntityManager para realizar operaciones sobre la base de datos*/
    private EntityManager entityManager(){
        return Conexion.getInstancia().getFactory().createEntityManager();
    }
    
}
