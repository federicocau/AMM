/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.blocks;

import amm.m3.classi.User;
import amm.m3.classi.TechwareObjFactory;
import amm.m3.classi.Venditore;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "LoginPage", urlPatterns = {"/LoginPage"})
public class LoginPage extends HttpServlet {

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
        
        // login.jsp attraverso url
        request.setAttribute("from_session", true);
        
        HttpSession HttpSession = request.getSession(); 
        // controllo se è presente una sessione precedente fatta col cliente
        if(HttpSession.getAttribute("client_loggedin")!= null && 
           HttpSession.getAttribute("client_loggedin").equals(true) &&
           (request.getParameter("Submit") == null) )
        {
            request.setAttribute("cliente", TechwareObjFactory.getInstance().getCliente((int)HttpSession.getAttribute("id")));
            request.setAttribute("listaOggetti", TechwareObjFactory.getInstance().getSellingObjectList());
            request.getRequestDispatcher("cliente.jsp").forward(request , response);
        }
        
        // controllo se è presente una sessione precedente fatta col venditore
        else 
           if(  HttpSession.getAttribute("vendor_loggedin")!= null && 
                HttpSession.getAttribute("vendor_loggedin").equals(true)&&
                (request.getParameter("Submit") == null) )        
            {
                request.setAttribute("venditore", TechwareObjFactory.getInstance().getVenditore((int)HttpSession.getAttribute("id")));
                request.getRequestDispatcher("venditore.jsp").forward(request , response);
            }

        // altrimenti è il primo login e controllo che i campi non siano vuoti
        if(request.getParameter("Submit") != null){
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
           //  devo controllare se sono null 
            ArrayList<User> listaUtenti = TechwareObjFactory.getInstance().getUserList();
            for(User u: listaUtenti)
            {
                if(u.getUsername().equals(username) && 
                   u.getPassword().equals(password) ){
                    
                    // se abbiamo una sessione precedente attiva la disabilitiamo dato che sono stati inseriti dei dati corretti
                    request.getSession().invalidate();
                    HttpSession = request.getSession();
                    HttpSession.setAttribute("id", u.getId());
                    
                    if(u instanceof Venditore)
                    {
                        HttpSession.setAttribute("vendor_loggedin", true);
                        request.setAttribute("venditore", u);
                        request.setAttribute("listaOggetti", TechwareObjFactory.getInstance().getSellingObjectList()); // copiare il nuovo utentifactory
                        request.getRequestDispatcher("venditore.jsp").forward(request , response);    
                    }
                    
                    else
                    {
                        HttpSession.setAttribute("client_loggedin", true);
                        request.setAttribute("cliente", u);
                        request.setAttribute("listaOggetti", TechwareObjFactory.getInstance().getSellingObjectList());
                        request.getRequestDispatcher("cliente.jsp").forward(request , response);
                    }
                }
            }
            
            // se i dati inseriti sono errati setto la variabile error a true
            request.setAttribute("error", true);
  
        } 

        request.getRequestDispatcher("login.jsp").forward(request , response);
        
        

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
