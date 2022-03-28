/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p03.Conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DEZKS
 */
public class Conexion {
    private static Conexion instancia = new Conexion();
    private EntityManagerFactory factory;

    public Conexion() {
        factory = Persistence.createEntityManagerFactory("com.escom.ipn_ETL-P03_jar_1.0-SNAPSHOTPU");
    }

    public static Conexion getInstancia() {
        return instancia;
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }
}
