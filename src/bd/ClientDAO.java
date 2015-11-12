/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.*;
import gamesstore.Client;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s2it_ggomes
 */
public class ClientDAO {

    private String SQLListClient() {
        String sql = "select name from client";
        return sql;
    }
    
    private String SQLSearchIdClient() {
        String sql = "select idClient from client where name = ?";
        return sql;
    }
    
    public int searchIdClient(Client client) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLSearchIdClient()));
            DatabaseUtilit.getPs().setString(1, client.getName());
            ResultSet rs = DatabaseUtilit.getPs().executeQuery();
            return rs.getInt(1);
        } catch(Exception ex) {
            System.err.println("Erro, query busca de ID " + ex);
        }
        return 0;
    }

    public List<Client> listAllClient() {
        List<Client> listClient = new ArrayList<>();

        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLListClient()));
            ResultSet rs = DatabaseUtilit.getPs().executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Client tempClient = new Client();
                    tempClient.setName(rs.getString(1));
                    listClient.add(tempClient);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Consulta nao realizada! \n Erro: " + ex);
        }
        return listClient;
    }

}
