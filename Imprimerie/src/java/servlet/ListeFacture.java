/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Client;
import metier.Facture;

/**
 *
 * @author Ari
 */
public class ListeFacture extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idCLient=null;
        Date datemin=null;
        Date datemax=null;
        int statut=0;
        try {
            if(request.getParameter("NomClient")!=null && !request.getParameter("NomClient").equalsIgnoreCase("")) idCLient=request.getParameter("NomClient");
            if(request.getParameter("datemin")!=null && !request.getParameter("datemin").equalsIgnoreCase("")) datemin=Date.valueOf(request.getParameter("datemin"));
            if(request.getParameter("datemax")!=null && !request.getParameter("datemax").equalsIgnoreCase("")) datemax=Date.valueOf(request.getParameter("datemax"));
            if(request.getParameter("Statut")!=null && !request.getParameter("Statut").equalsIgnoreCase("")) statut=Integer.valueOf(request.getParameter("Statut"));
            request.setAttribute("lc", new Client().listClients(null));
            Facture f=new Facture();
            request.setAttribute("lf", f.getListFactures(idCLient, datemin, datemax,statut));
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            RequestDispatcher dispat = request.getRequestDispatcher("ListeFacture.jsp");
            dispat.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
