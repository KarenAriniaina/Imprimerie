/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.ObjetBDD;

/**
 *
 * @author itu
 */
public class V_RM extends ObjetBDD{
    private String idActivite ;
    private double somme; 

    public V_RM() {
        this.setNomTable("V_RM");
    }

    public String getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(String idActivite) {
        this.idActivite = idActivite;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }
    
}
