/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.ObjetBDD;

/**
 *
 * @author karen
 */
public class DetailActiviteMateriel extends ObjetBDD{
    private String idActivite;
    private double prix;
    private String designation;
    private String nom;
    private double prixUnitaire;
    private double quantite;
    private double somme;
    private double MargeBeneficiaire;
    
    public DetailActiviteMateriel() {
        this.setNomTable("v_DetailActiviteMateriel");
    }

    
    public String getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(String idActivite) {
        this.idActivite = idActivite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public double getMargeBeneficiaire() {
        return MargeBeneficiaire;
    }

    public void setMargeBeneficiaire(double MargeBeneficiaire) {
        this.MargeBeneficiaire = MargeBeneficiaire;
    }
}
