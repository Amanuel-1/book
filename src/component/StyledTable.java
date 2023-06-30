package component;


import javax.swing.*;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ModernTable extends JTable {

    private static final Color TABLE_HEADER_COLOR = new Color(33, 150, 243);
    private static final Color TABLE_HEADER_TEXT_COLOR = Color.WHITE;
    private static final Color TABLE_ROW_COLOR = new Color(245, 245, 245);
    private static final Color TABLE_ROW_ALTERNATE_COLOR = new Color(220, 220, 220);
    private static final Color TABLE_SELECTION_COLOR = new Color(21, 101, 162);
    private static final Color TABLE_SELECTION_TEXT_COLOR = Color.WHITE;

    private static final Font TABLE_HEADER_FONT = new Font("Arial", Font.BOLD, 14);
    private static final Font TABLE_CELL_FONT = new Font("Arial", Font.PLAIN, 14);

    private static final int ROW_HEIGHT = 30;

    public ModernTable(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
        setUI(new ModernTableUI());
        setRowHeight(ROW_HEIGHT);
        setFont(TABLE_CELL_FONT);
        setGridColor(Color.LIGHT_GRAY);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private class ModernTableUI extends javax.swing.plaf.basic.BasicTableUI {

        @Override
        protected void installDefaults() {
            super.installDefaults();

            // Set table header properties
            JTableHeader tableHeader = table.getTableHeader();
            tableHeader.setBackground(TABLE_HEADER_COLOR);
            tableHeader.setForeground(TABLE_HEADER_TEXT_COLOR);
            tableHeader.setFont(TABLE_HEADER_FONT);
            tableHeader.setBorder(BorderFactory.createEmptyBorder());
            tableHeader.setReorderingAllowed(false);

            // Set table cell properties
            TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) rendererFromHeader;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);

            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(JLabel.CENTER);
            cellRenderer.setBorder(new EmptyBorder(0, 5, 0, 5));
            cellRenderer.setBackground(TABLE_ROW_COLOR);

            setDefaultRenderer(Object.class, cellRenderer);
        }

        @Override
        protected void paintGrid(Graphics g, int rMin, int rMax, int cMin, int cMax) {
            // Do nothing to remove default grid painting
        }
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component component = super.prepareRenderer(renderer, row, column);

        if (isRowSelected(row)) {
            component.setBackground(TABLE_SELECTION_COLOR);
            component.setForeground(TABLE_SELECTION_TEXT_COLOR);
        } else if (row % 2 == 0) {
            component.setBackground(TABLE_ROW_COLOR);
            component.setForeground(Color.BLACK);
        } else {
            component.setBackground(TABLE_ROW_ALTERNATE_COLOR);
            component.setForeground(Color.BLACK);
        }

        return component;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"Name", "Age", "Gender"};
        Object[][] rowData = {
                {"John", 25, "Male"},
                {"Sarah", 30, "Female"},
                {"David", 40, "Male"},
                {"Linda", 35, "Female"}
        };
        ModernTable table = new ModernTable(rowData, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}