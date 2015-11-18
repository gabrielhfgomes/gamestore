/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesstore;

/**
 *
 * @author s2it_ggomes
 */
public class Seller extends Employee {
    private int idSeller;
    private float comission;

    /**
     * @return the comission
     */
    public float getComission() {
        return comission;
    }

    /**
     * @param comission the comission to set
     */
    public void setComission(float comission) {
        this.comission = comission;
    }

    /**
     * @return the idSeller
     */
    public int getIdSeller() {
        return idSeller;
    }

    /**
     * @param idSeller the idSeller to set
     */
    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }
    
    
    
}
