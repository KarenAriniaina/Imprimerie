/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import dao.ObjetBDD;

/**
 *
 * @author itu
 */
public class V_Masokarena extends ObjetBDD {
    private String idActivite ;
    private String idSalaire ;
    private String idFonctionnalite ;
    private int duree ;
    private String designation ;
    private double valeur ;
    private int TempsHeure ;
    private double somme ;
    private String nomFonctionnalite ;
    private double MargeBeneficiaire;

    public String getNomFonctionnalite() {
        return nomFonctionnalite;
    }

    public void setNomFonctionnalite(String nomFonctionnalite) {
        this.nomFonctionnalite = nomFonctionnalite;
    }

    public String getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(String idActivite) {
        this.idActivite = idActivite;
    }

    public String getIdSalaire() {
        return idSalaire;
    }

    public void setIdSalaire(String idSalaire) {
        this.idSalaire = idSalaire;
    }

    public String getIdFonctionnalite() {
        return idFonctionnalite;
    }

    public void setIdFonctionnalite(String idFonctionnalite) {
        this.idFonctionnalite = idFonctionnalite;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public int getTempsHeure() {
        return TempsHeure;
    }

    public void setTempsHeure(int TempsHeure) {
        this.TempsHeure = TempsHeure;
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

    public V_Masokarena() {
        this.setNomTable("v_masokarena");
    }
    
    
    
    
    
}
