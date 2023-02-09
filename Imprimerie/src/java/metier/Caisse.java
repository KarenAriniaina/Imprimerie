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
public class Caisse extends ObjetBDD {
    private double recette;
    private double reste;
    private double depense;

    public double getRecette() {
        return recette;
    }

    public void setRecette(double recette) {
        this.recette = recette;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }

    public double getDepense() {
        return depense;
    }

    public void setDepense(double depense) {
        this.depense = depense;
    }

    public Caisse() {
        this.setNomTable("v_Caisse");
    }
    
    public void getCaisse() throws Exception{
        ObjetBDD[] lc=new Caisse().Find(null);
        Caisse c=(Caisse) lc[0];
        this.setDepense(c.getDepense());
        this.setRecette(c.getRecette());
        this.setReste(c.getReste());
    }
}
