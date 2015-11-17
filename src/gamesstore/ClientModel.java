/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesstore;
import bd.ClientDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.html.HTML;

/**
 *
 * @author gabri
 */
public class ClientModel extends AbstractTableModel{
    private String[] columns = {"Name", "RG", "CPF"};
    private static List<Client> rows;
    
    
    public int getColumnCount() {
        return columns.length;
    }
    
    public int getRowCount() {
        return rows.size();
    }
    
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client cli = rows.get(rowIndex);
                
        switch(columnIndex) {
            case 0:
                return cli.getName();
            case 1:
                return cli.getRG();
            case 2:
                return cli.getCPF();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
            
        }
    }
    
    public List<Client> fillingRows() {
        try {
            ClientDAO clientdao = new ClientDAO();
            rows = new ArrayList<>();
            rows = clientdao.listAllClient();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro mostrar dados tabela " + ex);
        }
        return rows;
    }
    
}
