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
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "LoginPage", urlPatterns = {"/LoginPage"}, loadOnStartup = 0)
public class LoginPage extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";

    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        //String dbConnection = "jdbc:derby://localhost:1527/ammdb";
        //System.out.println(dbConnection);
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex); /* controllare questa riga -> LoginPage*/
        }
        // mettere la nostra factory personale
        TechwareObjFactory.getInstance().setConnectionString(dbConnection);
    }
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
           //  devo controllare se è != null 
           // ripulisco il vecchio vettore
            Venditore.oggettiInVendita.clear();
            User u = TechwareObjFactory.getInstance().getUser(username, password);
            if(u != null)
            {
                    // se abbiamo una sessione precedente attiva la disabilitiamo dato che sono stati inseriti dei dati corretti
                    request.getSession().invalidate();
                    HttpSession = request.getSession();
                    HttpSession.setAttribute("id", u.getId());
                    
                    if(u instanceof Venditore)
                    {
                        HttpSession.setAttribute("vendor_loggedin", true);
                        request.setAttribute("venditore", u);
                        int id_venditore = u.getId();
                        request.setAttribute("listaOggetti", TechwareObjFactory.getInstance().getVenditoreObjectList(id_venditore)); // copiare il nuovo utentifactory
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
