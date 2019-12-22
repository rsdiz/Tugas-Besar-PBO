/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuisgame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Rosyid Iz
 */
public class CustomHeaderScore extends JLabel implements TableCellRenderer {
    
    public CustomHeaderScore() {
        setFont(new Font("Verdana", Font.BOLD, 18));
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
}