/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.*;

/**
 *
 * @author s2it_ggomes
 */
public class DatabaseUtilit {
    private static Connection con;
    private static PreparedStatement ps;
    private static String url = "jdbc:mysql://127.0.0.1/gamestore";
    private static String user = "root";
    private static String psw = "root";
    
    public static void Conectar() {
        try {
            if(con == null) {
                con = DriverManager.getConnection(getUrl(), user, psw);
                System.out.println("Conexão aberta");
            } else {
                System.out.println("Conexão já estava aberta");
            } 
        } catch (SQLException ex) {
            System.out.println("Não conectou, Erro :  " + ex);
        }
    }
    
    public static void Desconectar() {
        try {
            con.close();
            System.out.println("Conexão fechada!");
        } catch(SQLException ex) {
            System.out.println("Não desconectou, Erro : " + ex);
        }
        
    }
    
    public static Connection getCon() {
        return con;
    }
    
    public static String getUrl() {
        return url;
    }
    
    public static PreparedStatement getPs() {
        return ps;
    }
    
    public static void setPs(PreparedStatement ps) {
        DatabaseUtilit.ps = ps;
    }
}
