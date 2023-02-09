package view;

import dao.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import metier.Employe;
import metier.Genre;
import metier.Fonctionnalite;
import metier.FonctionnaliteEmploye;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author itu
 */
public class InsertionEmp {

    private String nom;
    private String prenom;
    private String sdateNaissance;
    private Date dateNaissance;
    private int genre;
    private int fonctionnalite;
    private String sgenre;
    private String sfonctionnalite;

    public String getSgenre() {
        return sgenre;
    }

    public void setSgenre(String sgenre) throws Exception {
        if (sgenre == null) {
            throw new Exception("select genre vide");
        }
        if (sgenre.equals("")) {
            throw new Exception("select genre vide");
        }
        this.sgenre = sgenre;
    }

    public String getSfonctionnalite() {
        return sfonctionnalite;
    }

    public void setSfonctionnalite(String sfonctionnalite) throws Exception {
        if (sfonctionnalite == null) {
            throw new Exception("select fonctionnalite vide");
        }
        if (sfonctionnalite.equals("")) {
            throw new Exception("select fonctionnalite vide");
        }
        this.sfonctionnalite = sfonctionnalite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
        if (nom == null) {
            throw new Exception("input nom vide");
        }
        if (nom.equals("")) {
            throw new Exception("input nom vide");
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws Exception {
        if (prenom == null) {
            throw new Exception("input prenom vide");
        }
        if (nom.equals("")) {
            throw new Exception("input prenom vide");
        }
        this.prenom = prenom;
    }

    public String getSdateNaissance() {
        return sdateNaissance;
    }

    public void setSdateNaissance(String sdateNaissance) throws Exception {
        if (sdateNaissance == null) {
            throw new Exception("select date de naissance vide");
        }
        if (sdateNaissance.equals("")) {
            throw new Exception("select date de naissance vide");
        }
        this.sdateNaissance = sdateNaissance;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) throws Exception {
        try {
            this.dateNaissance = Date.valueOf(dateNaissance);

        } catch (Exception e) {
            throw new Exception("exception format date");
        }
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(String genre) throws Exception {
        if (genre == null) {
            throw new Exception("select  genre vide");
        }
        try {
            this.genre = Integer.valueOf(genre);
        } catch (Exception e) {
            throw new Exception("Input genre erreur");
        }
    }

    public int getFonctionnalite() {
        return fonctionnalite;
    }

    public void setFonctionnalite(String fonctionnalite) throws Exception {
        if (fonctionnalite == null) {
            throw new Exception("select fonctionnalite vide");
        }
        try {
            this.fonctionnalite = Integer.valueOf(fonctionnalite);
        } catch (Exception e) {
            throw new Exception("Input fonctionnalite erreur");
        }
    }

    public InsertionEmp(String nom, String prenom, String sdateNaissance, String genre, String fonctionnalite) throws Exception {
        setNom(nom);
        setPrenom(prenom);
        setSfonctionnalite(fonctionnalite);
        setSgenre(genre);
        setFonctionnalite(fonctionnalite);
        setSdateNaissance(sdateNaissance);
        setGenre(genre);
        setDateNaissance(sdateNaissance);
    }

    public void insererEmp() throws Exception {
        Connection con = null;
        try {
            con = new Connexion().getConnection();
            con.setAutoCommit(false);
            Employe e = new Employe();
            e.setNom(nom);
            e.setPrenom(prenom);
            e.setDateNaissance(dateNaissance);
            e.setIdGenre(Genre.getListGenres()[genre].getIdGenre());
            e.Create(con);
            String currentEmp = Integer.toString(e.currentSequence(con));
            FonctionnaliteEmploye fe = new FonctionnaliteEmploye();
            fe.setIdEmploye("employe_" + currentEmp);
            fe.setIdFonctionnalite(Fonctionnalite.getListFonctionnalites()[fonctionnalite].getIdFonctionnalite());
            fe.Create(con);
            con.commit();
        } catch (Exception ex) {
            if (con != null) {
                con.rollback();
            }
            throw ex;
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

}
