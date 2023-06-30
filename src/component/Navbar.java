package component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class Navbar extends JPanel implements ActionListener {
    
    ModernButton btn1,btn2,btn3,btn4;
    
    public Navbar(){
            this.setPreferredSize(new Dimension(getPreferredSize().width,40));
            btn1 =new ModernButton("home");
            btn2 =new ModernButton("view");
            btn3 =new ModernButton("help");
            btn4 =new ModernButton("Accounts and settings");
          //  btn1 =new JButton("home", null);

          this.add(btn1);
          this.add(btn2);
          this.add(btn3);
          this.add(btn4);
         
          
    }


    public void actionPerformed(ActionEvent e){
         // Switch to the selected tab
     
    }
}
