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
public class Fonctionnalite extends ObjetBDD {
   private String idFonctionnalite ;
   private String Designation ;
   private static Fonctionnalite[] ListFonctionnalites ;

    public static Fonctionnalite[] getListFonctionnalites() throws Exception {
        if(Fonctionnalite.ListFonctionnalites == null){
            ObjetBDD[] lf = new Fonctionnalite().Find(null);
            Fonctionnalite.ListFonctionnalites = new Fonctionnalite[lf.length];
            System.arraycopy(lf, 0, Fonctionnalite.ListFonctionnalites, 0, lf.length);
        }
        return ListFonctionnalites;
    }

    public static void setListFonctionnalites(Fonctionnalite[] getListFonctionnalites) {
        Fonctionnalite.ListFonctionnalites = getListFonctionnalites;
    }

    public String getIdFonctionnalite() {
        return idFonctionnalite;
    }

    public void setIdFonctionnalite(String idFonctionnalite) {
        this.idFonctionnalite = idFonctionnalite;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public Fonctionnalite() {
        this.setNomTable("Fonctionnalite");
        this.setPrimaryKey("idFonctionnalite");
    }
    
    
   
   
   
}
