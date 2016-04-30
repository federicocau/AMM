/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.m3.classi;

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
    
}
