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
public class SellertDAO {

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
    
//    public void insertClient(Seller seller) {
//        try {
//            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLInsertSeller()));
//            DatabaseUtilit.getPs().setString(1, seller.getName());
//            DatabaseUtilit.getPs().setString(2, cli.getRG());
//            DatabaseUtilit.getPs().setString(3, cli.getCPF());
//            DatabaseUtilit.getPs().execute();
//            
//            System.out.println("Cliente foi salvo!");
//        } catch(Exception ex) {
//            System.err.println("Cliente não foi salva \n Erro: " + ex);
//        }
//    }
//    
//    public int searchIdClient(Client client) {
//        try {
//            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLSearchIdClient()));
//            DatabaseUtilit.getPs().setString(1, client.getName());
//            ResultSet rs = DatabaseUtilit.getPs().executeQuery();
//            if(rs != null && rs.next()){
//                return rs.getInt("idClient");
//            }
//            
//        } catch(Exception ex) {
//            System.err.println("Erro, query busca de ID " + ex);
//        }
//        return 0;
//    }
//;
//    public List<Client> listAllClient() {
//        List<Client> listClient = new ArrayList<>();
//
//        try {
//            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLListClient()));
//            ResultSet rs = DatabaseUtilit.getPs().executeQuery();
//
//            if (rs != null) {
//                while (rs.next()) {
//                    Client tempClient = new Client();
//                    tempClient.setName(rs.getString(1));
//                    listClient.add(tempClient);
//                }
//            }
//        } catch (SQLException ex) {
//            System.err.println("Consulta nao realizada! \n Erro: " + ex);
//        }
//        return listClient;
//    }

//    public void updateClient(Client cli) {
//        try {
//            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLUpdateClient()));
//            DatabaseUtilit.getPs().setString(1, cli.getName());
//            DatabaseUtilit.getPs().setString(2, cli.getRG());
//            DatabaseUtilit.getPs().setString(3, cli.getCPF());
//            DatabaseUtilit.getPs().setInt(4, cli.getIdClient());
//        
//            DatabaseUtilit.getPs().execute();
//            
//            System.out.println("Cliente foi atualizado!");
//        } catch(Exception ex) {
//            System.err.println("Cliente não foi atualizado \n Erro: " + ex);
//        }
//    }

}
