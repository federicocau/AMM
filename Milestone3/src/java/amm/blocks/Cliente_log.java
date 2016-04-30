/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.blocks;

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
@WebServlet(name = "Cliente_log", urlPatterns = {"/Cliente_log"})
public class Cliente_log extends HttpServlet {

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
        
        HttpSession HttpSession = request.getSession(); // creiamo la nuova sessione
        if(HttpSession.getAttribute("client_loggedin")!= null && 
           HttpSession.getAttribute("client_loggedin").equals(true) &&
           HttpSession.getAttribute("vendor_loggedin")== null)
        {
            request.setAttribute("cliente", TechwareObjFactory.getInstance().getCliente((int)HttpSession.getAttribute("id")));
            request.setAttribute("listaOggetti", TechwareObjFactory.getInstance().getSellingObjectList());
            request.getRequestDispatcher("cliente.jsp").forward(request , response);
        }
        
        else if(HttpSession.getAttribute("vendor_loggedin")!= null){
            request.setAttribute("vendor_on_client", true);
            request.getRequestDispatcher("login.jsp").forward(request , response);
        }
        
        else{    
            request.setAttribute("client_click", true);
            request.getRequestDispatcher("login.jsp").forward(request , response);
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
