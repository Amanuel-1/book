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
    public static final Dimension STATUS_DIMENSION = new Dimension(700, 400);
    public static final Dimension MainPanel = new Dimension(700,720);

    //components
    public Card TopSeller,TopAuthor,TotalBought ,card2,card3,card4;
    JPanel grid,status ;
    JScrollPane gridPane,statusPane ;




    private void initComponents(){
     //  initComponents();
     //initialize card components
     TotalBought = new Card("Top",MDCard,Color.WHITE);
     TopSeller = new Card("Top",MDCard,Color.WHITE);
     TopAuthor = new Card("Total",MDCard,Color.WHITE);
     card2 = new Card("Total",MDCard,Color.WHITE);
     card3 = new Card("Top",MDCard,Color.WHITE);
     card4 = new Card("Total",MDCard,Color.WHITE);
        //initialize panels
     grid  = new JPanel();
     status  = new JPanel(new GridLayout(4,2,30,30));
     
        //initialize scrollpane
     gridPane = new JScrollPane(grid);
     statusPane = new JScrollPane(status);
    }

    private void setCards(){
    status.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    grid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    grid.setPreferredSize(new Dimension(getWidth(), 150));
    grid.setLayout(new GridLayout(1,3,30,30));

    //adding some contents to the panels
    grid.add(TotalBought);
    grid.add(TopAuthor);
    grid.add(TopSeller);
    
    status.add(new Card("thiss", STATUS_DIMENSION, Color.CYAN));
    status.add(new Card("thiss", STATUS_DIMENSION, Color.CYAN));
    status.add(new Card("sdlkf", STATUS_DIMENSION, Color.CYAN));
    status.add(new Card("sd;flkj", STATUS_DIMENSION, Color.CYAN));
      
    }

    public Home(){
        this.setPreferredSize(MainPanel);
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //initialize the components
        initComponents();
   
      //setting the border properties of panels    
        setCards();
   
    



    this.add(gridPane,BorderLayout.NORTH);
    this.add(statusPane,BorderLayout.CENTER);
    
    }
    
}
