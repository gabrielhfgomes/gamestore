/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.*;
import java.util.*;
import gamesstore.Game;

/**
 *
 * @author s2it_ggomes
 */
public class GameDAO {

    private String SQLInsertGame() {
        String sql = "insert into game(name, manufacturer, price, stock, avaible_for_sell, year_release) values(?, ?, ?, ?, ?, ?, ?)";
        return sql;
    }

    private String SQLUpdateGame() {
        String sql = "update game set nome = ?, manufacturer = ?, price = ?, stock";
        sql += " where nome = ?";
        return sql;
    }

    private String SQLDeleteGame() {
        String sql = "delete from game where nome = ?";
        return sql;
    }

    private String SQLListGame() {
        String sql = "select name from game";
        return sql;
    }

    public void insertGame(Game game) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLInsertGame()));
        } catch (SQLException ex) {

        }
    }

    public void updateGame(Game game) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLUpdateGame()));
        } catch (SQLException ex) {
            System.out.println("Dados não atualizados por @updateGame, Erro: " + ex);
        }

    }

    public void deleteGame(Game game) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLDeleteGame()));
        } catch (Exception ex) {
            System.out.println("bd.GameDAO.deleteGame()");
        }
    }

    public List<Game> listAllGames() {
        List<Game> listGame = new ArrayList<>();

        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLListGame()));
            ResultSet rs = DatabaseUtilit.getPs().executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Game tempGame = new Game();
                    tempGame.setName(rs.getString(1));
                    listGame.add(tempGame);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Consulta nao realizada! \n Erro: " + ex);
        }
        return listGame;
    }

}