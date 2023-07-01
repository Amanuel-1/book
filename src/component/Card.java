package component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.plaf.PanelUI;
import javax.swing.plaf.basic.BasicPanelUI;

public class Card extends JPanel {
    Dimension size;
    String title;

    public Card(String title,Dimension size,Color c){
        this.size = size;
        this.title = title;
        this.setVisible(true);
        this.setPreferredSize(this.size);

        this.setBackground(c);
        this.setFont(new Font("Roboto",Font.BOLD,50));
        this.setForeground(c.darker());

        this.setUI(new BasicPanelUI() {
            protected void paintBorderedPanel(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected){
                g.drawRoundRect(x, y, width, height, 20, 20);
            }
            

        });
         

    }
    
}
