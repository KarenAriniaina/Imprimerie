/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import dao.ObjetBDD;
import java.sql.Connection;

/**
 *
 * @author itu
 */
public class Produit extends ObjetBDD {

    private String idProduit;
    private String nom;
    private double prix;
    private BeneficeProduit beneficeProduit;

    public Produit[] listProduits(Connection c) throws Exception {
        ObjetBDD[] lp = new Produit().Find(c);
        Produit[] lps = new Produit[lp.length];
        System.arraycopy(lp, 0, lps, 0, lp.length);
        return lps;
    }

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

    public Produit() {
        this.setNomTable("Produit");
        this.setPrimaryKey("idProduit");
    }

    public BeneficeProduit getBeneficeProduit() throws Exception {
        if (beneficeProduit == null) {
            this.beneficeProduit = new BeneficeProduit();
            this.beneficeProduit.setIdProduit(this.getIdProduit());
            ObjetBDD[] lb = this.beneficeProduit.Find(null);
            if (lb.length != 0) {
                this.setBeneficeProduit((BeneficeProduit) lb[0]);
            }
            else beneficeProduit=null;
        }
        return beneficeProduit;
    }

    public void setBeneficeProduit(BeneficeProduit beneficeProduit) {
        this.beneficeProduit = beneficeProduit;
    }

    public void getBenefice() throws Exception {
        this.beneficeProduit = new BeneficeProduit();
        this.beneficeProduit.setIdProduit(this.getIdProduit());
        ObjetBDD[] lb = this.beneficeProduit.Find(null);
        if (lb.length != 0) {
            this.setBeneficeProduit((BeneficeProduit) lb[0]);
        } else {
            throw new Exception("prix hors regle de gestion ");
        }

    }

}
