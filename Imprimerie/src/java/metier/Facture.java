/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import dao.Connexion;
import dao.ObjetBDD;
import java.sql.Connection;
import java.sql.Date;
import modele.Fille;
import modele.Mere;

/**
 *
 * @author itu
 */
public class Facture extends Mere {
    private String idFacture ;
    private String idClient ;
    private String NomClient;
    private Date dateFacture ;
    private double grandTotal ;
    private int EtatPaiement ;
    private double montantPaye ;
    private double totalPaye ;
    private double ResteAPaye;

    public String getNomClient() {
        return NomClient;
    }

    public void setNomClient(String NomClient) {
        this.NomClient = NomClient;
    }

    public String getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(String idFacture) {
        this.idFacture = idFacture;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) throws Exception{
        if(idClient.equalsIgnoreCase("")) throw  new Exception("CLient vide");
        this.idClient = idClient;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public int getEtatPaiement() {
        return EtatPaiement;
    }

    public void setEtatPaiement(int EtatPaiement) {
        this.EtatPaiement = EtatPaiement;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(double montantPaye) throws Exception {
        if(montantPaye <= 0){
            throw new Exception("montant paye inferieur ou egale a 0");
        }
        if(montantPaye > this.getResteAPaye()){
            throw new Exception("montant superieur a reste a payer");
        }
        this.montantPaye = montantPaye;
    }

    public double getResteAPaye() {
        return ResteAPaye;
    }

    public void setResteAPaye(double ResteAPaye){
        this.ResteAPaye = ResteAPaye;
    }

    public double getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(double totalPaye) {
        this.totalPaye = totalPaye;
    }
    
    
    public Facture() {
        this.setNomTable("Facture");
        this.setPrimaryKey("idFacture");
        this.setNode(new SousFacture());
    }

    @Override
    public void Create(Connection c) throws Exception {
        boolean nullve=false;
        if(c==null){
            c=new Connexion().getConnection();
            nullve=true;
        }
        this.setEtatPaiement(1);
        this.calculGrandTotal();
        super.Create(c);
        this.setIdFacture("Facture_"+Integer.toString(this.currentSequence(c)));
        for(Fille f : this.getListeFille()){
            SousFacture sf = (SousFacture)f;
            sf.setIdFacture(this.getIdFacture());
            sf.Create(c);
        }
        if(nullve){
            if(c!=null){
                c.commit();
                c.close();
            }
        }
    }
    
    public void calculGrandTotal() throws Exception{
        double total = 0;
        for(Fille f : getListeFille()){
            SousFacture sf = (SousFacture)f ;
            total += sf.getSousTotal();
        }
        this.setGrandTotal(total);
    }
    
    public void getFiche() throws Exception{
        this.setNomTable("v_Facture");
         ObjetBDD[] lf = this.Find(null);
        if(lf.length == 0){
                throw new Exception("facture introuvable");
            }
        Facture f = (Facture)lf[0];
        System.err.println(f.getDateFacture());
        this.setNomClient(f.getNomClient());
        this.setEtatPaiement(f.getEtatPaiement());
        this.setDateFacture(f.getDateFacture());
        this.setIdClient(f.getIdFacture());
        this.setResteAPaye(f.getResteAPaye());
        this.setGrandTotal(f.getGrandTotal());
        this.setTotalPaye(f.getTotalPaye());
    }
    
    public Facture[] getListFactures ( String Nom, Date dateDebut, Date dateFin, int etatPaiement) throws Exception{
        Facture f = new Facture();
        String sql = "SELECT * FROM V_facture WHERE 1 = 1 ";
        if(Nom != null){
            sql += "AND LOWER(NomCLient) like LOWER('%"+Nom+"%') ";
        }
        if(etatPaiement != 0){
            sql += "AND etatPaiement = "+etatPaiement+" ";
        }
        if(dateDebut != null){
            sql += "AND dateFacture >= '"+ dateDebut.toString()+"' ";
        }
        if(dateFin != null){
            sql += "AND dateFacture <= '"+ dateFin.toString()+"' ";
        }
        ObjetBDD[] l = f.Find(null,sql);
        Facture[] lf = new Facture[l.length];
        System.arraycopy(l, 0, lf, 0, lf.length);
        return lf ;
    }
    
    public void payerFacture(double montant) throws Exception{
        this.setNomTable("V_facture");
        this.setIdFacture(this.getIdFacture());
        Connection c = null ;
        try{
            c = new Connexion().getConnection();
            c.setAutoCommit(false);
            ObjetBDD[] lf = this.Find(c);
            if(lf.length == 0){
                throw new Exception("facture introuvable");
            }
            Facture f = (Facture)lf[0];
            this.setResteAPaye(f.getResteAPaye());
            System.err.println("rete="+f.getResteAPaye());
            this.setMontantPaye(montant);
            this.setNomTable("FacturePaiement");
            this.setPrimaryKey("idFacturePaiement");
            super.Create(c);
            this.setResteAPaye(this.getResteAPaye()-this.getMontantPaye());
            if(this.getResteAPaye()==0){
                this.setNomTable("Facture");
                this.setPrimaryKey("idFacture");
                this.setEtatPaiement(2);
                this.Update(c);
            }
            c.commit();
        }
        catch(Exception e){
            if(c != null){
                c.rollback();
            }
            throw e ;
        }
        finally{
            if(c!= null){
                c.close();
            }
        }
               
    }
}