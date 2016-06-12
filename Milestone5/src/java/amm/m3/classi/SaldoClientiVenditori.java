/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.m3.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class SaldoClientiVenditori extends User{
     
    /**
     *
     * @param conto
     * @param prezzo
     * @return
     */
    public static boolean Compra(double conto, double prezzo){
        if( (conto - prezzo) >= 0 )
            return true;
        else
            return false;
    }
    
    public static int CompraOggetto(int id_cliente, double conto_cliente, int id_oggetto, int quantita_ogg, double prezzo_ogg) throws SQLException{
        
        Connection conn = DriverManager.getConnection(TechwareObjFactory.getInstance().getConnectionString(), "root", "root");
        
        PreparedStatement getContoVenditore = null;
        PreparedStatement updateOggetto = null;
        PreparedStatement updateContoCliente = null;
        PreparedStatement updateContoVenditore = null;
        
        // variabili per il venditore
        int id_venditore=0;
        double conto_venditore=0;
        // variabile per la modifica dell'oggetto
        String modificaOggetto = null;
        String contoVenditore = null;
        // variabile per la modifica del conto del cliente
        String modificaContoCliente = null;
        // variabile per la modifica del conto del venditore
        String modificaContoVenditore = null;
        // select sui conti aggiornati
        double newContoCliente = 0;
        double newContoVenditore = 0;
        // flag per i parametri '?' della query
        int unico = 0;
        
        // questo pezzo di codice non dovrebbe mai essere eseguito        
        if(quantita_ogg <= 0){
            conn.rollback();
            return 1; // 1 = nessun oggetto
        }
      
        // STEP 1
        // prelevo il conto del venditore tramite l'id dell'oggetto (prima che venga eliminato; prelevo anche l'id)
        contoVenditore = "SELECT venditore.id, venditore.conto "
                        + "FROM venditore "
                        + "JOIN oggetto ON oggetto.venditore_id = venditore.id "
                        + "WHERE oggetto.id = " + id_oggetto;
        
        // prelevo i dati dal venditore
        getContoVenditore = conn.prepareStatement(contoVenditore);
        ResultSet set = getContoVenditore.executeQuery();
        if(set.next()){
            id_venditore = (set.getInt("id"));
            conto_venditore = (set.getDouble("conto"));
        }

        
        // se l'oggetto è unico
        if (quantita_ogg == 1){
            unico = 1;
            modificaOggetto = "DELETE FROM oggetto "
                            + "WHERE id = ?"; //+ id_oggetto;
        }
        
        // se ci sono pià copie dell'oggetto
        else{
            // decremento di 1 la quantità dell'oggetto
            quantita_ogg--;
            modificaOggetto = "UPDATE oggetto "
                        + "SET quantita = ? " // + quantita_ogg
                        + "WHERE id = ?";// + id_oggetto;
        }
      
        // STEP 2
        newContoCliente = conto_cliente - prezzo_ogg;
        
        // se la sottrazione è andata a buon fine
        if(newContoCliente >= 0){
            modificaContoCliente = "UPDATE cliente "
                        + "SET conto = ? " //+ newContoCliente
                        + "WHERE id = ?";// + id_cliente;
        }
        
        else{
            conn.rollback();
            return 2; // 2 = credito non disponibile
        }
            
            
        // STEP 3
        newContoVenditore = conto_venditore + prezzo_ogg;
        modificaContoVenditore = "UPDATE venditore "
                        + "SET conto = ? " //+ newContoVenditore
                        + "WHERE id = ?";// + id_venditore;  
              
        try{
            conn.setAutoCommit(false);
            
            updateOggetto = conn.prepareStatement(modificaOggetto);
            updateContoCliente = conn.prepareStatement(modificaContoCliente);
            updateContoVenditore = conn.prepareStatement(modificaContoVenditore);
            
            if(unico == 1)
                updateOggetto.setInt(1, id_oggetto);
            else{
                updateOggetto.setInt(1, quantita_ogg);
                updateOggetto.setInt(2, id_oggetto);
            }
            
            updateContoCliente.setDouble(1, newContoCliente);
            updateContoCliente.setInt(2, id_cliente);
            updateContoVenditore.setDouble(1, newContoVenditore);
            updateContoVenditore.setDouble(2, id_venditore);

            // numero di righe affette dalla query
            int q1 = updateOggetto.executeUpdate();
            int q2 = updateContoCliente.executeUpdate();
            int q3 = updateContoVenditore.executeUpdate();
            
            if(q1 != 1 || q2 != 1 || q3 != 1)
               conn.rollback();
            
            // se non ci sono errori
            conn.commit();
        }
        catch (SQLException e) 
        {   //rollback
            try{
                conn.rollback();
                return 3; // 3 = errore SQL
            
            }
            catch(SQLException e2) 
            {
                
            }
        }
        finally{
            if(updateOggetto != null)
                updateOggetto.close();
            if(updateContoCliente != null)
                 updateContoCliente.close();
            if(updateContoVenditore != null)
                 updateContoVenditore.close();
            
            conn.setAutoCommit(true);
            conn.close();

        }
        
        return 0;
    }
       
}
 