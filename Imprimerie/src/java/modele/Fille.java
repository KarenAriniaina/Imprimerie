/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import dao.ObjetBDD;

/**
 *
 * @author karen
 */
public abstract class Fille extends ObjetBDD{
    
    private String ColumnMere;
    
    public abstract void setColMere();

    public void setColumnMere(String ColumnMere) {
        this.ColumnMere = ColumnMere;
    }

    public String getColumnMere() {
        return ColumnMere;
    }
}
