/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import dao.Connexion;
import dao.ObjetBDD;
import java.sql.Connection;

/**
 *
 * @author itu
 */
public class Client extends ObjetBDD {
    private String idClient ;
    private String nom ;

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
    
    
    
}
