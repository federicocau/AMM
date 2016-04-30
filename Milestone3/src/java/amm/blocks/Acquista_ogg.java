/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.blocks;

import amm.m3.classi.SaldoClientiVenditori;
import amm.m3.classi.TechwareObjFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Acquista_ogg", urlPatterns = {"/Acquista_ogg"})
public class Acquista_ogg extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession HttpSession = request.getSession();
        request.setAttribute("cliente", TechwareObjFactory.getInstance().getCliente((int)HttpSession.getAttribute("id")));
        int id = Integer.parseInt(request.getParameter("oggettoId")); // valore id alunno inserito nell'url controllare se è diverso da null
        request.setAttribute("prezzo_oggetto", TechwareObjFactory.getInstance().getObjectById(id).getPrezzo());
        // trovare un modo per passare anche l'id del cliente
        double conto = TechwareObjFactory.getInstance().getCliente(id).getConto();
        double prezzo = TechwareObjFactory.getInstance().getObjectById(id).getPrezzo();
        boolean compra = false;
        
        if(SaldoClientiVenditori.Compra(conto,prezzo))
            compra = true;

        request.getRequestDispatcher("acquisto_oggetto.jsp").forward(request, response);
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
