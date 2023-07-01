package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import component.Card;

public class Home extends JPanel {
    public static final Dimension MDCard = new Dimension(100,100);
    public static final Dimension MainPanel = new Dimension(700,720);


    Card TotalBought = new Card("Total",MDCard,Color.WHITE);
    Card TopSeller = new Card("Top",MDCard,Color.WHITE);
    Card TopAuthor = new Card("Total",MDCard,Color.WHITE);
    Card card2 = new Card("Total",MDCard,Color.WHITE);
    Card card3 = new Card("Top",MDCard,Color.WHITE);
    Card card4 = new Card("Total",MDCard,Color.WHITE);

    public Home(){
        this.setPreferredSize(MainPanel);
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    
    JPanel grid  = new JPanel();
    
    grid.setLayout(new GridLayout(1,3,30,30));
    grid.add(TotalBought);
    grid.add(TopAuthor);
    grid.add(TopSeller);
     grid.add(card2);
    grid.add(card3);
    grid.add(card4);
    JScrollPane scrollPane = new JScrollPane(grid);

    this.add(scrollPane);
    
    }
    
}
