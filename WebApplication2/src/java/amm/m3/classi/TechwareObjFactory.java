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
    private static TechwareObjFactory singleton;

    public static TechwareObjFactory getInstance() {
        if (singleton == null) {
            singleton = new TechwareObjFactory();
        }
        return singleton;
    }
    
    // ricerca oggetto per id
    TechwareObject getTechwareObjById(int id){
        TechwareObject oggetto = null;
    
        return oggetto;
    }
    
    // restituisce tutti gli oggetti presenti nel sistema
    ArrayList<TechwareObject> getSellingObjectList(){
        ArrayList<TechwareObject> oggetti = null;
     
        return oggetti;
    }
    
    // restituisce tutti gli oggetti facenti parte di una certa categoria
    ArrayList<TechwareObject> getSellingObjectByCategory(String categoria){
        ArrayList<TechwareObject> oggetti = null;
     
        return oggetti;
    }
    
    /* Costruttore */
    private TechwareObjFactory() {

    }
    
    public ArrayList<User> getUserList() {
        ArrayList<User> listaUtenti = new ArrayList<User>();
        // Oggetto 1        
        TechwareObject oggetto_1 = new TechwareObject();
        oggetto_1.setNome("RAM 4GB DDR3 Hyper");
        oggetto_1.setUrl("http://mla-s2-p.mlstatic.com/memoria-ram-kingston-hyperx-4gb-1600mhz-ddr3-16983-MLA20130684328_072014-F.jpg");
        oggetto_1.setDescrizione("Test ram");
        oggetto_1.setPrezzo(50);
        oggetto_1.setQuantita(5);
        
        // Oggetto 2
        TechwareObject oggetto_2 = new TechwareObject();
        oggetto_2.setNome("SSD Samsung 500GB");
        oggetto_2.setUrl("http://ecx.images-amazon.com/images/I/419p%2BD3kufL.jpg");
        oggetto_2.setDescrizione("Test SSD");
        oggetto_2.setPrezzo(80);
        oggetto_2.setQuantita(3);
        
        // Oggetto 3 
        TechwareObject oggetto_3 = new TechwareObject();
        oggetto_3.setNome("Processore Intel Core i7");
        oggetto_3.setUrl("http://images.banzaicommerce.it/nobrand/0/HRes/362/101448362/STD101448362-1.jpg");
        oggetto_3.setDescrizione("Test Processore");
        oggetto_3.setPrezzo(110);
        oggetto_3.setQuantita(2);

        // Venditore
        Venditore vendor_1 = new Venditore();
        vendor_1.setUsername("SpanoDavide");
        vendor_1.setPassword("0");
        vendor_1.setNome("Davide");
        vendor_1.setCognome("Spano");
        vendor_1.setId(0);
        ArrayList<TechwareObject> arrayTechwareObjVendor_1 = new ArrayList<TechwareObject>();
        arrayTechwareObjVendor_1.add(oggetto_1);
        arrayTechwareObjVendor_1.add(oggetto_2);
        vendor_1.setOggettiInVendita(arrayTechwareObjVendor_1);
        listaUtenti.add(vendor_1);
        
        // Cliente
        Cliente client_1 = new Cliente();
        client_1.setUsername("SpanoDavide");
        client_1.setPassword("0");
        client_1.setNome("Davide");
        client_1.setCognome("Spano");
        client_1.setId(0);
        ArrayList<TechwareObject> arrayTechwareObjClient_1 = new ArrayList<TechwareObject>();
        arrayTechwareObjClient_1.add(oggetto_3);
        client_1.setOggettiDaAcquistare(arrayTechwareObjClient_1);
        listaUtenti.add(vendor_1);
        
        return listaUtenti;
        
    }
}