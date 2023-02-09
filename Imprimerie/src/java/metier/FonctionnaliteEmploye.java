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
public class FonctionnaliteEmploye extends ObjetBDD {
    private String idFonctionnaliteEmploye ;
    private String idFonctionnalite ;
    private String idEmploye;

    public String getIdFonctionnaliteEmploye() {
        return idFonctionnaliteEmploye;
    }

    public void setIdFonctionnaliteEmploye(String idFonctionnaliteEmploye) {
        this.idFonctionnaliteEmploye = idFonctionnaliteEmploye;
    }

    public String getIdFonctionnalite() {
        return idFonctionnalite;
    }

    public void setIdFonctionnalite(String idFonctionnalite) {
        this.idFonctionnalite = idFonctionnalite;
    }

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }

    public FonctionnaliteEmploye() {
        this.setNomTable("fonctionnaliteEmploye");
        this.setPrimaryKey("idFonctionnaliteEmploye");
    }
    
    
    
    
}

