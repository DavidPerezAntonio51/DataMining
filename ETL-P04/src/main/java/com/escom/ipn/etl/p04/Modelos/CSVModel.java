/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.etl.p04.Modelos;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author DEZKS
 */
/*Modelo de mapeo para los archivo CSV*/
public class CSVModel {
    @CsvBindByPosition(position = 0)
    private String fecha;
    @CsvBindByPosition(position = 1)
    private String lom;
    @CsvBindByPosition(position = 2)
    private String tec;
    @CsvBindByPosition(position = 3)
    private String dic;
    @CsvBindByPosition(position = 4)
    private String mcm;
    @CsvBindByPosition(position = 5)
    private String tla;
    @CsvBindByPosition(position = 6)
    private String xal;
    @CsvBindByPosition(position = 7)
    private String edl;
    @CsvBindByPosition(position = 8)
    private String ibm;
    @CsvBindByPosition(position = 9)
    private String nes;
    @CsvBindByPosition(position = 10)
    private String mon;
    @CsvBindByPosition(position = 11)
    private String eaj;
    @CsvBindByPosition(position = 12)
    private String aju;
    @CsvBindByPosition(position = 13)
    private String mpa;
    @CsvBindByPosition(position = 14)
    private String snt;
    @CsvBindByPosition(position = 15)
    private String cor;
    @CsvBindByPosition(position = 16)
    private String laa;

    public CSVModel() {
    }

    public CSVModel(String fecha, String lom, String tec, String dic, String mcm, String tla, String xal, String edl, String ibm, String nes, String mon, String eaj, String aju, String mpa, String snt, String cor, String laa) {
        this.fecha = fecha;
        this.lom = lom;
        this.tec = tec;
        this.dic = dic;
        this.mcm = mcm;
        this.tla = tla;
        this.xal = xal;
        this.edl = edl;
        this.ibm = ibm;
        this.nes = nes;
        this.mon = mon;
        this.eaj = eaj;
        this.aju = aju;
        this.mpa = mpa;
        this.snt = snt;
        this.cor = cor;
        this.laa = laa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLom() {
        return lom;
    }

    public void setLom(String lom) {
        this.lom = lom;
    }

    public String getTec() {
        return tec;
    }

    public void setTec(String tec) {
        this.tec = tec;
    }

    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }

    public String getMcm() {
        return mcm;
    }

    public void setMcm(String mcm) {
        this.mcm = mcm;
    }

    public String getTla() {
        return tla;
    }

    public void setTla(String tla) {
        this.tla = tla;
    }

    public String getXal() {
        return xal;
    }

    public void setXal(String xal) {
        this.xal = xal;
    }

    public String getEdl() {
        return edl;
    }

    public void setEdl(String edl) {
        this.edl = edl;
    }

    public String getIbm() {
        return ibm;
    }

    public void setIbm(String ibm) {
        this.ibm = ibm;
    }

    public String getNes() {
        return nes;
    }

    public void setNes(String nes) {
        this.nes = nes;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getEaj() {
        return eaj;
    }

    public void setEaj(String eaj) {
        this.eaj = eaj;
    }

    public String getAju() {
        return aju;
    }

    public void setAju(String aju) {
        this.aju = aju;
    }

    public String getMpa() {
        return mpa;
    }

    public void setMpa(String mpa) {
        this.mpa = mpa;
    }

    public String getSnt() {
        return snt;
    }

    public void setSnt(String snt) {
        this.snt = snt;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getLaa() {
        return laa;
    }

    public void setLaa(String laa) {
        this.laa = laa;
    }

    public boolean vacio(){
        return this.fecha.equals("")&&this.lom.equals("")&&this.tec.equals("")&&
                this.dic.equals("")&&this.mcm.equals("")&&this.tla.equals("")&&
                this.xal.equals("")&&this.edl.equals("")&&this.ibm.equals("")&&
                this.nes.equals("")&&this.mon.equals("")&&this.eaj.equals("")&&
                this.aju.equals("")&&this.mpa.equals("")&&this.snt.equals("")&&
                this.cor.equals("")&&this.laa.equals("");
    }
    @Override
    public String toString() {
        return "CSVModel{" + "fecha=" + fecha + ", lom=" + lom + ", tec=" + tec + ", dic=" + dic + ", mcm=" + mcm + ", tla=" + tla + ", xal=" + xal + ", edl=" + edl + ", ibm=" + ibm + ", nes=" + nes + ", mon=" + mon + ", eaj=" + eaj + ", aju=" + aju + ", mpa=" + mpa + ", snt=" + snt + ", cor=" + cor + ", laa=" + laa + '}';
    }

}
