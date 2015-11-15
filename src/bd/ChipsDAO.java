/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import gamesstore.Chips;
import gamesstore.Game;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class ChipsDAO {
   
    
    public String SQLListAllChips() {
        String sql = "select name from chips";
        return sql;
    }
    
    private String SQLSearchIdChip() {
        String sql = "select idChip from chips where name = ?";
        return sql;
    }
    
    public List<Chips> listAllChips() {
        List<Chips> listChips = new ArrayList<>();

        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLListAllChips()));
            ResultSet rs = DatabaseUtilit.getPs().executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Chips tempChip = new Chips();
                    tempChip.setName(rs.getString(1));
                    listChips.add(tempChip);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Consulta nao realizada! \n Erro: " + ex);
        }
        return listChips;
    }
    
    public int searchIdChip(Chips chip) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLSearchIdChip()));
            DatabaseUtilit.getPs().setString(1, chip.getName());
            ResultSet rs = DatabaseUtilit.getPs().executeQuery();
            if(rs != null && rs.next()){  
               return rs.getInt("idChip");  
            } 
            
        } catch(Exception ex) {
            System.err.println("Erro, query busca de ID " + ex);    
        }
        return 0;
    }
}
