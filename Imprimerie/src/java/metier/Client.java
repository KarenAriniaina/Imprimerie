/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import dao.Connexion;
import dao.ObjetBDD;
import java.sql.Connection;
import java.sql.Date;

/**
 *
 * @author itu
 */
public class Client extends ObjetBDD {
    private String idClient ;
    private String nom ;
    private Date DateNaissance;

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Client() {
       this.setNomTable("Client");
       this.setPrimaryKey("idClient");
    }

    public Client[] listClients (Connection c) throws Exception{
        ObjetBDD[] lc = new Client().Find(c);
        Client[] val = new Client[lc.length];
        System.arraycopy(lc, 0, val, 0, lc.length);
        return val ;
    }

    public Date getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(Date DateNaissance) {
        this.DateNaissance = DateNaissance;
    }
    
    public void getClient() throws Exception{
        ObjetBDD[] lc=this.Find(null);
        if(lc.length==0) throw new Exception("Aucun client trouvé");
        Client c=(Client) lc[0];
        this.setNom(c.getNom());
        this.setDateNaissance(c.getDateNaissance());
    }
    
    
}
