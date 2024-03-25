import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Nikhil Rajput
 */

public class TransactionForm extends JFrame {

        public TransactionForm() {
                initComponents();
                TransactionManagement.readTransaction();
        }

        public void initComponents() {

                jFrame1 = new JFrame();
                jPanel1 = new JPanel();
                addTransaction = new JLabel();
                date = new JLabel();
                farmerID = new JLabel();
                ItemType = new JLabel();
                ItemName = new JLabel();
                itemPrice = new JLabel();
                quantity = new JLabel();
                totalPrice = new JLabel();
                backButton = new JButton();
                addButton = new JButton();
                dateTextField = new JLabel();
                FarmerID = new JTextField();
                itemTypeComboBox = new JComboBox<>();
                ItemNameComboBox = new JComboBox<>();
                itemPriceTextField = new JLabel();
                quantityField = new JTextField();
                totalPriceTextfield = new JLabel();
                farmerTextField = new JLabel();
                farmerName = new JLabel();
                jPanel2 = new JPanel();
                jScrollPane1 = new JScrollPane();
                viewTransaction = new JTable();
                transactionListLable = new JLabel();
                searchButton = new JButton();
                searchTextField = new JTextField();

                GroupLayout jFrame1Layout = new GroupLayout(jFrame1.getContentPane());
                jFrame1.getContentPane().setLayout(jFrame1Layout);
                jFrame1Layout.setHorizontalGroup(
                                jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 400, Short.MAX_VALUE));
                jFrame1Layout.setVerticalGroup(
                                jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 300, Short.MAX_VALUE));

                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBackground(new java.awt.Color(0, 51, 0));
                jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                addTransaction.setFont(new java.awt.Font("Segoe UI Black", 1, 24));
                addTransaction.setForeground(new java.awt.Color(255, 255, 255));
                addTransaction.setText("Add New Transaction");

                date.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                date.setForeground(new java.awt.Color(255, 255, 255));
                date.setText("Date");
                
                dateTextField.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                dateTextField.setForeground(new java.awt.Color(255, 255, 255));
                dateTextField.setText("Date");

                farmerID.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                farmerID.setForeground(new java.awt.Color(255, 255, 255));
                farmerID.setText("Farmer ID");

                ItemType.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                ItemType.setForeground(new java.awt.Color(255, 255, 255));
                ItemType.setText("Item Type");

                ItemName.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                ItemName.setForeground(new java.awt.Color(255, 255, 255));
                ItemName.setText("Item Name");

                itemPrice.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                itemPrice.setForeground(new java.awt.Color(255, 255, 255));
                itemPrice.setText("Price / Item");

                quantity.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                quantity.setForeground(new java.awt.Color(255, 255, 255));
                quantity.setText("Quantity");

                totalPrice.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                totalPrice.setForeground(new java.awt.Color(255, 255, 255));
                totalPrice.setText("Total Price");

                backButton.setBackground(new java.awt.Color(255, 255, 51));
                backButton.setFont(new java.awt.Font("Segoe UI Black", 1, 18));
                backButton.setText("Back");

                addButton.setBackground(new java.awt.Color(51, 255, 51));
                addButton.setFont(new java.awt.Font("Segoe UI Black", 1, 18));
                addButton.setText("Add");

                farmerName.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                farmerName.setForeground(new java.awt.Color(255, 255, 255));
                farmerName.setText("Farmer Name");

                farmerTextField.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                farmerTextField.setForeground(new java.awt.Color(255, 255, 255));
                farmerTextField.setText("Input ID");

                itemPriceTextField.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                itemPriceTextField.setForeground(new java.awt.Color(255, 255, 255));
                itemPriceTextField.setText("Select Item");

                totalPriceTextfield.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                totalPriceTextfield.setForeground(new java.awt.Color(255, 255, 255));
                totalPriceTextfield.setText("Input Qty");

                itemTypeComboBox.setModel(
                                new DefaultComboBoxModel<>(new String[] { "Seed", "Fertilizer" }));

                                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                                jPanel1.setLayout(jPanel1Layout);
                                
                                jPanel1Layout.setHorizontalGroup(
                                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout
                                                    .createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(farmerID))
                                                .addGroup(jPanel1Layout
                                                    .createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(date))
                                                .addGroup(jPanel1Layout
                                                    .createSequentialGroup()
                                                    .addContainerGap()
                                                    .addGroup(jPanel1Layout
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(ItemType)
                                                        .addComponent(ItemName)
                                                        .addComponent(itemPrice)
                                                        .addComponent(totalPrice)
                                                        .addComponent(quantity)
                                                        .addComponent(farmerName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(backButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGap(100, 100, 100)
                                                    .addGroup(jPanel1Layout
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(itemTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(farmerTextField)
                                                        .addComponent(ItemNameComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(itemPriceTextField)
                                                        .addComponent(quantityField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(totalPriceTextfield, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(FarmerID, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dateTextField)))
                                                .addGroup(jPanel1Layout
                                                    .createSequentialGroup()
                                                    .addGap(24, 24, 24)
                                                    .addComponent(addTransaction)))
                                            .addContainerGap()));
                                
                                jPanel1Layout.linkSize(SwingConstants.HORIZONTAL,
                                    new java.awt.Component[] { FarmerID, ItemNameComboBox, dateTextField, farmerTextField, itemPriceTextField, itemTypeComboBox, quantityField, totalPriceTextfield });
                                
                                jPanel1Layout.setVerticalGroup(
                                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addComponent(addTransaction)
                                            .addGap(39, 39, 39)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout
                                                    .createSequentialGroup()
                                                    .addGroup(jPanel1Layout
                                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(date)
                                                        .addComponent(dateTextField))
                                                    .addGap(49, 49, 49))
                                                .addGroup(jPanel1Layout
                                                    .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(farmerID)
                                                    .addComponent(FarmerID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                            .addGap(26, 26, 26)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(farmerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(farmerName))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(ItemType)
                                                .addComponent(itemTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(30, 30, 30)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(ItemName)
                                                .addComponent(ItemNameComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(30, 30, 30)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(itemPrice)
                                                .addComponent(itemPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(28, 28, 28)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(quantity)
                                                .addComponent(quantityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(36, 36, 36)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(totalPrice)
                                                .addComponent(totalPriceTextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(backButton)
                                                .addComponent(addButton))
                                            .addGap(19, 19, 19)));
                                
                                jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

                viewTransaction.setAutoCreateRowSorter(true);
                viewTransaction.setFont(new java.awt.Font("Segoe UI Black", 1, 12));
                viewTransaction.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                                "Sr_No.", "Date", "Farmer Name", "Item Type", "Item Name",
                                                "Price / Item", "Quantity",
                                                "Total Price"
                                }));
                viewTransaction.setColumnSelectionAllowed(true);
                viewTransaction.setEnabled(false);
                jScrollPane1.setViewportView(viewTransaction);

                transactionListLable.setFont(new java.awt.Font("Segoe UI Black", 1, 24));
                transactionListLable.setText("List of all Transactions");

                searchButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
                searchButton.setText("Daily-Transaction");

                GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
GroupLayout.Alignment.LEADING)
.addGroup(jPanel2Layout
                .createSequentialGroup()
                .addComponent(jScrollPane1,
                                GroupLayout.PREFERRED_SIZE,
                                1000,
                                GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
.addGroup(jPanel2Layout
                .createSequentialGroup()
                .addComponent(transactionListLable)
                .addPreferredGap(
                                LayoutStyle.ComponentPlacement.RELATED,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                .addComponent(searchButton)
                .addPreferredGap(
                                LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTextField,
                                GroupLayout.PREFERRED_SIZE,
                                141,
                                GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                                .createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
GroupLayout.Alignment.LEADING)
.addGroup(jPanel2Layout
                .createSequentialGroup()
                .addContainerGap(
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                .addGroup(jPanel2Layout
                                .createParallelGroup(
                                                GroupLayout.Alignment.BASELINE)
                                .addComponent(searchButton)
                                .addComponent(searchTextField,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
.addGroup(jPanel2Layout
                .createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(transactionListLable)
                .addPreferredGap(
                                LayoutStyle.ComponentPlacement.RELATED,
                                35,
                                Short.MAX_VALUE)))
                                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
453, GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));

                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
GroupLayout.PREFERRED_SIZE,
GroupLayout.DEFAULT_SIZE,
GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel2,
GroupLayout.PREFERRED_SIZE,
GroupLayout.DEFAULT_SIZE,
GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel2,
GroupLayout.PREFERRED_SIZE,
GroupLayout.DEFAULT_SIZE,
GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE))
                                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date currentDate = new Date();
                String formattedDate = dateFormat.format(currentDate);

                dateTextField.setText(formattedDate);

                FarmerID.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                FarmerIDActionPerformed(evt);
                        }

                        public void FarmerIDActionPerformed(ActionEvent evt) {

                                String selecetedFarmerId = FarmerID.getText();
                                TransactionManagement.viewFarmerID(selecetedFarmerId);
                        }

                });
                itemTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                itemTypeComboBoxActionPerformed(evt);
                        }

                        private void itemTypeComboBoxActionPerformed(ActionEvent evt) {
                                ItemNameComboBox.removeAllItems();
                                String selecetedItemType = itemTypeComboBox.getSelectedItem().toString();
                                TransactionManagement.viewItemName(selecetedItemType);

                        }

                });

                ItemNameComboBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ItemNameComboBoxActionPerformed(evt);
                        }

                        private void ItemNameComboBoxActionPerformed(ActionEvent evt) {
                                itemPriceTextField.setText("");
                                String selecetedItemName = ItemNameComboBox.getSelectedItem().toString();
                                TransactionManagement.viewItemPrice(selecetedItemName);
                        }

                });

                addButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                addButtonActionPerformed(evt);
                        }

                        private void addButtonActionPerformed(ActionEvent evt) {

                                TransactionManagement.addTransaction();
                                TransactionManagement.readTransaction();
                                TransactionManagement.printTransaction();

                        }

                });

                backButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                backButtonActionPerformed(evt);
                        }

                        private void backButtonActionPerformed(ActionEvent evt) {
                                new Dashboard().setVisible(true);
                                dispose();
                        }

                });

                  searchButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                searchButtonActionPerformed(evt);
                        }

                        private void searchButtonActionPerformed(ActionEvent evt) {
                                new DailyTransaction().setVisible(true);
                                dispose();
                        }

                });

                quantityField.getDocument().addDocumentListener(new DocumentListener() {
                        @Override
                        public void insertUpdate(DocumentEvent e) {
                                updateTotalPrice();
                        }

                        @Override
                        public void removeUpdate(DocumentEvent e) {
                                updateTotalPrice();
                        }

                        @Override
                        public void changedUpdate(DocumentEvent e) {
                                // Not applicable for plain text components
                        }

                        private void updateTotalPrice() {
                                try {
                                        String priceStr = itemPriceTextField.getText();
                                        String quantityStr = quantityField.getText();

                                        Double price = Double.parseDouble(priceStr);
                                        int quantity = Integer.parseInt(quantityStr);

                                        double totalPrice = price * quantity;
                                        totalPriceTextfield.setText(String.valueOf(totalPrice));
                                } catch (NumberFormatException ex) {
                                        totalPriceTextfield.setText("Invalid input");
                                }
                        }
                });

                searchTextField.getDocument().addDocumentListener(new DocumentListener() {
                        @Override
                        public void insertUpdate(DocumentEvent e) {
                                filterTransactions();
                        }

                        @Override
                        public void removeUpdate(DocumentEvent e) {
                                filterTransactions();
                        }

                        @Override
                        public void changedUpdate(DocumentEvent e) {

                        }

                        private void filterTransactions() {
                                String searchText = searchTextField.getText();
                                TransactionManagement.searchTransaction(searchText);
                        }
                });
                
                viewTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            int row = viewTransaction.rowAtPoint(evt.getPoint());
                            int col = viewTransaction.columnAtPoint(evt.getPoint());
                    
                            if (row >= 0 && col >= 0) {
                                if (col == 0) {
                                    int TransactionID = (int) viewTransaction.getValueAt(row, 0);
                                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete Seed ID " + TransactionID + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                                    if (confirm == JOptionPane.YES_OPTION) {
                                        TransactionManagement.deleteTransaction(TransactionID);
                                    }
                                }
                            }
                        }
                    });
                    
                pack();
        }
        
        
        public static void main(String args[]) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new TransactionForm().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify
        public static  JTextField FarmerID;
        public static JLabel ItemName;
        public static JComboBox<String> ItemNameComboBox;
        public static JLabel ItemType;
        public static JButton addButton;
        public static JLabel addTransaction;
        public static JButton backButton;
        public static JLabel date;
        public static JLabel dateTextField;
        public static JLabel farmerID;
        public static JLabel farmerName;
        public static JLabel farmerTextField;
        public static JLabel itemPrice;
        public static JLabel itemPriceTextField;
        public static JComboBox<String> itemTypeComboBox;
        public static JFrame jFrame1;
        public static JPanel jPanel1;
        public static JPanel jPanel2;
        public static JScrollPane jScrollPane1;
        public static JTextField searchTextField;
        public static JLabel quantity;
        public static JTextField quantityField;
        public static JButton searchButton;
        public static JLabel totalPrice;
        public static JLabel totalPriceTextfield;
        public static JLabel transactionListLable;
        public static JTable viewTransaction;
        // End of variables declaration
}
