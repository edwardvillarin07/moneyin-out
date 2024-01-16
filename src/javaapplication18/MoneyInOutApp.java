import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MoneyInOutApp extends JFrame {
    private JTextField amountField;
    private JButton moneyInButton;
    private JButton moneyOutButton;
    private JTable recordTable;
    private DefaultTableModel tableModel;

    public MoneyInOutApp() {
        // Set up the JFrame
        setTitle("Money In/Out App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        amountField = new JTextField(10);
        moneyInButton = new JButton("Money In");
        moneyOutButton = new JButton("Money Out");
        recordTable = new JTable();
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Transaction Type");
        tableModel.addColumn("Amount");
        recordTable.setModel(tableModel);

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(moneyInButton);
        panel.add(moneyOutButton);

        add(panel, "North");
        add(new JScrollPane(recordTable), "Center");

        // Add action listeners to buttons
        moneyInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecord("Money In", Double.parseDouble(amountField.getText()));
            }
        });

        moneyOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecord("Money Out", Double.parseDouble(amountField.getText()));
            }
        });
    }

    private void addRecord(String type, double amount) {
        // Add a new record to the table
        Vector<String> row = new Vector<>();
        row.add(type);
        row.add(String.valueOf(amount));
        tableModel.addRow(row);

        // Clear the amount field after adding the record
        amountField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MoneyInOutApp().setVisible(true);
            }
        });
    }
}
