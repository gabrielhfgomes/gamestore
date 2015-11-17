/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import gamesstore.Game;
import gamesstore.Sell;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class SellDAO {
    
    private String SQLInsertSell() {
        String sql = "insert into sell( idSell, idGame, idClient, idChip ) values( ?, ?, ?, ? )";
        return sql;
    }
    
    private String SQLSearchLastIdSell() {
        String sql = "SELECT idSell FROM sell ORDER BY idSell DESC LIMIT 1";
        return sql;
    }
    
    public void insertSell(Sell sell) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLInsertSell()));
            DatabaseUtilit.getPs().setInt(1, sell.getIdSell());
            DatabaseUtilit.getPs().setInt(2, sell.getIdGame());
            DatabaseUtilit.getPs().setInt(3, sell.getIdClient());
            DatabaseUtilit.getPs().setInt(4, sell.getIdChip());
            DatabaseUtilit.getPs().execute();
            
            JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Dados não inseridos, Erro: " + ex);
        }
    }
    
    public int searchLastIdSell() {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLSearchLastIdSell()));

            ResultSet rs = DatabaseUtilit.getPs().executeQuery();
            if(rs != null && rs.next()){  
               return rs.getInt("idSell");  
            } 
            
        } catch(Exception ex) {
            System.err.println("Erro, query busca de ID " + ex);
        }
        return 0;
    }
}
