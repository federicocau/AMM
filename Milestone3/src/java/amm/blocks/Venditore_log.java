/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.blocks;

import amm.m3.classi.TechwareObjFactory;
import amm.m3.classi.TechwareObject;
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
@WebServlet(name = "Venditore_log", urlPatterns = {"/Venditore_log"})
public class Venditore_log extends HttpServlet {

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
        
        // venditore.jsp attraverso url
        request.setAttribute("from_session", true);
        
        HttpSession HttpSession = request.getSession(); // creiamo la nuova sessione
        if(HttpSession.getAttribute("vendor_loggedin")!= null && 
           HttpSession.getAttribute("vendor_loggedin").equals(true))
        {
            // inserimento oggetto
            TechwareObject oggetto = new TechwareObject();
            request.setAttribute("inserito", false);

            if(request.getParameter("Submit") != null){
                String nomeOggetto = request.getParameter("nome_oggetto");
                String urlOggetto = request.getParameter("url_immagine");
                String descrizioneOggetto = request.getParameter("descrizione_oggetto");
                int prezzoOggetto = 0;
                if(Integer.parseInt(request.getParameter("prezzo")) >= 0)
                    prezzoOggetto = Integer.parseInt(request.getParameter("prezzo"));

                int quantitaOggetto = 0;
                if(Integer.parseInt(request.getParameter("quantity")) >= 0)
                    quantitaOggetto = Integer.parseInt(request.getParameter("quantity"));


                // Assegna i dati prelevati
                oggetto.setNome(nomeOggetto);
                oggetto.setUrl(urlOggetto);
                oggetto.setDescrizione(descrizioneOggetto);
                oggetto.setPrezzo(prezzoOggetto);
                oggetto.setQuantita(quantitaOggetto);
                // oggetto inserito
                request.setAttribute("inserito", true);
                // setto l'oggetto che voglio passare alla pagina jsp
                request.setAttribute("oggetto", oggetto);
                
            }
            
            request.setAttribute("venditore", TechwareObjFactory.getInstance().getVenditore((int)HttpSession.getAttribute("id")));
            request.getRequestDispatcher("venditore.jsp").forward(request , response);
        }
        
        // sessione attiva col cliente
        else if(HttpSession.getAttribute("client_loggedin")!= null){
            request.setAttribute("client_on_vendor", true);
            request.getRequestDispatcher("login.jsp").forward(request , response);
        }
        
        // nessuna sessione, click su venditore
        else{    
            request.setAttribute("vendor_click", true);
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
