/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import dao.ObjetBDD;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author itu
 */
public class Employe extends ObjetBDD {
    private String idEmploye ;
    private String Nom;
    private String Prenom ;
    private Date DateNaissance ;
    private String idGenre ;

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public Date getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(Date DateNaissance) throws Exception  {
        int age = Date.valueOf(LocalDate.now()).getYear() - DateNaissance.getYear();
        if(age < 18){
            throw new Exception("vous etes trop jeunes");
        }
        this.DateNaissance = DateNaissance;
    }

    public String getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(String idGenre) {
        this.idGenre = idGenre;
    }

    public Employe() {
        this.setNomTable("employe");
        this.setPrimaryKey("idEmploye");
    }
    
    
    
}
