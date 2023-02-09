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
public class BeneficeProduit extends ObjetBDD {
    private String idProduit ;
    private String nom ;
    private double prix ;
    private double benefice ;
    private double prixConseille ;
    private double marge;

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double benefice) {
        this.benefice = benefice;
    }

    public double getPrixConseille() {
        return prixConseille;
    }

    public void setPrixConseille(double prixConseille) {
        this.prixConseille = prixConseille;
    }

    public double getMarge() {
        return marge;
    }

    public void setMarge(double marge) {
        this.marge = marge;
    }

    public BeneficeProduit() {
        this.setNomTable("v_beneficeProduit");
    }
    
    
    
}
