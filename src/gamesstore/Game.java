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
public class Game extends Product {
    private int idGame;
    private int avaible_for_sell;
    private String year_release; 
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the avaible_for_sell
     */
    public int getAvaible_for_sell() {
        return avaible_for_sell;
    }

    /**
     * @param avaible_for_sell the avaible_for_sell to set
     */
    public void setAvaible_for_sell(int avaible_for_sell) {
        this.avaible_for_sell = avaible_for_sell;
    }

    /**
     * @return the year_release
     */
    public String getYear_release() {
        return year_release;
    }

    /**
     * @param year_release the year_release to set
     */
    public void setYear_release(String year_release) {
        this.year_release = year_release;
    }

    @Override
    public String getManufacturer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setManufacturer(String manufacturer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the idGame
     */
    public int getIdGame() {
        return idGame;
    }

    /**
     * @param idGame the idGame to set
     */
    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }
}
