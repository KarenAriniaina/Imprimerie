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
public class Activite extends ObjetBDD {

    private String idActivite;
    private String Designation;
    private double MargeBeneficiaire;
    private double benefice;
    private double pvs;
    private static Activite[] listActivites;
    private V_Masokarena[] listemasokarena; //Liste Revient Salarial
    private DetailActiviteMateriel[] listeMateriel; //Liste Revient Materiel

    public DetailActiviteMateriel[] getListeMateriel() throws Exception {
        if (listeMateriel == null) {
            DetailActiviteMateriel d = new DetailActiviteMateriel();
            d.setIdActivite(this.getIdActivite());
            ObjetBDD[] ld = d.Find(null);
            listeMateriel = new DetailActiviteMateriel[ld.length];
            System.arraycopy(ld, 0, listeMateriel, 0, ld.length);
        }
        return listeMateriel;
    }

    public void setListeMateriel(DetailActiviteMateriel[] listeMateriel) {
        this.listeMateriel = listeMateriel;
    }

    public V_Masokarena[] getListemasokarena() throws Exception {
        if (listemasokarena == null) {
            V_Masokarena v = new V_Masokarena();
            v.setIdActivite(this.getIdActivite());
            ObjetBDD[] lm = v.Find(null);
            listemasokarena = new V_Masokarena[lm.length];
            System.arraycopy(lm, 0, listemasokarena, 0, lm.length);
        }
        return listemasokarena;
    }

    public void setListemasokarena(V_Masokarena[] listemasokarena) {
        this.listemasokarena = listemasokarena;
    }

    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double Benefice) {
        this.benefice = Benefice;
    }

    public double getPvs() {
        return pvs;
    }

    public void setPvs(double pvs) {
        this.pvs = pvs;
    }

    public static Activite[] getListActivites(Connection c) throws Exception {
        if (Activite.listActivites == null) {
            Activite a = new Activite();
            a.setNomTable("v_Benefice");
            ObjetBDD[] la = a.Find(c);
            Activite.listActivites = new Activite[la.length];
            System.arraycopy(la, 0, Activite.listActivites, 0, la.length);
        }
        return listActivites;
    }

    public double getMargeBeneficiaire() {
        return MargeBeneficiaire;
    }

    public void setMargeBeneficiaire(double MargeBeneficiaire) {
        this.MargeBeneficiaire = MargeBeneficiaire;
    }

    public static void setListActivites(Activite[] listActivites) {
        Activite.listActivites = listActivites;
    }

    public String getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(String idActivite) {
        this.idActivite = idActivite;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public Activite() {
        this.setNomTable("Activite");
        this.setPrimaryKey("idactivite");
    }

    public void getActivite() throws Exception {
        Connection con = null;
        try {
            Activite a = new Activite();
            a.setIdActivite(this.getIdActivite());
            a.setNomTable("v_Benefice");
            ObjetBDD[] la = a.Find(con);
            if (la.length == 0) {
                throw new Exception("Aucun service trouve");
            }
            a = (Activite) la[0];
            this.setBenefice(a.getBenefice());
            this.setDesignation(a.getDesignation());
            this.setMargeBeneficiaire(a.getMargeBeneficiaire());
            this.setPvs(a.getPvs());
            con = new Connexion().getConnection();
            DetailActiviteMateriel d = new DetailActiviteMateriel();
            d.setIdActivite(this.getIdActivite());
            ObjetBDD[] ld = d.Find(con);
            listeMateriel = new DetailActiviteMateriel[ld.length];
            System.arraycopy(ld, 0, listeMateriel, 0, ld.length);
            V_Masokarena v = new V_Masokarena();
            v.setIdActivite(this.getIdActivite());
            ObjetBDD[] lm = v.Find(con);
            listemasokarena = new V_Masokarena[lm.length];
            System.arraycopy(lm, 0, listemasokarena, 0, lm.length);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

}
