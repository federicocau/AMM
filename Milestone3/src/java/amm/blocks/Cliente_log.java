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
        
        // cliente.jsp attraverso url
        request.setAttribute("from_session", true);
        HttpSession HttpSession = request.getSession(); // creiamo la nuova sessione
        if(HttpSession.getAttribute("client_loggedin")!= null && 
           HttpSession.getAttribute("client_loggedin").equals(true))
        {
            request.setAttribute("cliente", TechwareObjFactory.getInstance().getCliente((int)HttpSession.getAttribute("id")));
            request.setAttribute("listaOggetti", TechwareObjFactory.getInstance().getSellingObjectList());
            request.setAttribute("selezionato", false);
            
            // se è stato cliccato un oggetto prelevo il suo id 
            if(request.getParameter("oggettoId") != null)
            {
                request.setAttribute("selezionato", true);
                int id = Integer.parseInt(request.getParameter("oggettoId"));
                request.setAttribute("oggetto", TechwareObjFactory.getInstance().getObjectById(id));           
            }

            if(request.getParameter("oggettoId_buy") != null)
            {
                request.setAttribute("selezionato", true);
                int id = Integer.parseInt(request.getParameter("oggettoId_buy"));
                request.setAttribute("oggetto", TechwareObjFactory.getInstance().getObjectById(id));
                
                // setto l'id utente
                int id_cliente = (int)HttpSession.getAttribute("id");
                // prendo il conto del cliente, il prezzo e la quantità dell'oggetto
                int quantità = TechwareObjFactory.getInstance().getObjectById(id).getQuantita();
                double conto = TechwareObjFactory.getInstance().getCliente(id_cliente).getConto();
                double prezzo = TechwareObjFactory.getInstance().getObjectById(id).getPrezzo();

                if(SaldoClientiVenditori.Compra(conto,prezzo) && (quantità > 0))
                {
                    request.setAttribute("comprato", true);
                    double conto_attuale = conto - prezzo;
                    // modifico il conto del cliente e diminuisco la quantità di 1 dell'oggetto
                    TechwareObjFactory.getInstance().getCliente(id_cliente).setConto(conto_attuale);
                    TechwareObjFactory.getInstance().getObjectById(id).setQuantita(quantità -1);      
                }

                // se passo a questo ramo ho due case: o quantità <= 0 oppure il credito è insufficiente
                else
                {   
                    if(quantità <= 0)
                      request.setAttribute("oggetto_esaurito", true); 
                    else
                      request.setAttribute("credito_insufficiente", true);
                }
            }

            request.getRequestDispatcher("cliente.jsp").forward(request , response);
        }
        
        // sessione attiva col venditore
        else if(HttpSession.getAttribute("vendor_loggedin")!= null){
            request.setAttribute("vendor_on_client", true);
            request.getRequestDispatcher("login.jsp").forward(request , response);
        }
        
        // nessuna sessione, click su cliente
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
