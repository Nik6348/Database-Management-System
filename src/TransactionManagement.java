import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TransactionManagement extends TransactionForm {
    public static boolean viewFarmerID(String selectedFarmerId) {
        try {
            Connection con = DB.connect();
            PreparedStatement st = con.prepareStatement("SELECT FarmerID FROM farmers WHERE FarmerID = ?");
            st.setString(1, selectedFarmerId);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                viewFarmerName(selectedFarmerId);
                return true;
            } else {
                farmerTextField.setText("Invalid ID");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void viewFarmerName(String selectedFarmerId) {
        try {
            Connection con = DB.connect();
            PreparedStatement st = con.prepareStatement("SELECT FirstName, LastName FROM farmers WHERE FarmerID = ?");
            st.setString(1, selectedFarmerId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String fullName = firstName + " " + lastName; 
                farmerTextField.setText(fullName);
            } else {
                farmerTextField.setText("Invalid ID");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewItemName(String selectedItemType) {
        try {
            Connection con = DB.connect();
            Statement st = con.createStatement();
            if (selectedItemType.equals("Seed")) {
                ResultSet rs = st.executeQuery("SELECT SeedName, PricePerUnit FROM Seeds");
                while (rs.next()) {
                    String seedName = rs.getString("SeedName");
                    ItemNameComboBox.addItem(seedName);
                }
            } else if (selectedItemType.equals("Fertilizer")) {
                ResultSet rs = st.executeQuery("SELECT FertilizerName FROM Fertilizers");
                while (rs.next()) {
                    String fertilizerName = rs.getString("FertilizerName");
                    ItemNameComboBox.addItem(fertilizerName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewItemPrice(String selectedItemName) {
        try {
            String itemType = itemTypeComboBox.getSelectedItem().toString();
            Connection con = DB.connect();
            PreparedStatement ps;
            ResultSet rs;
            if (itemType.equals("Seed")) {
                ps = con.prepareStatement("SELECT PricePerUnit FROM seeds WHERE SeedName = ?");
                ps.setString(1, selectedItemName);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String price = rs.getString("PricePerUnit");
                    itemPriceTextField.setText(price);
                    String quantity = quantityField.getText();
                    if (!quantity.isEmpty()) {
                        int totalPrice = Integer.parseInt(price) * Integer.parseInt(quantity);
                        totalPriceTextfield.setText(Integer.toString(totalPrice));
                    }
                }
            } else if (itemType.equals("Fertilizer")) {
                ps = con.prepareStatement("SELECT PricePerUnit FROM Fertilizers WHERE FertilizerName = ?");
                ps.setString(1, selectedItemName);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String price = rs.getString("PricePerUnit");
                    itemPriceTextField.setText(price);
                    String quantity = quantityField.getText();
                    if (!quantity.isEmpty()) {
                        int totalPrice = Integer.parseInt(price) * Integer.parseInt(quantity);
                        totalPriceTextfield.setText(Integer.toString(totalPrice));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double getLandAreaForFarmer(int farmerID) {
        Connection con = null;
        double landArea = 0.0;

        try {
            con = DB.connect();
            String query = "SELECT LandArea FROM Farmers WHERE FarmerID = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, farmerID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                landArea = resultSet.getDouble("LandArea");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return landArea;
    }

    public static void addTransaction() {
        Connection con = null;

        String selectedFarmerId = FarmerID.getText();
        if (!viewFarmerID(selectedFarmerId)) {
            JOptionPane.showMessageDialog(jFrame1, "Invalid Farmer ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String dateString = dateTextField.getText();
            Date date = Date.valueOf(dateString);
            System.out.println(date);
            int farmerID = Integer.parseInt(selectedFarmerId);
            String farmerName = farmerTextField.getText();
            String itemType = itemTypeComboBox.getSelectedItem().toString();
            String itemName = ItemNameComboBox.getSelectedItem().toString();
            double itemPrice = Double.parseDouble(itemPriceTextField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            double totalPrice = Double.parseDouble(totalPriceTextfield.getText());

            double landArea = getLandAreaForFarmer(farmerID);
            int allowedQuantity = (int) (landArea * 2); // 2 items per acre

            con = DB.connect();
            con.setAutoCommit(false);

            PreparedStatement checkDuplicateTransaction = con.prepareStatement(
                    "SELECT SUM(Quantity) as TotalQuantity FROM Transactions WHERE TransactionDate = ? AND FarmerID = ? AND ItemName = ?");
            checkDuplicateTransaction.setDate(1, new java.sql.Date(date.getTime()));
            checkDuplicateTransaction.setInt(2, farmerID);
            checkDuplicateTransaction.setString(3, itemName);
            ResultSet duplicateResult = checkDuplicateTransaction.executeQuery();

            while (duplicateResult.next()) {
                int totalPurchasedQuantity = duplicateResult.getInt("TotalQuantity");
                if (totalPurchasedQuantity + quantity > allowedQuantity) {
                    JOptionPane.showMessageDialog(jFrame1,
                            "The farmer can only purchase up to " + allowedQuantity + " items of '" + itemName
                                    + "' based on land area (" + landArea + " acres, 2 items per acre).",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            duplicateResult.close();
            checkDuplicateTransaction.close();

            if (itemType.equals("Seed") || itemType.equals("Fertilizer")) {
                PreparedStatement checkStockStatement = con.prepareStatement(
                        "SELECT QuantityAvailable FROM " + itemType + "s WHERE " + itemType + "Name = ?");
                checkStockStatement.setString(1, itemName);
                ResultSet stockResult = checkStockStatement.executeQuery();

                if (stockResult.next()) {
                    int availableQuantity = stockResult.getInt("QuantityAvailable");

                    if (quantity > availableQuantity) {
                        JOptionPane.showMessageDialog(
                                jFrame1, "Insufficient stock of " + itemType + " '" + itemName
                                        + "'. Available quantity: " + availableQuantity,
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                stockResult.close();
                checkStockStatement.close();
            }

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Transactions(FarmerID, FarmerName, TransactionDate, ItemType, ItemName, ItemPrice, Quantity, TotalPrice) VALUES(?,?,?,?,?,?,?,?)");
            ps.setInt(1, farmerID);
            ps.setString(2, farmerName);
            ps.setDate(3, date);
            ps.setString(4, itemType);
            ps.setString(5, itemName);
            ps.setDouble(6, itemPrice);
            ps.setInt(7, quantity);
            ps.setDouble(8, totalPrice);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                PreparedStatement updateStockStatement = con.prepareStatement("UPDATE " + itemType
                        + "s SET QuantityAvailable = QuantityAvailable - ? WHERE " + itemType + "Name = ?");
                updateStockStatement.setInt(1, quantity);
                updateStockStatement.setString(2, itemName);
                updateStockStatement.executeUpdate();

                con.commit();
                JOptionPane.showMessageDialog(jFrame1, "Transaction added successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                printTransaction();
            } else {
                JOptionPane.showMessageDialog(jFrame1, "Failed Transaction. Please try again.", "Error",
                        JOptionPane.ERROR_MESSAGE, null);
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(jFrame1, "An error occurred while adding the Transaction.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void readTransaction() {
        try {
            Connection con = DB.connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Transactions");
            DefaultTableModel tableModel = (DefaultTableModel) viewTransaction.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                int TransactionID = rs.getInt("TransactionID");
                Date Date = rs.getDate("TransactionDate");
                String FarmerName = rs.getString("FarmerName");
                String ItemName = rs.getString("ItemName");
                String ItemType = rs.getString("ItemType");
                String ItemPrice = rs.getString("ItemPrice");
                String Quantity = rs.getString("Quantity");
                String TotalPrice = rs.getString("TotalPrice");

                tableModel.addRow(new Object[] { TransactionID, Date, FarmerName, ItemType, ItemName, ItemPrice,
                        Quantity, TotalPrice });
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(jFrame1, "An error occurred while retrieving Transaction data.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void printTransaction() {
        try {
            Connection con = DB.connect();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM Transactions ORDER BY TransactionID DESC LIMIT 1");

            if (rs.next()) {
                int transactionID = rs.getInt("TransactionID");
                String date = rs.getString("TransactionDate");
                String farmerName = rs.getString("FarmerName");
                String itemName = rs.getString("ItemName");
                double itemPrice = rs.getDouble("ItemPrice");
                int quantity = rs.getInt("Quantity");
                double totalPrice = rs.getDouble("TotalPrice");

                // Create a text file for the transaction receipt
                String fileName = "transaction_receipt_" + transactionID + ".txt";
                PrintWriter receiptWriter = new PrintWriter(new FileWriter(fileName));

                // Write the transaction details to the file
                receiptWriter.println("Transaction ID: " + transactionID);
                receiptWriter.println("Date: " + date);
                receiptWriter.println("Farmer Name: " + farmerName);
                receiptWriter.println("Item Name: " + itemName);
                receiptWriter.println("Item Price: " + itemPrice);
                receiptWriter.println("Quantity: " + quantity);
                receiptWriter.println("Total Price: " + totalPrice);

                // Close the file writer
                receiptWriter.close();

                // JOptionPane.showMessageDialog(jFrame1, "Transaction receipt saved as '" +
                // fileName + "'", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(jFrame1, "Transaction not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(jFrame1, "An error occurred while generating the receipt.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void searchTransaction(String searchText) {
        try {
            Connection con = DB.connect();
            String query = "SELECT * FROM Transactions WHERE FarmerName LIKE ? OR ItemName LIKE ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            String searchPattern = "%" + searchText + "%";
            preparedStatement.setString(1, searchPattern);
            preparedStatement.setString(2, searchPattern);

            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel) viewTransaction.getModel();
            tableModel.setRowCount(0);

            while (resultSet.next()) {
                int TransactionID = resultSet.getInt("TransactionID");
                String Date = resultSet.getString("TransactionDate");
                String FarmerName = resultSet.getString("FarmerName");
                String ItemName = resultSet.getString("ItemName");
                String ItemType = resultSet.getString("ItemType");
                String ItemPrice = resultSet.getString("ItemPrice");
                String Quantity = resultSet.getString("Quantity");
                String TotalPrice = resultSet.getString("TotalPrice");

                tableModel.addRow(new Object[] { TransactionID, Date, FarmerName, ItemType, ItemName, ItemPrice,
                        Quantity, TotalPrice });
            }

            resultSet.close();
            preparedStatement.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(jFrame1, "An error occurred while retrieving Transaction data.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    static void deleteTransaction(int TransactionID) {
        try (Connection conn = DB.connect()) {
            String sql = "DELETE FROM Transactions WHERE TransactionID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, TransactionID);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                // Row deleted successfully, refresh the table
                readTransaction();
                JOptionPane.showMessageDialog(null, "Transaction ID " + TransactionID + " deleted successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete Seed. Please try again.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while deleting the Seed.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
