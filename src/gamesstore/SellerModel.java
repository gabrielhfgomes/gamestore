/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesstore;
import bd.SellerDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.html.HTML;

/**
 *
 * @author gabri
 */
public class SellerModel extends AbstractTableModel{
    private String[] columns = {"Name", "Salary", "Comission"};
    private static List<Seller> rows;
    
    
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
        Seller seller = rows.get(rowIndex);
                
        switch(columnIndex) {
            case 0:
                return seller.getName();
            case 1:
                return seller.getSalary();
            case 2:
                return seller.getComission();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
            
        }
    }
    
    public List<Seller> fillingRows() {
        try {
            SellerDAO sellerdao = new SellerDAO();
            rows = new ArrayList<>();
            rows = sellerdao.listAllSeller();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro mostrar dados tabela " + ex);
        }
        return rows;
    }
    
}
