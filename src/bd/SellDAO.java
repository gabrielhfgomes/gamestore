/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import gamesstore.Game;
import gamesstore.Sell;
import java.sql.SQLException;

/**
 *
 * @author gabri
 */
public class SellDAO {
    
    private String SQLInsertSell() {
        String sql = "insert into sell( idGame, idClient) values( ? ,?)";
        return sql;
    }
    
    public void insertSell(Sell sell) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLInsertSell()));
            DatabaseUtilit.getPs().setInt(1, sell.getIdClient());
            DatabaseUtilit.getPs().setInt(2, sell.getIdGame());
            DatabaseUtilit.getPs().execute();
        } catch (SQLException ex) {
            System.out.println("Dados não inseridos, Erro: " + ex);
        }
    }
}
