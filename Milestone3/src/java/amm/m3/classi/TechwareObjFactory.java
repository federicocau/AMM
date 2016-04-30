/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.m3.classi;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TechwareObjFactory {
    // Attributi
    private static TechwareObjFactory singleton;
    public static TechwareObjFactory getInstance() {
        if (singleton == null) {
            singleton = new TechwareObjFactory();
        }
        return singleton;
    }
    
    // Lista Oggetti
    private ArrayList<TechwareObject> listaOggetti = new ArrayList<TechwareObject>();
    // Lista Venditori
    private ArrayList<User> listaVenditori = new ArrayList<User>();
    // Lista Clienti
    private ArrayList<User> listaClienti = new ArrayList<User>();
    
    /* Costruttore */
    private TechwareObjFactory() {
        // Oggetto 1        
        TechwareObject oggetto_1 = new TechwareObject();
        oggetto_1.setId(0);
        oggetto_1.setCategoria("RAM");
        oggetto_1.setNome("RAM 4GB DDR3 Hyper");
        oggetto_1.setUrl("http://mla-s2-p.mlstatic.com/memoria-ram-kingston-hyperx-4gb-1600mhz-ddr3-16983-MLA20130684328_072014-F.jpg");
        oggetto_1.setDescrizione("Test ram");
        oggetto_1.setPrezzo(50);
        oggetto_1.setQuantita(5);  
        listaOggetti.add(oggetto_1);
        
        // Oggetto 2
        TechwareObject oggetto_2 = new TechwareObject();
        oggetto_2.setId(1);
        oggetto_2.setCategoria("SSD");
        oggetto_2.setNome("SSD Samsung 500GB");
        oggetto_2.setUrl("http://ecx.images-amazon.com/images/I/419p%2BD3kufL.jpg");
        oggetto_2.setDescrizione("Test SSD");
        oggetto_2.setPrezzo(80);
        oggetto_2.setQuantita(3);
        listaOggetti.add(oggetto_2);
        
        // Oggetto 3 
        TechwareObject oggetto_3 = new TechwareObject();
        oggetto_2.setId(2);
        oggetto_3.setCategoria("Processore");
        oggetto_3.setNome("Processore Intel Core i7");
        oggetto_3.setUrl("http://images.banzaicommerce.it/nobrand/0/HRes/362/101448362/STD101448362-1.jpg");
        oggetto_3.setDescrizione("Test Processore");
        oggetto_3.setPrezzo(110);
        oggetto_3.setQuantita(2);
        listaOggetti.add(oggetto_3);
        
        // Venditore
        Venditore vendor_1 = new Venditore();
        vendor_1.setId(0);
        vendor_1.setUsername("vendor");
        vendor_1.setPassword("0");
        vendor_1.setNome("Max");
        vendor_1.setCognome("Cage");
        vendor_1.setId(0);
        vendor_1.setTipo("venditore");
        vendor_1.setConto(150.02);
        ArrayList<TechwareObject> arrayTechwareObjVendor_1 = new ArrayList<TechwareObject>();
        arrayTechwareObjVendor_1.add(oggetto_1);
        arrayTechwareObjVendor_1.add(oggetto_2);
        vendor_1.setOggettiInVendita(arrayTechwareObjVendor_1);
        listaVenditori.add(vendor_1);
        
        
        // Cliente
        Cliente client_1 = new Cliente();
        client_1.setId(1);
        client_1.setUsername("client");
        client_1.setPassword("1");
        client_1.setNome("Gianni");
        client_1.setCognome("Spano");
        client_1.setId(0);
        client_1.setTipo("cliente");
        client_1.setConto(300.50);
        ArrayList<TechwareObject> arrayTechwareObjClient_1 = new ArrayList<TechwareObject>();
        arrayTechwareObjClient_1.add(oggetto_3);
        client_1.setOggettiDaAcquistare(arrayTechwareObjClient_1);
        listaClienti.add(client_1);

    }
     
    // ricerca oggetto per id
    public TechwareObject getObjectById(int id){
        for(TechwareObject o : listaOggetti)
        {
            if(o.id == id)
                return o;
        }
        
        return null;
    }
    
    // restituisce tutti gli oggetti presenti nel sistema
    public ArrayList<TechwareObject> getSellingObjectList(){
        return listaOggetti;
    }
    

    // restituisce tutti gli oggetti facenti parte di una certa categoria
    public TechwareObject getSellingObjectByCategory(String categoria){
        for(TechwareObject o : listaOggetti)
        {
            if(o.categoria == null ? categoria == null : o.categoria.equals(categoria))
                return o;
        }
        
        return null;
    }
    
    // restituisce tutti gli user
    public ArrayList<User> getUserList() 
    {
        ArrayList<User> listaUtenti = new ArrayList<User>();
        
        listaUtenti.addAll(listaVenditori);
        listaUtenti.addAll(listaClienti);
        
        return listaUtenti;
    }
    
    // restituisce tutti i clienti
    public ArrayList<User> getClienteList()
    {
        return listaClienti;
    }
    
    // restituisce tutti i venditori
    public ArrayList<User> getVenditoriList()
    {
        return listaVenditori;
    }
    
    public User getCliente(int id)
    {
        for(User u : listaClienti)
        {
            if(u.id == id)
                return u;
        }
        
        return null;
    }
    
    public User getVenditore(int id)
    {
        for(User u : listaVenditori)
        {
            if(u.id == id)
                return u;
        }
        
        return null;
    }
    /* implementare altri metodi */
    
    

}