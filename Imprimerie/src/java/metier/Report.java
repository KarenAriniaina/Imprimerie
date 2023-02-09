/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.ObjetBDD;
import java.sql.Date;

/**
 *
 * @author Ari
 */
public class Report extends ObjetBDD{
    private String idReport;
    private Date DateReport;
    private double Valeur;

    public String getIdReport() {
        return idReport;
    }

    public void setIdReport(String idReport) {
        this.idReport = idReport;
    }

    public Date getDateReport() {
        return DateReport;
    }

    public void setDateReport(Date DateReport){
        this.DateReport = DateReport;
    }

    public double getValeur() {
        return Valeur;
    }

    public void setValeur(double Valeur){
        this.Valeur = Valeur;
    }

    public Report() {
        this.setNomTable("Report");
        this.setPrimaryKey("idReport");
    }
    
}
