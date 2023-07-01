package view;




import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Genre;

public class AdminUI extends JPanel {
    
    JTable tblMain;
    JTextField txtSearch;
    JButton btnSearch, btnAdd, btnEdit, btnDiscount, btnRemove;
    DefaultTableModel tblModelMain;
    JPanel pnlBottom, pnlTop; // MainPanel Top and Bottom
    JScrollPane scrPaneTblMain;
    CardLayout cardLayout;    
    JTabbedPane tabPane;
    JPanel pnlAddBook, pnlEditBook, pnlDiscountBook, pnlManageBooks, pnlCard;
    JRadioButton rbtnTitle, rbtnAuthor, rbtnID, rbtnPrice;
    ButtonGroup rbtnGroup;

    Object[] selectedBook; // keeps track of the currently selected book from table
    
    static GridBagConstraints gbc = new GridBagConstraints();
    static Integer width = 600 , height = 600;
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    public AdminUI(){

        setLayout(new BorderLayout(5,5));

        initializeComponents();

        pnlTop.add(txtSearch);
        pnlTop.add(btnSearch);
        pnlTop.add(rbtnTitle);
        pnlTop.add(rbtnAuthor);
        pnlTop.add(rbtnID);
        pnlTop.add(rbtnPrice);

        pnlBottom.add(btnAdd);
        pnlBottom.add(btnEdit);
        pnlBottom.add(btnDiscount);        
        pnlBottom.add(btnRemove);    

        pnlCard.add(pnlManageBooks, "pnlManageBooks");
        pnlCard.add(pnlAddBook, "pnlAddBook");
        pnlCard.add(pnlEditBook, "pnlEditBook");;
        pnlCard.add(pnlDiscountBook, "pnlDiscountBook");


        setupManageBooksPanel();
        setupAddBooksPanel();
        setupEditBooksPanel();
        setupDiscountBooksPanel();
    
        add(pnlCard);

        setupActionListening();

        setBounds((int)(screenSize.getWidth() - width)/2, (int)(screenSize.getHeight()-height)/2, width, height); // Start at Center of Screen
        setVisible(true);
        
    }

    void initializeComponents(){
        txtSearch = new JTextField(20);
        
        btnSearch = new JButton("Search", null);
        btnAdd = new JButton("Add Book", null);
        btnEdit = new JButton("Edit Book", null);
        btnDiscount = new JButton("Discount Book", null);
        btnRemove = new JButton("Remove Book", null);

        rbtnTitle = new JRadioButton("Title");
        rbtnAuthor = new JRadioButton("Author");
        rbtnID = new JRadioButton("ID");
        rbtnPrice = new JRadioButton("Price");
        rbtnGroup = new ButtonGroup();
        rbtnGroup.add(rbtnTitle);
        rbtnGroup.add(rbtnAuthor);
        rbtnGroup.add(rbtnID);
        rbtnGroup.add(rbtnPrice);
        
        cardLayout = new CardLayout();
        
        pnlTop = new JPanel(new FlowLayout());
        pnlBottom = new JPanel(new FlowLayout());
        pnlAddBook = new JPanel(new GridBagLayout());        
        pnlEditBook = new JPanel(new GridBagLayout());
        pnlDiscountBook = new JPanel(new GridBagLayout());
        pnlManageBooks = new JPanel();
        pnlCard = new JPanel(cardLayout);

        tblModelMain = new DefaultTableModel(new Object[]{"Id", "Title","Author","Price"}, 0);
        tblMain = new JTable(tblModelMain);
        scrPaneTblMain = new JScrollPane(tblMain);
    }

    void setupManageBooksPanel(){
        pnlManageBooks.add(pnlTop, BorderLayout.NORTH);
        pnlManageBooks.add(scrPaneTblMain, BorderLayout.CENTER);
        pnlManageBooks.add(pnlBottom, BorderLayout.SOUTH);
    }

    void setupAddBooksPanel(){
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(50, 0, 100, 0);
        JLabel lblAddBooks = new JLabel("Add Books to Store");
        //lblAddBooks.setFont(PointOfSaleUI.headingFont);
        pnlAddBook.add(lblAddBooks, gbc);
        
        JLabel lblTitle = new JLabel("Title:");
        JLabel lblAuthor = new JLabel("Author:");
        JLabel lblPublisher = new JLabel("Publisher:");
        JLabel lblPublicationYear = new JLabel("Publication Year:");
        JLabel lblGenre = new JLabel("Genre:");
        JLabel lblPrice = new JLabel("Price:");
        JLabel lblQuantity = new JLabel("Quantity:");

        JTextField txtTitle = new JTextField(null, 50);
        JTextField txtAuthor = new JTextField(null, 50);
        JTextField txtPublisher = new JTextField(null, 50);
        JTextField txtPublicationYear = new JTextField(null, 50);
        
        JComboBox cbxGenre = new JComboBox<>(Genre.values());

        NumberFormat numFormatPrice = new DecimalFormat("$0.00");
        JFormattedTextField txtPrice = new JFormattedTextField(numFormatPrice);
        txtPrice.setColumns(50);

        SpinnerNumberModel spnrModel = new SpinnerNumberModel(5,0,9999,1);
        JSpinner spnrQuantity = new JSpinner(spnrModel);

        lblAddBooks.setHorizontalAlignment(SwingConstants.CENTER);

        JComponent components[] = {
            lblTitle,
            txtTitle,
            lblAuthor,
            txtAuthor,
            lblPublisher,
            txtPublisher,
            lblPublicationYear,
            txtPublicationYear,
            lblGenre,
            cbxGenre,
            lblPrice,
            txtPrice,
            lblQuantity,
            spnrQuantity
        };
        
        JPanel pnlInner;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for(int i = 0; i < components.length; i+=2){
            pnlInner = new JPanel();
            pnlInner.setLayout(new BoxLayout(pnlInner,BoxLayout.X_AXIS));
            
     //       if(components[i] instanceof JLabel) components[i].setFont(PointOfSaleUI.headingFont1B);
    //        if(components[i+1] instanceof JLabel) components[i+1] .setFont(PointOfSaleUI.headingFont1);

            
            pnlInner.add(components[i]);
            pnlInner.add(Box.createRigidArea(new Dimension(50,5)));
            pnlInner.add(components[i+1]);
            

            gbc.insets = new Insets(5,2,5,2);
            gbc.gridx = 0;  
            gbc.gridy += 1;
            pnlAddBook.add(pnlInner,gbc);
            
        }

        JButton btnBackAddBook = new JButton("Back");
        JButton btnAddBook = new JButton("Add");
        JPanel pnlBttmButtons = new JPanel(new FlowLayout());
        pnlBttmButtons.add(btnBackAddBook);
        pnlBttmButtons.add(btnAddBook);
        
        gbc.gridx = 0;
        gbc.gridy += 1;
        gbc.insets = new Insets(100, 0, 0, 0);
        pnlAddBook.add(pnlBttmButtons, gbc);
        btnBackAddBook.addActionListener(e->{
            cardLayout.show(pnlCard, "pnlManageBooks");
        });

        btnAddBook.addActionListener(e -> {
            /** connector function call to add book to database*/
        });


    }

    void setupEditBooksPanel(){
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(50, 0, 100, 0);
        JLabel lblEditBooks = new JLabel("Edit Book Information");
      //  lblEditBooks.setFont(PointOfSaleUI.headingFont);
        pnlEditBook.add(lblEditBooks, gbc);
        
        JLabel lblPrevTitle = new JLabel("PREV_INFO_HERE to"); //** Call connector function to display selected data within the JLABEL(PARENTHESES)*/
        JLabel lblPrevAuthor = new JLabel("PREV_INFO_HERE to"); //** Call connector function to display selected data within the JLABEL(PARENTHESES)*/
        JLabel lblPrevPublisher = new JLabel("PREV_INFO_HERE to"); //** Call connector function to display selected data within the JLABEL(PARENTHESES)*/
        JLabel lblPrevPublicationYear = new JLabel("PREV_INFO_HERE to"); //** Call connector function to display selected data within the JLABEL(PARENTHESES)*/
        JLabel lblPrevGenre = new JLabel("PREV_INFO_HERE to"); //** Call connector function to display selected data within the JLABEL(PARENTHESES)*/
        JLabel lblPrevPrice = new JLabel("PREV_INFO_HERE to"); //** Call connector function to display selected data within the JLABEL(PARENTHESES)*/
        JLabel lblPrevQuantity = new JLabel("PREV_INFO_HERE to"); //** Call connector function to display selected data within the JLABEL(PARENTHESES)*/
        
        JLabel lblTitle = new JLabel("Title");
        JLabel lblAuthor = new JLabel("Author");
        JLabel lblPublisher = new JLabel("Publisher");
        JLabel lblPublicationYear = new JLabel("Publication Year");
        JLabel lblGenre = new JLabel("Genre");
        JLabel lblPrice = new JLabel("Price");
        JLabel lblQuantity = new JLabel("Quantity");

        JTextField txtTitle = new JTextField(null, 50);
        JTextField txtAuthor = new JTextField(null, 50);
        JTextField txtPublisher = new JTextField(null, 50);
        JTextField txtPublicationYear = new JTextField(null, 50);
        
        JComboBox cbxGenre = new JComboBox<>(Genre.values());

        NumberFormat numFormatPrice = new DecimalFormat("$0.00");
        JFormattedTextField txtPrice = new JFormattedTextField(numFormatPrice);
        txtPrice.setColumns(50);

        SpinnerNumberModel spnrModel = new SpinnerNumberModel(5,0,9999,1);
        JSpinner spnrQuantity = new JSpinner(spnrModel);

        lblEditBooks.setHorizontalAlignment(SwingConstants.CENTER);

        JComponent components[] = {
            lblTitle,
            lblPrevTitle,
            txtTitle,
            lblAuthor,
            lblPrevAuthor,
            txtAuthor,
            lblPublisher,
            lblPrevPublisher,
            txtPublisher,
            lblPublicationYear,
            lblPrevPublicationYear,
            txtPublicationYear,
            lblGenre,
            lblPrevGenre,
            cbxGenre,
            lblPrice,
            lblPrevPrice,
            txtPrice,
            lblQuantity,
            lblPrevQuantity,
            spnrQuantity
        };
        
        JPanel pnlInner;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        for(int i = 0; i < components.length; i+=3){
            pnlInner = new JPanel();
            pnlInner.setLayout(new BoxLayout(pnlInner,BoxLayout.X_AXIS));
            
        //    if(components[i] instanceof JLabel) components[i].setFont(PointOfSaleUI.headingFont1B);
         //   if(components[i+1] instanceof JLabel) components[i+1] .setFont(PointOfSaleUI.headingFont1);
        //    if(components[i+2] instanceof JLabel) components[i+2] .setFont(PointOfSaleUI.headingFont1);

            
            pnlInner.add(components[i]);
            pnlInner.add(Box.createRigidArea(new Dimension(50,5)));
            pnlInner.add(components[i+1]);
            pnlInner.add(Box.createRigidArea(new Dimension(50,5)));
            pnlInner.add(components[i+2]);

            gbc.insets = new Insets(5,2,5,2);
            gbc.gridx = 0;  
            gbc.gridy += 1;
            pnlEditBook.add(pnlInner,gbc);
            
        }

        JButton btnBackEditBook = new JButton("Back");
        JButton btnEditBook = new JButton("Edit");
        JPanel pnlBttmButtons = new JPanel(new FlowLayout());
        pnlBttmButtons.add(btnBackEditBook);
        pnlBttmButtons.add(btnEditBook);
        
        gbc.gridx = 0;
        gbc.gridy += 1;
        gbc.insets = new Insets(100, 0, 0, 0);
        pnlEditBook.add(pnlBttmButtons, gbc);
        btnBackEditBook.addActionListener(e->{
            cardLayout.show(pnlCard, "pnlManageBooks");
        });

        btnEditBook.addActionListener(e -> {
            /** connector function call to Edit book information in database*/
        });
    }
    
    void setupDiscountBooksPanel(){

        GridBagConstraints gbc = new GridBagConstraints();
        JLabel lblDiscountBooks = new JLabel("Discount Book");
       // lblDiscountBooks.setFont(PointOfSaleUI.headingFontB); //* Separate it into controller class (the font)**/
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 100, 0);
        pnlDiscountBook.add(lblDiscountBooks, gbc);

        JLabel lblSelectedBookName = new JLabel("Book Name");
        JLabel lblSelectedBookNameValue = new JLabel("Ad ");
        JLabel lblPrevPrice = new JLabel("Previous Price");
        JLabel lblPrevPriceVal = new JLabel("PREV_PRICE"); /** The empty parentheses must call a getPrice(BookId) from the controller **/
        JLabel lblDiscountedPrice = new JLabel("Discounted Price");
        SpinnerNumberModel spnrNumberModel = new SpinnerNumberModel(0, 0, 100, 0.33); //**  Must call getPrice(BookId) from the controller **/
        JSpinner spnrDiscountedPrice = new JSpinner(spnrNumberModel);


        JComponent components[] = {
            lblSelectedBookName, lblSelectedBookNameValue, lblPrevPrice, lblPrevPriceVal, lblDiscountedPrice, spnrDiscountedPrice
        };

        JPanel pnlInner;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        for(int i = 0; i < components.length; i+=2){
            
            gbc.gridx = 0;
            gbc.gridy += 1;
            gbc.insets = new Insets(5, 0, 0, 0);

            pnlInner = new JPanel();
            pnlInner.setLayout(new BoxLayout(pnlInner, BoxLayout.X_AXIS));

          //  if(components[i] instanceof JLabel) components[i].setFont(PointOfSaleUI.headingFont1B);
          //  if(components[i+1] instanceof JLabel) components[i+1].setFont(PointOfSaleUI.headingFont1);

            pnlInner.add(components[i]);
            pnlInner.add(Box.createRigidArea(new Dimension(50, 10)));
            pnlInner.add(components[i+1]);

            
            pnlDiscountBook.add(pnlInner, gbc);
        }

        JButton btnDiscount = new JButton("Apply Discount");
        JButton btnBackDiscountBook = new JButton("Back");
        JPanel pnlBttmButtons = new JPanel(new FlowLayout());

        pnlBttmButtons.add(btnBackDiscountBook);
        pnlBttmButtons.add(btnDiscount);

        gbc.gridy += 1;
        gbc.insets = new Insets(100, 0, 0, 0);
        pnlDiscountBook.add(pnlBttmButtons, gbc);

        btnBackDiscountBook.addActionListener(e->{
            cardLayout.show(pnlCard, "pnlManageBooks");
        });
    }

    void addVerticalSpace(JComponent comp, Integer Spaces){

    }

    void setupActionListening(){
        btnAdd.addActionListener(e -> {
            cardLayout.show(pnlCard, "pnlAddBook");
        });

        btnEdit.addActionListener(e -> {
            cardLayout.show(pnlCard, "pnlEditBook");
        });

        btnDiscount.addActionListener(e -> {
            cardLayout.show(pnlCard, "pnlDiscountBook");
        });
        
        btnRemove.addActionListener(e ->{
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove?"
            , "Remove Confirmation", JOptionPane.YES_NO_OPTION);
            
        });
    }


    boolean inTabbedPane(Component c, JTabbedPane tpane){
        int tabCount = tpane.getTabCount();
        for(int i = 0; i < tabCount; i++){
            if(c == tpane.getComponentAt(i)) return true;
        }
        return false;
    }
}

