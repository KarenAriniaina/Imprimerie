/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import dao.ObjetBDD;
import java.lang.reflect.Method;
import java.sql.Connection;

/**
 *
 * @author karen
 */
public class Mere extends ObjetBDD {
    private Fille Node;
    private Fille[] ListeFille;

    public Fille getNode() {
        return Node;
    }

    public void setNode(Fille Node) {
        this.Node = Node;
    }

    public Fille[] getListeFille() throws Exception {
        if (ListeFille == null || ListeFille.length == 0) {
            Class cl = Node.getClass();
            String value = null;
            System.out.println("get" + Node.getColumnMere().substring(0, 1).toUpperCase() + Node.getColumnMere().substring(1));
            Method m1 = this.getClass().getMethod("get" + Node.getColumnMere().substring(0, 1).toUpperCase() + Node.getColumnMere().substring(1), null);
            value = (String) m1.invoke(this, null);
            if (value != null) {
                for (Method m2 : cl.getMethods()) {
                    if (m2.getName().equals("set" + Node.getColumnMere().substring(0, 1).toUpperCase() + Node.getColumnMere().substring(1))) {
                        m2.invoke(Node, value);
                        ObjetBDD[] liste = Node.Find(null);
                        ListeFille = new Fille[liste.length];
                        System.arraycopy(liste, 0, ListeFille, 0, liste.length);
                    }
                }

            }
        }
        return ListeFille;
    }

    public void setListeFille(Fille[] ListeFille) {
        this.ListeFille = ListeFille;
    }

    public void AjouterFille(Fille f) {
        Fille[] liste = ListeFille;
        if (liste == null) {
            ListeFille = new Fille[1];
        } else {
            ListeFille = new Fille[liste.length + 1];
            System.arraycopy(liste, 0, ListeFille, 0, liste.length);
        }
        ListeFille[ListeFille.length - 1] = f;
    }
}
