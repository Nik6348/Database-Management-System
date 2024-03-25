import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 *
 * @author Nikhil-Rajput
 */
public class DailyTransaction extends javax.swing.JFrame {

    
    public DailyTransaction() {
        initComponents();
        readTransaction();
    }
    private void readDailyTransaction(String query) { 
       try {
            Connection con = DB.connect();
           PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String transactionDate = rs.getString("TransactionDate");
                double totalTransactions = rs.getDouble("TotalTransactions");

                model.addRow(new Object[]{transactionDate, totalTransactions});
                
            }
            
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        
        }    }

         private void readTransaction() { 
       try {
            Connection con = DB.connect();
            String query = "SELECT TransactionDate, SUM(TotalPrice) as TotalTransactions " +
            "FROM transactions GROUP BY TransactionDate " +
            "ORDER BY TransactionDate";

           PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String transactionDate = rs.getString("TransactionDate");
                double totalTransactions = rs.getDouble("TotalTransactions");

                model.addRow(new Object[]{transactionDate, totalTransactions});
            
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        
        }    }
 
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        filterComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabel1.setText("Daily - Transactions");

        jTable1.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Total Transactions"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        backButton.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        homeButton.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        filterComboBox.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Newest Transaction","Oldest Transaction","Highest Transaction", "Lowest Transaction"}));
        filterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel2.setText("Search");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addComponent(homeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

         searchField.getDocument().addDocumentListener(new DocumentListener() {
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
                String searchText = searchField.getText();
            searchTransaction(searchText);
        }
});

        pack();
    }                      

    private void searchTransaction(String searchText) {
        try {
            Connection con = DB.connect();
            String query = "SELECT * FROM Transactions WHERE TransactionDate LIKE ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            String searchPattern = "%" + searchText + "%";
            preparedStatement.setString(1, searchPattern);

            ResultSet rs = preparedStatement.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String transactionDate = rs.getString("TransactionDate");
                double totalTransactions = rs.getDouble("TotalPrice");

                model.addRow(new Object[]{transactionDate, totalTransactions});
                
            }
            
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        
        }

    }

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        new Dashboard().setVisible(true);
        dispose();
    }                                          

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
       new TransactionForm().setVisible(true);
       dispose();
    }                                          

    private void filterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                               
    String selectedFilter = filterComboBox.getSelectedItem().toString();
    String orderByColumn;
    String sortOrder;

    if (selectedFilter.equals("Highest Transaction")) {
        orderByColumn = "TotalTransactions";
        sortOrder = "DESC";
    } else if (selectedFilter.equals("Lowest Transaction")) {
        orderByColumn = "TotalTransactions";
        sortOrder = "ASC";
    } else if (selectedFilter.equals("Newest Transaction")) {
        orderByColumn = "TransactionDate";
        sortOrder = "DESC";
    } else if (selectedFilter.equals("Oldest Transaction")) {
        orderByColumn = "TransactionDate";
        sortOrder = "ASC";
    } else {
        return; 
    }

    String query = "SELECT TransactionDate, SUM(TotalPrice) as TotalTransactions " +
                   "FROM transactions GROUP BY TransactionDate " +
                   "ORDER BY " + orderByColumn + " " + sortOrder;

    readDailyTransaction(query);
    }                                              

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailyTransaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> filterComboBox;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchField;
    // End of variables declaration                   


}
