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
public class Chips extends Product {
    private int idChip;
    private float weight;   
    private String type;
    
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }
    @Override
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    /**
     * @return the idChip
     */
    public int getIdChip() {
        return idChip;
    }

    /**
     * @param idChip the idChip to set
     */
    public void setIdChip(int idChip) {
        this.idChip = idChip;
    }
}
