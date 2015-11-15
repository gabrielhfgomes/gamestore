/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesstore;

/**
 *
 * @author gabri
 */
public class Sell {
    private int idSell;
    private int idGame;
    private int idClient;
    private int idChip;
    
    
    public Sell(Game game, Client client, int idSell, Chips chip) { 
        this.idSell = idSell;
        this.idGame = game.getIdGame();
        this.idChip = chip.getIdChip();
        this.idClient = client.getIdClient();
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

    /**
     * @return the idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * @return the idSell
     */
    public int getIdSell() {
        return idSell;
    }

    /**
     * @param idSell the idSell to set
     */
    public void setIdSell(int idSell) {
        this.idSell = idSell;
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
