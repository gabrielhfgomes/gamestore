/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.*;
import gamesstore.Seller;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s2it_ggomes
 */
public class SellerDAO {

    private String SQLListSeller() {
        String sql = "select name from client";
        return sql;
    }
    
    private String SQLInsertSeller() {
        String sql = "insert into seller(name, rg, cpf) values( ?, ?, ? )";
        return sql;
    }
    
    private String SQLUpdateSeller() {
        String sql = "update client set name = ?, rg = ?, cpf = ? where idClient = ?";
        return sql;
    }
    
    private String SQLSearchIdSeller() {
        String sql = "select idSeller from seller where name = ?";
        return sql;
    }
    
    public void insertSeller(Seller seller) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLInsertSeller()));
            DatabaseUtilit.getPs().setString(1, seller.getName());
            DatabaseUtilit.getPs().setFloat(2, seller.getComission());
            DatabaseUtilit.getPs().setFloat(3, seller.getSalary());
            DatabaseUtilit.getPs().execute();
            
            System.out.println("Vendedor foi salvo!");
        } catch(Exception ex) {
            System.err.println("Vendedor não foi salva \n Erro: " + ex);
        }
    }
    
    public int searchIdSeller(Seller seller) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLSearchIdSeller()));
            DatabaseUtilit.getPs().setString(1, seller.getName());
            ResultSet rs = DatabaseUtilit.getPs().executeQuery();
            if(rs != null && rs.next()){
                return rs.getInt("idSeller");
            }
            
        } catch(Exception ex) {
            System.err.println("Erro, query busca de ID " + ex);
        }
        return 0;
    }
;
    public List<Seller> listAllSeller() {
        List<Seller> listSeller = new ArrayList<>();

        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLListSeller()));
            ResultSet rs = DatabaseUtilit.getPs().executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Seller tempSeller = new Seller();
                    tempSeller.setName(rs.getString(1));
                    listSeller.add(tempSeller);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Consulta nao realizada! \n Erro: " + ex);
        }
        return listSeller;
    }

    public void updateClient(Seller seller) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLUpdateSeller()));
            DatabaseUtilit.getPs().setString(1, cli.getName()); 
            DatabaseUtilit.getPs().setString(2, cli.getRG());
            DatabaseUtilit.getPs().setString(3, cli.getCPF());
            DatabaseUtilit.getPs().setInt(4, cli.getIdClient());
        
            DatabaseUtilit.getPs().execute();
            
            System.out.println("Cliente foi atualizado!");
        } catch(Exception ex) {
            System.err.println("Cliente não foi atualizado \n Erro: " + ex);
        }
    }

}
