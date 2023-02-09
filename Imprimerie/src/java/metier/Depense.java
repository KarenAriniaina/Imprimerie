/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.ObjetBDD;

/**
 *
 * @author Ari
 */
public class Depense extends ObjetBDD{
    private String idDepense;
    private String Designation;
    private double Valeur;

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) throws Exception{
        if(Designation.equalsIgnoreCase("")) throw new Exception("Designation vide");
        this.Designation = Designation;
    }

    public String getIdDepense() {
        return idDepense;
    }

    public void setIdDepense(String idDepense) {
        this.idDepense = idDepense;
    }

    public double getValeur() {
        return Valeur;
    }

    public void setValeur(double Valeur) throws Exception{
        if(Valeur<=0) throw new Exception("Valeur depense impossible");
        this.Valeur = Valeur;
    }

    public Depense() {
        this.setNomTable("Depense");
        this.setPrimaryKey("idDepense");
    }
    
}
