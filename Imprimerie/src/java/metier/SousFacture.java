/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import modele.Fille;

/**
 *
 * @author itu
 */
public class SousFacture extends Fille {

    private String idSousFacture;
    private String idFacture;
    private String Designation;
    private int nombre;
    private double sousTotal;
    private double prixUnitaire;
    private double remise;

    public String getIdSousFacture() {
        return idSousFacture;
    }

    public void setIdSousFacture(String idSousFacture) {
        this.idSousFacture = idSousFacture;
    }

    public String getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(String idFacture) {
        this.idFacture = idFacture;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) throws Exception {
        if (nombre <= 0) {
            throw new Exception("quantite impossible");
        }
        this.nombre = nombre;
    }

    public double getSousTotal() {
        return sousTotal;
    }

    public void setSousTotal(double sousTotal) throws Exception {
        if (sousTotal <= 0) {
            throw new Exception("misy erreur");
        }
        this.sousTotal = sousTotal;
    }

    public void setColMere() {
        this.setColumnMere("idFacture");
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) throws Exception {
        if (prixUnitaire <= 0) {
            throw new Exception("prix impossible");
        }
        this.prixUnitaire = prixUnitaire;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) throws Exception {
        if (remise < 0) {
            throw new Exception("remise inferieur à 0");
        }
        this.remise = remise;
    }

    public SousFacture() {
        this.setNomTable("SousFacture");
        this.setPrimaryKey("idSousfacture");
        this.setColMere();
    }

    public SousFacture(String designation, int quantite, double prixUnitaire, int remise) throws Exception {
        this.setDesignation(designation);
        this.setNombre(quantite);
        this.setPrixUnitaire(prixUnitaire);
        this.setRemise(remise);
        System.err.println(quantite);
        System.err.println(prixUnitaire);
        System.err.println(remise);
        this.setSousTotal(this.getNombre() * this.getPrixUnitaire() - (this.getNombre() * this.getPrixUnitaire() * this.getRemise() / 100));
        this.setNomTable("SousFacture");
        this.setPrimaryKey("idSousfacture");
        this.setColMere();
    }

}
