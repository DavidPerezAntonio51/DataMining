/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p03.Controlador;

import com.escom.ipn.etl.p03.Conexion.Conexion;
import com.escom.ipn.etl.p03.DAO.DatosMetro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DEZKS
 */
/*El controlador Data se encarga exclusivamente de las operaciones sobre la tabla original de datos*/
public class ControladorData {
    /*Se encarga de la extracion de todos los datos y los retorna en una Lista*/
    public List<DatosMetro> getFullData(){
        Query query = entityManager().createQuery("SELECT d FROM DatosMetro d");
        return query.getResultList();
    }
    /*Nos devuelve el Entity Manager que nos ayuda con las transacciones y peticiones a la base de datos*/
    private EntityManager entityManager(){
        return Conexion.getInstancia().getFactory().createEntityManager();
    }
}
