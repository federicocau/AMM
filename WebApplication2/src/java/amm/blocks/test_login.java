/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.blocks;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SimpleRegistration", urlPatterns = {"/test_login.html"}) // nome della pagina html (aggancio un Servlet ad un URL sul file .xml)
public class test_login extends HttpServlet {

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
        // forziamo il lancio di un eccezione
        /*
        if(true)
            throw new ServletException();*/
        
        // Step 2
        /*
        Esame esame = new Esame();
        boolean registrato = false;
        // Lettura dati
        if (request.getParameter("registra") != null) { // parametro impostato quando viene premuto il bottone submit
            // Preleva i dati inviati
            String nomeStudente = request.getParameter("NomeStudente");
            String cognomeStudente = request.getParameter("CognomeStudente");
            String matricola = "";
            if(Integer.parseInt(request.getParameter("Matricola")) > 0) // trasformo la Stringa in un intero se matricola > 0
                matricola = request.getParameter("Matricola");
                // ramo else con un messaggio per l'utente, esempio: "Il formato della matricola non è corretto" 
                // oppure cambiando il colore del bordo della label del dato errato
            String nomeEsame = request.getParameter("ListaEsami");
            String voto = "";
            if(Integer.parseInt(request.getParameter("Voto")) > 0)
                voto = request.getParameter("Voto");
            String commentoProf = request.getParameter("Note");
            
            // Assegna i dati prelevati
            esame.setNomeStudente(nomeStudente);
            esame.setCognomeStudente(cognomeStudente);
            esame.setMatricolaStudente(matricola);
            esame.setNomeEsame(nomeEsame);
            esame.setVoto(voto);
            esame.setNota(commentoProf);
            // Esame registrato
            registrato = true;
        }*/
        
        
        // Step 1
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Registrazione esami veloce</title></head>");
            out.println("<body>");
            out.println("<h1> Registrazione Esami Triennale e Magistrale </h1>");
            
            // Step 3
            /*
            if (registrato) {
                out.println("<div>");
                out.println("<p><strong>Registrazione completata con successo</strong></p>");
                out.println("<p>Nome studente:" + esame.getNomeStudente() + "</p>");
                out.println("<p>Cognome studente:" + esame.getCognomeStudente() + "</p>");
                out.println("<p>Matricola studente:" + esame.getMatricolaStudente() + "</p>");
                out.println("<p>Esame:" + esame.getNomeEsame() + "</p>");
                out.println("<p>Voto:" + esame.getVoto() + "</p>");
                out.println("<p>Commento:" + esame.getNota() + "</p>");
                out.println("</div>");
            }*/
            
            // action = "<nome della url patterns>"
            out.println("<form method=\"post\" action=\"simpleregistration.html\">");
            out.println("  <div>");
            out.println("    <label for=\"NomeStudente\">Nome</label>");
            out.println("   <input type=\"text\" name=\"NomeStudente\" id=\"NomeStudente\" />");
            out.println("</div>");
            out.println("<div>");
            out.println("    <label for=\"CognomeStudente\">Cognome</label>");
            out.println("    <input type=\"text\" name=\"CognomeStudente\" id=\"CognomeStudente\" />");
            out.println("</div>");
            out.println("<div>");
            out.println("    <label for=\"Matricola\">Matricola</label>");
            out.println("    <input type=\"number\" name=\"Matricola\" id=\"Matricola\" /> ");
            out.println("</div>");
            out.println("<div>");
            out.println("    <label for=\"NomeEsame\">Nome Esame</label>");
            out.println("  <select name=\"ListaEsami\" id=\"ListaEsami\">");
            out.println("          <option value=\"PR1\">Programmazione 1</option>");
            out.println("           <option value=\"PR2\">Programmazione 2</option>");
            out.println("           <option value=\"AMM\">Amministrazione di Sistema</option>");
            out.println("           <option value=\"EAI\">Elaborazione di Immagini</option>");
            out.println("           <option value=\"FS\">Fondamenti di Sistema</option>");
            out.println("           <option value=\"ARE2\">Are 2</option>");
            out.println("</select>");
            out.println("</div>");
            out.println("<div>");
            out.println("    <label for=\"Voto\">Voto</label>");
            out.println("    <input type=\"range\" min=18 max=31 name=\"Voto\" id=\"Voto\" /> ");
            out.println("</div>");
            out.println("<div>");
            out.println("    <label for=\"Note\">Note</label>");
            out.println("    <textarea name=\"Note\" id=\"Note\" ></textarea>");
            out.println("</div>");
            out.println("<button type=\"submit\" name=\"registra\">Registra</button>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            out.close();
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
