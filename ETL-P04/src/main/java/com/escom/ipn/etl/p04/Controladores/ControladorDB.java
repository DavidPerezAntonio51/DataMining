/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p04.Controladores;

import com.escom.ipn.etl.p04.Modelos.TablaDeHechos;
import com.escom.ipn.etl.p04.conexion.Conexion;
import java.sql.SQLException;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

/**
 *
 * @author DEZKS
 */
public class ControladorDB {
    /*Se encarga de guardar en la base de datos el objeto transformado*/
    public void guardar (TablaDeHechos dato){
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
