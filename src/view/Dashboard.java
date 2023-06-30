package view;

import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import component.Navbar;
import component.RoundButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private JTabbedPane tabbedPane;
    private JPanel panel1, panel2, panel3;
    private JTable table1, table2, table3;
    private JPanel DashboardBody;
    Navbar navbar;

    public Dashboard() {


        setTitle("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        DashboardBody = new JPanel();
        DashboardBody.setLayout(new BorderLayout());
        navbar = new Navbar();
        // Create the tabbed pane
        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
          tabbedPane.setUI(new BasicTabbedPaneUI() {
            @Override
            protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
                return 200; // Set the width of each tab to 100 pixels
            }

            @Override
            protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
                return 50; // Set the height of each tab to 40 pixels
            }

            @Override
            protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected) {
                Color color = isSelected ? Color.LIGHT_GRAY : Color.WHITE;
                g.setColor(color);
                g.fillRect(x, y, width, height);
            }

            @Override
            protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected) {
                g.setColor(new Color(100,100,100));
                g.drawRect(x, y, width - 1, height - 1);
            }
        });

        // Create the panels for each tab
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        // Add tables to the panels
        table1 = new JTable(10, 3);
        table2 = new JTable(5, 4);
        table3 = new JTable(8, 2);

        panel1.add(new JScrollPane(table1));
        panel2.add(new JScrollPane(table2));
        panel3.add(new JScrollPane(table3));
        BookList book = new BookList();

        // Add the panels to the tabbed pane
        tabbedPane.addTab("Books", null, panel1, "this is where the books are located\n a previleged person can add, read or delete books \n from this lovation.");
        tabbedPane.addTab("Transactions", null, book, "Table 2");
        tabbedPane.addTab("Authors", null, panel3, "Table 3");

        // Set the tabbed pane to fill the entire frame
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