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
import javax.swing.JOptionPane;

/**
 *
 * @author s2it_ggomes
 */
public class ClientDAO {

    private String SQLListClient() {
        String sql = "select name, rg, cpf from client";
        return sql;
    }
    
    private String SQLInsertClient() {
        String sql = "insert into client(name, rg, cpf) values( ?, ?, ? )";
        return sql;
    }
    
    private String SQLUpdateClient() {
        String sql = "update client set name = ?, rg = ?, cpf = ? where idClient = ?";
        return sql;
    }
    
    private String SQLSearchIdClient() {
        String sql = "select idClient from client where name = ?";
        return sql;
    }
    
    private String SQLDeleteClient() {
        String sql = "delete from client where cpf = ?";
        return sql;
    }
    
    private String SQLSearchIdClientbyCpf() {
        String sql = "select idClient from client where cpf = ?";
        return sql;
    }
    
    public void insertClient(Client cli) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLInsertClient()));
            DatabaseUtilit.getPs().setString(1, cli.getName());
            DatabaseUtilit.getPs().setString(2, cli.getRG());
            DatabaseUtilit.getPs().setString(3, cli.getCPF());
            DatabaseUtilit.getPs().execute();
            
            System.out.println("Cliente foi salvo!");
            
        } catch(Exception ex) {
            System.err.println("Cliente não foi salva \n Erro: " + ex);
            JOptionPane.showMessageDialog(null, "Por favor insira um CPF/RG não registrado");
        }
    }
    
    public int searchIdClient(Client client) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLSearchIdClient()));
            DatabaseUtilit.getPs().setString(1, client.getName());
            ResultSet rs = DatabaseUtilit.getPs().executeQuery();
            if(rs != null && rs.next()){
                return rs.getInt("idClient");
            }
        } catch(Exception ex) {
            System.err.println("Erro, query busca de ID " + ex);
        }
        return 0;
    }
    
     public int searchIdClient(String cpf) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLSearchIdClientbyCpf()));
            DatabaseUtilit.getPs().setString(1, cpf);
            ResultSet rs = DatabaseUtilit.getPs().executeQuery();
            if(rs != null && rs.next()){
                return rs.getInt("idClient");
            }
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
                    tempClient.setRG(rs.getString(2));
                    tempClient.setCPF(rs.getString(3));
                    listClient.add(tempClient);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Consulta nao realizada! \n Erro: " + ex);
        }
        return listClient;
    }
    
   

    public void updateClient(Client cli) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLUpdateClient()));
            DatabaseUtilit.getPs().setString(1, cli.getName());
            DatabaseUtilit.getPs().setString(2, cli.getRG());
            DatabaseUtilit.getPs().setString(3, cli.getCPF());
            DatabaseUtilit.getPs().setInt(4, cli.getIdClient());
        
            DatabaseUtilit.getPs().execute();
            
            System.out.println("Cliente foi atualizado!");
            JOptionPane.showMessageDialog(null,"Cliente foi atualizado com sucesso!" );
        } catch(Exception ex) {
            System.err.println("Cliente não foi atualizado \n Erro: " + ex);
        }
    }
    
    public void deleteClient(String CPF) {
        try {
            DatabaseUtilit.setPs(DatabaseUtilit.getCon().prepareStatement(SQLDeleteClient()));
            DatabaseUtilit.getPs().setString(1, CPF);
            DatabaseUtilit.getPs().execute();
            System.out.println("Cliente excluido com sucesso!");
        } catch(Exception ex) {
            System.err.println("Erro: "+ ex + "ao excuir cliente!");
        }
    }

}
