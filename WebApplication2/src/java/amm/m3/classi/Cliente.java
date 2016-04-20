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
public class Cliente extends User{
    private ArrayList<TechwareObject> oggettiDaAcquistare = new ArrayList<TechwareObject>();

    /**
     * @return the oggettiDaAcquistare
     */
    public ArrayList<TechwareObject> getOggettiDaAcquistare() {
        return oggettiDaAcquistare;
    }

    /**
     * @param oggettiDaAcquistare the oggettiDaAcquistare to set
     */
    public void setOggettiDaAcquistare(ArrayList<TechwareObject> oggettiDaAcquistare) {
        this.oggettiDaAcquistare = oggettiDaAcquistare;
    }
}
