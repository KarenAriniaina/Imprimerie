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
public class Genre extends ObjetBDD {
    private String idGenre ;
    private String Designation ;
    private static Genre[] listGenres ;

    public static Genre[] getListGenres() throws Exception{
        if(Genre.listGenres == null){
            ObjetBDD[] lg = new Genre().Find(null);
            Genre.listGenres = new Genre[lg.length];
            System.arraycopy(lg, 0, Genre.listGenres, 0, lg.length);
        }
        return listGenres;
    }

    public static void setListGenres(Genre[] listGenres) {
        Genre.listGenres = listGenres;
    }

    public String getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(String idGenre) {
        this.idGenre = idGenre;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public Genre() {
        this.setNomTable("Genre");
        this.setPrimaryKey("idGenre");
    }
    
    
    
    
}
