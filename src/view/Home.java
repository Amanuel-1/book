package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import component.Card;

public class Home extends JPanel {
    public static final Dimension MDCard = new Dimension(400,400);

    Card TotalBought = new Card("Total",MDCard,Color.WHITE);
    Card TopSeller = new Card("Top",MDCard,Color.WHITE);
    Card TopAuthor = new Card("Total",MDCard,Color.WHITE);

    public Home(){
        JPanel grid  = new JPanel();
    grid.setLayout(new GridLayout(3,3));
    grid.add(TotalBought);
    grid.add(TopAuthor);
    grid.add(TopSeller);

    this.add(grid);
    }
    
}
