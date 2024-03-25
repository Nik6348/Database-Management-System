import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Nikhil-Rajput
 */

public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();

        Font titleFont = new Font("Segoe UI Black", Font.BOLD, 24);
        jLabel1.setFont(titleFont);
        jLabel1.setForeground(Color.RED);

        Font buttonFont = new Font("Segoe UI Black", Font.BOLD, 18);
        jButton1.setFont(buttonFont);
        jButton2.setFont(buttonFont);
        jButton3.setFont(buttonFont);
        jButton4.setFont(buttonFont);

        jButton1.setBackground(Color.WHITE);
        jButton2.setBackground(Color.WHITE);
        jButton3.setBackground(Color.WHITE);
        jButton4.setBackground(Color.WHITE);
        jButton1.setForeground(Color.BLACK);
        jButton2.setForeground(Color.BLACK);
        jButton3.setForeground(Color.BLACK);
        jButton4.setForeground(Color.BLACK);

       setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }

    private void initComponents() {
      
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agriculture Society Management System");
        jPanel1.add(jLabel1, BorderLayout.NORTH);

        jToolBar2.setRollover(true);
        jToolBar1.setRollover(true);
        jToolBar3.setRollover(true);

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("./images/fertilizer2.png")));
        jButton2.setText("Fertilizers Management");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("./images/farmer.png  ")));
        jButton1.setText("Farmers Management");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("./images/Seeds.png")));
        jButton3.setText("Seeds Management");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("./images/Transaction.png")));
        jButton4.setText("Transactions Management");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        backButton.setFont(new java.awt.Font("Segoe UI Black", 1, 18));
        backButton.setText("Back");

        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
         
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 2, 2));
        buttonPanel.add(jButton1);
        buttonPanel.add(jButton2);
        buttonPanel.add(jButton3);
        buttonPanel.add(jButton4);

        jPanel1.add(buttonPanel, BorderLayout.CENTER);

        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.add(backButton);

        jPanel1.add(backButtonPanel, BorderLayout.SOUTH);

        getContentPane().add(jPanel1);

        pack();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
        dispose();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        FarmerForm farmerForm = new FarmerForm();
        farmerForm.setVisible(true); 
        dispose();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        FertilizerForm fertilizerForm= new FertilizerForm();
       fertilizerForm.setVisible(true);
       dispose();
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        SeedForm seedForm = new SeedForm();
        seedForm.setVisible(true);
        dispose();
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new TransactionForm().setVisible(true);
        dispose();
    }                  
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    // End of variables declaration                   
}
