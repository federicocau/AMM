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
public class Venditore extends User{
    /* Attributi */
    private ArrayList<TechwareObject> oggettiInVendita = new ArrayList<TechwareObject>();
    
    /* Costruttore */
    public Venditore()
    {
        super();
    }

    /**
     * @return the oggettiInVendita
     */
    public ArrayList<TechwareObject> getOggettiInVendita() {
        return oggettiInVendita;
    }

    /**
     * @param oggettiInVendita the oggettiInVendita to set
     */
    public void setOggettiInVendita(ArrayList<TechwareObject> oggettiInVendita) {
        this.oggettiInVendita = oggettiInVendita;
    }
}
