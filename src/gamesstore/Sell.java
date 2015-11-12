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
    private int idGame;
    private int idClient;
    
    
    public Sell(Game game, Client client) {
        this.idGame = game.getIdGame();
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
    
}
