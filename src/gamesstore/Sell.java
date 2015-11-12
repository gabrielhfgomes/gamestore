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
    private String nameGame;
    private String nameClient;
    
    
    public Sell(Game game, Client client) {
        this.nameGame = game.getName();
        this.nameClient = client.getName();
    }

    /**
     * @return the nameGame
     */
    public String getNameGame() {
        return nameGame;
    }

    /**
     * @param nameGame the nameGame to set
     */
    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    /**
     * @return the nameClient
     */
    public String getNameClient() {
        return nameClient;
    }

    /**
     * @param nameClient the nameClient to set
     */
    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
    
}
