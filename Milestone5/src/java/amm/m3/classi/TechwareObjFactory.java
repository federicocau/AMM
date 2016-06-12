/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.m3.classi;
  
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/*
* Metodi:
    

*/

/**
 *
 * @author Admin
 */
public class TechwareObjFactory {
    // Attributi
    private static TechwareObjFactory singleton;
    String connectionString; /*** indirizzo in cui trovare il database ***/
    public static TechwareObjFactory getInstance() {
        if (singleton == null) {
            singleton = new TechwareObjFactory();
        }
        return singleton;
    }
    
    // Lista Oggetti
    //private ArrayList<TechwareObject> listaOggetti = new ArrayList<TechwareObject>();
    
    
    /* Costruttore */
    private TechwareObjFactory() {
        
    }
     
    // ricerca oggetto per id
    public TechwareObject getObjectById(int id){
        // chiudere le connessioni esterne
        Connection conn = null;
        PreparedStatement stmt = null;
        TechwareObject oggetto = null;
        
        try 
        {
            // path, username, password
            conn = DriverManager.getConnection(connectionString, "root", "root");
            String query = "select * from oggetto "
            + "where id = ?";
            // Prepared Statement
            stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                oggetto = new TechwareObject();
                oggetto.setId(res.getInt("id"));
                oggetto.setCategoria(res.getString("categoria"));
                oggetto.setNome(res.getString("nome"));
                oggetto.setUrl(res.getString("url"));
                oggetto.setDescrizione(res.getString("descrizione"));
                oggetto.setPrezzo(res.getDouble("prezzo"));
                oggetto.setQuantita(res.getInt("quantita"));
                //return oggetto;
            }     
            
            stmt.close();
            conn.close();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return oggetto;
    }
    
    // restituisce tutti gli oggetti presenti nel sistema
    public ArrayList<TechwareObject> getSellingObjectList(){
        // Lista Oggetti
        ArrayList<TechwareObject> listaOggetti = new ArrayList<TechwareObject>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "root", "root");
            Statement stmt = conn.createStatement();
            String query = "select * from oggetto ";
            ResultSet res = stmt.executeQuery(query);

            
             // ciclo sulle righe restituite
            while(res.next()) 
            {
                TechwareObject oggetto = new TechwareObject();
                oggetto.setId(res.getInt("id"));
                oggetto.setCategoria(res.getString("categoria"));
                oggetto.setNome(res.getString("nome"));
                oggetto.setUrl(res.getString("url"));
                oggetto.setDescrizione(res.getString("descrizione"));
                oggetto.setPrezzo(res.getDouble("prezzo"));
                oggetto.setQuantita(res.getInt("quantita"));
                listaOggetti.add(oggetto);
            }  
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaOggetti;
    }
    
    
    // Restituisce la lista di tutti gli oggetti il cui nome e descrizione contiene la stringa in input
    public ArrayList<TechwareObject> getSellingObjectList(String text)
    {
        // Lista Oggetti
        ArrayList<TechwareObject> listaOggetti = new ArrayList<TechwareObject>();
        
        try
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "root", "root");
            String query = "select *" +
                           "from oggetto " + 
                           "where nome LIKE ? OR descrizione LIKE ?";         
            PreparedStatement stmt = conn.prepareStatement(query);
            // Assegna dati
            text = "%"+text+"%";
            stmt.setString(1, text);
            stmt.setString(2, text);
            ResultSet res = stmt.executeQuery();
            
            while(res.next())
            {
                TechwareObject oggetto = new TechwareObject();
                oggetto.setId(res.getInt("id"));
                oggetto.setCategoria(res.getString("categoria"));
                oggetto.setNome(res.getString("nome"));
                oggetto.setUrl(res.getString("url"));
                oggetto.setDescrizione(res.getString("descrizione"));
                oggetto.setPrezzo(res.getDouble("prezzo"));
                oggetto.setQuantita(res.getInt("quantita"));
                listaOggetti.add(oggetto);
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return listaOggetti;
    }
    
    // restituisce tutti gli oggetti appartenenti ad un venditore
    public ArrayList<TechwareObject> getVenditoreObjectList(int id_venditore){
        // Lista Oggetti
        ArrayList<TechwareObject> oggettiInVendita = new ArrayList<TechwareObject>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "root", "root");

            String query = "SELECT * "
                        + "FROM oggetto "
                        + "JOIN venditore ON venditore.id = oggetto.venditore_id "
                        + "WHERE oggetto.venditore_id = " + id_venditore;
                Statement st = conn.createStatement();
                ResultSet set2 = st.executeQuery(query);
                // ripulisco l'array per non avere oggetti duplicati
                
                while(set2.next()){
                    TechwareObject oggetto = new TechwareObject();
                    oggetto.setId(set2.getInt("id"));
                    oggetto.setCategoria(set2.getString("categoria"));
                    oggetto.setNome(set2.getString("nome"));
                    oggetto.setUrl(set2.getString("url"));
                    oggetto.setDescrizione(set2.getString("descrizione"));
                    oggetto.setPrezzo(set2.getDouble("prezzo"));
                    oggetto.setQuantita(set2.getInt("quantita"));
                    oggettiInVendita.add(oggetto);         
                }
                st.close();
                conn.close();  
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return oggettiInVendita;
    }
    
    // restituisce tutti gli oggetti appartenenti ad un venditore
    public boolean checkVenditoreObject(int id_venditore, int id_oggetto){
        boolean flag = false;
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "root", "root");

            String query = "SELECT * "
                        + "FROM oggetto "
                        + "JOIN venditore ON venditore.id = oggetto.venditore_id "
                        + "WHERE oggetto.venditore_id = " + id_venditore
                        + "AND oggetto.id = " + id_oggetto;
            Statement st = conn.createStatement();
            // conto le righe brutalmente
            int rows=0;
            ResultSet set2 = st.executeQuery(query);
   
            while(set2.next()){
                rows++;
            }

            if(rows == 1)
                    flag = true;
            st.close();
            conn.close();
                  
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return flag;
    }
    
    // elimina un oggetto  
    public boolean eliminaOggetto(int id_oggetto){
        boolean flag = false;
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "root", "root");

            String query = "DELETE FROM oggetto "
                         + "WHERE id = " + id_oggetto;
            Statement st = conn.createStatement();
            // conto le righe brutalmente
            int rows = st.executeUpdate(query);

            if(rows == 1)
               flag = true;
            st.close();
            conn.close();
                  
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return flag;
    }
     
    // elimina un oggetto  
    public boolean modificaOggetto(TechwareObject oggetto) {
        boolean flag = false;
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "root", "root");
            String query = "UPDATE oggetto SET nome = ? , url = ? , descrizione = ?, prezzo = ?, quantita = ? WHERE id = ?";

            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, oggetto.nome);
            st.setString(2, oggetto.url);
            st.setString(3, oggetto.descrizione);
            st.setDouble(4, oggetto.prezzo);
            st.setInt(5, oggetto.quantita);
            st.setInt(6, oggetto.id);
            // conto le righe brutalmente
            int rows = st.executeUpdate();

            if(rows == 1)
               flag = true;
            st.close();
            conn.close();
                  
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return flag;
    }
    
    // elimina un oggetto  
    public boolean inserisciOggetto(TechwareObject oggetto, int id_venditore){
        boolean flag = false;
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "root", "root");
             
            String query = "INSERT INTO oggetto (id, categoria, nome, url, descrizione, prezzo, quantita, venditore_id ) VALUES "
                         + " (default, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, "none");
            st.setString(2, oggetto.nome);
            st.setString(3, oggetto.url);
            st.setString(4, oggetto.descrizione);
            st.setDouble(5, oggetto.prezzo);
            st.setInt(6, oggetto.quantita);
            st.setInt(7, id_venditore);
            // conto le righe brutalmente
            int rows = st.executeUpdate();

            if(rows == 1)
               flag = true;
            st.close();
            conn.close();
                  
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return flag;
    }
    

    // restituisce tutti gli oggetti facenti parte di una certa categoria
    /*public TechwareObject getSellingObjectByCategory(String categoria){
        for(TechwareObject o : listaOggetti)
        {
            if(o.categoria == null ? categoria == null : o.categoria.equals(categoria))
                return o;
        }
        
        return null;
    }*/
    
    // restituisce un utente
    public User getUser(String username, String password) 
    {
        try{
            Connection conn = DriverManager.getConnection(connectionString, "root", "root");
            String query = "select * from venditore where " + "username = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            // Esecuzione query
            ResultSet set = stmt.executeQuery();
            
            
             // ciclo sulle righe restituite
            if(set.next()) 
            {
                Venditore venditore = new Venditore();
                venditore.id = (set.getInt("id"));
                venditore.nome = (set.getString("nome"));
                venditore.cognome = (set.getString("cognome"));
                venditore.username = (set.getString("username"));
                venditore.password = (set.getString("password"));
                venditore.tipo = (set.getString("tipo"));
                venditore.conto = (set.getDouble("conto"));
                
                // query oggetti assegnati
                query = "SELECT * "
                        + "FROM oggetto "
                        + "JOIN venditore ON venditore.id = oggetto.venditore_id "
                        + "WHERE oggetto.venditore_id = " + venditore.id;
                Statement st = conn.createStatement();
                ResultSet set2 = st.executeQuery(query);
                // ripulisco l'array per non avere oggetti duplicati
                
                while(set2.next()){
                    TechwareObject oggetto = new TechwareObject();
                    oggetto.setId(set2.getInt("id"));
                    oggetto.setCategoria(set2.getString("categoria"));
                    oggetto.setNome(set2.getString("nome"));
                    oggetto.setUrl(set2.getString("url"));
                    oggetto.setDescrizione(set2.getString("descrizione"));
                    oggetto.setPrezzo(set2.getDouble("prezzo"));
                    oggetto.setQuantita(set2.getInt("quantita"));
                    venditore.oggettiInVendita.add(oggetto);         
                }
                st.close();
                stmt.close();
                conn.close();
                
                return venditore;
            }
            
            query = "select * from cliente where " + "username = ? and password = ?";
            stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            // Esecuzione query
            set = stmt.executeQuery();
            
            
             // ciclo sulle righe restituite
            if(set.next()) 
            {
                Cliente cliente = new Cliente();
                cliente.id = (set.getInt("id"));
                cliente.nome = (set.getString("nome"));
                cliente.cognome = (set.getString("cognome"));
                cliente.username = (set.getString("username"));
                cliente.password = (set.getString("password"));
                cliente.tipo = (set.getString("tipo"));
                cliente.conto = (set.getDouble("conto"));
                stmt.close();
                conn.close();
                
                return cliente;
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException e) 
        {
            System.out.println(e.toString()+"________");
            e.printStackTrace();
        }
        return null;
    }
    
    
    public User getVenditore(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "root", "root");
            // Query
            String query = "select * from venditore "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet set = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(set.next()) 
            {
                Venditore venditore = new Venditore();
                venditore.id = (set.getInt("id"));
                venditore.nome = (set.getString("nome"));
                venditore.cognome = (set.getString("cognome"));
                venditore.username = (set.getString("username"));
                venditore.password = (set.getString("password"));
                venditore.tipo = (set.getString("tipo"));
                venditore.conto = (set.getDouble("conto"));
                
                // query oggetti assegnati
                query = "SELECT * "
                        + "FROM oggetto "
                        + "JOIN venditore ON venditore.id = oggetto.venditore_id "
                        + "WHERE oggetto.venditore_id = " + venditore.id;
                Statement st = conn.createStatement();
                ResultSet set2 = st.executeQuery(query);
                while(set2.next()){
                    TechwareObject oggetto = new TechwareObject();
                    oggetto.setId(set2.getInt("id"));
                    oggetto.setCategoria(set2.getString("categoria"));
                    oggetto.setNome(set2.getString("nome"));
                    oggetto.setUrl(set2.getString("url"));
                    oggetto.setDescrizione(set2.getString("descrizione"));
                    oggetto.setPrezzo(set2.getDouble("prezzo"));
                    oggetto.setQuantita(set2.getInt("quantita"));
                    venditore.oggettiInVendita.add(oggetto);         
                }
                st.close();
                stmt.close();
                conn.close();
                
                return venditore;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    // restituisce tutti i venditori
    public ArrayList<Venditore> getVenditoriList()
    {
        ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "root", "root");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "venditore'";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()) 
            {
                Venditore venditore = new Venditore();
                venditore.id = (set.getInt("id"));
                venditore.nome = (set.getString("nome"));
                venditore.cognome = (set.getString("cognome"));
                venditore.username = (set.getString("username"));
                venditore.password = (set.getString("password"));
                venditore.tipo = (set.getString("tipo"));
                venditore.conto = (set.getDouble("conto"));
                listaVenditori.add(venditore);
            } 
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaVenditori;
    }
    
    public User getCliente(int id)
    {
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "root", "root");
            String query = "select * from cliente "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            
             // ciclo sulle righe restituite
            if(res.next()) 
            {
                Cliente current = new Cliente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setTipo(res.getString("tipo"));
                current.setConto(res.getDouble("conto"));
                stmt.close();
                conn.close();   
                return current;
            } 
            
                stmt.close();
                conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    
    // restituisce tutti i clienti
    public ArrayList<Cliente> getClienteList()
    {
        
        ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
        try 
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "root", "root");
            Statement stmt = conn.createStatement();
            String query = "select * from cliente";
            ResultSet res = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(res.next()) 
            {
                Cliente current = new Cliente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setTipo(res.getString("tipo"));
                current.setConto(res.getDouble("conto"));
                listaClienti.add(current);
            }     
            
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaClienti;
    }
    
    
    /* implementare altri metodi */
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
  
    
    

}