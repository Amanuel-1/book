package view;

import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import component.Navbar;
import component.RoundButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private JTabbedPane tabbedPane;
    private JPanel booksPannel, dashBoard, panel3;
    private JTable table1, table2, table3;
    private JPanel DashboardBody;
    Navbar navbar;

    public Dashboard() {


        setTitle("Dashboard");
        setSize(1200, 720);
        setLocationRelativeTo(null);//to position the window at the center of the screen.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        DashboardBody = new JPanel();
        DashboardBody.setLayout(new BorderLayout());
        //this is where we added the navebar 
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        URL avatarUrl = getClass().getResource("avatar.png");
        Navbar navbar = new Navbar("Amanuel", avatarUrl);

        panel.add(navbar, BorderLayout.NORTH);
        // Create the tabbed pane
        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        
        
          tabbedPane.setUI(new BasicTabbedPaneUI() {
            @Override
            protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
                return 250; // Set the width of each tab to 100 pixels
            }

            @Override
            protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
                return 50; // Set the height of each tab to 40 pixels
            }
       
        

            @Override
            protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected) {
                Color color = isSelected ? new Color(40,40,40) : new Color(30,30,30);
                g.setColor(color);
                
                g.fillRect(x, y, width, height);

                
            }

            @Override
            protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected) {
                g.setColor(new Color(100,100,100));
                
            }
             
            
        });

        // Create the panels for each tab
        booksPannel = new Home();
        dashBoard = new JPanel();
        panel3 = new JPanel();

        // Add tables to the panels
        table1 = new JTable(10, 3);
        table2 = new JTable(5, 4);
        table3 = new JTable(8, 2);

        booksPannel.add(new JScrollPane(table1));
        dashBoard.add(new JScrollPane(table2));
        panel3.add(new JScrollPane(table3));
        BookList book = new BookList();

        // Add the panels to the tabbed pane
        tabbedPane.addTab("Dashboard", null,new Home(), getTitle());
        tabbedPane.addTab("Inventory",new ImageIcon("avatar.png") , new AdminUI(), "this is where the books are located\n a previleged person can add, read or delete books \n from this lovation.");
        tabbedPane.addTab("Sales", null,book, "Table 2");
        tabbedPane.addTab("Authors", null, panel3, "Table 3");

        tabbedPane.setForeground(new Color(200,200,200));

        // Set the tabbed pane to fill the entire frame
        DashboardBody.setBackground(new Color(30,30,30));
        DashboardBody.add(tabbedPane,BorderLayout.CENTER);



        Container container = this.getContentPane();


        container.add(navbar,BorderLayout.NORTH);
        container.add(DashboardBody,BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}